package com.huggydugy.medic.presentation.navgraph


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.huggydugy.medic.presentation.screens.auth.AddPasswordScreen
import com.huggydugy.medic.presentation.screens.auth.CodeInputScreen
import com.huggydugy.medic.presentation.screens.auth.RegisterScreen
import com.huggydugy.medic.presentation.screens.auth.SignUpScreen
import com.huggydugy.medic.presentation.screens.board.OnBoardScreen
import com.huggydugy.medic.presentation.screens.scaffold.MainScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Screen.AppStartNavigation.route,
            startDestination = Screen.OnBoard.route
        ) {
            composable(route = Screen.OnBoard.route) {
                OnBoardScreen(
                    navController = navController,
                )
            }
        }

        navigation(
            route = Screen.AuthNavigation.route,
            startDestination = Screen.SignUp.route
        ) {
            composable(route = Screen.SignUp.route) {
                SignUpScreen(
                    navController = navController,
                )
            }
            composable(route = Screen.Register.route) {
                RegisterScreen(
                    navController = navController,
                )
            }
            composable(route = Screen.AddPassword.route) {
                AddPasswordScreen(
                    navController = navController,
                )
            }
            composable(route = Screen.CodeInput.route) {
                CodeInputScreen(
                    navController = navController,
                )
            }

        }

        composable(route = Screen.MainNavigation.route){
            MainScreen()
        }
    }
}