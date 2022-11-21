package com.example.splitpay.utilities

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView

object Fonts {
    private const val FONT_ROBOTO_BLACK = "fonts/Roboto-Black.ttf"
    private const val FONT_ROBOTO_BOLD = "fonts/Roboto-Bold.ttf"
    private const val FONT_ROBOTO_LIGHT = "fonts/Roboto-Light.ttf"
    private const val FONT_ROBOTO_MEDIUM = "fonts/Roboto-Medium.ttf"
    private const val FONT_ROBOTO_REGULAR = "fonts/Roboto-Regular.ttf"
    private const val FONT_ROBOTO_THIN = "fonts/Roboto-Thin.ttf"

    const val ROBOTO_BLACK = 6
    const val ROBOTO_BOLD = 7
    const val ROBOTO_LIGHT = 8
    const val ROBOTO_MEDIUM = 9
    const val ROBOTO_REGULAR = 10
    const val ROBOTO_THIN = 11

    fun setTextViewFont(textView: TextView, font: Int) {
        textView.typeface = getTypeFace(textView.context, font)
    }

    private fun getTypeFace(context: Context, font: Int): Typeface {

        val typeface: Typeface = when (font) {
            ROBOTO_BLACK -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_BLACK)
            ROBOTO_BOLD -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_BOLD)
            ROBOTO_LIGHT -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_LIGHT)
            ROBOTO_MEDIUM -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_MEDIUM)
            ROBOTO_REGULAR -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_REGULAR)
            ROBOTO_THIN -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_THIN)
            else -> Typeface.createFromAsset(context.assets, FONT_ROBOTO_REGULAR)
        }
        return typeface
    }
}