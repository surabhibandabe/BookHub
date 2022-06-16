package com.example.bookhub.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem


import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.bookhub.*
import com.example.bookhub.fragment.AboutAppFragment
import com.example.bookhub.fragment.FavouritesFragment
import com.example.bookhub.fragment.dashboardFragment
import com.example.bookhub.fragment.profileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var frameLayout:FrameLayout
    lateinit var navigationView:NavigationView
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar:Toolbar
    lateinit var drawerlayout: DrawerLayout
    var previousmenuitem:MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frameLayout=findViewById(R.id.frame_layout)
        navigationView=findViewById(R.id.navigation_view)
        toolbar=findViewById(R.id.toolbar)
        drawerlayout=findViewById(R.id.drawer_layout)
        coordinatorLayout=findViewById(R.id.coordinator)
        setUpToolbar()
       opendashboard()

        val actionBarDrawerToggle: ActionBarDrawerToggle
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this@MainActivity,drawerlayout,
                R.string.open_drawer,
                R.string.close_drawer
            )

        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if (previousmenuitem!=null){
                previousmenuitem?.isChecked=false

            }
            it.isCheckable=true
            it.isChecked=true
            previousmenuitem=it

            when(it.itemId){
                R.id.dashboard -> {
                    opendashboard()
                    drawerlayout.closeDrawers()


                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame_layout,
                        profileFragment()
                    ).commit()
                    supportActionBar?.title="Profile"
                    drawerlayout.closeDrawers()
                }
                R.id.aboutApp -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame_layout,

                        AboutAppFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                }
                R.id.favourites -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame_layout,

                        FavouritesFragment()
                    ).commit()
                    supportActionBar?.title="Favourite"
                    drawerlayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }



    }
    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Bookhub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==android.R.id.home){
            drawerlayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    fun opendashboard(){

        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, dashboardFragment())
        transaction.commit()
        supportActionBar?.title="dashboard"
        navigationView.setCheckedItem(R.id.dashboard)

    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frame_layout)
        when(frag){
            !is dashboardFragment ->opendashboard()
            else->super.onBackPressed()
        }
    }

}