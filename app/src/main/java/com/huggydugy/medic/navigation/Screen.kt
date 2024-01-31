package com.huggydugy.medic.navigation

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 30.01.2024, 21:51
* Класс для удобного контроля содержимого начальных страниц
*/

sealed class Screen (val route: String){
    object OnBoardScreen : Screen("on_board")
    object AddPasswordScreen : Screen("add_password")
    object AuthScreen : Screen("auth")
    object CodeInputScreen : Screen("code_input")
    object UserCardScreen : Screen("user_card")
}