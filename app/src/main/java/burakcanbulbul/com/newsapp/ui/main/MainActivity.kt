package burakcanbulbul.com.newsapp.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
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


class MainActivity : BaseActivity(), MainContract.View, AdapterView.OnItemClickListener {

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    private lateinit var mainPresenter : MainPresenter
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        init()
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun init() {
        changeStatusBarColor(R.color.news_blue)
        news_listview.onItemClickListener = this
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

    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this,"Tıklandı : "+position,Toast.LENGTH_LONG).show()
    }



}
