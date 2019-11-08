package burakcanbulbul.com.newsapp.di.module

import burakcanbulbul.com.newsapp.data.local.db.serializer.GsonSerializer
import burakcanbulbul.com.newsapp.data.local.db.serializer.Serializer
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module(includes = [GsonModule :: class])
class SerializerModule {
    @Provides
    fun provideSerializer(gson : Gson) : Serializer<Any> {
        return GsonSerializer().setGson(gson)
    }
}