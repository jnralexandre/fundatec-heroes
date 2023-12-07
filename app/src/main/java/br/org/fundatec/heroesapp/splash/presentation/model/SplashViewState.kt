package br.org.fundatec.heroesapp.splash.presentation.model

sealed class SplashViewState {
    object ChamarLoginActivity : SplashViewState()
    object ChamarHomeActivity : SplashViewState()
}