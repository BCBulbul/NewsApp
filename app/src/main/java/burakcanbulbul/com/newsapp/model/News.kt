package burakcanbulbul.com.newsapp.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "news_db")
data class News constructor(@PrimaryKey(autoGenerate = true) @NonNull var newsID : Int,
                            @ColumnInfo(name = "author") var author: String?,
                            @ColumnInfo(name="title")var title: String?,
                            @ColumnInfo(name = "set") val set : String?,
                            @ColumnInfo(name = "description") var description : String?,
                            @ColumnInfo(name = "url") var url : String?,
                            @ColumnInfo(name = "urlToImage") var urlToImage : String?,
                            @ColumnInfo(name = "publishedAt") var publishedAt : String?,
                            @ColumnInfo(name = "content") var content : String?)