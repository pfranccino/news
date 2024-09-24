package cl.pfranccino.news.core

import kotlinx.coroutines.coroutineScope

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()

    fun isLeft() = this is Left
    fun isRight() = this is Right

    suspend fun <L, R, T> Either<L, R>.coEither(
        leftOperation: suspend (L) -> T,
        rightOperation: suspend (R) -> T
    ): T = coroutineScope {
        when (this@coEither) {
            is Left -> leftOperation(value)
            is Right -> rightOperation(value)
        }
    }

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