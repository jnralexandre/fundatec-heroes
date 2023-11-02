package br.org.fundatec.heroesapp.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.login.presentation.model.LoginViewState
import br.org.fundatec.heroesapp.showSnackbarMessage

class LoginViewModel() : ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = LoginViewState.Loading

        val isValidEmail = email?.contains("@") ?: false && email?.contains(".com") ?: false
        if (email.isNullOrEmpty() || !isValidEmail) {
            viewState.value = LoginViewState.ShowEmailError
        } else if (password.isNullOrEmpty() || password.length < 8) {
            viewState.value = LoginViewState.ShowPasswordError
        } else {
            viewState.value = LoginViewState.Success
        }
    }

}