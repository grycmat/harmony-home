package com.example.harmonyhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.harmonyhome.composables.AddTask
import com.example.harmonyhome.composables.PreviewView
import com.example.harmonyhome.composables.TaskList
import com.example.harmonyhome.ui.theme.HarmonyHomeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonyHomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController, startDestination = "dashboard",
                    ) {
                        composable("dashboard") {
                            Dashboard() {
                                navController.navigate("addTask")
                            }
                        }
                        composable("addTask") {
                            AddTask(onGoBack = { navController.navigate("dashboard") })
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
            onClick = { floatingButtonClicked() },
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add task")
        }
    }, bottomBar = {
        NavigationBar {
            NavigationBarItem(selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") })
            NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange, contentDescription = "Calendar"
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

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text("Today", style = MaterialTheme.typography.headlineSmall)
        TaskList()
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    HarmonyHomeTheme {
        Dashboard(floatingButtonClicked = {})
    }
}