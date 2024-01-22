package com.huggydugy.medic

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ElementBoard(
    @DrawableRes val image: Int,
    val header: String,
    val description: String,
    val size: Dp = 200.dp
)
