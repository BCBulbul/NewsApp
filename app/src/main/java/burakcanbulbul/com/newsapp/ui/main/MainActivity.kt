package burakcanbulbul.com.newsapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.adapter.NewsListAdapter
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.model.DataSource
import burakcanbulbul.com.newsapp.model.Source
import burakcanbulbul.com.newsapp.remote.NewsAppDataSource
import burakcanbulbul.com.newsapp.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View, AdapterView.OnItemClickListener {

    @Inject
    lateinit var newsAppDataSource: NewsAppDataSource

    private lateinit var mainPresenter : MainPresenter
    private lateinit var newsListAdapter: NewsListAdapter
    private lateinit var dataList: ArrayList<Source>

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
        mainPresenter = MainPresenter(this,this)
        mainPresenter.setDataSource(newsAppDataSource)
        mainPresenter.setOnResponseListener(this)
        fetchNewsSources()
    }

    override fun onSuccess(dataSource: DataSource) {
        this.dataList = dataSource.sources
        newsListAdapter = NewsListAdapter(dataSource)
        news_listview.adapter = newsListAdapter
    }

    override fun fetchNewsSources() {
        mainPresenter.getNewsSources()

    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val newsIntent : Intent = Intent(this, DetailActivity:: class.java)
        newsIntent.putExtra("name", dataList[position].name)
        startActivity(newsIntent)
    }



}
