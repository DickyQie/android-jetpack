package com.zhangqie.jetpackmodel.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.zhangqie.jetpackmodel.R;

/**
 * Created by zhangqie on 2020/6/16
 * Describe:
 */
public class ViewModelActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.viewmodel1_layout);

       textView = findViewById(R.id.tv_name1);
       final MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.listMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                textView.setText("姓名："+user.getUserName()+"年龄："+user.getUserAge());
            }
        });


       findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               myViewModel.loadUsers();
           }
       });


    }




}
