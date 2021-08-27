package com.softwrengr.base.ui.activities


import androidx.activity.viewModels
import com.softwrengr.base.baseClasses.BaseActivity
import com.softwrengr.base.databinding.ActivityLoginBinding
import com.softwrengr.base.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(){

    private val viewModel : LoginViewModel by viewModels()


    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun setUpView() {

        binding.login.setOnClickListener {
            viewModel.login()
        }

    }

}