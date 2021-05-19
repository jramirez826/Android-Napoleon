package com.jramirez.pruebanapoleon.favoritePost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jramirez.pruebanapoleon.databinding.FragmentFavoritePostBinding
import com.jramirez.pruebanapoleon.post.PostAdapter

class FavoritePostFragment : Fragment() {

    private var _binding: FragmentFavoritePostBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FavoritePostViewModel
    private val adapter: PostAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritePostBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoritePostViewModel::class.java)
        setUpObserver()
        binding.rvFavoritePost.adapter = adapter
    }

    private fun setUpObserver() {
        viewModel.getPostsLiveData().observe(this, {
            adapter.update(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FavoritePostFragment()
    }
}