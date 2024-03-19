package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentMessageBinding

class HistoryFragment : BaseFragment<FragmentMessageBinding>(){
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}