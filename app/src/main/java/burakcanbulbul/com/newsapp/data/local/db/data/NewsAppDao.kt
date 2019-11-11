package burakcanbulbul.com.newsapp.data.local.db.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import burakcanbulbul.com.newsapp.model.News

@Dao
interface NewsAppDao {

    @Query("SELECT * FROM news_db")
    fun getAllNews() : List<News>

    @Insert
    fun insertAllNews(vararg new : News)

    @Delete
    fun deleteNew(new : News)
}