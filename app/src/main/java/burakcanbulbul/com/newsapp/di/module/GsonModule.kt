package burakcanbulbul.com.newsapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GsonModule {
    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }
}