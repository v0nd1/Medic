package com.huggydugy.medic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.graphs.RootNavigationGraph
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
