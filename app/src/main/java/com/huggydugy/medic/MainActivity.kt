package com.huggydugy.medic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.huggydugy.medic.data.viewModels.splashViewModel.SplashViewModel
import com.huggydugy.medic.domain.usecases.AppEntryUseCases
import com.huggydugy.medic.graphs.RootNavigationGraph
import com.huggydugy.medic.presentation.board.OnBoardScreen
import com.huggydugy.medic.presentation.board.OnBoardViewModel
import com.huggydugy.medic.presentation.navgraph.Graph
import com.huggydugy.medic.presentation.navgraph.NavGraph
import com.huggydugy.medic.ui.theme.MedicTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//            .apply {
//            setKeepOnScreenCondition{
//                viewModel.splashCondition
//            }
//        }
        setContent {
            MedicTheme {
                //val startDestination = viewModel.startDestination
                NavGraph(startDestination = Graph.AUTHENTICATION)
            }
        }
    }
}
