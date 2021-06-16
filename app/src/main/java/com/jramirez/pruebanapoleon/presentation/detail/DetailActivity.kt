package com.jramirez.pruebanapoleon.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jramirez.pruebanapoleon.databinding.ActivityDetailBinding
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.model.User
import com.jramirez.pruebanapoleon.presentation.utils.Constants

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var post: Post? = null
        intent.extras?.let {
            post = it.getParcelable(Constants.POST_KEY)
        }
        viewModel =
            ViewModelProvider(this, DetailViewModelFactory(post)).get(DetailViewModel::class.java)
        createLiveDataObservers()
        viewModel.getUser()
        post?.let { bindPost(it) }
    }

    private fun createLiveDataObservers() {
        viewModel.getUserLiveData().observe(this, Observer { user ->
            bindUser(user)
        })
    }

    private fun bindUser(user: User) {
        with(binding) {
            labAuthorName.text = user.name
            labAuthorEmail.text = user.email
            labAuthorPhone.text = user.phone
            labAuthorUsername.text = user.username
            labAuthorCity.text = user.address.city
            labAuthorCompany.text = user.company.name
        }
    }

    private fun bindPost(post: Post) {
        with(binding) {
            labPostTitle.text = post.title
            labPostDescription.text = post.body
        }
    }
}