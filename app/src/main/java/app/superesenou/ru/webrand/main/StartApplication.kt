package app.superesenou.ru.webrand.main

import android.app.Application



import app.superesenou.ru.webrand.data.ForumService
import app.superesenou.ru.webrand.data.Network


class StartApplication: Application() {

    private val BASE_URL_WEBRAND="http://webrand.kg"
    companion object {
        @Volatile
        lateinit var servicewebrand: ForumService

    }

    override fun onCreate() {
        super.onCreate()
        servicewebrand= Network.initService(BASE_URL_WEBRAND)
    }
}