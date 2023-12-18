package com.example.harmonyhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyhome.composables.AddTask
import com.example.harmonyhome.composables.PreviewView
import com.example.harmonyhome.composables.TaskView
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonyHomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    var screen by remember {
                        mutableIntStateOf(0)
                    }
                    AnimatedContent(targetState = screen, label = "") {
                        when(it) {
                            0 -> Dashboard(floatingButtonClicked = { screen = 1 })
                            1 -> AddTask()
                            else -> Text("Else")
                        }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Dashboard(modifier: Modifier = Modifier, floatingButtonClicked: () -> Unit) {
    Scaffold(topBar = { TopAppBar({ Text("Hello Roommate!") }) }, floatingActionButton = {
        FloatingActionButton(
            onClick = { floatingButtonClicked() }, containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add task")
        }
    }, bottomBar = {
        NavigationBar {
            NavigationBarItem(selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") })
            NavigationBarItem(selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = "Calendar"
                    )
                })

        }
    }) {
        Column(Modifier.padding(it)) {
            PreviewView()
            TodayView()
        }

    }
}

@Composable
fun TodayView() {

    var offset by remember {
        mutableFloatStateOf(0f)
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text("Today", style = MaterialTheme.typography.headlineSmall)
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .border(1.dp, MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
                .verticalScroll(rememberScrollState())
        ) {
            TaskView()
            TaskView()
            TaskView()
            TaskView()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    HarmonyHomeTheme {
        Dashboard(floatingButtonClicked = {})
    }
}