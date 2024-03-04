package com.huggydugy.medic.presentation.screens.board

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.Green
import com.huggydugy.medic.ui.theme.Roboto

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardScreen(
    navController: NavController,
    //event: (OnBoardEvent) -> Unit
){
    val elements = listOf(
        ElementBoard(
            image = R.drawable.illustration,
            header = "Анализы",
            description = "Экспресс сбор и получение проб"
        ),
        ElementBoard(
            image = R.drawable.illustration2,
            header = "Уведомления",
            description = "Вы быстро узнаете о результатах",
            size = 350.dp
        ),
        ElementBoard(
            image = R.drawable.illustration3,
            header = "Мониторинг",
            description = "Наши врачи всегда наблюдают \n" +
                "за вашими показателями здоровья",
            size = 330.dp
        )
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount ={ elements.size }
    )
    Box(modifier = Modifier.fillMaxSize()){
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            state = pagerState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clickable {
                                //event(OnBoardEvent.SaveAppEntry)
                                navController.navigate(Screen.SignUp.route)
                            },
                        text = if(it == elements.lastIndex) "Завершить" else "Пропустить",
                        fontSize = 20.sp,
                        fontFamily = Roboto,
                        color = BlueLight2,
                        fontWeight = FontWeight.Normal
                    )
                    Image(
                        painter = painterResource(id = R.drawable.shape_onboard),
                        contentDescription = "shape",
                        modifier = Modifier
                            .size(170.dp)
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = elements[it].header,
                    color = Green,
                    fontSize = 20.sp,
                    fontFamily = Roboto,

                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = elements[it].description,
                    color = Gray,
                    fontSize = 14.sp,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(elements.size){
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .drawWithContent {
                                    if (pagerState.currentPage == it) {
                                        drawRoundRect(
                                            color = BlueLight2,
                                            size = size,
                                            cornerRadius = CornerRadius.Zero
                                        )
                                        drawCircle(
                                            color = Color.White,
                                            center = size.center,
                                            radius = 0.dp.toPx()
                                        )
                                    } else {
                                        drawRoundRect(
                                            color = BlueLight2,
                                            size = size,
                                            cornerRadius = CornerRadius.Zero
                                        )
                                        drawCircle(
                                            color = Color.White,
                                            center = size.center,
                                            radius = 6.dp.toPx()
                                        )
                                    }
                                }
                                .background(BlueLight2)
                                .size(13.dp)
                        )
                    }
                }
                Image(
                    modifier = Modifier
                        .weight(1f)
                        .size(elements[it].size),
                    painter = painterResource(id = elements[it].image),
                    contentDescription = null
                )
            }

        }
    }


}