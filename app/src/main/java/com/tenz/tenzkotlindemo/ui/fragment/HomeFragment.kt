package com.tenz.tenzkotlindemo.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.adapter.MustPlayAdapter
import com.tenz.tenzkotlindemo.adapter.MustPrepareAdapter
import com.tenz.tenzkotlindemo.base.BaseFragment
import com.tenz.tenzkotlindemo.helper.GlideImageLoader
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import com.tenz.tenzkotlindemo.util.ToastUtil
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment(){

    companion object{
        fun newInstance(): HomeFragment{
            return HomeFragment()
        }
    }

    override fun getLayout(): Int = R.layout.fragment_home

    override fun onStart() {
        super.onStart()
        banner_home.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        banner_home.stopAutoPlay()
    }

    override fun initView() {
        val layoutParams = view_status_bar.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(mContext)
        view_status_bar.layoutParams = layoutParams

        //初始化刷新加载更多
        refresh_layout.setOnRefreshListener(OnRefreshListener {
            refresh_layout.finishRefresh(1000)
        })
        refresh_layout.setOnLoadMoreListener(OnLoadMoreListener {
            refresh_layout.finishLoadMore(1500)
        })

        rl_must_prepare.setOnClickListener(View.OnClickListener {
            //必备

        })
        rl_must_play.setOnClickListener(View.OnClickListener {
            //必玩

        })
        rl_hot.setOnClickListener(View.OnClickListener {
            //热门

        })
        rl_sort.setOnClickListener(View.OnClickListener {
            //分类

        })
        rl_recommend.setOnClickListener(View.OnClickListener {
            //推荐

        })
    }

    override fun initData() {
        initBannerData()
        initMustPrepareData()
        initMustPlayData()
        initHotData()
        initSortData()
        initRecommendData()
    }

    /**
     * 初始化banner
     */
    fun initBannerData(){
        val bannerImageList = ArrayList<String>()
        val bannerTitleList = ArrayList<String>()
        bannerImageList.add("http://img.zcool.cn/community/01b72057a7e0790000018c1bf4fce0.png")
        bannerImageList.add("http://img.zcool.cn/community/01fca557a7f5f90000012e7e9feea8.jpg")
        bannerImageList.add("http://img.zcool.cn/community/01996b57a7f6020000018c1bedef97.jpg")
        bannerImageList.add("http://img.zcool.cn/community/01700557a7f42f0000018c1bd6eb23.jpg")
        bannerTitleList.add("初秋特惠大放价")
        bannerTitleList.add("坚果早餐生活")
        bannerTitleList.add("夏日特惠4折起")
        bannerTitleList.add("女性专场返利")
        banner_home.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
        banner_home.setImageLoader(GlideImageLoader())
        banner_home.setImages(bannerImageList)
        banner_home.setBannerTitles(bannerTitleList)
        banner_home.isAutoPlay(true)
        banner_home.setDelayTime(15000)
        banner_home.setIndicatorGravity(BannerConfig.CENTER)
        banner_home.start()
    }

    /**
     * 初始化必备列表数据
     */
    fun initMustPrepareData(){
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_must_prepare.layoutManager = linearLayoutManager
        var mustPrepareList = ArrayList<String>()
        for (i in 0..5){
            mustPrepareList.add("")
        }
        rv_must_prepare.adapter = MustPrepareAdapter(mContext, mustPrepareList)
    }

    /**
     * 初始化必玩列表数据
     */
    fun initMustPlayData(){
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_must_play.layoutManager = linearLayoutManager
        var mustPlayList = ArrayList<String>()
        for (i in 0..9){
            mustPlayList.add("")
        }
        rv_must_play.adapter = MustPlayAdapter(mContext, mustPlayList)
    }

    /**
     * 初始化热门列表数据
     */
    fun initHotData(){
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_hot.layoutManager = linearLayoutManager
        var hotList = ArrayList<String>()
        for (i in 0..5){
            hotList.add("")
        }
        rv_hot.adapter = MustPrepareAdapter(mContext, hotList)
    }

    /**
     * 初始化分类列表数据
     */
    fun initSortData(){
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_sort.layoutManager = linearLayoutManager
        var sortList = ArrayList<String>()
        for (i in 0..9){
            sortList.add("")
        }
        rv_sort.adapter = MustPlayAdapter(mContext, sortList)
    }

    /**
     * 初始化推荐列表数据
     */
    fun initRecommendData(){
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_recommend.layoutManager = linearLayoutManager
        var recommmendList = ArrayList<String>()
        for (i in 0..5){
            recommmendList.add("")
        }
        rv_recommend.adapter = MustPrepareAdapter(mContext, recommmendList)
    }

}