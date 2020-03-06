package com.example.common.viewmodel.login

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.data.network.SchedulerProvider
import com.example.common.model.error.ErrorMessage
import com.example.common.repository.login.LoginRepository
import com.example.common.viewmodel.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by jason on 02/10/2019.
 */
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val schedulerProvider: SchedulerProvider
) :
    BaseViewModel(repository),
    ILoginViewModel {

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    override val isLoginSuccess: LiveData<Boolean>
        get() = _isLoginSuccess

    override fun login(email: String, password: String) {
        disposable.add(
            repository.login(
                email,
                password
            ).compose(schedulerProvider.getObservableScheduler())
                .doOnSubscribe {
                    isLoading.postValue(true)
                }
                .doFinally {
                    isLoading.postValue(false)
                }
                .subscribe({
                    _isLoginSuccess.postValue(true)
                }, {
                    error.postValue(ErrorMessage(it))
                })
        )
    }
}