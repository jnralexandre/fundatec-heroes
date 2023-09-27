package br.org.fundatec.heroesapp.home.presentation.model

sealed class HomeViewState {
    data class Sucess(val sucessMessage: String) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    object HideButton : HomeViewState()
}