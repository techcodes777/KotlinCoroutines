package com.eclatsol.kotlincoroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainVewModel : ViewModel() {

    init {
        viewModelScope.launch() {
            while (true){
                delay(500)
                Log.e("MainViewModel", "Hello World!")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("MainViewModel", "ViewModel Destroyed")
    }
}