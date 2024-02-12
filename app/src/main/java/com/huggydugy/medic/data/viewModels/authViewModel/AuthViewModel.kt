package com.huggydugy.medic.data.viewModels.authViewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.huggydugy.medic.data.viewModels.UIEvent
import com.huggydugy.medic.data.rules.Validator

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 01.02.2024, 11:22
* Класс для учета изменений полей регистрации
*/

class AuthViewModel: ViewModel() {

    private val TAG = AuthViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allValidationsPassed = mutableStateOf(false)
    var emailValidationPassed = mutableStateOf(false)
    var passwordValidationPassed = mutableStateOf(false)

    fun onEvent(event: UIEvent){
        when(event){
            is UIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                validateDataWithRules()
                printState()
            }
            is UIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                validateDataWithRules()
                printState()
            }
            is UIEvent.PatronymicChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    patronymic = event.patronymic
                )
                validateDataWithRules()
                printState()
            }
            is UIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                validateDataWithRules()
                printState()
            }
            is UIEvent.DateChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    date = event.date
                )
                validateDataWithRules()
                printState()
            }
            is UIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                validateDataWithRules()
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

        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val firstNameResult = Validator.validateFistName(
            fName = registrationUIState.value.firstName
        )

        val lastNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )

        val patronymicResult = Validator.validatePatronymic(
            patronymic = registrationUIState.value.patronymic
        )

        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )

        val dateResult = Validator.validateDate(
            date = registrationUIState.value.date
        )

        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )

        Log.d(TAG, "Inside_validationDataWithRules")
        Log.d(TAG, "fName = $firstNameResult")
        Log.d(TAG, "lName = $lastNameResult")
        Log.d(TAG, "patronymic = $patronymicResult")
        Log.d(TAG, "email = $emailResult")
        Log.d(TAG, "password = $passwordResult")
        Log.d(TAG, "data = $dateResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = firstNameResult.status,
            lastNameError = lastNameResult.status,
            patronymicError = patronymicResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            dateError = dateResult.status

        )

        allValidationsPassed.value = firstNameResult.status && lastNameResult.status
                && patronymicResult.status && dateResult.status
        emailValidationPassed.value = emailResult.status
        passwordValidationPassed.value = passwordResult.status
    }

    private fun sendEmail(){
        Log.d(TAG, "Inside_sendEmail")
        printState()
        creatureUserInFireBase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

    private fun creatureUserInFireBase(email: String, password: String){
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")
            }
            .addOnFailureListener{
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception = ${it.message}")
                Log.d(TAG, "Exception = ${it.localizedMessage}")
            }
    }

}