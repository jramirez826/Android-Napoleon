package com.jramirez.pruebanapoleon.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jramirez.pruebanapoleon.presentation.base.BaseViewModel
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.model.User
import com.jramirez.pruebanapoleon.service.repository.UserRepository
import com.jramirez.pruebanapoleon.service.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

class DetailViewModel(
    private val post: Post?,
    private val repository: UserRepository = UserRepositoryImpl()
) :
    BaseViewModel() {

    private var userLiveData = MutableLiveData<User>()

    fun getUserLiveData(): LiveData<User> = userLiveData

    fun getUser() {
        post?.let {
            viewModelScope.launch {
                val response = repository.getUser(it.userId)
                if (response.data != null)
                    userLiveData.postValue(response.data)
                else
                    errorLiveData.postValue(response.message)
            }
        }
    }
}