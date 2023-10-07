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
        if (binding.editTextNome.text.toString().isEmpty()) {
            mostrarSnackbarErroNome()
        } else if (binding.editTextEmail.text.toString().isEmpty() && binding.editTextEmail.text.toString().contains("@") && binding.editTextEmail.text.toString().contains(".com")) {
            mostrarSnackbarErroEmail()
        } else if (binding.editTextSenha.text.toString().isEmpty() && binding.editTextSenha.text.toString().length < 8) {
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
        findViewById<EditText>(R.id.edit_text_nome).setError("Informe um nome de usuário");
    }

    private fun mostrarSnackbarErroEmail() {
        Snackbar.make(
            binding.root, R.string.informe_e_mail,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_email).setError("Informe um e-mail válido");
    }

    private fun mostrarSnackbarErroSenha() {
        Snackbar.make(
            binding.root, R.string.informe_senha,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_senha).setError("A senha precisa conter no mínimo 8 caracteres");
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
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.laranja_fundatec)).show()
    }

}