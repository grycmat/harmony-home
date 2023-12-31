package com.example.harmonyhome.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.harmonyhome.R

@Composable
fun AddTagDialog(onAdd: (tag: String) -> Unit) {

    var tagName by remember {
        mutableStateOf("")
    }

    Dialog(
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
        onDismissRequest = { println("dissmiss request") }) {
        Card {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(28.dp)
            ) {
                Text(
                    text = "Add Tag",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
                )
                OutlinedTextField(value = tagName, onValueChange = { tagName = it })
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_small))) {
                        Text(text = "Cancel")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Add")
                    }
                }
            }
        }
    }
}