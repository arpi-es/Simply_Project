package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.bottomnav.BottomNavigation
import com.example.myapplication.bottomnav.NavigationGraph
import com.example.myapplication.home.HomeViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.util.TransparentSystemBars


class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyApplicationTheme {
                TransparentSystemBars()
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),

                    ) {
                    MainScreenView(viewModel = viewModel)
                }
            }
        }
    }
}

@Suppress("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(0.dp)
        ) {
            NavigationGraph(navController = navController, viewModel = viewModel)
        }
    }
}


