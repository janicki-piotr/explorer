package pl.redny.core.base

sealed class Result<out R, out T> {

    class Success<out T>(val successData: T) : Result<Nothing, T>()
    class Failure<out R : Error>(val errorData: R) : Result<R, Nothing>()

    sealed class State : Result<Nothing, Nothing>() {
        class Loading : State()
        class Loaded : State()
    }

    fun handleResult(successBlock: (T) -> Unit = {}, failureBlock: (R) -> Unit = {}, stateBlock: (State) -> Unit = {}) {
        when (this) {
            is Success -> successBlock(successData)
            is Failure -> failureBlock(errorData)
            is State -> stateBlock(this)
        }
    }
}

typealias SimpleResult = Result<Error, Entity>