package com.tenz.tenzkotlindemo.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tenz.tenzkotlindemo.R
import com.tenz.tenzkotlindemo.base.BaseActivity
import com.tenz.tenzkotlindemo.ui.fragment.HomeFragment
import com.tenz.tenzkotlindemo.ui.fragment.MineFragment
import com.tenz.tenzkotlindemo.ui.fragment.NewsFragment
import com.tenz.tenzkotlindemo.ui.fragment.PhotosFragment
import com.tenz.tenzkotlindemo.util.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val INDEX_HOME = 1
    val INDEX_NEWS = 2
    val INDEX_PHOTOS = 3
    val INDEX_MINE = 4

    lateinit var mHomeFragment: HomeFragment
    lateinit var mNewsFragment: NewsFragment
    lateinit var mPhotosFragment: PhotosFragment
    lateinit var mMineFragment: MineFragment

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initStatusBar() {
        StatusBarUtil.setTranslucent(this, 0)
    }

    override fun initView() {
        bnv_main.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
                item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.tab_home -> {
                    showFragment(INDEX_HOME)
                    true
                }
                R.id.tab_news -> {
                    showFragment(INDEX_NEWS)
                    true
                }
                R.id.tab_photos -> {
                    showFragment(INDEX_PHOTOS)
                    true
                }
                R.id.tab_mine -> {
                    showFragment(INDEX_MINE)
                    true
                }
                else -> {
                    false
                }

            }
        })
    }

    override fun initData() {
        //默认显示首页
        showFragment(INDEX_HOME)

    }

    fun test(index: Int){
        when(index){
            1 -> print("")
                2 -> print("")
            else -> print("")
        }
    }

    /**
     * 显示fragment
     */
    fun showFragment(index: Int){
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideFragment(beginTransaction)
        when(index){
            INDEX_HOME ->
                if(!this::mHomeFragment.isInitialized){
                    mHomeFragment = HomeFragment.newInstance()
                    beginTransaction.add(R.id.fl_main,mHomeFragment)
                }else{
                    beginTransaction.show(mHomeFragment)
                }
            INDEX_NEWS ->
                if(!this::mNewsFragment.isInitialized){
                    mNewsFragment = NewsFragment.newInstance()
                    beginTransaction.add(R.id.fl_main,mNewsFragment)
                }else{
                    beginTransaction.show(mNewsFragment)
                }
            INDEX_PHOTOS ->
                if(!this::mPhotosFragment.isInitialized){
                    mPhotosFragment = PhotosFragment.newInstance()
                    beginTransaction.add(R.id.fl_main,mPhotosFragment)
                }else{
                    beginTransaction.show(mPhotosFragment)
                }
            INDEX_MINE ->
                if(!this::mMineFragment.isInitialized){
                    mMineFragment = MineFragment.newInstance()
                    beginTransaction.add(R.id.fl_main,mMineFragment)
                }else{
                    beginTransaction.show(mMineFragment)
                }
        }
        beginTransaction.commit()
    }

    /**
     * 隐藏fragment
     */
    private fun hideFragment(beginTransaction: FragmentTransaction) {
        if(this::mHomeFragment.isInitialized){
            beginTransaction.hide(mHomeFragment)
        }
        if(this::mNewsFragment.isInitialized){
            beginTransaction.hide(mNewsFragment)
        }
        if(this::mPhotosFragment.isInitialized){
            beginTransaction.hide(mPhotosFragment)
        }
        if(this::mMineFragment.isInitialized){
            beginTransaction.hide(mMineFragment)
        }
    }

    interface Test{
        var color: Int
    }

    open class Person(var name: String): Test{
        override var color: Int
            get() = 2
            set(value) {
                value
            }

    }

    class Student(name: String, var score: Int): Person(name)

    fun test(){
        val student = Student("tenz", 80)
        print("student's name: ${student.name}")
    }

}
