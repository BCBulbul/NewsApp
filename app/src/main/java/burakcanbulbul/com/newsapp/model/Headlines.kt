package burakcanbulbul.com.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Headlines constructor(@SerializedName("status") @Expose var status : Status, @SerializedName("totalResults") @Expose var totalResult : Int,
                     @SerializedName("articles") @Expose var articles : ArrayList<Article> )
