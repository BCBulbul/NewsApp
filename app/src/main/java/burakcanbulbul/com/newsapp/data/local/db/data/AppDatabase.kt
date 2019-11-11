package burakcanbulbul.com.newsapp.data.local.db.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import burakcanbulbul.com.newsapp.model.News

@Database(entities = [News::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun newsDao(): NewsAppDao
}