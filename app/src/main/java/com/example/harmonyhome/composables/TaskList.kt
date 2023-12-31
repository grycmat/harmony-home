package com.example.harmonyhome.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun TaskList(viewModel: TaskListViewModel = hiltViewModel()) {

    val coroutineScope = rememberCoroutineScope()
    val tasks = viewModel.getTasks().collectAsState(initial = emptyList())

    fun removeTask(id: Int) {
        coroutineScope.launch { viewModel.deleteById(id) }
    }

    LazyColumn {
        items(tasks.value) { task ->
            TaskView(task, onDismiss = {removeTask(it)})
        }

    }
}

