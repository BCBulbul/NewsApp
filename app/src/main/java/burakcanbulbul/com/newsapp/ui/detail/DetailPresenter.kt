package burakcanbulbul.com.newsapp.ui.detail

import android.arch.lifecycle.LifecycleObserver
import android.util.Log
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailPresenter constructor(mainView: DetailContract.View) : DetailContract.Presenter(mainView), LifecycleObserver {

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    private lateinit var onSuccessListener: DetailContract.OnSuccessListener

    override fun setDataSource(newsAppDataSource: NewsAppDataSource) {
        this.newsAppDataSource = newsAppDataSource
    }

    override fun getNewsHeadlines() {
        newsAppDataSource.getArticleHeadlines().enqueue(object : Callback<Headlines>{
            override fun onResponse(call: Call<Headlines>, response: Response<Headlines>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onSuccessListener.onSuccess(response.body()!!.articles)
                }
            }

            override fun onFailure(call: Call<Headlines>, t: Throwable) {
                Log.d("OnFailure HeadLines",t.message)
            }


        })
    }

    override fun setOnSuccessListener(onSuccessListener: DetailContract.OnSuccessListener) {
        this.onSuccessListener = onSuccessListener
    }


}