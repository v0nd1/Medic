package com.huggydugy.medic.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 01.02.2024, 11:22
* Класс для учета изменений полей регистрации
*/

class AuthViewModel: ViewModel() {

    private val TAG = AuthViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UIEvent){
        when(event){
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }
            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }
            is UIEvent.PatronymicChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    patronymic = event.patronymic
                )
                printState()
            }
            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is UIEvent.DateChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    date = event.date
                )
                printState()
            }
            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }
            is UIEvent.RegisterButtonClicked -> {
                signUp()
            }
            is UIEvent.CheckEmailButtonClicked ->{
                sendEmail()
            }
        }
    }

    private fun signUp(){
        Log.d(TAG, "Inside_signUp")
        printState()
    }

    private fun sendEmail(){
        Log.d(TAG, "Inside_sendEmail")
        printState()
    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

}