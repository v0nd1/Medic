package com.huggydugy.medic.presentation.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.huggydugy.medic.R
import com.huggydugy.medic.presentation.components.ThemeButton
import com.huggydugy.medic.presentation.components.ThemeTextField
import com.huggydugy.medic.data.viewModels.authViewModel.AuthViewModel
import com.huggydugy.medic.data.viewModels.UIEvent
import com.huggydugy.medic.presentation.navgraph.Screen
import com.huggydugy.medic.ui.theme.Black
import com.huggydugy.medic.ui.theme.Gray
import com.huggydugy.medic.ui.theme.GrayLight
import com.huggydugy.medic.ui.theme.Roboto

@Composable
fun SignUpScreen(
    navController: NavController,
    //loginViewModel: AuthViewModel = viewModel()
){
    var value by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
        .padding(vertical = 30.dp, horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(30.dp),
                painter = painterResource(id = R.drawable.hello_emojies),
                contentDescription = null)
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "Добро пожаловать!",
                fontWeight = FontWeight.Bold,
                fontFamily = Roboto,
                fontSize = 25.sp,
                color = Black
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Войдите, чтобы пользоваться функциями приложения",
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Вход по E-mail",
            fontFamily = Roboto,
            color = Gray,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        ThemeTextField(
            placeholder = "example@mail.ru",
            onTextSelected = {
                //loginViewModel.onEvent(UIEvent.EmailChanged(it))
            },
            //errorStatus = loginViewModel.registrationUIState.value.emailError
        )
        Spacer(modifier = Modifier.height(25.dp))
        ThemeTextField(
            placeholder = "password",
            onTextSelected = {
                //loginViewModel.onEvent(UIEvent.PasswordChanged(it))
            },
            //errorStatus = loginViewModel.registrationUIState.value.passwordError
        )
        Spacer(modifier = Modifier.height(25.dp))
        ThemeButton(
            label = "Далее",
            navController = navController,
            route = Screen.CodeInput.route,
            //enabled = loginViewModel.emailValidationPassed.value,
            onClick = {
                //loginViewModel.onEvent(UIEvent.CheckEmailButtonClicked)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Или войдите с помощью",
                fontFamily = Roboto,
                color = Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                onClick = {
                    navController.navigate(Screen.MainNavigation.route)
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Black
                ),
                border = BorderStroke(1.dp, GrayLight)

            ) {
                Text(text = "Войти с Яндекс")
            }
        }
    }
}
