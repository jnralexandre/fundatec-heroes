package br.org.fundatec.heroesapp.character.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding
    val tipoPersonagem = arrayOf("Herói", "Vilão")
    val tipoEmpresa = arrayOf("Marvel", "DC")

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = findViewById<Spinner>(R.id.tipo_personagem)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            tipoPersonagem
        )
        spinner.adapter = arrayAdapter

        val spinner2 = findViewById<Spinner>(R.id.tipo_empresa)
        val arrayAdapter2 = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            tipoEmpresa
        )
        spinner2.adapter = arrayAdapter2
    }
}

