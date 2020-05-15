package com.tenz.tenzkotlindemo.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.adapter.NewsAdapter
import com.tenz.tenzkotlindemo.adapter.PhotosAdapter
import com.tenz.tenzkotlindemo.base.BaseFragment
import com.tenz.tenzkotlindemo.ui.activity.WebActivity
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_mine.view_status_bar
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.layout_title_bar.*

class NewsFragment: BaseFragment(), PhotosAdapter.OnItemClickListener {

    var mNewsList = arrayListOf<String>()

    companion object{
        fun newInstance(): NewsFragment{
            return NewsFragment()
        }
    }

    override fun getLayout(): Int = R.layout.fragment_news

    override fun initView() {
        val layoutParams = view_status_bar.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(mContext)
        view_status_bar.layoutParams = layoutParams
        initTitleBar(title_bar,"新闻","",true)

        //初始化刷新加载更多
        refresh_layout.autoRefresh()
        refresh_layout.setOnRefreshListener(OnRefreshListener {
            refresh_layout.finishRefresh(1000)
            mNewsList.clear()
            for (i in 0..15){
                mNewsList.add("")
            }
            rv_news.adapter!!.notifyDataSetChanged()
        })
        refresh_layout.setOnLoadMoreListener(OnLoadMoreListener {
            refresh_layout.finishLoadMore(1500)
            for (i in 0..15){
                mNewsList.add("")
            }
            rv_news.adapter!!.notifyDataSetChanged()
        })
    }

    override fun initData() {
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_news.layoutManager = linearLayoutManager
        for (i in 0..15){
            mNewsList.add("")
        }
        rv_news.adapter = NewsAdapter(mContext, mNewsList, this)
    }

    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putString(WebActivity.KEY_URL, "https://www.jianshu.com/p/70ba6fad93bf")
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}