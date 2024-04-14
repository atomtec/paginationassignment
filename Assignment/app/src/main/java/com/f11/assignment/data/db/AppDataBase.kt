package com.f11.assignment.data.db


import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.f11.assignment.data.db.entity.Post


@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}


@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Post>)

    @Query("SELECT * FROM Post")
    fun getAllPosts(): PagingSource<Int, Post>
}