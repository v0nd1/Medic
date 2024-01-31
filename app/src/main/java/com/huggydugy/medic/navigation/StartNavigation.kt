package com.huggydugy.medic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.huggydugy.medic.screens.auth.AddPasswordScreen
import com.huggydugy.medic.screens.auth.AuthScreen
import com.huggydugy.medic.screens.auth.CodeInputScreen
import com.huggydugy.medic.screens.auth.UserCardScreen
import com.huggydugy.medic.screens.board.OnBoardScreen
import com.huggydugy.medic.screens.scaffold.main.MainScreen

@Composable
fun StartNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.OnBoardScreen.route){
        composable(route = Screen.OnBoardScreen.route){
            OnBoardScreen(navHostController)
        }
        composable(route = Screen.AddPasswordScreen.route){
            AddPasswordScreen(navHostController)
        }
        composable(route = Screen.AuthScreen.route){
            AuthScreen(navHostController)
        }
        composable(route = Screen.CodeInputScreen.route){
            CodeInputScreen(navHostController)
        }
        composable(route = Screen.UserCardScreen.route){
            UserCardScreen(navController = navHostController)
        }
        composable(route = Screen.MainScreen.route){
            MainScreen(navHostController = navHostController)
        }
    }
}