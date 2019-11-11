package burakcanbulbul.com.newsapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity
import burakcanbulbul.com.newsapp.ui.main.MainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        changeStatusBarColor(R.color.news_blue)
    }


    fun init(view : View){
        val splashIntent : Intent = Intent(this, MainActivity :: class.java)
        startActivity(splashIntent)
    }

    override fun getLayoutRes(): Int = R.layout.activity_splash
}
