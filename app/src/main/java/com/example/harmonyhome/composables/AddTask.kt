package com.example.harmonyhome.composables


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddTask(viewModel: AddTaskViewModel = viewModel()) {

    val inputsModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

    val inputsShape = RoundedCornerShape(12.dp)

    var showDateSelector by remember {
        mutableStateOf(false)
    }

    var showAssigneeSelector by remember {
        mutableStateOf(false)
    }

    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    Scaffold(topBar = {
        TopAppBar(title = { Text("Task") })
    }) { paddingVals: PaddingValues ->
        if (showDateSelector) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                confirmButton = {
                    Button(onClick = {
                        viewModel.deadline(dateFormatter.format(Date(datePickerState.selectedDateMillis!!)))
                        showDateSelector = false

                    }) {
                        Text("Confirm", modifier = Modifier.padding(12.dp))
                    }
                },
                onDismissRequest = {
                    showDateSelector = false
                },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                DatePicker(state = datePickerState)
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(paddingVals)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            OutlinedTextField(
                label = { Text("What needs to be done?") },
                shape = inputsShape,
                modifier = inputsModifier,
                value = viewModel.taskName,
                onValueChange = { viewModel.taskName(it) }, singleLine = true
            )
            OutlinedTextField(
                label = { Text("Description") },
                shape = inputsShape,
                modifier = inputsModifier,
                value = viewModel.taskDesc,
                onValueChange = { viewModel.taskDesc(it) },
                maxLines = 5,
                minLines = 5
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = inputsModifier) {
                    ConstraintLayout {
                        val (label, input) = createRefs()
                        Text("Assignee", modifier = Modifier
                            .constrainAs(label) { top.linkTo(parent.top) }
                            .padding(end = 16.dp))
                        ExposedDropdownMenuBox(
                            modifier = Modifier
                                .constrainAs(input) { start.linkTo(label.start, margin = 100.dp) },
                            expanded = showAssigneeSelector,
                            onExpandedChange = { showAssigneeSelector = it }) {
                            Box(
                                Modifier
                                    .menuAnchor()
                                    .constrainAs(input) {
                                        start.linkTo(
                                            label.start,
                                            margin = 100.dp
                                        )
                                    }
                                    .height(30.dp)
                                    .fillMaxWidth()
                                    .padding(end = 200.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Gray,
                                        shape = RoundedCornerShape(11.dp)
                                    )
                            )
                            {
                                Row(
                                    Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        viewModel.assignee,
                                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                                    )
                                    Icon(
                                        modifier = Modifier.padding(top = 4.dp, end = 4.dp),
                                        imageVector = Icons.Outlined.ArrowDropDown,
                                        contentDescription = "Icon"
                                    )
                                }
                            }
                            ExposedDropdownMenu(
                                expanded = showAssigneeSelector,
                                onDismissRequest = { }) {
                                DropdownMenuItem(interactionSource = remember {
                                    MutableInteractionSource()
                                }, text = { Text("Myself") }, onClick = {
                                    viewModel.assignee("Myself")
                                    showAssigneeSelector = false
                                })
                                DropdownMenuItem(text = { Text("Someone else") }, onClick = {
                                    viewModel.assignee("Someone else")
                                    showAssigneeSelector = false
                                })
                            }
                        }
                    }


                }
                Row(verticalAlignment = Alignment.Bottom, modifier = inputsModifier) {
                    ConstraintLayout {
                        val (label, input) = createRefs()
                        Text(
                            "Deadline",
                            modifier = Modifier
                                .constrainAs(label) { top.linkTo(parent.top) }
                                .padding(end = 16.dp)
                        )
                        Box(
                            Modifier
                                .constrainAs(input) { start.linkTo(label.start, margin = 100.dp) }
                                .height(30.dp)
                                .fillMaxWidth()
                                .padding(end = 200.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(11.dp)
                                )
                                .clickable {
                                    showDateSelector = !showDateSelector
                                })
                        {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(viewModel.deadline, modifier = Modifier.padding(start = 12.dp, top = 2.dp))
                                Icon(
                                    modifier = Modifier.padding(top = 4.dp, end = 4.dp),
                                    imageVector = Icons.Outlined.ArrowDropDown,
                                    contentDescription = "Icon"
                                )
                            }
                        }
                    }
                }

            }
            TagsList(modifier = inputsModifier)
            Text(text = "Subtasks", style = MaterialTheme.typography.headlineSmall)
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