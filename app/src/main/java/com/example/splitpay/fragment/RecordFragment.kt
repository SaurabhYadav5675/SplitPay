package com.example.splitpay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.splitpay.R
import com.example.splitpay.adapter.DailyRecordAdapter
import com.example.splitpay.databinding.FragmentRecordBinding
import com.example.splitpay.model.DailyRecord
import com.example.splitpay.utilities.Fonts

class RecordFragment : Fragment() {
    private var _binding: FragmentRecordBinding? = null//nullable if not attached
    private val binding get() = _binding!!//make not nullable to get

    private lateinit var txtDaily: TextView
    private lateinit var txtWallet: TextView
    private lateinit var listDaily: ListView
    private lateinit var listWallet: ListView

    override
    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecordBinding.inflate(layoutInflater, container, false)

        txtDaily = binding.txtDaily
        txtWallet = binding.txtWallet
        val switch = binding.switchRecord

        listDaily = binding.listDaily
        listWallet = binding.listWallet

        Fonts.setTextViewFont(txtDaily, Fonts.ROBOTO_MEDIUM)
        Fonts.setTextViewFont(txtWallet, Fonts.ROBOTO_MEDIUM)

        updateVisibility(switch.isChecked)

        switch.setOnCheckedChangeListener { _, checked ->
            run {
                updateVisibility(checked)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateVisibility(status: Boolean) {
        setAdapter(status)
        if (status) {
            listDaily.visibility = View.GONE
            listWallet.visibility = View.VISIBLE

            txtDaily.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey2))
            txtWallet.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        } else {
            listDaily.visibility = View.VISIBLE
            listWallet.visibility = View.GONE

            txtDaily.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            txtWallet.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey2))
        }
    }

    //https://www.youtube.com/watch?v=WG4QgVABQws for flutter module
    //https://www.oodlestechnologies.com/blogs/how-to-merge-a-flutter-project-in-native-android-project/

    //https://docs.flutter.dev/development/add-to-app/android/project-setup
    //https://docs.flutter.dev/development/add-to-app/android/add-flutter-screen?tab=cached-engine-with-initial-route-kotlin-tab


    private fun setAdapter(status: Boolean) {
        if (!status) run {
            val dailyList: ArrayList<DailyRecord> = ArrayList()
            dailyList.add(
                DailyRecord(
                    1,
                    "test1",
                    "Create a new class RvAdapter.kt this will act as an Adapter class for the recycler view. Using View binding we use the generated class of the layout single_item.xml",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    2,
                    "test1",
                    "Go to the single_item.xml file and refer to the following code. Below is the code for the single_item.xml file.",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    3,
                    "test1",
                    "Go to build.gradle(app) and the following dependency inside the android tag and click sync now",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    4,
                    "test1",
                    "Create a new class RvAdapter.kt this will act as an Adapter class for the recycler view. Using View binding we use the generated class of the layout single_item.xml",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    5,
                    "test1",
                    "Go to build.gradle(app) and the following dependency inside the android tag and click sync now",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    6,
                    "test1",
                    "Go to the single_item.xml file and refer to the following code. Below is the code for the single_item.xml file.",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            dailyList.add(
                DailyRecord(
                    7,
                    "test1",
                    "Create a new class RvAdapter.kt this will act as an Adapter class for the recycler view. Using View binding we use the generated class of the layout single_item.xml",
                    "", 100,
                    "",
                    "",
                    ""
                )
            )
            val adapterDaily = this.context?.let { DailyRecordAdapter(it, dailyList) }
            listDaily.adapter = adapterDaily
        }
    }
}