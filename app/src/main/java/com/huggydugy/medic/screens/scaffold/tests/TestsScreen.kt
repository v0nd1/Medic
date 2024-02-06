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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.BlueLight3
import com.huggydugy.medic.ui.theme.BlueLight4
import com.huggydugy.medic.ui.theme.Gray
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
            .padding(horizontal = 10.dp)
    ) {
        ThemeSearchBar()
        Spacer(modifier = Modifier.height(20.dp))
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
        fontSize = 25.sp
    )
    Spacer(modifier = Modifier.height(10.dp))
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
    gradient: List<Color>
){

    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = gradient
                    )
                )
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,

            ) {
                Column(
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(
                        text = headText,
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                    Text(
                        text = descr,
                        textAlign = TextAlign.Left,
                        color = White,
                        fontFamily = Roboto
                    )
                    Text(
                        text = price,
                        textAlign = TextAlign.Left,
                        color = White,
                        fontFamily = Roboto
                    )
                }



                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )

            }

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