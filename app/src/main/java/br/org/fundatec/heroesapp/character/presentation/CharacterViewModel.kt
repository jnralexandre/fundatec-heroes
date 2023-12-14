package br.org.fundatec.heroesapp.character.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.fundatec.heroesapp.character.domain.CharacterUseCase
import br.org.fundatec.heroesapp.character.presentation.model.CharacterViewState
import br.org.fundatec.heroesapp.character.presentation.model.TipoEmpresa
import br.org.fundatec.heroesapp.character.presentation.model.TipoPersonagem
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val useCase by lazy {
        CharacterUseCase()
    }

    private val viewState: MutableLiveData<CharacterViewState> = MutableLiveData()
    val state: LiveData<CharacterViewState> = viewState


    fun validarPreenchimento(
        name: String,
        description: String,
        age: String,
        birthday: String,
        tipoEmpresa: Int,
        tipoPersonagem: Int,
        image: String
    ) {
        if (name.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowNameError
            return
        } else if (description.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowDescriptionError
            return
        } else if (age.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowAgeError
            return
        } else if (tipoEmpresa == 0) {
            viewState.value = CharacterViewState.ShowUniverseTypeError
            return

        } else if (tipoPersonagem == 0) {
            viewState.value = CharacterViewState.ShowCharacterTypeError
            return
        } else if (image.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowImageError
            return
        }
//        else if (birthday.toString().isNullOrBlank()) {
//            viewState.value = CharacterViewState.ShowBirthdayError
//            return
//        }
        else {
            viewModelScope.launch {
                val isSuccess = useCase.createCharacter(
                    name = name,
                    description = description,
                    age = age.toInt(),
                    birthday = null,
                    tipoEmpresa = TipoEmpresa.getValueOf(tipoEmpresa),
                    tipoPersonagem = TipoPersonagem.getValueOf(tipoPersonagem),
                    image = image
                )
                if (isSuccess) {
                    viewState.value = CharacterViewState.ShowHomeScreen
                } else {
                    viewState.value = CharacterViewState.ShowGenericError
                }
            }
        }
    }

}