package br.org.fundatec.heroesapp.profile.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityProfileBinding
import br.org.fundatec.heroesapp.showSnackbarMessage
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
        if (
            binding.editTextNomeUsuario.text.toString().isEmpty()
        ) {
            showSnackbarMessage(
                binding.editTextNomeUsuario,
                R.string.informe_nome_de_usuario,
                R.color.vermelho
            )
        } else if (
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
            mostrarSnackbarSucesso()
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