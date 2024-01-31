package com.huggydugy.medic.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.navigation.Screen
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Blue
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.Red
import com.huggydugy.medic.ui.theme.Roboto
import com.huggydugy.medic.ui.theme.White

@Composable
fun AddPasswordScreen(navController: NavController){
    Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp)
                .clickable { navController.navigate(Screen.UserCardScreen.route) },
            text = "Пропустить",
            fontSize = 15.sp,
            fontFamily = Roboto,
            color = BlueLight2,
            fontWeight = FontWeight.Normal
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Создайте пароль",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Roboto,

                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Для защиты ваших персональных данных",
                fontSize = 14.sp,
                fontFamily = Roboto,
                color = Gray
            )
            Spacer(modifier = Modifier.height(30.dp))
            EnterPassword()
            Spacer(modifier = Modifier.height(60.dp))
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
                    .size(13.dp)
            )
        }
    }
}

@Composable
private fun Keyboard(){
    val rows = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9")
    )
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed by interactionSource.collectIsPressedAsState()
    val containerColor = if(isPressed) Blue else GrayLight2
    val contentColor = if(isPressed) White else Black

    var password by remember{
        mutableStateOf("")
    }
    val buttonSize = 100.dp
    val iconSize = 40.dp
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        for (row in rows){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (symbol in row){
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(buttonSize),
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(100),
                        interactionSource = interactionSource,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = containerColor,
                            contentColor = contentColor
                        )
                    ) {
                        Text(
                            text = symbol,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Roboto
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(buttonSize),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(100),
                interactionSource = interactionSource,
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    contentColor = contentColor
                )
            ) {
                Text(
                    text = "0",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Roboto
                )
            }
            Icon(
                painterResource(id = R.drawable.del_icon),
                null,
                modifier = Modifier
                    .padding(horizontal = 48.dp)
                    .size(iconSize)
                    .clickable { }
            )
        }
    }
}