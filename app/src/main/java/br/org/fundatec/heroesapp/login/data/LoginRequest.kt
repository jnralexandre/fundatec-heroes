package br.org.fundatec.heroesapp.login.data

data class LoginRequest(
    val name: String,
    val email: String,
    val password: String,
)
