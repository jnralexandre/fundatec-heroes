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
    }

    private fun validarUsuario() {
        if (binding.editTextEmailActivityLogin.text.toString()
                .isEmpty() && binding.editTextEmailActivityLogin.text.toString()
                .contains("@") && binding.editTextEmailActivityLogin.text.toString()
                .contains(".com")
        ) {
            mostrarSnackbarErroEmail()
        } else if (binding.editTextPasswordActivityLogin.text.toString()
                .isEmpty() && binding.editTextPasswordActivityLogin.text.toString().length < 8
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
        findViewById<EditText>(R.id.edit_text_email_activity_login).error =
            "Informe um e-mail válido";
    }

    private fun mostrarSnackbarErroSenha() {
        Snackbar.make(
            binding.root, R.string.informe_senha,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_password_activity_login).error =
            "A senha precisa conter no mínimo 8 caracteres";
    }

    private fun mostrarSnackbarSucesso() {
        Snackbar.make(
            binding.root, R.string.usuario_criado, Snackbar.LENGTH_INDEFINITE
        ).setAction(android.R.string.ok) {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }.setActionTextColor(
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    this, R.color.white
                )
            )
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.special_text)).show()
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