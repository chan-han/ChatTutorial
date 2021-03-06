package com.wpfl5.chattutorial.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers


open class BaseViewModel : ViewModel(){
    val coroutineIoContext = viewModelScope.coroutineContext + Dispatchers.IO

    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(coroutineIoContext) {
            emitSource(block())
        }
    }



}