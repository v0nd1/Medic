package com.huggydugy.medic.data

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
)
