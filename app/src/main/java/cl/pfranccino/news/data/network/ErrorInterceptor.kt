package cl.pfranccino.news.data.network

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (!response.isSuccessful) {
            val errorBody = response.body?.string()
            try {
                val apiError = Gson().fromJson(errorBody, ApiError::class.java)
                throw ApiException(apiError)
            } catch (e: Exception) {
                throw IOException("Unexpected error occurred")
            }
        }
        return response
    }
}