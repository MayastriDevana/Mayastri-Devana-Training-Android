package com.example.bcasyariah.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T :ViewBinding> : Fragment(){
    private var _binding: T? = null
    protected val binding: T
        get() = _binding ?: throw IllegalStateException("Binding not initialized yet.")
    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): T
    abstract fun setupView()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}