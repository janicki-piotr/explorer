package pl.redny.application.feature.account

data class AccountWalletDataResponse(
    val name: String,
    val description: String,
    val icon: String,
    val amount: Long
)
