package burakcanbulbul.com.newsapp.di.module

import android.content.Context
import burakcanbulbul.com.newsapp.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [SerializerModule :: class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplication(mainApplication : MainApplication) : Context = mainApplication


}