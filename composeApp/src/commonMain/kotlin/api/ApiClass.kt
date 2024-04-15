package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import model.QuotesDataClassItem


class ApiClass {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

   suspend fun githubUsers(): Result<List<QuotesDataClassItem>>{
        val response = client.get("https://zenquotes.io/api/quotes/[YOUR_API_KEY]")
     /*   {
            headers {
                append(HttpHeaders.Authorization, ApiHeader.auth)
            }
        }*/

        return response.body()
    }
/*
    suspend fun getUser(userName:String):SearchUserDataClass{
        val response = client.get("https://api.github.com/users/$userName")
        return response.body()

    }*/

}