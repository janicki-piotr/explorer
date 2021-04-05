package pl.redny.infrastructure.config

import org.koin.dsl.binds
import org.koin.dsl.module
import pl.redny.core.domain.account.WalletRepository
import pl.redny.core.domain.game.CurrencyRepository
import pl.redny.infrastructure.retrofit.OfficialAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfrastructureModule

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.guildwars2.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        OfficialAPIService(get())
    } binds arrayOf(
        WalletRepository::class,
        CurrencyRepository::class
    )
}