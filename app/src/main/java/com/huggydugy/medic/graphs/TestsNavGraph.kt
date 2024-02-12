package com.huggydugy.medic.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.huggydugy.medic.presentation.navgraph.Graph
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.presentation.scaffold.account.AccountScreen
import com.huggydugy.medic.presentation.scaffold.results.ResultsScreen
import com.huggydugy.medic.presentation.scaffold.support.SupportScreen
import com.huggydugy.medic.presentation.scaffold.tests.TestsScreen

@Composable
fun MainNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.TESTS,
        startDestination = Screen.Tests.route
    ){
        composable(route = Screen.Tests.route){
            TestsScreen(navController = navController)
        }
        composable(route = Screen.Results.route){
            ResultsScreen(navController = navController)
        }
        composable(route = Screen.Support.route){
            SupportScreen(navController = navController)
        }
        composable(route = Screen.Account.route){
            AccountScreen(navController = navController)
        }
    }
}