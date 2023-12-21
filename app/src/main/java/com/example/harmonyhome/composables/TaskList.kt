package com.example.harmonyhome.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.example.harmonyhome.room.HarmonyHomeDb
import com.example.harmonyhome.room.Task
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TaskList(viewModel: TaskListViewModel = viewModel()) {

    val tasks = viewModel.getTasks().collectAsState(initial = emptyList())

    LazyColumn {
        items(tasks.value) { task ->
            TaskView(task)
        }
    }
}