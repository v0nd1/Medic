package com.huggydugy.medic.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.GrayLight
import com.huggydugy.medic.ui.theme.GrayLight1
import com.huggydugy.medic.ui.theme.GrayLight2

@Composable
fun AvatarPicker(){
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(50))
            .background(GrayLight1)
            .clickable {  },
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.take_photo),
            contentDescription = "Avatar",
            modifier = Modifier.size(65.dp),
            tint = Black
        )
    }
}