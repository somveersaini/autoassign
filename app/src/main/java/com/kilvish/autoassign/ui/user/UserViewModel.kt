package com.kilvish.autoassign.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kilvish.autoassign.data.user.UserRepo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel @Inject constructor(
    val userRepo: UserRepo
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val viewState = MutableLiveData<UserViewState>(InitialState)

    fun getUserViewState() = viewState

    fun postInitialState() {
        viewState.postValue(InitialState)
    }

    fun submitApplicationData(
        type: String,
        custTitle: String,
        pannumber: String,
        dob: String,
        aadharNumber: String,
        custName: String
    ) {
        viewState.postValue(LoadingState)
        val disposableSingleObserver = userRepo.submitApplication(type, custTitle, pannumber, dob, aadharNumber, custName)
            .subscribeOn(Schedulers.io())
            .subscribe({
                viewState.postValue(SuccessState(it))
            }, {
                viewState.postValue(ErrorState(it.message ?: " "))
            })
        addDisposable(disposableSingleObserver)
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}