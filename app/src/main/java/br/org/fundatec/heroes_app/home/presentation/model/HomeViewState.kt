package br.org.fundatec.heroes_app.home.presentation.model

sealed class HomeViewState {
    data class Sucess(val sucessMessage: String) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    object HideButton : HomeViewState()
}