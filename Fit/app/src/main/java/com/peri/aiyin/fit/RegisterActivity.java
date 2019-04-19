package com.peri.aiyin.fit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.peri.aiyin.fit.Utils.StringUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends Activity {

    private TextView text_login;
    private EditText regName;
    private EditText regMail;
    private EditText regPassword;
    private EditText passwordAgain;
    private String  strName;
    private String strMail;
    private String strPassword;
    private String strPwdAgain;
    private String result;
    private int ResultCode=2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        text_login=findViewById(R.id.text_login);
        regMail=findViewById(R.id.register_mail);
        regName=findViewById(R.id.register_name);
        regPassword=findViewById(R.id.register_password);
        passwordAgain=findViewById(R.id.password_again);
        text_login.setClickable(true);
        text_login.setOnClickListener(btnClickHandler);
    }
    private View.OnClickListener btnClickHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.text_login:
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    break;
                case R.id.btn_register_on:
                    strName=regName.getText().toString().trim();
                    strMail=regMail.getText().toString().trim();
                    strPassword=regPassword.getText().toString().trim();
                    strPwdAgain=passwordAgain.getText().toString().trim();
                    if(TextUtils.isEmpty(strName)||TextUtils.isEmpty(strMail)
                            ||TextUtils.isEmpty(strPassword)||TextUtils.isEmpty(strPwdAgain))
                        Toast.makeText(RegisterActivity.this, "全部都为必填项哟", Toast.LENGTH_SHORT).show();
                    else if(!strPassword.equals(strPwdAgain))
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"两次密码不一样",Toast.LENGTH_SHORT).show();
                                    }
                                      });
                    else{
                        try{
                            String path="http://192.168.43.4:8080/register";
                            URL url=new URL(path);
                            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                            connection.setRequestMethod("POST");
                            //设置请求超时时间
                            connection.setConnectTimeout(8000);
                            connection.setReadTimeout(8000);
                            connection.setUseCaches(false);//设置缓存
                            //传输数据
                            String data="name="+strName+"&password="+strPassword+"&eMail"+strMail;
                            //表单请求方式
                            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            connection.setRequestProperty("Content-Length", data.length()+"");
                            connection.setDoOutput(true);
                            OutputStream os = connection.getOutputStream();
                            os.write(data.getBytes());
                            int code=connection.getResponseCode();
                            if(code==200){
                                //获得一个文件的输入流
                                InputStream inputStream= connection.getInputStream();
                                result = StringUtil.readStream(inputStream);
                                //更新UI
                                showToast(result);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };
    public void showToast(final String content){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(result.equals("success")){
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra("id",strName );
                    intent.putExtra("password", strPassword);
                    setResult(ResultCode, intent);
                    finish();
                }

            }
        });
    }

}
