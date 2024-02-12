package com.huggydugy.medic.data.viewModels


/*
* Автор: Вдовенко Дмитрий
* Дата создания: 01.02.2024, 11:21
* Класс для учета изменений полей регистрации
*/
sealed class UIEvent{
    data class EmailChanged(val email: String): UIEvent()
    data class FirstNameChanged(val firstName: String) : UIEvent()
    data class LastNameChanged(val lastName: String) : UIEvent()
    data class PatronymicChanged(val patronymic: String) : UIEvent()
    data class DateChanged(val date: String) : UIEvent()
    data class PasswordChanged(val password: String) : UIEvent()

    object RegisterButtonClicked : UIEvent()
    object CheckEmailButtonClicked : UIEvent()
}
