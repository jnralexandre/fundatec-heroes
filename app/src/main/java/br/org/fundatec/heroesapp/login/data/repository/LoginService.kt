package br.org.fundatec.heroesapp.login.data.repository

import br.org.fundatec.heroesapp.login.data.LoginRequest
import br.org.fundatec.heroesapp.login.data.remote.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("api/login")
    suspend fun createUser(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>


    @GET("api/login")
    suspend fun verificarUser(
        @Query("password") password: String,
        @Query("email") email: String
    ): Response<LoginResponse>

}