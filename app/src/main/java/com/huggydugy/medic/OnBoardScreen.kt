package com.huggydugy.medic

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.huggydugy.medic.ui.theme.BlueLight
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.GrayLight
import com.huggydugy.medic.ui.theme.Green

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(){
    val next = listOf(
        "Пропустить",
        "Пропустить",
        "Пропустить",
        "Завершить"
    )
    val pagerState = rememberPagerState()
    Box(modifier = Modifier.fillMaxSize()){
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            pageCount = 4,
            state = pagerState
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {  },
                        text = next[it]
                    )
                    Image(painter = painterResource(id = R.drawable.shape_onboard), contentDescription = "shape")
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Анализы", color = Green)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Экспресс сбор и получение проб")
                Image(
                    modifier = Modifier
                        .width(100.dp),
                    painter = painterResource(id = R.drawable.illustration),
                    contentDescription = "flask"
                )
            }

        }
    }


}