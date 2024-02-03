package com.huggydugy.medic.graphs

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.huggydugy.medic.R

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 30.01.2024, 21:51
* Класс для удобного контроля содержимого страниц
*/

sealed class Screen (
    val route: String,
    val iconFilled: Int = 0,
    val iconOutlined: Int = 0,
    val title: String = "",

){
    // Start screens
    object OnBoard : Screen("on_board" )
    object AddPassword : Screen("add_password")
    object SignUp : Screen("auth")
    object CodeInput : Screen("code_input")
    object Register : Screen("register")

    // Main scaffold screens
    object Main : Screen("main")
    object Account : Screen(
        route = "account",
        title = "Профиль",
        iconFilled =  R.drawable.account_filled,
        iconOutlined = R.drawable.account_outlined
    )
    object Tests : Screen(
        route = "tests",
        title = "Анализы",
        iconFilled = R.drawable.tests_filled,
        iconOutlined = R.drawable.tests_outlined
    )
    object Results : Screen(
        route = "results",
        title = "Результаты",
        iconFilled = R.drawable.results,
        iconOutlined = R.drawable.results
    )
    object Support : Screen(
        route = "suport",
        title = "Поддержка",
        iconFilled = R.drawable.support,
        iconOutlined = R.drawable.support
    )
}