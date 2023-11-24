package br.org.fundatec.heroesapp.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.fundatec.heroesapp.login.domain.LoginUseCase
import br.org.fundatec.heroesapp.profile.presentation.model.ProfileViewState
import kotlinx.coroutines.launch

class ProfileViewModel() : ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(name: String?, email: String?, password: String?) {
        viewState.value = ProfileViewState.Loading

        val isValidEmail = email?.contains("@") ?: false && email?.contains(".com") ?: false
        if (name.isNullOrEmpty()) {
            viewState.value = ProfileViewState.ShowUserError
        } else if (email.isNullOrEmpty() || !isValidEmail) {
            viewState.value = ProfileViewState.ShowEmailError
        } else if (password.isNullOrEmpty() || password.length < 8) {
            viewState.value = ProfileViewState.ShowPasswordError
        } else {
            viewModelScope.launch {
                val isSuccess = useCase.createUser(name, email, password)
                if (isSuccess) {
                    viewState.value = ProfileViewState.Success
                } else {
                    viewState.value = ProfileViewState.Error
                }
            }
        }
    }

}