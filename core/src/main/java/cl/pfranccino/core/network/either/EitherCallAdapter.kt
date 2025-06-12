package cl.pfranccino.core.network.either

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class EitherCallAdapter<T>(
    private val successType: Type,
    private val errorType: Type
) : CallAdapter<T, Call<Either<ApiError, T>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<T>): Call<Either<ApiError, T>> {
        return EitherCall(call, errorType)
    }
}