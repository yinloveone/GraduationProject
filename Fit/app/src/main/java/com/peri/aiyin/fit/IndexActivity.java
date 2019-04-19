package com.peri.aiyin.fit;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class IndexActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity);
        ImageView imageView = findViewById(R.id.image);
        Animatable animatable = (Animatable) imageView.getDrawable();
        animatable.start();
    }
}
