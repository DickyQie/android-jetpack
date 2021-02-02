package com.zhangqie.jetpackmodel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


/**
 * Created by zhangqie on 2020/6/16
 * Describe:
 */
public class MyViewModel extends ViewModel {

    public MutableLiveData<User> listMutableLiveData = new MutableLiveData();

    public void loadUsers() {
        User user = new User();
        user.setUserName("掌上");
        user.setUserAge("19");
        listMutableLiveData.postValue(user);

    }


}
