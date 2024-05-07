package com.yandex.mobius360quest.to_hide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.yandex.mobius360quest.R

abstract class BaseViewBinbingFragment<T : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> T
) : Fragment() {

    private var _binding: T? = null

    protected val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflater(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val root = binding.root as ViewGroup
        root.forEach {
            it.isEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
