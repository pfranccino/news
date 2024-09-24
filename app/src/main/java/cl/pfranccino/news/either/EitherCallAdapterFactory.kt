package cl.pfranccino.news.either

import retrofit2.CallAdapter
import retrofit2.Call
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class EitherCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "Return type must be parameterized as Call<Either<ApiError, T>>" }

        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != Either::class.java) return null

        check(responseType is ParameterizedType) { "Response type must be parameterized as Either<ApiError, T>" }

        val errorType = getParameterUpperBound(0, responseType)
        val successType = getParameterUpperBound(1, responseType)

        return EitherCallAdapter<Any>(successType, errorType)
    }
}