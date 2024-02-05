package com.huggydugy.medic.screens.scaffold.tests

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.GrayLight4
import com.huggydugy.medic.ui.theme.White2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestsScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        var queryString by remember {
            mutableStateOf("")
        }
        var isActive by remember {
            mutableStateOf(false)
        }
        val contextForToast = LocalContext.current.applicationContext
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            query = queryString,
            onQueryChange = {
                queryString = it
            },
            onSearch = {
                isActive = false
                Toast.makeText(
                    contextForToast,
                    "Your query: $queryString",
                    Toast.LENGTH_SHORT
                ).show()
            },
            active = isActive,
            onActiveChange = {
                isActive = it
            },
            placeholder = {
                Text(text = "Искать анализы")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            colors = SearchBarDefaults.colors(
                containerColor = GrayLight2,
                dividerColor = GrayLight4
            ),
            shape = RoundedCornerShape(30)
        ) {
            
        }
    }
}