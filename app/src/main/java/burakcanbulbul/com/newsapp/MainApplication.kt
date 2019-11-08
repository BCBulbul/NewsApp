package burakcanbulbul.com.newsapp

import android.app.Activity
import android.content.Context
import android.support.multidex.MultiDex
import android.support.v4.app.Fragment
import burakcanbulbul.com.newsapp.di.component.DaggerApplicationComponent
import com.squareup.picasso.Picasso
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : DaggerApplication(), HasFragmentInjector, HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        initLibraries()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this@MainApplication)
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }

    private fun initLibraries(){
        Picasso.setSingletonInstance(Picasso.Builder(this).build())
    }


}