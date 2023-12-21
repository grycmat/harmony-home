package com.example.harmonyhome.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.R
import com.example.harmonyhome.room.Task

@Composable
fun TaskView(task: Task) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_large))
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AssistChip(onClick = { /*TODO*/ }, label = { Text(task.assignee) })
            Row {
                Icon(
                    modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_small)),
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Type"
                )
                Text(text = task.deadline)
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_small))
        ) {
            Text(text = task.name, style = MaterialTheme.typography.headlineMedium)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = task.description, style = MaterialTheme.typography.bodyLarge)
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notifications")
        }
        Divider(
            Modifier.padding(top = dimensionResource(id = R.dimen.padding_small)), thickness = 1.dp
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TaskViewPreview() {
//    HarmonyHomeTheme {
//        TaskView()
//    }
//}