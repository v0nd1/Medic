package com.huggydugy.medic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huggydugy.medic.domain.usecases.AppEntryUseCases
import com.huggydugy.medic.presentation.navgraph.Graph
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set


    var startDestination by mutableStateOf(Graph.AUTHENTICATION)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach {
            if(it){
                startDestination = Graph.TESTS
            }else{
                startDestination = Graph.AUTHENTICATION
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}