package br.org.fundatec.heroes_app.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.org.fundatec.heroes_app.R
import br.org.fundatec.heroes_app.gone
import br.org.fundatec.heroes_app.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {
    private val button by lazy {
        findViewById<Button>(R.id.button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observerState(HomeViewState.HideButton)
    }

    private fun observerState(state: HomeViewState) {
        when (state) {
            is HomeViewState.Sucess -> {
                state.sucessMessage
            }

            is HomeViewState.Error -> {
                state.errorMessage
            }

            HomeViewState.Loading -> {}

            HomeViewState.HideButton -> {
                button.gone()
            }
        }
    }
}