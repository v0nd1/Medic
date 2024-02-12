package com.huggydugy.medic.presentation.scaffold

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.graphs.MainNavGraph
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.ui.theme.BlueLight
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.Roboto
import com.huggydugy.medic.ui.theme.White
import com.huggydugy.medic.ui.theme.White2

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        contentColor = White2
    ) {
        Box(modifier = Modifier.padding(it)){
            MainNavGraph(navController = navController)
        }
    }
}
@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        Screen.Tests,
        Screen.Results,
        Screen.Support,
        Screen.Account
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar(
            modifier = Modifier.border(1.dp, GrayLight2),
            containerColor = White2,
            contentColor = Gray
        ){
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController)
            }
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title, fontFamily = Roboto)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.iconFilled),
                contentDescription = "Navigation Icon",
                modifier = Modifier.size(35.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor= BlueLight,
            selectedTextColor = BlueLight,
            unselectedIconColor = Gray,
            unselectedTextColor = Gray,
            disabledIconColor = Color.Cyan,
            disabledTextColor = Gray,
            indicatorColor = White
        )
    )
}
