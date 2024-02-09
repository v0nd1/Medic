package com.huggydugy.medic.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.huggydugy.medic.screens.auth.AddPasswordScreen
import com.huggydugy.medic.screens.auth.CodeInputScreen
import com.huggydugy.medic.screens.auth.RegisterScreen
import com.huggydugy.medic.screens.auth.SignUpScreen
import com.huggydugy.medic.screens.board.OnBoardScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screen.OnBoard.route
    ){
        composable(route = Screen.OnBoard.route){
            OnBoardScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.CodeInput.route){
            CodeInputScreen(navController = navController)
        }
        composable(route = Screen.AddPassword.route){
            AddPasswordScreen(navController = navController)
        }
        composable(route = Screen.Register.route){
            RegisterScreen(navController = navController)
        }
    }
}
