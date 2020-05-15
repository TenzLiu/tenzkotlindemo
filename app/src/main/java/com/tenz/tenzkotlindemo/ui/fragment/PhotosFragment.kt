package com.tenz.tenzkotlindemo.ui.fragment

import android.content.Intent
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.adapter.PhotosAdapter
import com.tenz.tenzkotlindemo.base.BaseFragment
import com.tenz.tenzkotlindemo.ui.activity.PhotosDetailActivity
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_mine.view_status_bar
import kotlinx.android.synthetic.main.fragment_photos.*
import kotlinx.android.synthetic.main.layout_title_bar.*

class PhotosFragment: BaseFragment(), PhotosAdapter.OnItemClickListener {

    companion object{
        fun newInstance(): PhotosFragment{
            return PhotosFragment()
        }
    }

    override fun getLayout(): Int = R.layout.fragment_photos

    override fun initView() {
        val layoutParams = view_status_bar.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(mContext)
        view_status_bar.layoutParams = layoutParams
        initTitleBar(title_bar,"图片","",true)

        //初始化刷新加载更多
        refresh_layout.setOnRefreshListener(OnRefreshListener {
            refresh_layout.finishRefresh(1000)
        })
        refresh_layout.setOnLoadMoreListener(OnLoadMoreListener {
            refresh_layout.finishLoadMore(1500)
        })
    }

    override fun initData() {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv_photos.layoutManager = staggeredGridLayoutManager
        var photosList = ArrayList<String>()
        for (i in 0..40){
            photosList.add("")
        }
        rv_photos.adapter = PhotosAdapter(mContext, photosList, this)
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(mContext, PhotosDetailActivity::class.java))
    }

}