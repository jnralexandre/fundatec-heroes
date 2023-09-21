package br.org.fundatec.heroes_app.home.view

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroes_app.R
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<Button>(R.id.btn_criar_usuario).setOnClickListener() {
            mostrarSnackbar3()
        }
    }

    private fun mostrarSnackbar() {
        Snackbar.make(findViewById(android.R.id.content), R.string.app_name, Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun mostrarSnackbar2(view: View) {
        Snackbar.make(view, R.string.app_name, Snackbar.LENGTH_LONG).show()
    }

    private fun mostrarSnackbar3() {
        Snackbar.make(
            findViewById(android.R.id.content),
            R.string.usuario_criado,
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction(android.R.string.ok) {
                val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            .setActionTextColor(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            )
            .setBackgroundTint(ContextCompat.getColor(this, R.color.laranja_fundatec))
            .show()
    }


}