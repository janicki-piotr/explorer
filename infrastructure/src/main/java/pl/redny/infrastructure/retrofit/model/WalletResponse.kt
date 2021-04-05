package pl.redny.infrastructure.retrofit.model

import com.google.gson.annotations.SerializedName
import pl.redny.core.domain.account.WalletValue

class WalletResponse {

    @SerializedName("id")
    var id: Short = 0.toShort()

    @SerializedName("value")
    var value: Long = 0.toLong()

    fun toWalletValue(): WalletValue = WalletValue(id, value)

}