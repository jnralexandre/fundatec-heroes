package br.org.fundatec.heroesapp.login.data.repository

import android.util.Log
import br.org.fundatec.heroesapp.login.data.LoginRequest
import br.org.fundatec.heroesapp.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginRepository {
    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(LoginService::class.java)

    suspend fun createUser(
        name: String,
        email: String,
        password: String,
    ): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createUser(
                    loginRequest = LoginRequest(
                        name = name,
                        email = email,
                        password = password,
                    )
                )
                response.isSuccess
            } catch (ex: Exception) {
                Log.e("createUser", ex.message.toString())
                false
            }
        }
    }
}