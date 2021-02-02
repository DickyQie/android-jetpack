package com.zhangqie.jetpackmodel.livedata;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by zhangqie on 2020/6/17
 * Describe:
 */
public class LiveUser {


    private String city;
    private MutableLiveData<String> name = new MediatorLiveData<>();


    private MutableLiveData<Integer> age = new MediatorLiveData<>();

    public LiveUser(String city,String name,Integer age){
        this.city = city;
        this.name.setValue(name);
        this.age.setValue(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public MutableLiveData<Integer> getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age.setValue(age);
    }

}
