package com.example.splitpay.dialogbox

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.splitpay.R

class InformationDialog(context: Context, themeId: Int) : Dialog(context, themeId) {
    lateinit var title: String
    lateinit var message: String
    var onCloseClick: View.OnClickListener? = null

    constructor(@NonNull context: Context, themeId: Int, title: String, message: String) : this(
        context,
        themeId
    ) {
        this.title = title
        this.message = message
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_information)
        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        val txtMessage = findViewById<TextView>(R.id.txtMessage)
        val imgClose = findViewById<ImageView>(R.id.imgClose)

        imgClose.setOnClickListener {
            onCloseClick?.onClick(it)
        }
    }

    fun onCloseClicked(onClickListener: View.OnClickListener) {
        this.onCloseClick = onClickListener
    }
}