package com.example.splitpay.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private var fragmentList: ArrayList<Fragment> = ArrayList()
    var fragmentTag: ArrayList<String> = ArrayList()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment, tag: String) {
        if (!fragmentList.contains(fragment) && !fragmentTag.contains(tag)) {
            fragmentList.add(fragment)
            fragmentTag.add(tag)
        }
        notifyDataSetChanged()
    }

    fun removeAllFragment() {
        fragmentList.clear()
        fragmentTag.clear()
        notifyDataSetChanged()
    }
}