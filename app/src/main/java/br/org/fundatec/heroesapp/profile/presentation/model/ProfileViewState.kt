package br.org.fundatec.heroesapp.profile.presentation.model

sealed class ProfileViewState {

    object Success : ProfileViewState()
    object Loading : ProfileViewState()
    object Error : ProfileViewState()
    object ShowUserError : ProfileViewState()
    object ShowEmailError : ProfileViewState()
    object ShowPasswordError : ProfileViewState()

}