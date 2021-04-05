package pl.redny.application.config

import org.koin.dsl.module
import pl.redny.application.feature.account.GetAccountWalletData

class ApplicationModule

val accountModule = module {
    single {
        GetAccountWalletData(get(), get())
    }
}