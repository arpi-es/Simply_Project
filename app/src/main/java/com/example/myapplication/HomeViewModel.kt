package com.example.myapplication

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel  : ViewModel() {

    private val _lock = mutableStateOf(LockState.LOCKED)
    val lockState: State<LockState> get() = _lock

    fun changeLock(state: LockState) {
        _lock.value = state
    }
}


enum class LockState { LOCKED, LOADING, UNLOCK }