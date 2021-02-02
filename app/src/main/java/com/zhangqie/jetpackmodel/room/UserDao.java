package com.zhangqie.jetpackmodel.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by zhangqie on 2020/6/17
 * Describe:
 */

@Dao //room注解
public interface UserDao {

    @Query(value = "select * from db_user")
    List<DbUser> getAll();//查询所以数据

    @Query(value = "select * from db_user WHERE uid IN (:userIds)")
    List<DbUser> loadAllByIds(int[] userIds);//根据uid查询

    @Query(value = "select * from db_user WHERE uname LIKE :name AND age LIKE :age LIMIT 1")//条件查询
    DbUser findByName(String name, int age);

    @Query(value = "select * from db_user where uid like :uid")
    DbUser getUSerId(int uid);


    @Insert
    void insertAll(DbUser... dbUsers);//支持可变参数

    @Delete
    void delete(DbUser dbUser);

    @Query(value = "delete from db_user where uid = :uid")
    void deleteId(int uid);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(DbUser dbUser);////更新，若出现冲突，则使用替换策略，还有其他策略可选择

    @Query(value = "update db_user set uname = :name where uid = :uid")
    void updateId(int uid, String name);

}
