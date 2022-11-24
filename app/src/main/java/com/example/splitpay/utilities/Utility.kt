package com.example.splitpay.utilities

import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import com.example.splitpay.EmptyScreen

class Utility {
    companion object {
        fun checkEmptyString(data: String): Boolean {
            return (data.isEmpty() || data.lowercase() != "null")
        }

        fun showEmptyScreen(root: ViewGroup, context: Context, message: String, animFile: Int) {
            val emptyScreen = EmptyScreen(context, message, animFile)
            emptyScreen.initView()
            root.addView(emptyScreen, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        }
    }
}