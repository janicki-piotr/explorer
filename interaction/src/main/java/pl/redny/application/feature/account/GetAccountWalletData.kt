package pl.redny.application.feature.account

import arrow.core.None
import pl.redny.core.base.Result
import pl.redny.application.base.UseCase
import pl.redny.core.domain.account.WalletRepository
import pl.redny.core.domain.account.WalletValue
import pl.redny.core.domain.game.Currency
import pl.redny.core.domain.game.CurrencyRepository

class GetAccountWalletData(
    private val walletRepository: WalletRepository,
    private val currencyRepository: CurrencyRepository
) :
    UseCase<None>() {
    override suspend fun run(params: None) {
        resultChannel.send(Result.State.Loading())

        val currencyAsync = startAsync {
            resultChannel.send(currencyRepository.getCurrencies())
        }

        val walletAsync = startAsync {
            resultChannel.send(walletRepository.getWallet())
        }

        resultChannel.send(Result.State.Loaded())
    }

    fun mapCurrency(walletValue: WalletValue, currency: Currency) =
        AccountWalletDataResponse(
            currency.name,
            currency.description,
            currency.icon,
            walletValue.amount
        )

}