package com.huggydugy.medic.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.GrayLight3
import com.huggydugy.medic.ui.theme.GrayLight4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeTextField(
    placeholder: String,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
){
    var value by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value ,
        onValueChange = {
            value = it
            onTextSelected(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = GrayLight4,
            unfocusedBorderColor = Color.Transparent,
            containerColor = GrayLight2,
            errorContainerColor = GrayLight2,
            disabledBorderColor = GrayLight3
        ),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = Gray
            )
        },
        isError = !errorStatus
    )
}