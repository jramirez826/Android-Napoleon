package com.jramirez.pruebanapoleon.post

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jramirez.pruebanapoleon.base.CellClickListener
import com.jramirez.pruebanapoleon.databinding.ActivityPostBinding
import com.jramirez.pruebanapoleon.model.Post

class PostActivity : AppCompatActivity(), CellClickListener<Post> {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel
    private val adapter: PostAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        createLiveDataObservers()
        setUpView()
        viewModel.loadPosts()
    }

    override fun onCellClickListener(item: Post) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
    }

    private fun createLiveDataObservers() {
        viewModel.getPostsLiveData().observe(this, Observer { items ->
            adapter.update(items)
        })
    }

    private fun setUpView() {
        with(binding) {
            rvPosts.adapter = adapter
        }
    }
}