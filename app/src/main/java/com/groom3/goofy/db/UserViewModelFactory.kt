package com.groom3.goofy.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
        return super.create(modelClass)
    }
}