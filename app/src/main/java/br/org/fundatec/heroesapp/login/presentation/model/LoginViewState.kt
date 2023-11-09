package br.org.fundatec.heroesapp.login.presentation.model

sealed class LoginViewState {

    object Success : LoginViewState()
    object Loading : LoginViewState()
    object Error : LoginViewState()
    object ShowEmailError : LoginViewState()
    object ShowPasswordError : LoginViewState()

}
