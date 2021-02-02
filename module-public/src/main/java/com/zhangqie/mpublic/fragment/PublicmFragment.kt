package com.zhangqie.mpublic.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.zhangqie.base.api.AppARouterUrl
import com.zhangqie.base.base.BaseFragment
import com.zhangqie.mpublic.R

/**
 * Created by zhangqie on 2021/2/2
 * Describe: 集成时直接使用
 */

@Route(path = AppARouterUrl.PAGER_PUBLIC)
class PublicmFragment : BaseFragment() {

    override fun layoutId(): Int {
        return R.layout.fg_publicm
    }

    override fun initView() {

    }

    override fun initData() {

    }
}