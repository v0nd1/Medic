package com.huggydugy.medic.data.viewModels.authViewModel

data class RegistrationUIState(
    var firstName: String = "",
    var lastName: String = "",
    var patronymic: String = "",
    var email: String = "",
    var date: String = "",
    var password: String = "",

    var firstNameError: Boolean = false,
    var lastNameError: Boolean = false,
    var patronymicError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var dateError: Boolean = false,

)
