package br.org.fundatec.heroesapp.login.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityLoginBinding
import br.org.fundatec.heroesapp.home.view.HomeActivity
import br.org.fundatec.heroesapp.profile.view.ProfileActivity
import com.google.android.material.snackbar.Snackbar

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
        if (binding.editTextEmail.text.toString()
                .isEmpty() && binding.editTextEmail.text.toString()
                .contains("@") && binding.editTextEmail.text.toString()
                .contains(".com")
        ) {
            mostrarSnackbarErroEmail()
        } else if (binding.editTextPassword.text.toString()
                .isEmpty() && binding.editTextPassword.text.toString().length < 8
        ) {
            mostrarSnackbarErroSenha()
        } else {
            chamarHomeActivity()
        }

    }

    private fun mostrarSnackbarErroEmail() {
        Snackbar.make(
            binding.root, R.string.informe_e_mail,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_email).error =
            "Informe um e-mail válido";
    }

    private fun mostrarSnackbarErroSenha() {
        Snackbar.make(
            binding.root, R.string.informe_senha,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_password).error =
            "A senha precisa conter no mínimo 8 caracteres";
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