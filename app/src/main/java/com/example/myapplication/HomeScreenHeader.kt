package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.dark_grey
import com.example.myapplication.ui.theme.primary_black

@Preview
@Composable
fun HomeScreenHeader(modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(vertical = 6.dp),
    ) {

        Icon(
            painter = painterResource(R.drawable.ic_support),
            contentDescription = "support",
            modifier = Modifier
                .padding(start = 28.dp)
        )

//        Text(
//            "MY NISSAN ARIYA",
//            style = TextStyle(
//                fontSize = 16.sp,
//            ),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.weight(1f),
//
//        )

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.small_lock),
                contentDescription = "small_lock"
            )
            Text(
                "MY NISSAN ARIYA",
                style = TextStyle(
                    fontSize = 16.sp,
                ),
                textAlign = TextAlign.Center
            )
        }

        Icon(
            painter = painterResource(R.drawable.notification),
            contentDescription = "notification",
            modifier = Modifier
                .padding(end = 28.dp)

        )
    }

}

@Preview
@Composable
fun HomeScreenInfo(modifier: Modifier = Modifier) {


    Row(
        modifier = modifier.fillMaxWidth().padding(start = 28.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        Column {
            Text(
                "Est. Range",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = dark_grey
                )
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "120",
                    style = TextStyle(
                        fontSize = 40.sp,
                        color = primary_black
                    )
                )

                Text(
                    "mi",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = primary_black
                    )
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(R.drawable.cloud),
                    contentDescription = "cloud",
                    modifier = Modifier
                        .padding(end = 4.dp)

                )

                Text(
                    "70° • Irvine, CA",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontSize = 14.sp,
                    ),
                )


            }


        }
        Spacer(modifier = Modifier.width(16.dp))
//        Column {
//            Text(
//                stringResource(R.string.average_sleep_time_heading),
//                style = SmallHeadingStyle
//            )
//            Text(
//                stringResource(R.string.placeholder_text_ave_time_2),
//                style = HeadingStyle,
//            )
//        }
    }
    Spacer(modifier = Modifier.height(32.dp))
}