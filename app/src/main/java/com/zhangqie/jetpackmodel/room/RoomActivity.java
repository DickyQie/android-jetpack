package com.zhangqie.jetpackmodel.room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhangqie.jetpackmodel.R;

import java.util.List;

/**
 * Created by zhangqie on 2020/6/17
 * Describe:
 */
public class RoomActivity extends AppCompatActivity {

    private TextView tvInsert, tvDelete, tvUpdate, tvQueryID, tvQueryAll, tvSize, tvAll;

    UserDao userDao;
    UserDataBase instance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.room1_activity);

        tvInsert = findViewById(R.id.tv_insert_room);
        tvDelete = findViewById(R.id.tv_delete_room);
        tvUpdate = findViewById(R.id.tv_update_room);
        tvQueryID = findViewById(R.id.tv_query_id_room);
        tvQueryAll = findViewById(R.id.tv_query_all_room);
        tvSize = findViewById(R.id.tv_size_room);
        tvAll = findViewById(R.id.tv_all_room);
        initData();
    }

    private void initData() {
        instance = UserDataBase.getInstance(this);
        deleteDatabase(UserDataBase.DB_NAME);//删除数据库，属于contextwrapper中的函数
        userDao = instance.getUserDao();
    }

    private void showDataModel(){
        instance = UserDataBase.getInstance(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance.clearAllTables();
    }

    public void insert(View view) {
        StringBuffer stringBuffer = new StringBuffer();
        DbUser dbUser;
        for (int i = 1; i < 3; i++) {
            dbUser = new DbUser();
            dbUser.setAge(22 + i);
            dbUser.setName("张三" + i);
            dbUser.setCity("泸州" + i + "号");
            dbUser.setSingle(i % 2 == 0);
            userDao.insertAll(dbUser);
            stringBuffer.append(dbUser.toString()).append("\n");
        }
        tvInsert.setText(stringBuffer.toString());
        getAll();
    }

    private void getAll() {
        List<DbUser> list = userDao.getAll();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            Log.i("aaa", list.get(i).getName());
            stringBuffer.append("uid: ")
                    .append(list.get(i).getUid())
                    .append("姓名: ")
                    .append(list.get(i).getName())
                    .append("年龄: ")
                    .append(list.get(i).getAge())
                    .append("城市: ")
                    .append(list.get(i).getCity())
                    .append("Single: ")
                    .append(list.get(i).isSingle())
                    .append("\n");
        }
        String text = "All Size ： " + list.size();
        tvSize.setText(text);
        tvAll.setText(stringBuffer.toString());
    }

    public void update(View v){
        DbUser user = userDao.getUSerId(1);
        user.setAge(12);
        user.setName("万神纪");
        user.setCity("神都");
        user.setSingle(true);
        userDao.update(user);
        tvInsert.setText(user.toString());
        getAll();
    }


    public void queryId(View view){
        DbUser user = userDao.getUSerId(1);
        if (user != null){
            tvQueryID.setText(user.toString());
        }else{
            Toast.makeText(RoomActivity.this,"数据为空",Toast.LENGTH_LONG).show();
        }
    }

    public void queryAll(View view){
        getAll();
    }

    public void delete(View view){
        DbUser user = userDao.getUSerId(2);
        tvDelete.setText(user.toString());

        userDao.deleteId(2);
        getAll();
    }


    public void deleteLnt(View view) {
        DbUser user = userDao.findByName("张三2", 24);
        userDao.delete(user);
        tvDelete.setText(user.toString());
        getAll();
    }


}
