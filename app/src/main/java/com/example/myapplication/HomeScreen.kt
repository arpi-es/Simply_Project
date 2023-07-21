package com.example.myapplication


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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.main_BG


@Preview(showBackground = true)
@Preview(device = Devices.FOLDABLE, showBackground = true)
@Composable
fun HomeScreen() {

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


        var selectedTab by remember { mutableStateOf(MainItem.Unlock) }

        Row(modifier = Modifier.fillMaxWidth().offset(y = 328.dp)) {

            MainItemsTab(
                onTabSelected = { selectedTab = it },
                selectedTab = selectedTab,
            )
        }

    }

}
