package br.org.fundatec.heroesapp.character.presentation.model

sealed class CharacterViewState {

    object NameError: CharacterViewState()
    object DescriptionError: CharacterViewState()
    object ImageError: CharacterViewState()
    object TipoEmpresaError: CharacterViewState()
    object TipoPersonagemError: CharacterViewState()
    object AgeError: CharacterViewState()
    object DateError: CharacterViewState()
    object ShowHomeScreen: CharacterViewState()

    object Error: CharacterViewState()

}