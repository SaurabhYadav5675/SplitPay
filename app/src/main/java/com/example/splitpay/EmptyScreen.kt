package com.example.splitpay

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable


class EmptyScreen(context: Context) : FrameLayout(context) {
    lateinit var message: String
    private var lottieFile: Int = R.raw.empty_state

    constructor(context: Context, message: String, lottieFile: Int) : this(context) {
        this.message = message
        this.lottieFile = lottieFile
    }

    fun initView() {
        inflate(context, R.layout.empty_screen, this)
        val lottieAnim = findViewById<LottieAnimationView>(R.id.lottieAnim)
        val txtMessage = findViewById<TextView>(R.id.lottieMessage)
        txtMessage.text = message
        lottieAnim.setAnimation(lottieFile)
        lottieAnim.repeatCount = LottieDrawable.INFINITE
    }
}