package burakcanbulbul.com.newsapp.di.module

import android.content.Context
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
}