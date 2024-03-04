package com.huggydugy.medic.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.huggydugy.medic.presentation.navgraph.NavGraph
import com.huggydugy.medic.ui.theme.MedicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value } )
        }
        setContent {
            MedicTheme {
                NavGraph(startDestination = viewModel.startDestination.value)
            }
        }
    }
}
