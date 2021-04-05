package pl.redny.gw2explorer.ui.wallet

import arrow.core.None
import kotlinx.coroutines.channels.ReceiveChannel
import pl.redny.application.feature.account.GetAccountWalletData
import pl.redny.core.base.Entity
import pl.redny.core.base.Error
import pl.redny.core.base.Result
import pl.redny.gw2explorer.ui.base.BaseViewModel

class WalletViewModel(private val getAccountWalletData: GetAccountWalletData) : BaseViewModel() {
    override val receiveChannel: ReceiveChannel<Result<Error, Entity>>
        get() = getAccountWalletData.receiveChannel

    init {
        getAccountWalletData(None)
    }

    override fun resolve(value: Result<Error, Entity>) {
        value.handleResult(::handleSuccess, ::handleFailure, ::handleState)
    }

    fun handleSuccess(data: Entity) {
        when (data) {
//            is Currency -> _text.value = data.toString()
//            is Wallet -> _text.value = data.toString()
        }
    }

    fun handleFailure(error: Error) {

    }

    fun handleState(state: Result.State) {

    }
}