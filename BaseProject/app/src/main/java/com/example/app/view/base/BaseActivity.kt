package com.example.app.view.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleObserver
import com.example.common.model.error.ErrorMessage
import com.example.common.viewmodel.base.IViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by jason on 02/10/2019.
 */
abstract class BaseActivity<T : IViewModel> : DaggerAppCompatActivity() {
    @Inject
    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        lifecycle.addObserver(viewModel as LifecycleObserver)
        initView()
    }

    /**
     * Define the layout res id can be used to [Activity.setContentView]
     *
     * @return the layout res id
     */
    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    /**
     * Init [View] components here. Such as set adapter for [RecyclerView], set listener
     * or anything else
     */
    protected open fun initView() {
        Log.e("AAAAAAA", "Hello world")
    }

    protected fun showLoadingDialog() {
        Toast.makeText(this, "Dialog Showing...", Toast.LENGTH_LONG).show()
    }

    protected fun dismissLoadingDialog() {
        Toast.makeText(this, "Dialog Dismissed...", Toast.LENGTH_LONG).show()
    }

    protected fun handleError(errorMessage: ErrorMessage) {
        Toast.makeText(this, "Error here.....", Toast.LENGTH_LONG).show()
    }
}