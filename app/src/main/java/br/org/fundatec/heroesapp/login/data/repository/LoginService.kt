package br.org.fundatec.heroesapp.login.data.repository

import br.org.fundatec.heroesapp.login.data.LoginRequest
import br.org.fundatec.heroesapp.login.data.remote.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/api/login")
    suspend fun createUser(@Body loginRequest: LoginRequest): Result<LoginResponse>
}