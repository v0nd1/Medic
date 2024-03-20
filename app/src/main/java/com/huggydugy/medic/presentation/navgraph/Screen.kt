package com.huggydugy.medic.presentation.navgraph

import com.huggydugy.medic.R

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 30.01.2024, 21:51
* Класс для удобного контроля содержимого страниц
*/

sealed class Screen (
    val route: String,
    val iconFilled: Int = 0,
    val title: String = "",

){
    // Navigation blocks names
    object AppStartNavigation : Screen(route = "appStartNavigation")
    object AuthNavigation : Screen(route = "authNavigation")
    object MainNavigation : Screen(route = "mainNavigation")

    // Start screens
    object OnBoard : Screen("onBoard" )
    object AddPassword : Screen("addPassword")
    object SignUp : Screen("auth")
    object CodeInput : Screen("codeInput")
    object Register : Screen("register")

    // Main scaffold screens
    object Account : Screen(
        route = "account",
        title = "Профиль",
        iconFilled =  R.drawable.account_filled
    )
    object Tests : Screen(
        route = "tests",
        title = "Анализы",
        iconFilled = R.drawable.tests_filled
    )
    object Results : Screen(
        route = "results",
        title = "Результаты",
        iconFilled = R.drawable.results
    )
    object Support : Screen(
        route = "support",
        title = "Поддержка",
        iconFilled = R.drawable.support
    )
}