package br.org.fundatec.heroesapp.character.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.character.presentation.CharacterViewModel
import br.org.fundatec.heroesapp.character.presentation.model.CharacterViewState
import br.org.fundatec.heroesapp.databinding.ActivityCharacterBinding
import br.org.fundatec.heroesapp.home.view.HomeActivity
import br.org.fundatec.heroesapp.showError
import br.org.fundatec.heroesapp.showSnackBar

private const val DELAY_TELA = 3000L


class CharacterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding
    private val characterViewModel: CharacterViewModel by viewModels()


    val personagem = arrayOf("Personagem","Herói", "Vilão")
    val empresa = arrayOf("Universo","Marvel", "DC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        buttonCriarPersonagem()
        spinnerPersonagem()
        spinnerEmpresa()
    }

    private fun buttonCriarPersonagem(){
        binding.floatingActionButton.setOnClickListener{
            characterViewModel.validarPreenchimento(
                binding.editTextName.text.toString(),
                binding.editTextDescription.text.toString(),
                binding.editTextAge.text.toString(),
                binding.editTextDate.text.toString(),
                binding.tipoEmpresa.selectedItemPosition,
                binding.tipoPersonagem.selectedItemPosition,
                binding.editTextUrl.text.toString(),
            )
        }
        characterViewModel.state.observe(this) {
            when(it) {

                CharacterViewState.ShowNameError ->
                    binding.editTextName.showError(R.string.name)

                CharacterViewState.ShowDescriptionError ->
                    binding.editTextDescription.showError(R.string.description)

                CharacterViewState.ShowImageError ->
                    binding.editTextUrl.showError(R.string.url)

                CharacterViewState.ShowUniverseTypeError -> showSnackBar(
                    binding.tipoEmpresa,
                    R.string.tipo_empresa,
                    R.color.background_button
                )

                CharacterViewState.ShowCharacterTypeError -> showSnackBar(
                    binding.tipoPersonagem,
                    R.string.tipo_personagem,
                    R.color.background_button
                )

                CharacterViewState.ShowAgeError ->
                    binding.editTextAge.showError(R.string.age)

                CharacterViewState.ShowBirthdayError -> showSnackBar(
                    binding.editTextDate,
                    R.string.date,
                    R.color.background_button
                )

                CharacterViewState.ShowGenericError -> showSnackBar(
                    binding.root,
                    R.string.erroGenerico_personagem,
                    R.color.background_button
                )

                CharacterViewState.ShowHomeScreen -> chamarTelaHome()

            }
        }
    }

    private fun chamarTelaHome() {
        showSnackBar(
            binding.root,
            R.string.sucessoCriar_personagem,
            R.color.background_button
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@CharacterActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
    }


    private fun spinnerPersonagem() {
        val spinner = findViewById<Spinner>(R.id.tipo_personagem)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            personagem
        )
        spinner.adapter = arrayAdapter
    }

    private fun spinnerEmpresa() {
        val spinner = findViewById<Spinner>(R.id.tipo_empresa)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            empresa
        )
        spinner.adapter = arrayAdapter
    }


}

