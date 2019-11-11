package burakcanbulbul.com.newsapp.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.adapter.NewsRecyclerViewAdapter
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.model.Headlines
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.panel.PanelActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.news_detail_toolbar.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import android.support.v4.os.HandlerCompat.postDelayed
import burakcanbulbul.com.newsapp.data.local.db.data.AppDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : BaseActivity() , DetailContract.View{

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource
    @Inject
    lateinit var appDatabase: AppDatabase

    private var sourceName : String? = ""

    private lateinit var newsRecyclerViewAdapter: NewsRecyclerViewAdapter
    private lateinit var detailPresenter: DetailPresenter

    private var dataList : ArrayList<Article> = arrayListOf()

    override fun getLayoutRes(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        init()
    }

    override fun init() {
        changeStatusBarColor(R.color.news_blue)
        sourceName = this.intent.getStringExtra("name")
        news_detail_toolbar_text_view.text = sourceName
        initPresenter()
        refreshNews()
    }

    override fun initPresenter() {
        detailPresenter = DetailPresenter(this)
        detailPresenter.setDataSource(newsAppDataSource)
        detailPresenter.setOnSuccessListener(this)
        fetchNewsHeadlines()
    }

    override fun fetchNewsHeadlines() {
        detailPresenter.getNewsHeadlines()
    }

    override fun onSuccess(articles: ArrayList<Article>) {
        this.dataList = articles
        initAdapter(articles)
    }

    override fun initAdapter(articles: ArrayList<Article>) {
        newsRecyclerViewAdapter = NewsRecyclerViewAdapter(this,articles)
        newsRecyclerViewAdapter.setOnRecyclerViewClickListener(this)
        newsRecyclerViewAdapter.setAppDatabase(appDatabase)
        news_detail_recycler_view.layoutManager = LinearLayoutManager(this)
        news_detail_recycler_view.setHasFixedSize(true)
        news_detail_recycler_view.adapter = newsRecyclerViewAdapter
    }

    override fun onRecyclerViewClick(view: View?, position: Int) {
        val newsIntent : Intent = Intent(this, PanelActivity :: class.java)
        newsIntent.putExtra("URL",dataList[position].url)
        startActivity(newsIntent)
    }

    // her 1 dakikada bir istek atılan ve yeni haber varsa listeyi refresh eden method

    override fun refreshNews() {
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                newsAppDataSource.getArticleHeadlines().enqueue(object : Callback<Headlines>{
                    override fun onResponse(call: Call<Headlines>, response: Response<Headlines>) {
                        if(response.isSuccessful.and(response.body() != null)){
                            if(dataList.size < response.body()!!.articles.size){
                                newsRecyclerViewAdapter = NewsRecyclerViewAdapter(this@DetailActivity,response.body()!!.articles)
                                news_detail_recycler_view.layoutManager = LinearLayoutManager(this@DetailActivity)
                                news_detail_recycler_view.adapter = newsRecyclerViewAdapter
                                news_detail_recycler_view.scrollToPosition(0)
                                Toast.makeText(this@DetailActivity,"Yeni haberler eklendi",Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<Headlines>, t: Throwable) {
                        Log.d("OnFailure",t.message)
                    }


                })

                handler.postDelayed(this, 60000)
            }
        }, 60000)
    }


    fun backIconPressed(view : View){onBackPressed()}
}
