package br.org.fundatec.heroesapp.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.fundatec.heroesapp.character.domain.CharacterUseCase
import br.org.fundatec.heroesapp.home.domain.toModel
import br.org.fundatec.heroesapp.home.presentation.model.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val useCase by lazy {
        CharacterUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState

    private fun buscarNaLista() {
        viewModelScope.launch {
            val listCharacter = useCase.listCharacter()
            if (listCharacter.isNotEmpty()) {
                viewState.value = HomeViewState.Success(listCharacter.toModel())
            } else {
                viewState.value = HomeViewState.Error("A lista está vazia")
            }
        }
    }

    init {
        buscarNaLista()
    }

}