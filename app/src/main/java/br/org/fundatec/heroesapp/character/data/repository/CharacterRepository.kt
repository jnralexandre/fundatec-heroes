package br.org.fundatec.heroesapp.character.data.repository

import android.util.Log
import br.org.fundatec.heroesapp.character.data.CharacterRequest
import br.org.fundatec.heroesapp.character.data.remote.CharacterResponse
import br.org.fundatec.heroesapp.login.data.repository.LoginRepository
import br.org.fundatec.heroesapp.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class CharacterRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(CharacterService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    suspend fun createCharacter(
        name: String,
        description: String,
        age: Int,
        tipoEmpresa: String,
        tipoPersonagem: String,
        image: String,
        birthday: LocalDateTime?): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.criarPersonagem(
                    idUser = loginRepository.pegarId(),
                    characterRequest = CharacterRequest(
                        name = name,
                        description = description,
                        age = age,
                        birthday = null,
                        universeType = tipoEmpresa,
                        characterType = tipoPersonagem,
                        image = image
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createCharacter", ex.message.toString())
                false
            }
        }
    }

    suspend fun listCharacter(): List<CharacterResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.listarPersonagem(
                    idUser = loginRepository.pegarId()
                )
                response.body()?: listOf()
            } catch (ex: Exception) {
                Log.e("listCharacter", ex.message.toString())
                listOf();
            }
        }
    }

}