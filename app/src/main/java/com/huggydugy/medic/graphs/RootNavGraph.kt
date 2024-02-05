package com.huggydugy.medic.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.huggydugy.medic.screens.auth.RegisterScreen
import com.huggydugy.medic.screens.scaffold.MainScreen
import com.huggydugy.medic.screens.scaffold.tests.TestsScreen

@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.TESTS
    ){
        authNavGraph(navController)
        composable(route = Graph.TESTS){
            MainScreen()
        }
    }
}
