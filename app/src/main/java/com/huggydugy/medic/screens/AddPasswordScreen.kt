package com.huggydugy.medic.screens

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.Roboto
import com.huggydugy.medic.ui.theme.White

@Preview(showBackground = true)
@Composable
fun AddPasswordScreen(){
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