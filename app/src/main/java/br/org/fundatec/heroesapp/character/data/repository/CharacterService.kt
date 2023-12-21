package br.org.fundatec.heroesapp.character.data.repository

import br.org.fundatec.heroesapp.character.data.CharacterRequest
import br.org.fundatec.heroesapp.character.data.remote.CharacterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CharacterService {

    @POST("/api/character/{idUser}")
    suspend fun criarPersonagem(
        @Path("idUser") idUser: Int,
        @Body characterRequest: CharacterRequest
    ): Response<ResponseBody>

    @GET("/api/character/{idUser}")
    suspend fun listarPersonagem(
        @Path("idUser") idUser: Int,
    ): Response<List<CharacterResponse>>

    @DELETE("/api/character/{idCharacter}")
    suspend fun deletarPersonagem(
        @Path("idCharacter") idCharacter: Int,
    ): Response<ResponseBody>
}