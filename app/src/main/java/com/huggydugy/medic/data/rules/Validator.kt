package com.huggydugy.medic.data.rules

object Validator {
    fun validateFistName(fName: String) : ValidationResult{
        return ValidationResult(
            (!fName.isNullOrEmpty() && fName.length >= 4)
        )
    }
    fun validateLastName(lName: String) : ValidationResult{
        return ValidationResult(
            (!lName.isNullOrEmpty() && lName.length >= 4)
        )
    }
    fun validatePatronymic(patronymic: String) : ValidationResult{
        return ValidationResult(
            (!patronymic.isNullOrEmpty() && patronymic.length >= 4)
        )
    }
    fun validateEmail(email:String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }
    fun validateDate(date: String) : ValidationResult{
        return ValidationResult(
            (!date.isNullOrEmpty() && date.length >= 8)
        )
    }
    fun validatePassword(password: String) : ValidationResult{
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length == 8)
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)