package br.org.fundatec.heroesapp.login.domain

import br.org.fundatec.heroesapp.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy {
        LoginRepository()
    }

    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
       return  repository.createUser(
           name = name,
           email = email,
           password = password,
       )
    }

    suspend fun verificarUser(
        password: String,
        email: String,
    ): Boolean {
        return repository.verificarUser(
            password = password,
            email = email
        )
    }

}