package com.jramirez.pruebanapoleon.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jramirez.pruebanapoleon.model.Post

class DetailViewModelFactory(private val post: Post) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(post) as T
    }
}