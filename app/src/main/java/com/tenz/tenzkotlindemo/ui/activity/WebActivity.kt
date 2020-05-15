package com.tenz.tenzkotlindemo.ui.activity

import android.os.Build
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.layout_title_bar.*


class WebActivity: BaseActivity(){

    companion object{
        val KEY_URL = "url"
        val KEY_HTML_DATA = "html_data"
    }

    lateinit var mUrl: String
    lateinit var mHtmlData: String

    override fun getLayoutId(): Int = R.layout.activity_web

    override fun initView() {
        initWebSetting(wv_web.settings)
    }

    override fun initData() {
        val bundle = intent.extras
        if(null != bundle){
            mUrl = bundle.getString(KEY_URL,"")
            mHtmlData = bundle.getString(KEY_HTML_DATA,"")
        }
        if(this::mUrl.isInitialized){
            wv_web.loadUrl(mUrl)
        }else if(this::mHtmlData.isInitialized){
            wv_web.loadData(mHtmlData,"text/html;charset=UTF-8",null)
        }
    }

    /**
     * 初始化web
     */
    fun initWebSetting(webSettings: WebSettings){
        webSettings.javaScriptEnabled = true

        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true

        webSettings.setSupportZoom(false)
        webSettings.builtInZoomControls = false
        webSettings.displayZoomControls = false

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //sdk>=5.0
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        wv_web.webChromeClient =WebChromeClient()
        wv_web.webViewClient = WebViewClient()

    }

    /**
     * WebChromeClient
     */
    inner class WebChromeClient : android.webkit.WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (pb_web == null)
                return
            //进度条
            if (newProgress < 100) {
                pb_web.progress = newProgress
            } else {
                pb_web.visibility = View.GONE
            }
        }

        override fun onReceivedTitle(view: WebView, title: String) {
            super.onReceivedTitle(view, title)
            if (null == title_bar) {
                return
            }
            //标题
            initTitleBar(title_bar, title, "", false)
        }
    }

    /**
     * WebViewClient
     */
    inner class WebViewClient : android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            //复写shouldOverrideUrlLoading()方法，使得打开网页时不调用系统浏览器，而是在本WebView中显示
            wv_web.loadUrl(url)
            return true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (wv_web != null) {
            wv_web.removeAllViews()
            wv_web.destroy()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KEYCODE_BACK && wv_web.canGoBack()) {
            wv_web.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}