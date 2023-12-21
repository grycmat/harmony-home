package com.example.harmonyhome.composables

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.harmonyhome.room.HarmonyHomeDb
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    application: Application
) : ViewModel() {
    private val db = HarmonyHomeDb.getDatabase(application);
    private val taskDao = db.taskDao()
    private val tasks = taskDao.getAllTasks()

    fun getTasks() = tasks
}