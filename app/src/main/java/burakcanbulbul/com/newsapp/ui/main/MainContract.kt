package burakcanbulbul.com.newsapp.ui.main

import android.arch.lifecycle.MutableLiveData
import android.support.v4.widget.ContentLoadingProgressBar
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Source
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.mvp.MainPresenterImpl
import burakcanbulbul.com.newsapp.ui.mvp.MainView

interface MainContract {

    interface View : MainView,OnResponseListener {
       fun init()
       fun initPresenter()
       fun fetchNewsSources()
    }

    interface OnResponseListener{
        fun onSuccess(dataSource: DataSource)
    }

    abstract class Presenter : MainPresenterImpl<MainContract.View> {

        constructor(mainView: MainContract.View){
            super.mainView = mainView
        }

        abstract fun setDataSource(newsAppDataSource: NewsAppDataSource)
        abstract fun setOnResponseListener(onResponseListener: OnResponseListener)
        abstract fun getNewsSources()

    }
}