package com.example.todoapp.data.RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")  //1st step
data class TaskItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val taskName : String,
    val isDone : Boolean=false,

)