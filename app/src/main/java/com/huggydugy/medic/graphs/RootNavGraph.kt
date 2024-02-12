package com.huggydugy.medic.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.huggydugy.medic.presentation.auth.AddPasswordScreen
import com.huggydugy.medic.presentation.auth.CodeInputScreen
import com.huggydugy.medic.presentation.auth.RegisterScreen
import com.huggydugy.medic.presentation.auth.SignUpScreen
import com.huggydugy.medic.presentation.navgraph.Graph
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.presentation.scaffold.MainScreen

@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION,
    ){
        navigation(
            route = Graph.AUTHENTICATION,
            startDestination = Screen.OnBoard.route
        ){
            composable(route = Screen.OnBoard.route){
                //val viewModel: OnBoardViewModel = hiltViewModel()
                //OnBoardScreen(navController = navController)
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
        //authNavGraph(navController)
        composable(route = Graph.TESTS){
            MainScreen()
        }
    }
}
