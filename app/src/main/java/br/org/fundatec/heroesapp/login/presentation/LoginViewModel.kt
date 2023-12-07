package br.org.fundatec.heroesapp.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.fundatec.heroesapp.login.domain.LoginUseCase
import br.org.fundatec.heroesapp.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = LoginViewState.Loading

        val isValidEmail = email?.contains("@") ?: false && email?.contains(".com") ?: false
        if (email.isNullOrEmpty() || !isValidEmail) {
            viewState.value = LoginViewState.ShowEmailError
            return
        }

        if (password.isNullOrEmpty() || password.length < 8) {
            viewState.value = LoginViewState.ShowPasswordError
            return
        }

        fetchLogin(email = email, password = password)
    }

    private fun fetchLogin(email: String, password: String) {
        viewModelScope.launch {
            val isSuccessLogin = useCase.verificarUser(email = email, password = password)
            viewState.value = if (isSuccessLogin) {
                LoginViewState.Success
            } else {
                LoginViewState.Error
            }
        }
    }

}