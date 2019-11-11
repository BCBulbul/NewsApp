package burakcanbulbul.com.newsapp.ui.detail

import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.mvp.MainPresenterImpl
import burakcanbulbul.com.newsapp.ui.mvp.MainView
import burakcanbulbul.com.newsapp.widget.OnRecyclerViewClickListener

interface DetailContract {

    interface View : MainView,OnSuccessListener, OnRecyclerViewClickListener {
        fun init()
        fun initPresenter()
        fun fetchNewsHeadlines()
        fun initAdapter(articles: ArrayList<Article>)
        fun refreshNews()
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