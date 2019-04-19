package com.peri.aiyin.fit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.peri.aiyin.fit.Utils.StringUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    private String userName;
    private String password;
    private EditText text_name;
    private EditText text_pwd;
    private Button btn_login;
    private String result;
    private TextView tx_register;

    private int RequestCode = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        text_name= findViewById(R.id.name);
        text_pwd=findViewById(R.id.password);
        btn_login=findViewById(R.id.login);
        btn_login.setOnClickListener(btnClickHandler);
        tx_register=findViewById(R.id.register);
        tx_register.setClickable(true);
        tx_register.setOnClickListener(btnClickHandler);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            text_name.setText(data.getStringExtra("name"));
            text_pwd.setText(data.getStringExtra("password"));
        }
    }

    private View.OnClickListener btnClickHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login:
                    userName=text_name.getText().toString().trim();
                    password=text_pwd.getText().toString().trim();
                    if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(password)){
                        Toast.makeText(MainActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    }else{
                        new Thread(){
                            public void run(){
                                try{
                                    //StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
                                    String path="http://192.168.43.4:8080/loginPage";
                                    URL url=new URL(path);
                                    HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                                    connection.setRequestMethod("POST");
                                    //设置请求超时时间
                                    connection.setConnectTimeout(8000);
                                    connection.setReadTimeout(8000);
                                    connection.setUseCaches(false);//设置缓存
                                    //传输数据
                                    String data="name="+userName+"&password="+password;
                                    //表单请求方式
                                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                                    connection.setRequestProperty("Content-Length", data.length()+"");
                                    connection.setDoOutput(true);
                                    OutputStream os = connection.getOutputStream();
                                    os.write(data.getBytes());
                                    int code=connection.getResponseCode();
                                    if(code==200){
                                        InputStream inputStream=connection.getInputStream();
                                        result= StringUtil.readStream(inputStream);
                                        runOnUiThread(new Thread(){
                                            @Override
                                            public void run(){
                                                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(MainActivity.this,TabActivity.class);
                                                startActivity(intent);

                                            }
                                        });

                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }

                        }.start();
                    }

                    break;
                case R.id.register:
                    Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                    startActivityForResult(intent,RequestCode);
                    break;
            }
        }
    };
}
