package com.w1nkkkk.binchecker.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.BinRepository
import com.w1nkkkk.binchecker.domain.ConnectivityReceiver
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BinViewModel (
    private val repository: BinRepository
) : ViewModel() {
    sealed class State {
        data class Success(val bin: BinModel, val binNum : Int) : State()
        data class Error(val error: Throwable) : State()
    }

    private val _bin : MutableLiveData<State> = MutableLiveData()
    val bin : LiveData<State> = _bin

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _bin.postValue(State.Error(exception))
    }

    fun getBin(bin : Int) {
        CoroutineScope(coroutineExceptionHandler + Dispatchers.IO).launch {
            checkConnection {
                val data = repository.getBin(bin)
                _bin.postValue(State.Success(data, bin))
            }
        }
    }

    private suspend fun checkConnection(work : suspend () -> Unit) {
        if (ConnectivityReceiver.isInternetConnect) {
            work()
        }
        else {
            throw Exception("Check your internet connection")
        }
    }

}