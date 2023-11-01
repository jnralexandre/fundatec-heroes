package br.org.fundatec.heroesapp.login.domain

import android.util.Log
import br.org.fundatec.heroesapp.login.data.LoginRequest
import br.org.fundatec.heroesapp.login.data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

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
}