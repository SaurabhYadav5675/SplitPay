package com.example.splitpay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.splitpay.R
import com.example.splitpay.databinding.FragmentProfileBinding
import com.example.splitpay.utilities.Utility

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        Utility.showEmptyScreen(binding.root, requireContext(), "", R.raw.empty_state)
        return binding.root
    }
}