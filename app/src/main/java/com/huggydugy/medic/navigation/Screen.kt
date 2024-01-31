package com.huggydugy.medic.navigation

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
    val iconFilled: Int,
    val iconOutlined: Int,
    val label: String? = null,

){
    object OnBoardScreen : Screen("on_board", 0, 0, null)
    object AddPasswordScreen : Screen("add_password",0, 0, null)
    object AuthScreen : Screen("auth",0, 0, null)
    object CodeInputScreen : Screen("code_input",0, 0, null)
    object UserCardScreen : Screen("user_card",0, 0, null)
    object MainScreen : Screen("main",0, 0, null)
    object AccountScreen : Screen(
        route = "account",
        label = "Профиль",
        iconFilled =  R.drawable.account_filled,
        iconOutlined = R.drawable.account_outlined
    )
    object TestsScreen : Screen(
        route = "tests",
        label = "Анализы",
        iconFilled = R.drawable.tests_filled,
        iconOutlined = R.drawable.tests_outlined
    )
    object ResultsScreen : Screen(
        route = "results",
        label = "Результаты",
        iconFilled = R.drawable.results,
        iconOutlined = R.drawable.results
    )
    object SupportScreen : Screen(
        route = "suport",
        label = "Поддержка",
        iconFilled = R.drawable.support,
        iconOutlined = R.drawable.support
    )
}