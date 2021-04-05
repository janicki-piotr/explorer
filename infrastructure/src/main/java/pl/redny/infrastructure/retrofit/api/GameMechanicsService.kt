package pl.redny.infrastructure.retrofit.api

import pl.redny.infrastructure.retrofit.model.CurrencyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GameMechanicsService {

    @GET("v2/currencies?ids=all")
    fun getCurrencies(): Call<List<CurrencyResponse>>

    @GET("v2/currencies?")
    fun getCurrency(@Query("ids") id: Short): Call<List<CurrencyResponse>>
}