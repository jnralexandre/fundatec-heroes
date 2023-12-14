package br.org.fundatec.heroesapp.home.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.character.view.CharacterActivity
import br.org.fundatec.heroesapp.databinding.ActivityHomeBinding
import br.org.fundatec.heroesapp.home.presentation.HomeViewModel
import br.org.fundatec.heroesapp.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acRecycleView.adapter = adapter
        viewModel.state.observe(this) {
            when (it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                HomeViewState.Loading -> {

                }

                is HomeViewState.Error ->
                    it.errorMessage
            }

        }

        binding.acFloatingActionButton.setOnClickListener {
            chamarCharacterActivity()
        }

    }

    private fun chamarCharacterActivity() {
        val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
        startActivity(intent)
    }

}