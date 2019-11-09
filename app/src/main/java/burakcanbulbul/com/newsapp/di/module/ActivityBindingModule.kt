package burakcanbulbul.com.newsapp.di.module

import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.ui.detail.DetailActivity
import burakcanbulbul.com.newsapp.ui.main.MainActivity
import burakcanbulbul.com.newsapp.ui.panel.PanelActivity
import burakcanbulbul.com.newsapp.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindBaseActivity() : BaseActivity
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
    @ContributesAndroidInjector
    abstract fun bindDetailActivity() : DetailActivity
    @ContributesAndroidInjector
    abstract fun bindPanelActivity () : PanelActivity
    @ContributesAndroidInjector
    abstract fun bindSplashActivity() : SplashActivity


}