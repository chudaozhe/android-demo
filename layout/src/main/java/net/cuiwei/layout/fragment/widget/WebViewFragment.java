package net.cuiwei.layout.fragment.widget;

import android.net.http.SslError;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.*;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.layout.R;

import java.net.MalformedURLException;
import java.net.URL;

public class WebViewFragment extends Fragment {
    private WebView webview;
    private EditText urlsView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_web_view, container, false);
        webview=view.findViewById(R.id.webview);
        urlsView = view.findViewById(R.id.urls);

        webviewSetting();
        webview.loadUrl("https://yangkeduo.com/");//默认加载

        return view;
    }

    public void webviewSetting(){
        WebSettings wSet = webview.getSettings();
        wSet.setDomStorageEnabled(true);
        wSet.setJavaScriptEnabled(true);
//        String userAgent = webview.getSettings().getUserAgentString();
//        Log.i("TAG", "User Agent:" + userAgent);
//        webview.getSettings().setUserAgentString( userAgent);
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                if (!url.contains("yangkeduo.com/goods.html?goods_id=")){
                    view.loadUrl(url);
                    return false;
                }else {
                    Log.e("cw-url", url);
                    try {
                        URL urlObj = new URL(url);
                        String args=urlObj.getQuery();
                        String[] argsArray=args.split("&");
                        String goods_id = null;
                        for (String arg : argsArray) {
                            System.out.println(arg);
                            if (arg.contains("goods_id=")){
                                goods_id=arg.substring(9);
                                break;
                            }
                        }
                        if (null!=goods_id){
                            urlsView.append("https://yangkeduo.com/goods.html?goods_id="+goods_id+"\n");
                            urlsView.setMovementMethod(ScrollingMovementMethod.getInstance());
                            urlsView.setSelection(urlsView.getText().length(), urlsView.getText().length());
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                //当收到证书错误时，忽略掉，直接继续处理就行了；相当于信任了所有的证书一样
                handler.proceed();
            }
        });
    }
}