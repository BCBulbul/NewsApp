package burakcanbulbul.com.newsapp.ui.main


import android.arch.lifecycle.LifecycleObserver
import android.util.Log
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Source
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter constructor(mainView: MainContract.View) : MainContract.Presenter(mainView), LifecycleObserver{

    @Inject
    lateinit var newsAppDataSource : NewsAppDataSource

    private lateinit var onResponseListener : MainContract.OnResponseListener

    override fun setOnResponseListener(onResponseListener: MainContract.OnResponseListener) {
        this.onResponseListener = onResponseListener
    }

    override fun setDataSource(newsAppDataSource: NewsAppDataSource) {
        this.newsAppDataSource = newsAppDataSource
    }

    override fun getNewsSources(){
        newsAppDataSource.getSources().enqueue(object : Callback<DataSource>{

            override fun onResponse(call: Call<DataSource>, response: Response<DataSource>) {
                if(response.isSuccessful.and(response.body() != null)){
                    onResponseListener.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<DataSource>, t: Throwable) {
                Log.d("onFailure newsSources",t.message)
            }


        })
    }


}