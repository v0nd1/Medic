package com.huggydugy.medic.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.GrayLight4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeSearchBar(
    colorContainer: Color = GrayLight2,
    colorContent: Color = Gray,
    colorDivide: Color = GrayLight4,
){
    var queryString by remember {
        mutableStateOf("")
    }
    var isActive by remember {
        mutableStateOf(false)
    }
    val contextForToast = LocalContext.current.applicationContext

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
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
            Text(
                text = "Искать анализы",
                color = colorContent
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = colorContent
            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = colorContainer,
            dividerColor = colorDivide
        )
    ) {

    }

}