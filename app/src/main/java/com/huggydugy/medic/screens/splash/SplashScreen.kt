package com.huggydugy.medic.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.AquaGradient
import com.huggydugy.medic.ui.theme.BlueGradient
import com.huggydugy.medic.ui.theme.BlueGradient2
import com.huggydugy.medic.ui.theme.BlueGradient3
import com.huggydugy.medic.ui.theme.BlueLight
import com.huggydugy.medic.ui.theme.White

@Composable
fun SplashScreen(navController: NavController){
    val gradient = listOf(AquaGradient, BlueGradient2, BlueGradient, BlueGradient2, BlueGradient3, AquaGradient)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(gradient)),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            tint = White,
            modifier = Modifier.size(200.dp)
        )
    }
}