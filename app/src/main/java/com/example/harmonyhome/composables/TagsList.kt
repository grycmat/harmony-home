package com.example.harmonyhome.composables

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.R
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsList(modifier: Modifier = Modifier) {
    val tagList = remember {
        mutableStateListOf("tag 1", "tag 2", "tag 3")
    }

    var showAddTagDialog by remember {
        mutableStateOf(false)
    }

    if (showAddTagDialog) {
        AddTagDialog(onAdd = { addTag(it) } )
    }


    Row(modifier = modifier) {
        Text(modifier = Modifier.padding(top = 14.dp, end = dimensionResource(id = R.dimen.padding_medium)), text = "Tags")
        FlowRow {
            AssistChip(
                modifier = Modifier.padding(4.dp),
                onClick = { showAddTagDialog = true },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Add Tag"
                    )
                },
                label = { Text("Add Tag") })
            tagList.forEach { tag ->
                AssistChip(
                    modifier = Modifier.padding(4.dp),
                    onClick = { removeTag(tag) },
                    label = { Text(tag) }
                )
            }
        }
    }
}

fun addTag(tag: String) {

}

fun removeTag(tag: String) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun TagsListPreview() {
    HarmonyHomeTheme {
        TagsList()
    }
}