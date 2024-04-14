package com.f11.assignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.f11.assignment.data.db.entity.Post
import com.f11.assignment.data.repo.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    val posts: Flow<PagingData<Post>> = repository.getPosts().cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            repository.refreshPosts()
        }
    }
}

class ViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}