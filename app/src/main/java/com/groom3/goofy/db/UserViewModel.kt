package com.groom3.goofy.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val users = repository.users
    lateinit var email : String


    fun insertUser(){
        viewModelScope.launch (Dispatchers.IO){
            repository.insert(User(0,email))
        }
    }
}