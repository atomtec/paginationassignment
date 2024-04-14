package com.f11.assignment.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.f11.assignment.data.db.entity.Post
import com.f11.assignment.data.db.PostDao
import com.f11.assignment.data.api.RetrofitClient
import kotlinx.coroutines.flow.Flow

class PostRepository(private val postDao: PostDao) {

    private val apiService = RetrofitClient.apiService

    fun getPosts(): Flow<PagingData<Post>> = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false),
        pagingSourceFactory = { postDao.getAllPosts() }
    ).flow

    suspend fun refreshPosts() {
        val posts = apiService.fetchPosts()
        postDao.insertAll(posts)
    }
}
