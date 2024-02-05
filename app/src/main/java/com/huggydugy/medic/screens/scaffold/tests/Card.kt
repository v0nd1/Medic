package com.huggydugy.medic.screens.scaffold.tests

import androidx.compose.ui.graphics.Color
import com.huggydugy.medic.R
import com.huggydugy.medic.ui.theme.BlueLight3
import com.huggydugy.medic.ui.theme.BlueLight4

sealed class Card(
    val image: Int,
    val headText: String,
    val descr: String,
    val price: String,
    val gradient: List<Color>
){
    object Card1 : Card(
        image = R.drawable.man_card,
        headText = "Чек-ап для мужчин",
        descr = "9 исследований",
        price = "8000 ₽",
        gradient = listOf(BlueLight3, BlueLight4)
    )
    object Card2 : Card(
        image = R.drawable.flask_card,
        headText = "Подготовка к вакцинации",
        descr = "Комплексное обследование\n" +
                "перед вакцинацией",
        price = "4000 ₽ ",
        gradient = listOf(BlueLight3, BlueLight4)
    )

}
