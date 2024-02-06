package com.huggydugy.medic.screens.scaffold.tests

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.scale
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

@Composable
fun TestsScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        ThemeSearchBar()
        Spacer(modifier = Modifier.height(45.dp))
        Events()

    }
}

@Composable
private fun Events(){
    val cards = listOf(
        Card.Card1,
        Card.Card2
    )
    Text(
        text = "Акции и новости",
        color = Gray,
        fontFamily = Roboto,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(20.dp))
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
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
            .height(200.dp)
            .padding(end = 15.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = gradient
                    )
                ),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Column(
                modifier = Modifier
                    .width(textWidth)
                    .fillMaxHeight()
                    .padding(start = 10.dp, top = 15.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ThemeSearchBar(
    colorContainer: Color = GrayLight2,
    colorContent: Color = Gray,
    colorDivide: Color = GrayLight4,
){
    var queryString by remember {
        mutableStateOf("")
    }
    var isActive by remember {
        mutableStateOf(false)
    }
    val contextForToast = LocalContext.current.applicationContext
    SearchBar(
        modifier = Modifier
            .fillMaxWidth(),
        query = queryString,
        onQueryChange = {
            queryString = it
        },
        onSearch = {
            isActive = false
            Toast.makeText(
                contextForToast,
                "Your query: $queryString",
                Toast.LENGTH_SHORT
            ).show()
        },
        active = isActive,
        onActiveChange = {
            isActive = it
        },
        placeholder = {
            Text(
                text = "Искать анализы",
                color = colorContent
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = colorContent
            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = colorContainer,
            dividerColor = colorDivide
        )
    ) {

    }

}