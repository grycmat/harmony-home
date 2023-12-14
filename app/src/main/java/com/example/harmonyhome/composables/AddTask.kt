package com.example.harmonyhome.composables


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask() {

    val inputsModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

    val inputsShape = RoundedCornerShape(12.dp)

    var taskName by remember {
        mutableStateOf("")
    }

    var taskDesc by remember {
        mutableStateOf("")
    }

    var showDateSelector by remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Task") })
    }) { paddingVals: PaddingValues ->
        if (showDateSelector) {
            DatePickerDialog(
                confirmButton = { Text("Confirm") },
                onDismissRequest = { showDateSelector = false },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                DatePicker(state = rememberDatePickerState())
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(paddingVals)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            OutlinedTextField(
                label = { Text("Name this task") },
                shape = inputsShape,
                modifier = inputsModifier,
                value = taskName,
                onValueChange = { taskName = it }, singleLine = true
            )
            OutlinedTextField(
                label = { Text("Description") },
                shape = inputsShape,
                modifier = inputsModifier,
                value = taskDesc,
                onValueChange = { taskDesc = it },
                maxLines = 5,
                minLines = 5
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = inputsModifier) {
                    Text("Assignee", modifier = Modifier.padding(end = 16.dp))
                    OutlinedTextField(
                        modifier = Modifier.height(28.dp).padding(end = 128.dp),
                        value = "",
                        onValueChange = {},
                        shape = inputsShape
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = inputsModifier) {
                    Text("Deadline", modifier = Modifier.padding(end = 16.dp))
                    Box(
                        Modifier
                            .height(28.dp)
                            .fillMaxWidth()
                            .padding(end = 128.dp)
                            .border(width = Dp.Hairline, color = Color.Black, shape = inputsShape)
                            .clickable {
                                showDateSelector = !showDateSelector
                            })
                }
            }
            TagsList(modifier = inputsModifier)
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