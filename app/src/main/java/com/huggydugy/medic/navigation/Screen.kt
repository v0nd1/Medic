package com.huggydugy.medic.navigation

sealed class Screen (val route: String){
    object OnBoardScreen : Screen("on_board")
    object AddPasswordScreen : Screen("add_password")
    object AuthScreen : Screen("auth")
    object CodeInputScreen : Screen("code_input")
}