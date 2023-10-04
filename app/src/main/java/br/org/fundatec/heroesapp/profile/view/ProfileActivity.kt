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
        setContentView(R.layout.activity_profile)

        val edit_text_binding_nome = binding.editTextNome
        val edit_text_binding_email = binding.editTextEmail
        val edit_text_binding_senha = binding.editTextSenha

        binding.btnCriarUsuario.setOnClickListener {
            validacaoPreenchimento(
                edit_text_binding_nome,
                edit_text_binding_email,
                edit_text_binding_senha
            )
        }
    }

    private fun validacaoPreenchimento(
        edit_text_binding_nome: EditText,
        edit_text_binding_email: EditText,
        edit_text_binding_senha: EditText
    ) {

        if (edit_text_binding_nome.text.toString().isEmpty()) {
            mostrarSnackbarErroNome()
        } else if (edit_text_binding_email.text.toString()
                .isEmpty() && edit_text_binding_email.text.toString()
                .contains("@") && edit_text_binding_email.text.toString().contains(".com")
        ) {
            mostrarSnackbarErroEmail()
        } else if (edit_text_binding_senha.text.toString()
                .isEmpty() && edit_text_binding_senha.text.length < 8
        ) {
            mostrarSnackbarErroSenha()
        }

    }

    private fun mostrarSnackbarErroNome() {
        Snackbar.make(
            findViewById(android.R.id.content),
            R.string.informe_nome_de_usuario,
            Snackbar.LENGTH_LONG,
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_nome).setError("Informe um nome de usuário");
    }

    private fun mostrarSnackbarErroEmail() {
        Snackbar.make(
            findViewById(android.R.id.content), R.string.informe_e_mail, Snackbar.LENGTH_LONG
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_email).setError("Informe um e-mail válido");
    }

    private fun mostrarSnackbarErroSenha() {
        Snackbar.make(
            findViewById(android.R.id.content), R.string.informe_senha, Snackbar.LENGTH_LONG
        ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
        findViewById<EditText>(R.id.edit_text_senha).setError("A senha precisa conter no mínimo 8 caracteres");
    }

    private fun mostrarSnackbarSucesso() {
        Snackbar.make(
            findViewById(android.R.id.content),
            R.string.usuario_criado,
            Snackbar.LENGTH_INDEFINITE
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