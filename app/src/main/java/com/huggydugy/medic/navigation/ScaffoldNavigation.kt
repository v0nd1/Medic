package com.huggydugy.medic.navigation

import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.huggydugy.medic.screens.scaffold.account.AccountScreen
import com.huggydugy.medic.screens.scaffold.results.ResultsScreen
import com.huggydugy.medic.screens.scaffold.support.SupportScreen
import com.huggydugy.medic.screens.scaffold.tests.TestsScreen

@Composable
fun ScaffoldNavigation(navHostController: NavHostController, modifier: Modifier){
    NavHost(navController = navHostController, startDestination = Screen.TestsScreen.route){
        composable(route = Screen.TestsScreen.route){
            TestsScreen(navController = navHostController)
        }
        composable(route = Screen.ResultsScreen.route){
            ResultsScreen(navController = navHostController)
        }
        composable(route = Screen.SupportScreen.route){
            SupportScreen(navController = navHostController)
        }
        composable(route = Screen.AccountScreen.route){
            AccountScreen(navController = navHostController)
        }
    }

}