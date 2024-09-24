package cl.pfranccino.news.data.model

import com.google.gson.annotations.SerializedName

data class NewsResponseDTO(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<ArticleDTO>
)