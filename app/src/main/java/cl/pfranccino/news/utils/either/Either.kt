package cl.pfranccino.news.utils.either

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()

    fun isLeft() = this is Left
    fun isRight() = this is Right

    fun fold(leftOp: (L) -> Unit, rightOp: (R) -> Unit) {
        when (this) {
            is Left -> leftOp(value)
            is Right -> rightOp(value)
        }
    }

    fun <T> map(f: (R) -> T): Either<L, T> =
        when (this) {
            is Left -> this
            is Right -> Right(f(value))
        }
}
