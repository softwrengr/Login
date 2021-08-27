package com.softwrengr.base.baseClasses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

//Common for all activities
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    //private lateinit var mViewModel: VM
    lateinit var binding:VB
    var isDisableOnBackPress = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        setUpView()

    }

    abstract fun setUpView()

    abstract fun getViewBinding() : VB

//    @LayoutRes
//    abstract fun getLayoutRes(): Int

//    val binding by lazy {
//        DataBindingUtil.setContentView(this, getLayoutRes()) as VB
//    }
//    abstract fun getViewModel(): VM



    public override fun onResume() {
        super.onResume()
    }
    public override fun onPause() {
        super.onPause()
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun disableAutoFill() {
        window.decorView.importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
    }

    fun showToast(context: Context,message: String?){
        Toast.makeText(context,""+message,Toast.LENGTH_SHORT).show()
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }

}