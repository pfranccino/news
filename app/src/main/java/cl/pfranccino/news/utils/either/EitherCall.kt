package cl.pfranccino.news.utils.either

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

class EitherCall<T>(
    private val delegate: Call<T>,
    private val errorType: Type
) : Call<Either<ApiError, T>> {

    override fun enqueue(callback: Callback<Either<ApiError, T>>) {
        delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    callback.onResponse(this@EitherCall, Response.success(Either.Right(response.body()!!)))
                } else {
                    val errorBody = response.errorBody()?.string() ?: ""
                    val error = try {
                        Gson().fromJson(errorBody, ApiError::class.java)
                    } catch (e: Exception) {
                        ApiError("error", "parseError", "Failed to parse error response")
                    }
                    callback.onResponse(this@EitherCall, Response.success(Either.Left(error)))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val error = when (t) {
                    is IOException -> ApiError("error", "networkError", "Network error occurred")
                    else -> ApiError("error", "unexpectedError", t.message ?: "An unexpected error occurred")
                }
                callback.onResponse(this@EitherCall, Response.success(Either.Left(error)))
            }
        })
    }

    override fun clone(): Call<Either<ApiError, T>> = EitherCall(delegate.clone(), errorType)

    override fun execute(): Response<Either<ApiError, T>> {
        throw UnsupportedOperationException("EitherCall doesn't support synchronous execution")
    }

    override fun isExecuted(): Boolean = delegate.isExecuted
    override fun cancel() = delegate.cancel()
    override fun isCanceled(): Boolean = delegate.isCanceled
    override fun request() = delegate.request()
    override fun timeout() = delegate.timeout()
}