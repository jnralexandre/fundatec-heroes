package br.org.fundatec.heroesapp.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityLoginBinding
import br.org.fundatec.heroesapp.home.view.HomeActivity
import br.org.fundatec.heroesapp.profile.presentation.ProfileActivity
import br.org.fundatec.heroesapp.showSnackbarMessage

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            validarUsuario()
        }

        binding.btnNovoPorAqui.setOnClickListener {
            chamarProfileActivity()
        }
    }

    private fun validarUsuario() {
        if (
            binding.editTextEmail.text.toString().isEmpty() ||
            !binding.editTextEmail.text.toString().contains("@") ||
            !binding.editTextEmail.text.toString().contains(".com")
        ) {
            showSnackbarMessage(
                binding.editTextEmail,
                R.string.informe_e_mail,
                R.color.vermelho
            )
        } else if (
            binding.editTextPassword.text.toString().isEmpty() ||
            binding.editTextPassword.text.toString().length < 8
        ) {
            showSnackbarMessage(
                binding.editTextPassword,
                R.string.informe_senha,
                R.color.vermelho
            )
        } else {
            chamarHomeActivity()
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