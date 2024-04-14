package com.f11.assignment

import android.app.Application
import androidx.room.Room
import com.f11.assignment.data.db.AppDatabase
import com.f11.assignment.data.repo.PostRepository

class AssignmentApp : Application() {
    private lateinit var database: AppDatabase
    lateinit var repository: PostRepository

    override fun onCreate() {
        super.onCreate()
        initializeDatabase()
        initializeRepository()
    }

    private fun initializeDatabase() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "my_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    private fun initializeRepository() {
        repository = PostRepository(database.postDao())
    }
}
