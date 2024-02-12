package com.huggydugy.medic.presentation.board

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 22.01.2024, 20:37
* Класс для удобного контроля содержимого начальных страниц
*/

data class ElementBoard(
    @DrawableRes val image: Int,
    val header: String,
    val description: String,
    val size: Dp = 200.dp
)
