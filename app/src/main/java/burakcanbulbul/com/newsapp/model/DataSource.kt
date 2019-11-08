package burakcanbulbul.com.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class DataSource constructor(@SerializedName("status") @Expose var status : String, @SerializedName("sources") @Expose var sources : ArrayList<Source>) : Serializable
