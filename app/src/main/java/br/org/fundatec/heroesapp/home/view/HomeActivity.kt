package br.org.fundatec.heroesapp.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.character.view.CharacterActivity
import br.org.fundatec.heroesapp.character.view.CharacterDetailActivity
import br.org.fundatec.heroesapp.databinding.ActivityHomeBinding
import br.org.fundatec.heroesapp.home.presentation.HomeViewModel
import br.org.fundatec.heroesapp.home.presentation.model.HomeViewState
import br.org.fundatec.heroesapp.showSnackBar
import br.org.fundatec.heroesapp.visible

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter() {
            Log.e("Home Activity", it.toString())
            chamarTelaDetalhesDoPersonagem(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()

        binding.acRecycleView.adapter = adapter
        viewModel.state.observe(this) {
            when (it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                is HomeViewState.DeletarPersonagem ->
                    showSnackBar(
                        binding.root,
                        R.string.remover_personagem,
                        R.color.background_button
                    )

                HomeViewState.Loading -> {
                    binding.progressBar.visible()
                }

                is HomeViewState.Error ->
                    it.errorMessage
            }

        }

        binding.acFloatingActionButton.setOnClickListener {
            chamarCharacterActivity()
        }
        deletarComSwipe()
    }

    private fun deletarComSwipe() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                val character = adapter.retrieveCharacter(h.adapterPosition)
                viewModel.removerPersonagem(character.id)
                adapter.removeAt(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.acRecycleView)
    }

    private fun chamarCharacterActivity() {
        val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
        startActivity(intent)
    }

    private fun chamarTelaDetalhesDoPersonagem(characterModel: CharacterModel) {
        val intent = Intent(this@HomeActivity, CharacterDetailActivity::class.java)
        intent.putExtra("character", characterModel);
        startActivity(intent)
    }

}