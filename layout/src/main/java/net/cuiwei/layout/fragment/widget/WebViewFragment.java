package net.cuiwei.layout.fragment.widget;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.layout.R;

public class WebViewFragment extends Fragment {
    private WebView webview;
    private EditText inputView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_web_view, container, false);
        webview=view.findViewById(R.id.webview);
        inputView = view.findViewById(R.id.input);

        webviewSetting();
        webview.loadUrl("https://test.cuiwei.net/");//默认加载

        inputView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String url = v.getText().toString().trim();
                //具体是"搜索"，还是"完成"，需在xml里设置
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    webview.loadUrl(url);
                    Log.e("url", url);
                    //return false;
                }
                return false;
            }
        });
        return view;
    }

    public void webviewSetting(){
        WebSettings wSet = webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }
}