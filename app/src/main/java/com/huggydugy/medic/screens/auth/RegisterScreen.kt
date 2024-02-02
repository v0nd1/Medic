package com.huggydugy.medic.screens.auth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.huggydugy.medic.components.ThemeButton
import com.huggydugy.medic.components.ThemeDataField
import com.huggydugy.medic.components.ThemeTextField
import com.huggydugy.medic.data.AuthViewModel
import com.huggydugy.medic.data.UIEvent
import com.huggydugy.medic.navigation.Screen
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.BlueLight2
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight2
import com.huggydugy.medic.ui.theme.Roboto


@Composable
fun RegisterScreen(navController: NavController, loginViewModel: AuthViewModel = viewModel()){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Создание карты пациента",
                fontSize = 25.sp,
                fontFamily = Roboto,
                color = Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .clickable { navController.navigate(Screen.AuthScreen.route) },
                text = "Пропустить",
                fontSize = 18.sp,
                fontFamily = Roboto,
                color = BlueLight2,
                fontWeight = FontWeight.Normal,

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Без карты пациента вы не сможете заказать анализы.",
            fontSize = 13.5.sp,
            fontFamily = Roboto,
            color = Gray,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
            fontSize = 13.5.sp,
            fontFamily = Roboto,
            color = Gray,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(40.dp))
        ThemeTextField(
            placeholder = "Имя",
            onTextSelected = {
                loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
            },
            errorStatus = loginViewModel.registrationUIState.value.firstNameError
        )
        Spacer(modifier = Modifier.height(20.dp))
        ThemeTextField(
            placeholder = "Отчество",
            onTextSelected = {
                loginViewModel.onEvent(UIEvent.PatronymicChanged(it))
            },
            errorStatus = loginViewModel.registrationUIState.value.patronymicError
        )
        Spacer(modifier = Modifier.height(20.dp))
        ThemeTextField(
            placeholder = "Фамилия",
            onTextSelected = {
                loginViewModel.onEvent(UIEvent.LastNameChanged(it))
            },
            errorStatus = loginViewModel.registrationUIState.value.lastNameError
        )
        Spacer(modifier = Modifier.height(20.dp))
        ThemeDataField(
            placeholder = "Дата рождения (дд/мм/гггг)" ,
            onTextSelected = {
                loginViewModel.onEvent(UIEvent.DateChanged(it))
            },
            errorStatus = loginViewModel.registrationUIState.value.dateError
        )
        Spacer(modifier = Modifier.height(20.dp))

        ThemeExposedDropdownMenuBox("Пол")
        Spacer(modifier = Modifier.height(40.dp))
        ThemeButton(
            label = "Создать",
            //navController = navController,
            //route = Screen.AddPasswordScreen.route,
            enabled = true,
            onClick = {
                loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeExposedDropdownMenuBox(placeholder: String) {
    val context = LocalContext.current
    val genders = arrayOf("Мужской", "Женский")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(genders[0]) }

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
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
        )
        ExposedDropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genders.forEach { item ->
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    text = { Text(text = item) },
                    onClick = {
                        selectedText = item
                        expanded = false
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
