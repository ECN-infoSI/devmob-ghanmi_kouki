package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn: StateFlow<Boolean> = _isUserLoggedIn
    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    private val _transportMode = MutableStateFlow("")
    val transportMode: StateFlow<String> = _transportMode

    fun setUserName(name: String) {
        viewModelScope.launch { _userName.emit(name) }
    }

    fun setTransportMode(mode: String) {
        viewModelScope.launch { _transportMode.emit(mode) }
    }
    fun login(name: String) {
        _userName.value = name
        _isUserLoggedIn.value = true
    }
}
