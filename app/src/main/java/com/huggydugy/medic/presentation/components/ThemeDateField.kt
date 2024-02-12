package com.huggydugy.medic.presentation.components

import MaskVisualTransformation
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
import com.huggydugy.medic.presentation.components.DateDefaults.DATE_LENGTH
import com.huggydugy.medic.presentation.components.DateDefaults.DATE_MASK
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeDataField(
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
            if (it.length <= DATE_LENGTH) {
                value = it
                onTextSelected(it)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Transparent,
            containerColor = GrayLight2,
        ),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = Gray
            )
        },
        visualTransformation = MaskVisualTransformation(DATE_MASK),
        isError = !errorStatus
    )
}

object DateDefaults {
    const val DATE_MASK = "##/##/####"
    const val DATE_LENGTH = 8
}
