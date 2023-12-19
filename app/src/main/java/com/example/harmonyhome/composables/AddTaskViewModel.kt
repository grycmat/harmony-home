package com.example.harmonyhome.composables

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.harmonyhome.room.Task

class AddTaskViewModel : ViewModel() {
    private val _deadline = mutableStateOf("")
    val deadline: String by _deadline
    fun deadline(nextDeadline: String) {
        _deadline.value = nextDeadline
    }

    private val _taskName =
        mutableStateOf("")
    val taskName: String by _taskName
    fun taskName(nextTaskName: String) {
        _taskName.value = nextTaskName
    }

    private val _taskDesc =
        mutableStateOf("")
    val taskDesc: String by _taskDesc
    fun taskDesc(nextTaskDesc: String) {
        _taskDesc.value = nextTaskDesc
    }

    private val _assignee =
        mutableStateOf("Myself")
    val assignee: String by _assignee
    fun assignee(nextAssignee: String) {
        _assignee.value = nextAssignee
    }

    fun createTask(): Task {
        return Task(
            name = taskName,
            description = taskDesc,
            assignee = assignee,
            deadline = deadline
        )
    }
}