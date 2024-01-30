package com.huggydugy.medic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.navigation.AppNavigation
import com.huggydugy.medic.screens.auth.AddPasswordScreen
import com.huggydugy.medic.screens.auth.CodeInputScreen
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
                    AddPasswordScreen(navController = navController)
                    //AppNavigation(navController = navController)
                }
            }
        }
    }
}
