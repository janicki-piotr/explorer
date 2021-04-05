package pl.redny.core.base

sealed class Error {

    object NetworkError : Error()

    object GenericError : Error()

    object ResponseError : Error()

    object PersistenceError : Error()
}