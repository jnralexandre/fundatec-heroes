package br.org.fundatec.heroesapp.profile.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityProfileBinding
import br.org.fundatec.heroesapp.gone
import br.org.fundatec.heroesapp.login.view.LoginActivity
import br.org.fundatec.heroesapp.profile.presentation.ProfileViewModel
import br.org.fundatec.heroesapp.profile.presentation.model.ProfileViewState
import br.org.fundatec.heroesapp.showSnackbarMessage
import br.org.fundatec.heroesapp.visible
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarUsuario.setOnClickListener {
            viewModel.validateInputs(
                name = binding.editTextNomeUsuario.text.toString(),
                email = binding.editTextEmail.text.toString(),
                password = binding.editTextPassword.text.toString()
            )
        }
        initializeObservers()
    }

    private fun initializeObservers() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                ProfileViewState.Loading ->
                    binding.progressBar.visible()
                ProfileViewState.Error -> {
                    binding.progressBar.gone()
                    showSnackbarMessage(
                        binding.editTextEmail,
                        R.string.erro_ao_criar_personagem,
                        R.color.vermelho
                    )
                }
                ProfileViewState.ShowUserError -> {
                    showSnackbarMessage(
                        binding.editTextNomeUsuario,
                        R.string.informe_nome_de_usuario,
                        R.color.vermelho
                    )
                }

                ProfileViewState.ShowEmailError -> {
                    showSnackbarMessage(
                        binding.editTextEmail,
                        R.string.informe_e_mail,
                        R.color.vermelho
                    )
                }

                ProfileViewState.ShowPasswordError -> {
                    showSnackbarMessage(
                        binding.editTextPassword,
                        R.string.informe_senha,
                        R.color.vermelho
                    )
                }

                ProfileViewState.Success -> mostrarSnackbarSucesso()
            }

        }
    }

    private fun mostrarSnackbarSucesso() {
        Snackbar.make(
            binding.root, R.string.usuario_criado,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.special_text)).show()
        val handle = Handler()
        handle.postDelayed({ finish() }, 1000)
    }

}