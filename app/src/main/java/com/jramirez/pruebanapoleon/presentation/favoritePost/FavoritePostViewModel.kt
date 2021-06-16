package com.jramirez.pruebanapoleon.presentation.favoritePost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jramirez.pruebanapoleon.presentation.base.BaseViewModel
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.service.repository.RoomFavoritePostRepository
import com.jramirez.pruebanapoleon.service.repository.RoomFavoritePostRepositoryImpl

class FavoritePostViewModel(
    favoritePostRepository: RoomFavoritePostRepository = RoomFavoritePostRepositoryImpl()
) :
    BaseViewModel() {

    private var postsLiveData: LiveData<List<Post>> = MutableLiveData()

    init {
        postsLiveData = favoritePostRepository.getPosts()
    }

    fun getPostsLiveData(): LiveData<List<Post>> = postsLiveData

}
