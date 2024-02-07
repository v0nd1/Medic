package com.huggydugy.medic.graphs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.huggydugy.medic.screens.auth.RegisterScreen
import com.huggydugy.medic.screens.scaffold.MainScreen
import com.huggydugy.medic.screens.scaffold.tests.TestsScreen

@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.TESTS,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
    ){
        authNavGraph(navController)
        composable(route = Graph.TESTS){
            MainScreen()
        }
    }
}
