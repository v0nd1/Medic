package com.huggydugy.medic.presentation.scaffold.tests

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.Aqua
import com.huggydugy.medic.ui.theme.AquaGreen
import com.huggydugy.medic.ui.theme.BlueLight3
import com.huggydugy.medic.ui.theme.BlueLight4

sealed class CardEventData(
    val image: Int,
    val headText: String,
    val descr: String,
    val price: String,
    val gradient: List<Color>,
    val textWidth: Dp
){
    object Card1 : CardEventData(
        image = R.drawable.man_card,
        headText = "Чек-ап для мужчин",
        descr = "9 исследований",
        price = "8000 ₽",
        gradient = listOf(BlueLight4, BlueLight3),
        textWidth = 135.dp
    )
    object Card2 : CardEventData(
        image = R.drawable.flask_card,
        headText = "Подготовка к вакцинации",
        descr = "Комплексное обследование\n" +
                "перед вакцинацией",
        price = "4000 ₽ ",
        gradient = listOf(Aqua, AquaGreen),
        textWidth = 180.dp
    )

}
