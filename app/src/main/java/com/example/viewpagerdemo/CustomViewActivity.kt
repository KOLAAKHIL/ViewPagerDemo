package com.example.viewpagerdemo

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.viewpagerdemo.databinding.ActivityCustomViewBinding
import com.example.viewpagerdemo.databinding.CustomTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CustomViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCustomViewBinding
    lateinit var adapter: ViewPageAdapter
    lateinit var fragments:MutableList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        customTabView()

    }

    private fun customTabView() {

        fragments= mutableListOf(HomeFragment(),ProfileFragment(),SettingsFragment() )

        adapter = ViewPageAdapter(fragments, supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            val customtabBinding = CustomTabBinding.inflate(layoutInflater)
            when (position){

                0-> {
                    customtabBinding.tabText.visibility = View.INVISIBLE
                    customtabBinding.tabIcon.setImageResource(R.drawable.baseline_add_home_24)
                }
                1->{
                    customtabBinding.tabText.text = "Profile"
                    customtabBinding.tabIcon.setImageResource(R.drawable.baseline_adjust_24)
                }
                3 ->{
                    customtabBinding.tabText.text = "Settings"
                    customtabBinding.tabIcon.visibility = View.INVISIBLE
                }
            }
            tab.customView = customtabBinding.root
        }.attach()
    }
}