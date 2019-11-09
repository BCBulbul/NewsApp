package burakcanbulbul.com.newsapp.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.adapter.NewsRecyclerViewAdapter
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.news_detail_toolbar.*
import javax.inject.Inject

class DetailActivity : BaseActivity() , DetailContract.View{

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

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
        newsRecyclerViewAdapter = NewsRecyclerViewAdapter(articles)
        newsRecyclerViewAdapter.setOnRecyclerViewClickListener(this)
        news_detail_recycler_view.layoutManager = LinearLayoutManager(this)
        news_detail_recycler_view.setHasFixedSize(true)
        news_detail_recycler_view.adapter = newsRecyclerViewAdapter
    }

    override fun onRecyclerViewClick(view: View?, position: Int) {
        // burada url değeri intentle yeni bir activity e geçilecke, activity açtırılacak
        Log.d("Posisiton",this.dataList[position].url)
    }


    fun backIconPressed(view : View){onBackPressed()}
}
