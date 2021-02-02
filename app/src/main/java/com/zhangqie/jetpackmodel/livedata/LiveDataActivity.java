package com.zhangqie.jetpackmodel.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import com.zhangqie.jetpackmodel.R;

/**
 * Created by zhangqie on 2020/6/17
 * Describe:
 */
public class LiveDataActivity extends AppCompatActivity {

    private TextView tvAge;
    private TextView tvName;
    private TextView tvCity;
    private TextView tv_info_live;

    private LiveUser liveUser;
    private MutableLiveData<LiveUser> liveData = new MutableLiveData<>();
    //map转化liveData的返回类型，用一个liveData可以向下转化出所需要的liveData。还有一个switchmap函数类似
    private LiveData<String> userinfo = Transformations.map(liveData, new Function<LiveUser, String>() {
        @Override
        public String apply(LiveUser input) {
            return "姓名： " + input.getName().getValue() + " 年龄：" + input.getAge().getValue() + " 城市：" + input.getCity();
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livedata1_activity);
        initView();
    }


    private void initView() {
        tvAge = findViewById(R.id.tv_age_live);
        tvName = findViewById(R.id.tv_name_live);
        tvCity = findViewById(R.id.tv_city_live);
        tv_info_live = findViewById(R.id.tv_info_live);

        liveUser = new LiveUser("泸州市", "小张", 23);
        tvCity.setText(liveUser.getCity());
        liveUser.getAge().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvAge.setText(integer.toString());
            }
        });

        piveName(liveUser.getName(),tvName);

        liveData.setValue(liveUser);

        //liveData形式的数据显示整个user对象数据
        userinfo.observe(LiveDataActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv_info_live.setText(s);
            }
        });

    }



    private void piveName(LiveData<String> data, TextView textView){
        data.observe(this,textView::setText);
    }


    public void changeLive(View view) {
        //UI上这两个会变化，因为使用了liveData
        liveUser.setAge(22);
        liveUser.setName("张三");

        //UI上这个不会变化，因为是普通的属性字段
        liveUser.setCity("重庆");

        //transformations map 的演示变化，这里只是将数据源的user改变，UI界面上就能响应变化，不需要setText手动调用。
        liveData.setValue(liveUser);
    }
}
