package com.huggydugy.medic.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.GrayLight3
import com.huggydugy.medic.ui.theme.Roboto
import kotlinx.coroutines.delay

@Composable
fun CodeInputScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
    ) {
        var value by remember {
            mutableStateOf("")
        }
        var second by remember {
            mutableStateOf(60)
        }
        val text =
            if (second > 0) "Отправить код повторно можно будет через $second секунд"
            else "Отправить"
        LaunchedEffect(second){
            while (second > 0){
                delay(1000)
                second--
            }
        }
        Box(
            modifier = Modifier
                .background(color = GrayLight2, shape = RoundedCornerShape(10.dp))
                .size(35.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable { navController.navigate(Screen.AddPassword.route) },
            contentAlignment = Alignment.Center
        ){
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Введите код из E-mail",
                color = Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            CodeTextField(value = value, length = 4, onValueChange ={value = it}, navController = navController)
            Spacer(modifier = Modifier.height(15.dp))
            if (second > 0){
                Text(
                    modifier = Modifier
                        .padding(horizontal = 80.dp),
                    text = text,
                    color = Gray,
                    fontSize = 14.sp,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Center
                )
            }else{
                Text(
                    modifier = Modifier
                        .padding(horizontal = 80.dp)
                        .clickable { second = 60 },
                    text = "Отправить код",
                    color = Gray,
                    fontSize = 14.sp,
                    fontFamily = Roboto,
                    textAlign = TextAlign.Center
                )
            }

        }
    }


}

@Composable
private fun CodeTextField(
    value: String,
    length: Int,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 50.dp,
    boxHeight: Dp = 50.dp,
    enabled: Boolean = true,
    spaceBetweenBoxes: Dp = 14.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
    navController: NavController
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
            if (it.length == 4 && it == "3332"){
                navController.navigate(Screen.AddPassword.route)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Row(
                Modifier.
                    size(width = (boxWidth + spaceBetweenBoxes) * length, height = boxHeight),
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenBoxes),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(length) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = GrayLight2,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .size(boxWidth, boxHeight)
                            .border(
                                1.dp,
                                color = GrayLight3,
                                shape = RoundedCornerShape(10.dp)
                            ),

                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = value.getOrNull(it)?.toString() ?: "",
                            textAlign = TextAlign.Center,
                            fontFamily = Roboto,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    )
}