package com.huggydugy.medic.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ThemeButton(
    label: String,
    navController: NavController,
    route: String,
    enabled: Boolean,
    onClick: () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        onClick = {
            navController.navigate(route = route)
            onClick.invoke()
        },
        shape = RoundedCornerShape(10.dp),
        enabled = enabled
    ) {
        Text(text = label, fontSize = 16.sp)
    }
}