package app.superesenou.ru.webrand.data

import app.superesenou.ru.webrand.main.model.WebrandContact

import retrofit2.Call
import retrofit2.http.*

interface ForumService {

    @GET("/api.php?")
    fun getWebrand():Call<MutableList<WebrandContact>>
}