package com.huggydugy.medic.presentation.auth

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.huggydugy.medic.presentation.components.ThemeButton
import com.huggydugy.medic.presentation.components.ThemeDataField
import com.huggydugy.medic.presentation.components.ThemeExposedDropdownMenuBox
import com.huggydugy.medic.presentation.components.ThemeTextField
import com.huggydugy.medic.data.viewModels.authViewModel.AuthViewModel
import com.huggydugy.medic.data.viewModels.UIEvent
import com.huggydugy.medic.presentation.navgraph.Graph
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Blue
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.Roboto


@Composable
fun RegisterScreen(navController: NavHostController, loginViewModel: AuthViewModel = viewModel()){
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
                    .clickable { navController.navigate(Graph.TESTS)},
                text = "Пропустить",
                fontSize = 15.sp,
                fontFamily = Roboto,
                color = Blue,
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
            navController = navController,
            route = Graph.TESTS,
            enabled = true,
            onClick = {
                loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
            }
        )
    }
}



