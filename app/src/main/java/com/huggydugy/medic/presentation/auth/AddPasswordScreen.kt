package com.huggydugy.medic.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Blue
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.Roboto
import com.huggydugy.medic.ui.theme.White

@Composable
fun AddPasswordScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable { navController.navigate(Screen.Register.route) },
            text = "Пропустить",
            fontSize = 15.sp,
            fontFamily = Roboto,
            color = Blue,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Создайте пароль",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Roboto,
                textAlign = TextAlign.Center
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Для защиты ваших персональных данных",
                fontSize = 14.sp,
                fontFamily = Roboto,
                color = Gray,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .height(60.dp),
                contentAlignment = Alignment.Center
            ){
                EnterPassword()
            }
            Keyboard()
        }
    }

}


@Composable
private fun EnterPassword(){
    val password = "1"
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0 until password.length.coerceAtLeast(4)){
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .drawWithContent {
                        if (i < password.length) {
                            drawRoundRect(
                                color = BlueLight2,
                                size = size,
                                cornerRadius = CornerRadius.Zero
                            )
                            drawCircle(
                                color = Color.Transparent,
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
                                color = Color.Transparent,
                                center = size.center,
                                radius = 6.dp.toPx()
                            )
                        }
                    }
                    .size(20.dp)
            )
        }
    }
}

@Composable
private fun Keyboard(
    buttonSize: Dp = 90.dp,
    iconSize: Dp = 40.dp
){
    val rows = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("", "0", "del")
    )
    var password by remember{
        mutableStateOf("")
    }
    val fontSize = 30.sp
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        for (row in rows){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (symbol in row){
                    val exceptionButton = listOf("","del")
                    val interactionSource = remember { MutableInteractionSource() }
                    val isPressed by interactionSource.collectIsPressedAsState()

                    val containerColor =
                        if(isPressed) Blue
                        else if(symbol in exceptionButton) Color.Transparent
                        else GrayLight2

                    val contentColor =
                        if(isPressed) White
                        else if(symbol in exceptionButton) Black
                        else Black

                    val enabled = symbol == ""
                    Button(
                        modifier = Modifier
                            .size(buttonSize),
                        onClick = { println(symbol) },
                        shape = RoundedCornerShape(100),
                        interactionSource = interactionSource,
                        enabled = !enabled,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColor,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Black
                        )

                    ) {
                        if (symbol == "del"){
                            Icon(
                                painterResource(id = R.drawable.del_icon),
                                null,
                                modifier = Modifier
                                    .size(iconSize)
                                    .clickable { }
                            )
                        }else{
                            Text(
                                text = symbol,
                                fontSize = fontSize,
                                fontWeight = FontWeight.Bold,
                                fontFamily = Roboto
                            )
                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}