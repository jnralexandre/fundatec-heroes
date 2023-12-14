package br.org.fundatec.heroesapp.character.presentation.model

sealed class CharacterViewState {

    object ShowNameError: CharacterViewState()
    object ShowDescriptionError: CharacterViewState()
    object ShowImageError: CharacterViewState()
    object ShowUniverseTypeError: CharacterViewState()
    object ShowCharacterTypeError: CharacterViewState()
    object ShowAgeError: CharacterViewState()
    object ShowBirthdayError: CharacterViewState()
    object ShowHomeScreen: CharacterViewState()

    object ShowGenericError: CharacterViewState()

}