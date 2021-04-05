package pl.redny.core.domain.game

import pl.redny.core.base.Error
import pl.redny.core.base.Result

interface CurrencyRepository {

    fun getCurrencies(): Result<Error, Currencies>

    fun getCurrency(id: Short): Result<Error, Currency>
}
