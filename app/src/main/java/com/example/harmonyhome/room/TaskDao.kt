package com.example.harmonyhome.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Query("SELECT * FROM tasks ORDER BY name ASC")
    fun getAllTasks(): Flow<List<Task>>
}