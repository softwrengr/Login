package com.softwrengr.base.baseClasses

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.softwrengr.base.ui.activities.MainActivity

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {
    private var mRootView: View? = null
    open lateinit var binding: VB

    @LayoutRes
    abstract fun getLayoutRes(): Int
    //    abstract fun getViewModel() : VM
    open fun init() {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        init(inflater, container!!)
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }


    fun init(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    fun getMainActivity(): MainActivity {
        return (activity as MainActivity)
    }
    fun showToast(message: String) {
        Toast.makeText(getMainActivity(), "" + message, Toast.LENGTH_SHORT).show()
    }

}