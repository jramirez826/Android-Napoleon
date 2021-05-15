package com.jramirez.pruebanapoleon.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jramirez.pruebanapoleon.base.BaseViewModel
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.repository.PostRepository
import com.jramirez.pruebanapoleon.service.repository.PostRepositoryImpl
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository = PostRepositoryImpl()) :
    BaseViewModel() {

    private var postsLiveData = MutableLiveData<List<Post>>()

    fun getPostsLiveData(): LiveData<List<Post>> = postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            if (response.data != null)
                postsLiveData.postValue(response.data)
            else
                errorLiveData.postValue(response.message)
        }
    }
}