package com.huggydugy.medic

import android.content.Context
import android.os.Bundle
import android.provider.DocumentsContract.Root
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.graphs.RootNavigationGraph
import com.huggydugy.medic.screens.auth.PinLockScreen
import com.huggydugy.medic.screens.auth.RegisterScreen
import com.huggydugy.medic.ui.theme.MedicTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
