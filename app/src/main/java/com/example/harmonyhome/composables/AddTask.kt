package com.example.harmonyhome.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AddTask() {

    val inputsModifier = Modifier
        .padding(16.dp)

    var taskName by remember {
        mutableStateOf("")
    }

    var taskDesc by remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Task") })
    }) { paddingVals ->
        Column(Modifier.padding(paddingVals)) {
            OutlinedTextField(
                shape = RoundedCornerShape(12.dp),
                modifier = inputsModifier,
                value = taskName,
                onValueChange = { taskName = it }, singleLine = true
            )
            OutlinedTextField(
                shape = RoundedCornerShape(12.dp),
                modifier = inputsModifier,
                value = taskDesc,
                onValueChange = { taskDesc = it },
                maxLines = 5,
                minLines = 5
            )
            Column {
                Row {
                    Text("Assignee")
                    OutlinedTextField(value = "", onValueChange = {})
                }
                Row {
                    Text("Deadline")
                    OutlinedTextField(value = "", onValueChange = {})
                }
                TagsList()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddTaskPreview() {
    HarmonyHomeTheme {
        AddTask()
    }

}