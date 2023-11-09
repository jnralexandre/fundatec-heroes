package br.org.fundatec.heroesapp.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.org.fundatec.heroesapp.profile.presentation.model.ProfileViewState

class ProfileViewModel() : ViewModel() {

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
//        viewState.value = ProfileViewState.Loading

        val isValidEmail = email?.contains("@") ?: false && email?.contains(".com") ?: false
        if (email.isNullOrEmpty() || !isValidEmail) {
            viewState.value = ProfileViewState.ShowEmailError
        } else if (password.isNullOrEmpty() || password.length < 8) {
            viewState.value = ProfileViewState.ShowPasswordError
        } else {
//            viewState.value = ProfileViewState.Success
        }
    }

}