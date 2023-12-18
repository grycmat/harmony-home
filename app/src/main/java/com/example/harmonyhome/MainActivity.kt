package com.example.harmonyhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.composables.PreviewView
import com.example.harmonyhome.composables.TaskView
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonyHomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dashboard()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopAppBar({ Text("Hello Roommate!") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add task")
            }
        },
    ) {
        Column(Modifier.padding(it)) {
            PreviewView()
            TodayView()
        }

    }
}

@Composable
fun TodayView() {
    Column(Modifier.fillMaxWidth().padding(top = 16.dp)) {
        Text("Today", style = MaterialTheme.typography.headlineSmall)
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .border(1.dp, MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
        ) {

            TaskView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    HarmonyHomeTheme {
        Dashboard()
    }
}