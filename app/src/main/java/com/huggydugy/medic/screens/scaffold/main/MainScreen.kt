package com.huggydugy.medic.screens.scaffold.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.huggydugy.medic.navigation.ScaffoldNavigation
import com.huggydugy.medic.navigation.Screen
import com.huggydugy.medic.ui.theme.Roboto

@Composable
fun MainScreen(navHostController: NavHostController){
    val screens = listOf(
        Screen.TestsScreen,
        Screen.ResultsScreen,
        Screen.SupportScreen,
        Screen.AccountScreen
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                screens.forEach { screen ->
                    val selected = currentDestination?.hierarchy?.any {it.route == screen.route} == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navHostController.navigate(screen.route){
                                popUpTo(navHostController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(if (selected) screen.iconFilled else screen.iconOutlined),
                                contentDescription = screen.label
                            )
                        },
                        label = {
                            Text(text = screen.label.toString(), fontFamily = Roboto)
                        }
                    )
                }
            }
        }
    ) {
        ScaffoldNavigation(navHostController = navHostController, modifier = Modifier.padding(it))
    }
}