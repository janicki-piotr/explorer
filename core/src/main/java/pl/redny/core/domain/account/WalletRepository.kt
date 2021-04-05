package pl.redny.core.domain.account

import pl.redny.core.base.Error
import pl.redny.core.base.Result

interface WalletRepository {

    fun getWallet(): Result<Error, Wallet>
}
