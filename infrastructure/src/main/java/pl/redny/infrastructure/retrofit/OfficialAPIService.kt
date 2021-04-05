package pl.redny.infrastructure.retrofit

import pl.redny.core.base.Error
import pl.redny.core.base.Result
import pl.redny.core.domain.account.Wallet
import pl.redny.core.domain.account.WalletRepository
import pl.redny.core.domain.account.WalletValue
import pl.redny.core.domain.game.Currencies
import pl.redny.core.domain.game.Currency
import pl.redny.core.domain.game.CurrencyRepository
import pl.redny.infrastructure.retrofit.api.AccountService
import pl.redny.infrastructure.retrofit.api.GameMechanicsService
import retrofit2.Retrofit

class OfficialAPIService(retrofit: Retrofit) : WalletRepository, CurrencyRepository {

    private val accountService: AccountService =
        retrofit.create(AccountService::class.java)
    private val gameMechanicsService: GameMechanicsService =
        retrofit.create(GameMechanicsService::class.java)

    override fun getWallet(): Result<Error, Wallet> {
        val response = accountService
            .getWallet("63659C76-8630-324C-8268-2061F453BEDD39253BF1-6D28-4291-843B-ED025E4DF369")
            .execute()

        if (response.isSuccessful) {
            return Result.Success(
                Wallet(response.body()
                    .map { element -> element.toWalletValue() }
                )
            )
        }

        return Result.Failure(Error.NetworkError)
    }

    override fun getCurrencies(): Result<Error, Currencies> {
        val response = gameMechanicsService
            .getCurrencies()
            .execute()

        if (response.isSuccessful) {
            return Result.Success(
                Currencies(response.body()
                    .map { element -> element.toCurrency() }
                )
            )
        }

        return Result.Failure(Error.NetworkError)
    }

    override fun getCurrency(id: Short): Result<Error, Currency> {
        val response = gameMechanicsService
            .getCurrency(id)
            .execute()

        if (response.isSuccessful) {
            return Result.Success(response.body()
                .map { element -> element.toCurrency() }
                .first()
            )
        }

        return Result.Failure(Error.NetworkError)
    }
}