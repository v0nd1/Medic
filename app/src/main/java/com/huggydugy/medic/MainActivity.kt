package com.huggydugy.medic

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.navigation.StartNavigation
import com.huggydugy.medic.screens.auth.AuthScreen
import com.huggydugy.medic.screens.auth.RegisterScreen
import com.huggydugy.medic.ui.theme.MedicTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //StartNavigation(navHostController = navController)
                    //RegisterScreen(navController = navController)
                    AuthScreen(navController = navController)
                }
            }
        }
    }
}
