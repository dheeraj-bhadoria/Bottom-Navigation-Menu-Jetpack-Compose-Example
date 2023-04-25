package com.dheeraj.bottom_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dheeraj.bottom_navigation.ui.theme.Compose_material_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_material_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomNavigationExample()
                }
            }
        }
    }
}
@Composable
fun BottomNavigationExample() {
    val screens = listOf("Home", "Feed", "Post", "Alert", "Jobs")
    var selectedScreen by remember { mutableStateOf(screens.first()) }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(getIconForScreen(screen), contentDescription = screen) },
                        label = { Text(screen) },
                        selected = screen == selectedScreen,
                        onClick = { selectedScreen = screen },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Selected Screen: $selectedScreen")
            }

        }
    )
}

@Composable
fun getIconForScreen(screen: String): ImageVector {
    return when (screen) {
        "Home" -> Icons.Default.Home
        "Feed" -> Icons.Default.AccountBox
        "Post" -> Icons.Default.Add
        "Alert" -> Icons.Default.Notifications
        "Jobs" -> Icons.Default.Done
        else -> Icons.Default.Home
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationExamplePreview() {
    BottomNavigationExample()
}