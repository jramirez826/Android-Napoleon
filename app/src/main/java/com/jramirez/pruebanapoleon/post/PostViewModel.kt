package com.jramirez.pruebanapoleon.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jramirez.pruebanapoleon.base.BaseViewModel
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.repository.PostRepository
import com.jramirez.pruebanapoleon.service.repository.PostRepositoryImpl
import com.jramirez.pruebanapoleon.service.repository.RoomFavoritePostRepository
import com.jramirez.pruebanapoleon.service.repository.RoomFavoritePostRepositoryImpl
import kotlinx.coroutines.launch

class PostViewModel(
    private val postRepository: PostRepository = PostRepositoryImpl(),
    private val roomFavoritePostRepository: RoomFavoritePostRepository = RoomFavoritePostRepositoryImpl()
) :
    BaseViewModel() {

    private var postsLiveData = MutableLiveData<List<Post>>()

    fun getPostsLiveData(): LiveData<List<Post>> = postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            val response = postRepository.getPosts()
            if (response.data != null)
                postsLiveData.postValue(response.data)
            else
                errorLiveData.postValue(response.message)
        }
    }

    fun manageFavoritePost(post: Post) {
        viewModelScope.launch {
            post.isFavorite?.let {
                if (it)
                    roomFavoritePostRepository.savePost(post)
                else
                    roomFavoritePostRepository.deletePost(post.id)
            }
        }
    }
}