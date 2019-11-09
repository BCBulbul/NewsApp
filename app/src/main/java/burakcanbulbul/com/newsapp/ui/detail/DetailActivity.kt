package burakcanbulbul.com.newsapp.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.Article
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import kotlinx.android.synthetic.main.news_detail_toolbar.*
import javax.inject.Inject

class DetailActivity : BaseActivity() , DetailContract.View{

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    private var sourceName : String? = ""
    private var articleList : ArrayList<Article> = arrayListOf()

    private lateinit var detailPresenter: DetailPresenter

    override fun getLayoutRes(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        init()
    }

    override fun init() {
        changeStatusBarColor(R.color.news_blue)
        sourceName = this.intent.getStringExtra("name")
        Toast.makeText(this,"Gelen data : "+sourceName,Toast.LENGTH_LONG).show()
    }

    override fun initPresenter() {
        detailPresenter = DetailPresenter(this)
        detailPresenter.setDataSource(newsAppDataSource)
    }

    override fun fetchNewsHeadlines() {

    }

    override fun onSuccess(articles: ArrayList<Article>) {
        for(article in articles){
            if(article.status.name == sourceName){
                Log.d("Eşitler"+article.status.name,"daasdas"+sourceName)
                articleList.add(article)
            }
        }
    }

    fun backIconPressed(view : View){onBackPressed()}
}
