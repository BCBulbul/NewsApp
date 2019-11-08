package burakcanbulbul.com.newsapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.adapter.NewsListAdapter
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.model.Source
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.remote.NewsAppDataSourceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {


    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    private lateinit var mainPresenter : MainPresenter
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        init()
     /*   newsAppDataSource.getSources().enqueue(object : Callback<DataSource>{

            override fun onResponse(call: Call<DataSource>, response: Response<DataSource>) {
                if(response.isSuccessful.and(response.body() != null)){
                    Log.d("SourceData",response.body()!!.sources[0].description)
                    val adapter : NewsListAdapter = NewsListAdapter(this@MainActivity, response.body()!!)
                    news_listview.adapter = adapter
                }

            }

            override fun onFailure(call: Call<DataSource>, t: Throwable) {
                Log.d("SourceFailure",t.message)
            }

        })*/

        /*

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

    override fun init() {
        initPresenter()
    }

    override fun initPresenter() {
        mainPresenter = MainPresenter(this)
        mainPresenter.setDataSource(newsAppDataSource)
        mainPresenter.setOnResponseListener(this)
        fetchNewsSources()
    }

    override fun onSuccess(dataSource: DataSource) {
        newsListAdapter = NewsListAdapter(this,dataSource)
        news_listview.adapter = newsListAdapter
    }

    override fun fetchNewsSources() {
        mainPresenter.getNewsSources()
    }



}
