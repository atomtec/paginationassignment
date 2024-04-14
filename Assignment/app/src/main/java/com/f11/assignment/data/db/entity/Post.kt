package com.f11.assignment.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//As this is a simple use case so same class is used as DTO, Domain Model and Entity
@Parcelize
@Entity
data class Post(
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) : Parcelable
