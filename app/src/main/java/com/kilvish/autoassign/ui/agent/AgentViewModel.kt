package com.kilvish.autoassign.ui.agent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kilvish.autoassign.data.agent.AgentRepo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AgentViewModel @Inject constructor(
    val agentRepo: AgentRepo
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val viewState = MutableLiveData<AgentViewState>(InitialState)

    fun getAgentState() = viewState

    fun postInitialState() {
        viewState.postValue(InitialState)
    }

    fun fetchAgentData(type: String) {
        viewState.postValue(LoadingState)
        val disposableSingleObserver = agentRepo.getAutoAssignData(type)
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