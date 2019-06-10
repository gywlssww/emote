package com.example.emote

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.beust.klaxon.JsonArray

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_post.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URLDecoder
import java.net.URLEncoder

class MainActivity : AppCompatActivity()
    , Mypage.OnFragmentInteractionListener, Emoteboard.OnFragmentInteractionListener, Statistics.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var adapter:ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
         //insertInfo()
        /*test용
       val db=DB()
        val str=db.getPosts()
        val date=str!!.get(0).date
        val title=str!!.get(0).title
        val con=str!!.get(0).contents
        val place=str!!.get(0).place
        val activity=str!!.get(0).activity


        Log.i("dbplz2",date)
        Log.i("dbplz3",title)
        Log.i("dbplz4",con)
        Log.i("dbplz5",place)
        Log.i("dbplz6",activity)
        */


    }


    fun init(){

        adapter= ViewPagerAdapter(supportFragmentManager,layout_tab.tabCount)
        viewPager.adapter=adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                layout_tab.getTabAt(0)?.setIcon(R.drawable.icon_1_w)
                layout_tab.getTabAt(1)?.setIcon(R.drawable.icon_2_w)
                layout_tab.getTabAt(2)?.setIcon(R.drawable.icon_3_w)

                when(p0) {
                    0 -> layout_tab.getTabAt(0)?.setIcon(R.drawable.icon_1_b)
                    1 -> layout_tab.getTabAt(1)?.setIcon(R.drawable.icon_2_b)
                    2 -> layout_tab.getTabAt(2)?.setIcon(R.drawable.icon_3_b)
                }
            }

        })

        layout_tab.setupWithViewPager(viewPager)
        layout_tab.getTabAt(0)?.setIcon(R.drawable.icon_1_b)
        layout_tab.getTabAt(1)?.setIcon(R.drawable.icon_2_w)
        layout_tab.getTabAt(2)?.setIcon(R.drawable.icon_3_w)

    }

}
