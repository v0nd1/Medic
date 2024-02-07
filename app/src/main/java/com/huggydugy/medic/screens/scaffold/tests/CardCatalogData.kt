package com.huggydugy.medic.screens.scaffold.tests

sealed class CardCatalogData(
    val title: String,
    val time: String = "1 день",
    val price: String,
) {
    object Card1: CardCatalogData(
        title = "ПЦР-тест на определение РНК коронавируса стандартный",
        time = "2 дня",
        price = "1800 ₽"
    )
    object Card2: CardCatalogData(
        title = "Клинический анализ крови с лейкоцитарной формулировкой",
        price = "690 ₽"
    )
    object Card3: CardCatalogData(
        title = "Биохимический анализ крови, базовый",
        price = "2440 ₽"
    )
    object Card4: CardCatalogData(
        title = "СОЭ (венозная кровь)",
        price = "240 ₽"
    )
    object Card5: CardCatalogData(
        title = "Общий анализ мочи",
        price = "350 ₽"
    )
    object Card6: CardCatalogData(
        title = "Тироксин свободный (Т4 свободный)",
        price = "680 ₽"
    )
    object Card7: CardCatalogData(
        title = "Группа крови + Резус-фактор",
        price = "750 ₽"
    )
}