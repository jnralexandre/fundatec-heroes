package br.org.fundatec.heroes_app.home.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroes_app.R
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btn_entrar).setOnClickListener() {
            if (findViewById<EditText>(R.id.edit_text_email).getText().length == 0) {
                mostrarSnackbar("edit_text_email")
            } else if (findViewById<EditText>(R.id.edit_text_senha).getText().length < 8) {
                mostrarSnackbar("edit_text_senha")
            } else {
                chamarHomeActivity()
            }
        }

        findViewById<TextView>(R.id.btn_novo_por_aqui).setOnClickListener() {
            chamarProfileActivity()
        }
    }

    private fun mostrarSnackbar(name: String) {
        if (name.equals("edit_text_email")) {
            Snackbar.make(
                findViewById(android.R.id.content), R.string.informe_e_mail, Snackbar.LENGTH_LONG
            ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
            findViewById<EditText>(R.id.edit_text_email).setError("Informe um e-mail válido");
        } else if (name.equals("edit_text_senha")) {
            Snackbar.make(
                findViewById(android.R.id.content), R.string.informe_senha, Snackbar.LENGTH_LONG
            ).setBackgroundTint(ContextCompat.getColor(this, R.color.vermelho)).show()
            findViewById<EditText>(R.id.edit_text_senha).setError("A senha precisa conter no mínimo 8 caracteres");
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