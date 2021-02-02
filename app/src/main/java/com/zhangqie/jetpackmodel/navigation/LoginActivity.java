package com.zhangqie.jetpackmodel.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangqie.jetpackmodel.R;

/**
 * Created by zhangqie on 2021/2/2
 * Describe:
 * 用这种方式可以减少Activity
 *
 * 1.一个模块可以只需要一个Activity
 *
 * 2.一个应用也可以只要一个主的Activity
 *
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_login);
    }

}
