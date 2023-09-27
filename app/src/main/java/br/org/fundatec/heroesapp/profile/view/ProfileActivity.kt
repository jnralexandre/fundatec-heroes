package br.org.fundatec.heroesapp.profile.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.home.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<Button>(R.id.btn_criar_usuario).setOnClickListener() {
            if (findViewById<EditText>(R.id.edit_text_nome).getText().length == 0) {
                mostrarSnackbar("edit_text_nome")
            } else if (findViewById<EditText>(R.id.edit_text_email).getText().length == 0) {
                mostrarSnackbar("edit_text_email")
            } else if (findViewById<EditText>(R.id.edit_text_senha).getText().length < 8) {
                mostrarSnackbar("edit_text_senha")
            } else {
                mostrarSnackbar("btn_criar_usuario");
            }
        }
    }

    private fun mostrarSnackbar(name: String) {
        if (name.equals("edit_text_nome")) {
            Snackbar.make(
                findViewById(android.R.id.content),
                R.string.informe_nome_de_usuario,
                Snackbar.LENGTH_LONG,
            ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
            findViewById<EditText>(R.id.edit_text_nome).setError("Informe um nome de usuário");
        } else if (name.equals("edit_text_email")) {
            Snackbar.make(
                findViewById(android.R.id.content), R.string.informe_e_mail, Snackbar.LENGTH_LONG
            ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
            findViewById<EditText>(R.id.edit_text_email).setError("Informe um e-mail válido");
        } else if (name.equals("edit_text_senha")) {
            Snackbar.make(
                findViewById(android.R.id.content), R.string.informe_senha, Snackbar.LENGTH_LONG
            ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
            findViewById<EditText>(R.id.edit_text_senha).setError("A senha precisa conter no mínimo 8 caracteres");
        } else {
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
}