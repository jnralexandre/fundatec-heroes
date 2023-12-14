package br.org.fundatec.heroesapp.home.presentation.model

import br.com.fundatec.heroesapp.home.domain.CharacterModel

sealed class HomeViewState {
    data class Success(val list: List<CharacterModel>) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
}