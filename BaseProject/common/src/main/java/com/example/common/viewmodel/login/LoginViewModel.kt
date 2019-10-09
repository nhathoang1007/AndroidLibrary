package com.example.common.viewmodel.login

import android.os.Handler
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

    override fun login(email: String, password: String) {
        repository.setLoading(true)
        Handler().postDelayed({
            disposable.add(
                repository.login(
                    email,
                    password
                ).compose(schedulerProvider.getObservableScheduler())
                    .subscribe({
                        repository.setError(ErrorMessage())
                        repository.setLoading(false)
                    }, {
                        it.printStackTrace()
                        val errorMessage = ErrorMessage()
                        errorMessage.onApiFailure(it)
                        repository.setError(errorMessage)
                        repository.setLoading(false)
                    })
            )
        }, 10000)

    }
}