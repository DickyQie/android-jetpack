package com.zhangqie.jetpackmodel

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.zhangqie.jetpackmodel.livedata.LiveDataActivity
import com.zhangqie.jetpackmodel.navigation.LoginActivity
import com.zhangqie.jetpackmodel.room.RoomActivity
import com.zhangqie.jetpackmodel.viewmodel.ViewModelActivity
import com.zhangqie.jetpackmodel.zproject1.ProjectMain1
import com.zhangqie.jetpackmodel.zproject1.ProjectMain2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val strings = arrayOf("ViewModel", "LiveData", "Room",
            "Navigation", "小项目测试1", "小项目测试2", "Paging")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, strings)
        listview.setAdapter(adapter)
        listview.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id -> showIntent(position) })
    }

    private fun showIntent(position: Int) {
        var intent: Intent? = null
        if (position == 0) {
            intent = Intent(this@MainActivity, ViewModelActivity::class.java)
        } else if (position == 1) {
            intent = Intent(this@MainActivity, LiveDataActivity::class.java)
        } else if (position == 2) {
            intent = Intent(this@MainActivity, RoomActivity::class.java)
        }else if (position == 3) {
            intent = Intent(this@MainActivity, LoginActivity::class.java)
        }else if (position == 4) {
            intent = Intent(this@MainActivity, ProjectMain1::class.java)
        }else if (position == 5) {
            intent = Intent(this@MainActivity, ProjectMain2::class.java)
        }
        startActivity(intent)
    }
}