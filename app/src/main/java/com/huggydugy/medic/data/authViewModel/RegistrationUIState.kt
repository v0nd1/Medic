package com.huggydugy.medic.data.authViewModel

/*
* Автор: Вдовенко Дмитрий
* Дата создания: 01.02.2024, 11:22
* Класс данных для хранения состояний полей регистрации
*/
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
