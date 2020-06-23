package net.cuiwei.layout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import net.cuiwei.layout.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        EditText url = findViewById(R.id.url);
        String url2 = url.getText().toString();
        WebView page =findViewById(R.id.page);

        page.loadUrl("https://test.cuiwei.net/");
        WebSettings wSet = page.getSettings();
        wSet.setJavaScriptEnabled(true);
        page.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

}
