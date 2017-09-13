package com.example.zyt.frame.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.zyt.frame.R;

/**
 * Created by zyt on 2017/9/11.
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView backImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        backImageView = (ImageView) findViewById(R.id.setting_back);
        backImageView.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //保存一些数据
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_back:{onBackPressed();}break;
        }
    }
}
