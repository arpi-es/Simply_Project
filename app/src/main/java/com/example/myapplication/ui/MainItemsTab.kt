package com.example.myapplication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.active_blue_dark
import com.example.myapplication.ui.theme.dark_grey
import com.example.myapplication.ui.theme.primary_black


enum class MainItem(val title: Int, val image: Int) {
    Lock(R.string.Lock, R.drawable.ic_lock),
    Unlock(R.string.Unlock, R.drawable.ic_unlock),
    Climate(R.string.Climate, R.drawable.climate),
    Charge(R.string.Charge, R.drawable.charge),
    Lights(R.string.Lights, R.drawable.lights),
}

@Composable
fun MainItemsTab(
    onTabSelected: (MainItem) -> Unit,
    selectedTab: MainItem,
    modifier: Modifier = Modifier,
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedTab.ordinal,
        containerColor = Color.Transparent,
        indicator = { tabPositions: List<TabPosition> ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTab.ordinal])
                    .fillMaxSize()
                    .padding(horizontal = 2.dp)
                    .border(BorderStroke(2.dp, active_blue_dark), RoundedCornerShape(10.dp))
            )
        },
        divider = { }
    ) {
        MainItem.values().forEachIndexed { index, mainItem ->
            val selected = index == selectedTab.ordinal
            MainItemText(
                mainItem = mainItem,
                selected = selected,
                onTabSelected = onTabSelected,
                index = index
            )
        }
    }
}

@Composable
private fun MainItemText(
    mainItem: MainItem,
    selected: Boolean,
    index: Int,
    onTabSelected: (MainItem) -> Unit,
) {
//    Tab(
//        modifier = Modifier
//            .padding(horizontal = 2.dp)
//            .clip(RoundedCornerShape(50.dp)),
//        selected = selected,
//        unselectedContentColor = dark_grey,
//        selectedContentColor = primary_black,
//        onClick = {
//            onTabSelected(MainItem.values()[index])
//        }
//    ) {

        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedButton(
                onClick = { },
                modifier = Modifier.size(50.dp),  //avoid the oval shape
                shape = CircleShape,
                border = BorderStroke(2.dp, dark_grey),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(contentColor = dark_grey)
            )
            {
                Image(
                    painter = painterResource(id = mainItem.image),
                    contentDescription = "Image",
                )
            }


            Text(
                text = stringResource(id = mainItem.title),
                style = TextStyle(
                    fontSize = 12.sp,
                    color = dark_grey
                ),
                textAlign = TextAlign.Center
            )

        }

//    }
}