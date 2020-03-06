package com.example.app.view.login

import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.app.R
import com.example.app.view.base.BaseActivity
import com.example.common.viewmodel.login.ILoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ILoginViewModel>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        super.initView()
        button.setOnClickListener {
            viewModel.login(
                editText?.text?.toString() ?: "email@gmail.com",
                editText?.text?.toString() ?: "123456"
            )
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.isLoginSuccess.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Login successfully!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
