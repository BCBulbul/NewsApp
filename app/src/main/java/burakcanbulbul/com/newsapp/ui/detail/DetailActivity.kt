package burakcanbulbul.com.newsapp.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity

class DetailActivity : BaseActivity() , DetailContract.View{

    private var sourceName : String? = ""

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

    }

    override fun fetchNewsHeadlines() {

    }
}
