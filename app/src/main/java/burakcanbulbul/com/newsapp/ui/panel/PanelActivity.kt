package burakcanbulbul.com.newsapp.ui.panel

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import burakcanbulbul.com.newsapp.R
import burakcanbulbul.com.newsapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_panel.*

class PanelActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        val newsURL:String = this.intent.getStringExtra("URL")
        init()
        initWebView(newsURL)
    }

    override fun getLayoutRes(): Int = R.layout.activity_panel

    override fun onBackPressed() {
        if (news_webview.canGoBack()) {
            news_webview.goBack()
        } else {
            super.onBackPressed()
        }
        super.onBackPressed()
    }

    private fun init(){
        changeStatusBarColor(R.color.news_blue)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView(URL : String) {
        news_webview.settings.javaScriptEnabled = true
        news_webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
                if (event != null) {
                    if (event.keyCode == KeyEvent.KEYCODE_BACK && news_webview.canGoBack()) {
                        news_webview.goBack()
                        return true
                    }
                }
                return super.shouldOverrideKeyEvent(view, event)
            }

        }

        news_webview.loadUrl(URL)
    }
}
