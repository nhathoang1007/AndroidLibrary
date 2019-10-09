package com.example.app.view.login

import androidx.lifecycle.Observer
import com.example.app.R
import com.example.app.view.base.BaseActivity
import com.example.common.model.error.ErrorMessage
import com.example.common.viewmodel.login.ILoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity<ILoginViewModel>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        viewModel.login("aa", "aa")
        viewModel.isLoading.observe(this, Observer<Boolean> {
            if (it) {
                showLoadingDialog()
            } else {
                dismissLoadingDialog()
            }
        })
        viewModel.error.observe(this, Observer<ErrorMessage> {
            handleError(it)
        })

        btn.setOnClickListener {
            viewModel.onStop()
        }
    }
}
