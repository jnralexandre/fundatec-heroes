package br.org.fundatec.heroesapp.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.character.view.CharacterActivity
import br.org.fundatec.heroesapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imCriarPersonagem.setOnClickListener {
            chamarCharacterActivity()
        }
    }

    private fun chamarCharacterActivity() {
        val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
        startActivity(intent)
    }

}