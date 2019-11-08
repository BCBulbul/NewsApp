package burakcanbulbul.com.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article constructor(@SerializedName("source") @Expose var source: Source,
                              @SerializedName("author") @Expose var author: Int,
                              @SerializedName("title") @Expose var title: String, @SerializedName("set") val set : String,
                              @SerializedName("description") @Expose var description : String,
                              @SerializedName("url") @Expose var url : String,
                              @SerializedName("urlToImage") @Expose val urlToImage : String,
                              @SerializedName("publishedAt") @Expose var publishedAt : String,
                              @SerializedName("content") @Expose var content : String) : Serializable