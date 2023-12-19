package com.example.harmonyhome.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String = "asd",
    var description: String = "asdf",
    var deadline: String = "asdfa",
    var assignee: String = "aasaa"
)