package br.org.fundatec.heroesapp.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityLoginBinding
import br.org.fundatec.heroesapp.home.view.HomeActivity
import br.org.fundatec.heroesapp.login.presentation.LoginViewModel
import br.org.fundatec.heroesapp.login.presentation.model.LoginViewState
import br.org.fundatec.heroesapp.profile.view.ProfileActivity
import br.org.fundatec.heroesapp.showSnackbarMessage

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            viewModel.validateInputs(
                email = binding.editTextEmail.text.toString(),
                password = binding.editTextPassword.text.toString()
            )
        }

        binding.btnNovoPorAqui.setOnClickListener {
            chamarProfileActivity()
        }

        initializeObservers()
    }

    private fun initializeObservers(){
        viewModel.state.observe(this) { viewState->
            when(viewState){
                LoginViewState.Error -> TODO()
                LoginViewState.Loading -> TODO()
                LoginViewState.ShowEmailError -> TODO()
                LoginViewState.ShowPasswordError -> TODO()
                LoginViewState.Success -> chamarHomeActivity()
            }

        }
    }

    private fun chamarHomeActivity() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun chamarProfileActivity() {
        val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
        startActivity(intent)
    }

}