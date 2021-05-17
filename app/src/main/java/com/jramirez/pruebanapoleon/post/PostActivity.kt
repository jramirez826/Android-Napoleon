package com.jramirez.pruebanapoleon.post

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import com.jramirez.pruebanapoleon.R
import com.jramirez.pruebanapoleon.base.CellClickListener
import com.jramirez.pruebanapoleon.databinding.ActivityPostBinding
import com.jramirez.pruebanapoleon.detail.DetailActivity
import com.jramirez.pruebanapoleon.model.Post
import com.jramirez.pruebanapoleon.utils.Constants
import com.jramirez.pruebanapoleon.utils.DeleteItemCallback

class PostActivity : AppCompatActivity(), CellClickListener<Post> {

    private lateinit var binding: ActivityPostBinding
    private lateinit var viewModel: PostViewModel
    private val adapter: PostAdapter = PostAdapter(this)
    private lateinit var deleteItemCallback: DeleteItemCallback

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
        val intent = Intent(this, DetailActivity::class.java)
        intent.apply {
            putExtra(Constants.POST_KEY, item)
        }
        startActivity(intent)
    }

    private fun createLiveDataObservers() {
        viewModel.getPostsLiveData().observe(this, { items ->
            adapter.update(items)
        })
    }

    private fun setUpView() {
        with(binding) {
            rvPosts.adapter = adapter
            deleteItemCallback = DeleteItemCallback(adapter)
            val itemTouchHelper = ItemTouchHelper(deleteItemCallback)
            itemTouchHelper.attachToRecyclerView(binding.rvPosts)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_delete_all -> adapter.removeItems()
        }
        return super.onOptionsItemSelected(item)
    }
}