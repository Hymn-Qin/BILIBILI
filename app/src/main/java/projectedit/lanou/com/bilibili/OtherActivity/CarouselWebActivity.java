package projectedit.lanou.com.bilibili.OtherActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import projectedit.lanou.com.bilibili.R;

public class CarouselWebActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    WebView webView;
    String url;
    String title;
    TextView textView;
    ImageView imageView, menu;
    ProgressBar bar;
    boolean isOut = true;
    boolean isIn = false;
    View view;
    PopupWindow pop;
    TextView l;
    CardView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_web);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        initView();
        initData();
    }

    private void initView() {
        l = (TextView) findViewById(R.id.main);
        menu = (ImageView) findViewById(R.id.web_menu);
        bar = (ProgressBar) findViewById(R.id.myProgressBar);
        imageView = (ImageView) findViewById(R.id.web_back);
        textView = (TextView) findViewById(R.id.web_name);
        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl(url);
        textView.setText(title);
//

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(menu);
            }
        });
    }
    private void showPopUp(View v) {

        LayoutInflater inflater = LayoutInflater.from(this);
        view = inflater.inflate(R.layout.web_menu_up_window, null);
        c = (CardView) view.findViewById(R.id.car_menu);
        Button fenxiang = (Button) view.findViewById(R.id.fenxiang);
        Button liulanqi = (Button) view.findViewById(R.id.liulanqi);
        Button fuzhi = (Button) view.findViewById(R.id.fuzhi);
        fenxiang.setOnClickListener(this);
        liulanqi.setOnClickListener(this);
        fuzhi.setOnClickListener(this);
        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(this);
        pop = new PopupWindow(view, 360,
                350, true);
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new BitmapDrawable());

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        pop.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - v.getHeight() / 2);
    }

    private void showPopDown(View v) {

        LayoutInflater inflater = LayoutInflater.from(this);
        view = inflater.inflate(R.layout.web_menu_down_window, null);
        Button fenxiangD = (Button) view.findViewById(R.id.fenxiang_down);
        Button liulanqiD = (Button) view.findViewById(R.id.liulanqi_down);
        Button fuzhiD = (Button) view.findViewById(R.id.fuzhi_down);
        fenxiangD.setOnClickListener(this);
        liulanqiD.setOnClickListener(this);
        fuzhiD.setOnClickListener(this);
        c = (CardView) view.findViewById(R.id.car_menu);

        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(this);
        pop = new PopupWindow(view, 600, LayoutParams.WRAP_CONTENT, true);
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new BitmapDrawable());

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        pop.showAtLocation(v, Gravity.NO_GRAVITY, location[0] - (pop.getWidth() - v.getWidth()) / 2,
                location[1] - pop.getHeight());
        pop.setAnimationStyle(R.style.MenuAnimationFade);
    }


    private void initData() {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.GONE);
                } else {

                        bar.setVisibility(View.VISIBLE);

                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);

            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                textView.setText("找不到网页");

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fenxiang:
                Toast.makeText(this, "点击1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.liulanqi:
                Toast.makeText(this, "点击2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuzhi:
                Toast.makeText(this, "点击3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fenxiang_down:
                Toast.makeText(this, "点击4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.liulanqi_down:
                Toast.makeText(this, "点击5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuzhi_down:
                Toast.makeText(this, "点击6", Toast.LENGTH_SHORT).show();
                break;
        }
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:

                    showPopDown(l);

                break;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}
