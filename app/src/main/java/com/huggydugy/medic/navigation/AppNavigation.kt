package com.huggydugy.medic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.huggydugy.medic.screens.auth.AddPasswordScreen
import com.huggydugy.medic.screens.auth.AuthScreen
import com.huggydugy.medic.screens.auth.CodeInputScreen
import com.huggydugy.medic.screens.board.OnBoardScreen

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.OnBoardScreen.route){
        composable(route = Screen.OnBoardScreen.route){
            OnBoardScreen(navController)
        }
        composable(route = Screen.AddPasswordScreen.route){
            AddPasswordScreen(navController)
        }
        composable(route = Screen.AuthScreen.route){
            AuthScreen(navController)
        }
        composable(route = Screen.CodeInputScreen.route){
            CodeInputScreen(navController)
        }
    }
}