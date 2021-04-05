package pl.redny.core.domain.account

import pl.redny.core.base.Entity

data class Wallet(val walletValues: List<WalletValue>) : Entity