package br.org.fundatec.heroesapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R
import br.org.fundatec.heroesapp.home.view.HomeActivity
import br.org.fundatec.heroesapp.login.view.LoginActivity
import br.org.fundatec.heroesapp.splash.presentation.SplashViewModel
import br.org.fundatec.heroesapp.splash.presentation.model.SplashViewState

private const val DELAY_SHOW_SCREEN = 3000L

class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ChamarHomeActivity -> chamarHomeActivity()
                SplashViewState.ChamarLoginActivity -> chamarLoginActivity()
            }
        }

        val handle = Handler()
        handle.postDelayed({ chamarLoginActivity() }, 3000)

    }

    private fun chamarLoginActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }

    private fun chamarHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }

}


