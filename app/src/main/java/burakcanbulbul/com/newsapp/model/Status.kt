package burakcanbulbul.com.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Status constructor(@SerializedName("id") @Expose var id : String,
                              @SerializedName("name") @Expose var name : String) : Serializable