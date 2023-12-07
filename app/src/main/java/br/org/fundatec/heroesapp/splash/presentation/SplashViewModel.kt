package br.org.fundatec.heroesapp.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.fundatec.heroesapp.splash.domain.IsValidCacheUseCase
import br.org.fundatec.heroesapp.splash.presentation.model.SplashViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val useCase by lazy {
        IsValidCacheUseCase()
    }

    private val viewState: MutableLiveData<SplashViewState> = MutableLiveData()
    val state: LiveData<SplashViewState> = viewState

    private fun validateUserCache() {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashViewState.ChamarHomeActivity
            } else {
                viewState.value = SplashViewState.ChamarLoginActivity
            }
        }
    }

    init {
        validateUserCache()
    }

}