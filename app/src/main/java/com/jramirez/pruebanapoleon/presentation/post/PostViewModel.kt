package com.jramirez.pruebanapoleon.presentation.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jramirez.pruebanapoleon.presentation.base.BaseViewModel
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.repository.*
import kotlinx.coroutines.launch

class PostViewModel(
    private val postRepository: PostRepository = PostRepositoryImpl(),
    private val roomFavoritePostRepository: RoomFavoritePostRepository = RoomFavoritePostRepositoryImpl(),
    private val roomReadPostRepository: RoomReadPostRepository = RoomReadPostRepositoryImpl()
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
            if (post.isFavorite)
                roomFavoritePostRepository.savePost(post)
            else
                roomFavoritePostRepository.deletePost(post.id)
        }
    }

    fun markPostAsRead(postId: Int) {
        viewModelScope.launch {
            roomReadPostRepository.saveReadPost(postId)
        }
    }
}