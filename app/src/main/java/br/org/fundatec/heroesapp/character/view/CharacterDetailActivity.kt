package br.org.fundatec.heroesapp.character.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.databinding.ActivityDetailsCharacterBinding
import com.bumptech.glide.Glide

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsCharacterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsCharacterBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val character = intent.extras?.getSerializable("character") as? CharacterModel
        if (character == null) {
            finish()
            return
        }
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.imageView)
        binding.textViewNomePersonagem.text = character.name
        binding.textViewDescricaoPersonagem.text = character.description
        binding.textViewIdadePersonagem.text = character.age.toString()
        binding.textNascimentoPersonagem.text = character.date
    }
}