package com.ayman.android.openwebpage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity{
    // تعريف المتغيرات ولدينا كائن واحد فقط ويب فيو
    WebView webview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // اعداد شريط المعالجة
        requestWindowFeature(Window.FEATURE_PROGRESS);
        // ربط هذه الاكتفتي بالليوت الذي فيه العنصر ويب فيو
        setContentView(R.layout.activity_main);
        /**
         * هنا إذا كنت تريد تشغيل صفحة الويب في المتصفح ..
         * فلا تحتاج إلى كل هذه الأكواد فقط الى سطرين .. تعريف المتغير لويب فيو + تحديد الرابط
         * هذه السطرين في الأسفل حررها وامسح الباقي إذا كنت تريد فتح صفحة الويب من متصفح الجوال بواسطة التطبيق
         */
        //WebView webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("http://www.andrody.com/");

        // ربط وتعريف المتغير webview بواسطة الآي دي
        webview = (WebView) findViewById(R.id.webView);

        // تمكين جافا سكريبت في صفحة الويب
        webview.getSettings().setJavaScriptEnabled(true);

        // السماح بالتكبير وتصغير في الصفحة
        webview.getSettings().setBuiltInZoomControls(true);

        // تصغير صفحة الويب لتناسب شاشة الجوال
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);

        // فتح صفحة الويب المطلوبة .. اكتب رابط الصفحة التي تريد فتحها بالتطبيق بالاسفل
        webview.loadUrl("https://www.facebook.com");

        // عرض شريط المعالجة والتقدم لصفحة الويب
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });

        // الاتصال بكلاس InsideWebViewClient
        webview.setWebViewClient(new InsideWebViewClient());

    }

    private class InsideWebViewClient extends WebViewClient {
        @Override
        // تمكين وعرض الصفحة داخل التطبيق نفسه دون الخروج لمتصفح خارجي
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

    }}