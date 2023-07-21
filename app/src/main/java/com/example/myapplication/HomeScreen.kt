package com.example.myapplication


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.main_BG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val lockState = viewModel.lockState


    Box(modifier = Modifier.fillMaxSize().background(color = main_BG)) {
        Image(
            painter = painterResource(R.drawable.morning),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopStart
        )

        Row(
            modifier = Modifier.fillMaxWidth().offset(y = 153.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(R.drawable.car),
                contentDescription = null,

                modifier = Modifier
                    .width(218.dp)
                    .height(159.dp),
            )
        }


        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(24.dp))
            HomeScreenHeader(Modifier.fillMaxSize())

            Spacer(modifier = Modifier.height(24.dp))
            HomeScreenInfo(Modifier.fillMaxSize())

            Spacer(modifier = Modifier.height(24.dp))

        }


        var selectedTab by remember { mutableStateOf(MainItem.Lock) }
        val openDialog = remember { mutableStateOf(false) }


        val context = LocalContext.current


        when (lockState.value) {
            LockState.LOCKED -> {}
            LockState.LOADING -> {
                LaunchedEffect(Unit) {
                    showMessage(context, "Waking ARIYA to unlock...")
                    delay(5000L)
                    viewModel.changeLock(LockState.UNLOCK)
                    showMessage(context, "ARIYA unlocked")
                }
            }

            LockState.UNLOCK -> {}
        }

        Row(
            modifier = Modifier.fillMaxWidth().offset(y = 328.dp).padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            MainItem.values().forEachIndexed { index, mainItem ->
                val selected = index == selectedTab.ordinal
                val loading =
                    lockState.value.toString() == LockState.LOADING.name && (mainItem == MainItem.Unlock)
                MainItemBotton(
                    mainItem = mainItem,
                    selected = selected,
                    onTabSelected = { it ->
                        run {
                            if (it == MainItem.Unlock) {
                                openDialog.value = true
                            } else {
                                selectedTab = it
                            }
                        }
                    },
                    index = index,
                    loading = loading,

                    )
            }
        }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Are you sure?") },
                text = { Text("This action will remotely unlock your vehicle. ") },
                confirmButton = {
                    Button(onClick = {
                        openDialog.value = false
                        selectedTab = MainItem.Unlock
                        viewModel.changeLock(LockState.LOADING)
                    })
                    {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text("No")
                    }
                },
            )
        }
    }

}


fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}