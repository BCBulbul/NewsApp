package burakcanbulbul.com.newsapp.ui.detail

import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.mvp.MainPresenterImpl
import burakcanbulbul.com.newsapp.ui.mvp.MainView

interface DetailContract {

    interface View : MainView {
        fun init()
        fun initPresenter()
        fun fetchNewsHeadlines()
    }

    interface OnSuccessListener{
        fun onSuccess(headlines: Headlines)
    }

    abstract class Presenter : MainPresenterImpl<DetailContract.View> {

        constructor(mainView: DetailContract.View){
            super.mainView = mainView
        }

        abstract fun setDataSource(newsAppDataSource: NewsAppDataSource)
        abstract fun getNewsHeadlines()

    }
}