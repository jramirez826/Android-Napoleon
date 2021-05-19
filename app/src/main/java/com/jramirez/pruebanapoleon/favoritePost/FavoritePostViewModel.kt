package com.jramirez.pruebanapoleon.favoritePost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jramirez.pruebanapoleon.base.BaseViewModel
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
