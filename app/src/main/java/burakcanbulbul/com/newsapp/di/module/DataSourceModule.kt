package burakcanbulbul.com.newsapp.di.module

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import burakcanbulbul.com.newsapp.data.local.db.data.AppDatabase
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.remote.NewsAppDataSourceBuilder
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [GsonModule ::class, SerializerModule :: class])
class DataSourceModule {

    @Provides
    fun provideNewsAppDataSource(context: Context, gson : Gson?) : NewsAppDataSource{
        return NewsAppDataSourceBuilder().with(context).build(gson!!)
    }

    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "news").build()
    }
}