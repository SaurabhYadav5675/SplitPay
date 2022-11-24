package com.example.splitpay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.splitpay.R
import com.example.splitpay.adapter.DailyRecordAdapter
import com.example.splitpay.databinding.FragmentRecordBinding
import com.example.splitpay.model.DailyRecord
import com.example.splitpay.utilities.Fonts
import com.example.splitpay.viewmodels.DailyRecordVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RecordFragment : Fragment() {
    private var _binding: FragmentRecordBinding? = null//nullable if not attached
    private val binding get() = _binding!!//make not nullable to get
    private lateinit var recordVM: DailyRecordVM

    private lateinit var txtDaily: TextView
    private lateinit var txtWallet: TextView
    private lateinit var listDaily: ListView
    private lateinit var listWallet: ListView

    private lateinit var dailyArrayList: ArrayList<DailyRecord>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecordBinding.inflate(layoutInflater, container, false)
        recordVM = ViewModelProvider(requireActivity())[DailyRecordVM::class.java]
        txtDaily = binding.txtDaily
        txtWallet = binding.txtWallet
        val switch = binding.switchRecord

        listDaily = binding.listDaily
        listWallet = binding.listWallet
        dailyArrayList = ArrayList()

        Fonts.setTextViewFont(txtDaily, Fonts.ROBOTO_MEDIUM)
        Fonts.setTextViewFont(txtWallet, Fonts.ROBOTO_MEDIUM)

        updateVisibility(switch.isChecked)
        switch.setOnCheckedChangeListener { _, checked ->
            run {
                updateVisibility(checked)
            }
        }
        setAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateVisibility(status: Boolean) {
        if (status) {
            listDaily.visibility = View.GONE
            listWallet.visibility = View.VISIBLE

            txtDaily.setTextColor(ContextCompat.getColor(requireContext(), R.color.offwhite))
            txtWallet.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            listDaily.visibility = View.VISIBLE
            listWallet.visibility = View.GONE

            txtDaily.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            txtWallet.setTextColor(ContextCompat.getColor(requireContext(), R.color.offwhite))
        }
        GlobalScope.launch { if (!status) recordVM.getRecords() }
    }

    private fun setAdapter() {
        recordVM.records.observe(viewLifecycleOwner, Observer { it ->
            //  if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
            if (it != null && it.isNotEmpty()) {
                dailyArrayList.clear()
                dailyArrayList = it as ArrayList<DailyRecord>
                val adapterDaily = DailyRecordAdapter(requireContext(), dailyArrayList)
                listDaily.adapter = adapterDaily
            } else {
                Toast.makeText(
                    context, "No data found", Toast.LENGTH_SHORT
                ).show()
            }
            // }
        })
    }
}