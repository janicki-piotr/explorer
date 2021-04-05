package pl.redny.infrastructure.retrofit.api

import pl.redny.infrastructure.retrofit.model.WalletResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountService {

    @GET("v2/account/wallet")
    fun getWallet(@Query("access_token") accessToken: String): Call<List<WalletResponse>>
}