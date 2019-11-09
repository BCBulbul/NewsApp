package burakcanbulbul.com.newsapp.ui.detail

import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.mvp.MainPresenterImpl
import burakcanbulbul.com.newsapp.ui.mvp.MainView

interface DetailContract {

    interface View : MainView,OnSuccessListener {
        fun init()
        fun initPresenter()
        fun fetchNewsHeadlines()
    }

    interface OnSuccessListener{
        fun onSuccess(articles: ArrayList<Article>)
    }

    abstract class Presenter : MainPresenterImpl<DetailContract.View> {

        constructor(mainView: DetailContract.View){
            super.mainView = mainView
        }

        abstract fun setDataSource(newsAppDataSource: NewsAppDataSource)
        abstract fun setOnSuccessListener(onSuccessListener: OnSuccessListener)
        abstract fun getNewsHeadlines()

    }
}