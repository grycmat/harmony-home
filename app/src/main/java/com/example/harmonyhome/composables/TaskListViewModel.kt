package com.example.harmonyhome.composables

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Query
import com.example.harmonyhome.room.HarmonyHomeDb
import com.example.harmonyhome.room.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    application: Application
) : ViewModel() {
    private val db = HarmonyHomeDb.getDatabase(application);
    private val taskDao = db.taskDao()

    fun getTasks() = taskDao.getAllTasks()
    suspend fun deleteTask(task: Task) {
        taskDao.delete(task)
    }


    suspend fun deleteById(id: Int) {
        taskDao.deleteById(id)
    }

}