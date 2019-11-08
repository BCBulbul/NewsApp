package burakcanbulbul.com.newsapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.remote.NewsAppDataSourceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
/*
        newsAppDataSource.getSources().enqueue(object : Callback<DataSource>{
            override fun onFailure(call: Call<DataSource>, t: Throwable) {
                Log.d("SourceFailure",t.message)
            }

            override fun onResponse(call: Call<DataSource>, response: Response<DataSource>) {
                Log.d("SourceData",response.body()!!.sources[0].description)
            }

        })

        newsAppDataSource.getArticleHeadlines().enqueue(object : Callback<Headlines> {

            override fun onResponse(call: Call<Headlines>, response: Response<Headlines>) {
                if(response.isSuccessful.and(response.body() != null))
                Log.d("DATA","Article Description : "+ response.body()!!.articles[0].content)
            }

            override fun onFailure(call: Call<Headlines>, t: Throwable) {
                Log.d("onFailure",t.message)
            }

        })*/
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

}
