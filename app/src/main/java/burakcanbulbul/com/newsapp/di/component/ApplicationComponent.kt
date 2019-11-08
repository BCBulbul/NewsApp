package burakcanbulbul.com.newsapp.di.component

import burakcanbulbul.com.newsapp.MainApplication
import burakcanbulbul.com.newsapp.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [ApplicationModule::class,AndroidSupportInjectionModule :: class,
    ActivityBindingModule :: class,FragmentBindingModule :: class, DataSourceModule :: class,GsonModule::class,SerializerModule::class
])
interface ApplicationComponent : AndroidInjector<MainApplication>{

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}