package com.example.splitpay.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.splitpay.databinding.AdapterDailyRecordBinding
import com.example.splitpay.model.DailyRecord
import com.example.splitpay.utilities.Fonts


class DailyRecordAdapter(
    private val context: Context,
    private val dailyList: ArrayList<DailyRecord>
) :
    BaseAdapter() {

    override fun getCount(): Int {
        return dailyList.size
    }

    override fun getItem(position: Int): Any {
        return dailyList[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View? = p1
        val binding: AdapterDailyRecordBinding
        if (view == null) {
            binding =
                AdapterDailyRecordBinding.inflate(LayoutInflater.from(context), p2, false)
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as AdapterDailyRecordBinding
        }

        val txtTitle = binding.txtTitle
        val txtAmount = binding.txtAmount
        val txtDescription = binding.txtDescription
        val txtDate = binding.txtDate

        val record = dailyList[p0]

        txtTitle.text = record.title
        val rs = context.resources.getString(com.example.splitpay.R.string.Rs)
        txtAmount.text = "-$rs ${record.amount}"
        txtDescription.text = record.description
        txtDate.text="21 nov 2022  09:30pm"

        Fonts.setTextViewFont(txtTitle, Fonts.ROBOTO_BOLD)
        Fonts.setTextViewFont(txtAmount, Fonts.ROBOTO_BOLD)
        Fonts.setTextViewFont(txtDescription, Fonts.ROBOTO_REGULAR)

        return view
    }
}