package com.huggydugy.medic.data.viewModels.mainViewModel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val selectedButtonCatalogIndex = mutableIntStateOf(-1)

     fun onButtonCatalogClicked(index: Int){
        selectedButtonCatalogIndex.intValue = index
    }

}