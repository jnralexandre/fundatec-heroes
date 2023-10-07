package br.org.fundatec.heroesapp.profile.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityProfileBinding
import br.org.fundatec.heroesapp.home.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriarUsuario.setOnClickListener {
            validarProfile()
        }
    }

    private fun validarProfile() {
        if (binding.editTextNameActivityProfile.text.toString().isEmpty()) {
            mostrarSnackbarErroNome()
        } else if (binding.editTextEmailActivityLogin.text.toString().isEmpty() && binding.editTextEmailActivityLogin.text.toString().contains("@") && binding.editTextEmailActivityLogin.text.toString().contains(".com")) {
            mostrarSnackbarErroEmail()
        } else if (binding.editTextPasswordActivityProfile.toString().isEmpty() && binding.editTextPasswordActivityProfile.text.toString().length < 8) {
            mostrarSnackbarErroSenha()
        } else {
            mostrarSnackbarSucesso()
        }

    }

    private fun mostrarSnackbarErroNome() {
        Snackbar.make(
            binding.root,
            R.string.informe_nome_de_usuario,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_name_activity_profile).setError("Informe um nome de usuário");
    }

    private fun mostrarSnackbarErroEmail() {
        Snackbar.make(
            binding.root, R.string.informe_e_mail,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_email_activity_login).setError("Informe um e-mail válido");
    }

    private fun mostrarSnackbarErroSenha() {
        Snackbar.make(
            binding.root, R.string.informe_senha,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_password_activity_profile).setError("A senha precisa conter no mínimo 8 caracteres");
    }

    private fun mostrarSnackbarSucesso() {
        Snackbar.make(
            binding.root, R.string.usuario_criado, Snackbar.LENGTH_INDEFINITE
        ).setAction(android.R.string.ok) {
            val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(intent)
        }.setActionTextColor(
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    this, R.color.white
                )
            )
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.special_text)).show()
    }

}