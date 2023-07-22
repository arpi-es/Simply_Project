package com.example.myapplication.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
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
fun MainItemBotton(
    mainItem: MainItem,
    selected: Boolean,
    index: Int,
    onTabSelected: (MainItem) -> Unit,
    loading : Boolean
) {

    Column(
        modifier = Modifier.padding(5.dp)
            .clickable(
                enabled = !selected,
                onClick = {
                    if (index < 2) {
                        onTabSelected(MainItem.values()[index])
                    }
                }
            ) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {

        Box {
            Image(
                painter = painterResource(id = mainItem.image),
                contentDescription = "Image",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(
                        (if (loading) 0.dp else 2.dp),
                        (if (selected) dark_grey else primary_black),
                        CircleShape),
                colorFilter = ColorFilter.tint((if (selected) dark_grey else primary_black))
            )

            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(size = 50.dp),
                    color = active_blue_dark,
                    strokeWidth = 2.dp
                )
            }



        }


        Text(
            text = stringResource(id = mainItem.title),
            style = TextStyle(
                fontSize = 12.sp,
                color = (if (selected) dark_grey else primary_black)
            ),
            textAlign = TextAlign.Center
        )
    }
}