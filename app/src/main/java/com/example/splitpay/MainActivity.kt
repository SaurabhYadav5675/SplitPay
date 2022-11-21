package com.example.splitpay

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.splitpay.adapter.FragmentAdapter
import com.example.splitpay.databinding.ActivityMainBinding
import com.example.splitpay.fragment.GroupsFragment
import com.example.splitpay.fragment.HomeFragment
import com.example.splitpay.fragment.ProfileFragment
import com.example.splitpay.fragment.RecordFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var menuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        bottomNav = binding.bottomNavigationView
        menuItem = bottomNav.menu.getItem(0).setCheckable(true)

        val fragmentAdapter = FragmentAdapter(this)
        fragmentAdapter.addFragment(HomeFragment(), "Home")
        fragmentAdapter.addFragment(GroupsFragment(), "Group")
        fragmentAdapter.addFragment(RecordFragment(), "Record")
        fragmentAdapter.addFragment(ProfileFragment(), "Profile")
        viewPager.adapter = fragmentAdapter
        viewPager.setPageTransformer(ViewPager2.PageTransformer() { page, position ->
            page.rotationY = position * -30;
        })

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                menuItem.isChecked = false
                bottomNav.menu.getItem(position).isChecked = true;
                menuItem = bottomNav.menu.getItem(position);
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })


        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> viewPager.currentItem = 0
                R.id.navGroup -> viewPager.currentItem = 1
                R.id.navRecord -> viewPager.currentItem = 2
                R.id.navProfile -> viewPager.currentItem = 3
            }
            false
        }
    }
}


