package com.huggydugy.medic.screens.scaffold.tests

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Blue
import com.huggydugy.medic.ui.theme.BlueLight
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.BlueLight3
import com.huggydugy.medic.ui.theme.BlueLight4
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.GrayLight4
import com.huggydugy.medic.ui.theme.Roboto
import com.huggydugy.medic.ui.theme.White
import com.huggydugy.medic.ui.theme.White2
import com.huggydugy.medic.ui.theme.White3

private val PADDING = 20.dp
@Composable
fun TestsScreen(navController: NavController){
    val scrollBehavior = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollBehavior)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Events()
        Spacer(modifier = Modifier.height(30.dp))
        CatalogTests()
    }

}

@Composable
private fun Events(){
    val cards = listOf(
        CardEventData.Card1,
        CardEventData.Card2
    )
    Column{
        Text(
            text = "Акции и новости",
            color = Gray,
            fontFamily = Roboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = PADDING)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = PADDING),
            horizontalArrangement = Arrangement.spacedBy(PADDING)
        ){
            items(cards.size){
                CardEvent(
                    cards[it].image,
                    cards[it].headText,
                    cards[it].descr,
                    cards[it].price,
                    cards[it].gradient,
                    cards[it].textWidth
                )
            }

        }
    }

}

@Composable
private fun CardEvent(
    image: Int,
    headText: String,
    descr: String,
    price: String,
    gradient: List<Color>,
    textWidth: Dp = 150.dp
){
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = gradient
                    )
                ),
            horizontalArrangement = SpaceBetween,
            ) {
            Column(
                modifier = Modifier
                    .width(textWidth)
                    .fillMaxHeight()
                    .padding(start = 10.dp, top = 15.dp, bottom = 10.dp),
                verticalArrangement = SpaceBetween
            ) {
                Text(
                    text = headText,
                    modifier = Modifier.wrapContentSize(),
                    textAlign = TextAlign.Left,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )
                Column {
                    Text(
                        text = descr,
                        modifier = Modifier.wrapContentSize(),
                        textAlign = TextAlign.Left,
                        fontSize = 14.sp,
                        color = White,
                        fontFamily = Roboto
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = price,
                        modifier = Modifier.wrapContentSize(),
                        fontSize = 25.sp,
                        textAlign = TextAlign.Left,
                        color = White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Roboto
                    )
                }
            }
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
private fun ButtonCatalog(label: String, isPressed: Boolean){
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clickable { }
            .clip(RoundedCornerShape(30))
            .background(if (isPressed) Blue else GrayLight2),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = label,
            color = Gray,
            modifier = Modifier.padding(18.dp),
            fontFamily = Roboto
        )
    }
}

@Composable
private fun CardCatalog(
    title: String,
    time: String,
    price: String,
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .shadow(
                2.dp,
                RoundedCornerShape(10)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(20.dp),
            verticalArrangement = SpaceBetween
        ) {
            Text(
                text = title,
                color = Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Roboto
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = time,
                        color = Gray,
                        fontSize = 15.sp,
                        fontFamily = Roboto
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = price,
                        color = Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = Roboto
                    )
                }
                Button(
                    modifier = Modifier
                        .wrapContentSize(),
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                        contentColor = White
                    )
                ) {
                    Text(text = "Добавить", fontSize = 13.sp, fontFamily = Roboto)
                }
            }
        }
    }
}

@Composable
private fun CatalogTests(){
    val buttons = listOf(
       "Популярное", "Covid", "Комплексные",
       "Чекапы", "Биохимия", "Гормоны",
       "Иммунитет", "Витамины", "Аллергены",
       "Анализ крови", "Анализ мочи", "Анализ кала",
        "Только в клинике"
    )
    val cards = listOf(
        CardCatalogData.Card1,
        CardCatalogData.Card2,
        CardCatalogData.Card3,
        CardCatalogData.Card4,
        CardCatalogData.Card5,
        CardCatalogData.Card6,
        CardCatalogData.Card7
    )
    Column {
        Text(
            text = "Каталог анализов",
            color = Gray,
            fontFamily = Roboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = PADDING)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(PADDING),
            contentPadding = PaddingValues(horizontal = PADDING)
        ){
            items(buttons.size){
                ButtonCatalog(label = buttons[it], isPressed = false)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PADDING, vertical = PADDING),
            verticalArrangement = Arrangement.spacedBy(PADDING)
        ){
            cards.forEach{ it ->
                CardCatalog(
                    title = it.title,
                    time = it.time,
                    price = it.price
                )
            }
        }
    }
}
