package com.huggydugy.medic.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.presentation.auth.AddPasswordScreen
import com.huggydugy.medic.presentation.auth.CodeInputScreen
import com.huggydugy.medic.presentation.auth.RegisterScreen
import com.huggydugy.medic.presentation.auth.SignUpScreen
import com.huggydugy.medic.presentation.board.OnBoardScreen
import com.huggydugy.medic.presentation.board.OnBoardViewModel
import com.huggydugy.medic.presentation.scaffold.MainScreen

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Graph.AUTHENTICATION,
            startDestination = Screen.OnBoard.route
        ){
            composable(route = Screen.OnBoard.route){
                //val viewModel: OnBoardViewModel = hiltViewModel()
                OnBoardScreen(
                    navController = navController,
                    //event = viewModel::onEvent
                )
            }
//            composable(route = Screen.SignUp.route){
//                SignUpScreen(navController = navController)
//            }
//            composable(route = Screen.CodeInput.route){
//                CodeInputScreen(navController = navController)
//            }
//            composable(route = Screen.AddPassword.route){
//                AddPasswordScreen(navController = navController)
//            }
//            composable(route = Screen.Register.route){
//                RegisterScreen(navController = navController)
//            }
        }
        navigation(
            route = Graph.TESTS,
            startDestination = Screen.UU.route
        ){
            composable(route = Screen.UU.route){
                Text(text = "dsdsd")
            }
        }



    }

}