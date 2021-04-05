package pl.redny.infrastructure.retrofit.model

import com.google.gson.annotations.SerializedName
import pl.redny.core.domain.game.Currency

class CurrencyResponse {

    @SerializedName("id")
    var id: Short = 0.toShort()

    @SerializedName("name")
    var name: String = ""

    @SerializedName("description")
    var description: String = ""

    @SerializedName("order")
    var order: Short = 0.toShort()

    @SerializedName("icon")
    var icon: String = ""

    fun toCurrency(): Currency = Currency(id, name, description, order, icon)

}