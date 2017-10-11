package projectedit.lanou.com.bilibili.OtherActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.superplayer.library.SuperPlayer;

import java.util.ArrayList;
import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.StartTabAdapter;
import projectedit.lanou.com.bilibili.Beans.LiveItemPlay;
import projectedit.lanou.com.bilibili.Fragment.FocusOnFragment;
import projectedit.lanou.com.bilibili.Fragment.FoundFragment;
import projectedit.lanou.com.bilibili.Fragment.HisPlayFragment;
import projectedit.lanou.com.bilibili.Fragment.LiveFragment;
import projectedit.lanou.com.bilibili.Fragment.LivePlayItemDanmaku;
import projectedit.lanou.com.bilibili.Fragment.LivePlayItemRed;
import projectedit.lanou.com.bilibili.Fragment.LivePlayItemSeven;
import projectedit.lanou.com.bilibili.Fragment.PartitionFragment;
import projectedit.lanou.com.bilibili.Fragment.RecommendedFragment;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.utils.HttpUtils;

public class LIvePlayItemActivity extends AppCompatActivity implements View.OnClickListener, SuperPlayer.OnNetChangeListener{

    private SuperPlayer player;
    private boolean isLive ;
    private String id;
    private String url;
    private LiveItemPlay liveItemPlay;
    ImageView start;
    String urlMin;
    Handler handler;
    String title;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> titleList;
    List<Fragment> fragmentList;
    StartTabAdapter adapter;
    int YY;
    RelativeLayout Rl, RP, ALL;
    int h;
    int screenWidth ;
    int screenHight;

    TextView roomName, author, titleName, numOn;
    ImageView back, menu, playerSt, playerStBG, authorPh, gift, send, endPlay ;
    EditText editText;
    LinearLayout endL, loadPlay;
    String danmu;
    String url1 = "http://live.bilibili.com/AppRoom/index?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&buld=427000&jumpFrom=24000&mobi_app=android&platform=android&room_id=";
    //http://live.bilibili.com/AppRoom/index?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&buld=427000&jumpFrom=24000&mobi_app=android&platform=android&room_id=5279
    //  评论区发言人前面的图片成就http://live.bilibili.com/appUser/getTitle?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xhdpi&sign=5c740758766395e1467c9c900e025f05

    //  弹幕http://live.bilibili.com/AppRoom/msg?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=5170&sign=6ff6e1bd8970d5bf105cae5000a7ba43

    //礼物  http://live.bilibili.com/AppIndex/getAllItem?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xhdpi&sign=5c740758766395e1467c9c900e025f05

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullscreen(true);
        setContentView(R.layout.activity_live_play_item);



        Intent intent = getIntent();
        url = intent.getStringExtra("playurl");
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        urlMin = url1 + id;

        Log.d("LIvePlayItemActivity", urlMin);
        initView();
        TAB();

        initPlayer();
        UrlPath();
        initData();


    }



    private void initView() {
        player = (SuperPlayer) findViewById(R.id.super_player);
        roomName = (TextView) findViewById(R.id.room_name);
        author = (TextView) findViewById(R.id.author_name);
        titleName = (TextView) findViewById(R.id.title_play);
        numOn = (TextView) findViewById(R.id.num_onlone);

        back = (ImageView) findViewById(R.id.back_play);
        menu = (ImageView) findViewById(R.id.menu_play);



        authorPh = (ImageView) findViewById(R.id.author_ph);

        gift = (ImageView) findViewById(R.id.gifts);
        send = (ImageView) findViewById(R.id.send_danmu);
        endL = (LinearLayout) findViewById(R.id.end_play);
        loadPlay = (LinearLayout) findViewById(R.id.load_play);
        tabLayout = (TabLayout) findViewById(R.id.tab_play);
        viewPager = (ViewPager) findViewById(R.id.pager_play);
        Rl = (RelativeLayout) findViewById(R.id.pinglun);
        RP = (RelativeLayout) findViewById(R.id.player_messager);
        ALL = (RelativeLayout) findViewById(R.id.allView);
        editText = (EditText) findViewById(R.id.play_danmu);

        h = player.getHeight();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHight = displayMetrics.heightPixels;

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danmu = editText.getText().toString();

            }
        });

    }

    public void TAB(){


            titleList = new ArrayList<>();
            titleList.add("互动");
            titleList.add("红叶祭");
            titleList.add("七日榜");
            titleList.add("粉丝榜");

            fragmentList = new ArrayList<>();
            fragmentList.add(new LivePlayItemDanmaku(id));
            fragmentList.add(new LivePlayItemRed(id));
            fragmentList.add(new LivePlayItemSeven(id));
            fragmentList.add(new LivePlayItemSeven(id));

            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(3)));
            adapter = new StartTabAdapter(this.getSupportFragmentManager(), titleList, fragmentList);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setSelectedTabIndicatorHeight(3);




    }

    private void initData() {



        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){
                    titleName.setText(liveItemPlay.getData().getTitle());
                    author.setText(liveItemPlay.getData().getUname());
                    numOn.setText(liveItemPlay.getData().getOnline() + "");
                    ImageLoader.getInstance().displayImage
                            (liveItemPlay.getData().getM_face(),authorPh);

                }
                return false;
            }
        });

    }

    private void initPlayer() {

        player.setLive(false);
        player.setNetChangeListener(true)
                .setOnNetChangeListener(this)
                .onPrepared(new SuperPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        /**
                         * 监听视频是否已经准备完成开始播放。（可以在这里处理视频封面的显示跟隐藏）
                         */
                        loadPlay.setVisibility(View.GONE);
                    }
                })
                .onComplete(new Runnable() {
                    @Override
                    public void run() {
                        /**
                         * 监听视频是否已经播放完成了。（可以在这里处理视频播放完成进行的操作）
                         */
                        isLive = false;

                    }
                })
                .onInfo(new SuperPlayer.OnInfoListener() {
                    @Override
                    public void onInfo(int what, int extra) {
                        /**
                         * 监听视频的相关信息。
                         */
                    }
                })
                .onError(new SuperPlayer.OnErrorListener() {
                    @Override
                    public void onError(int what, int extra) {
                        /**
                         * 监听视频播放失败的回调
                         */
                    }
                })
                .setTitle(title + " 的直播间")
                .play(url);
        player.setScaleType(SuperPlayer.SCALETYPE_FITXY);






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onWifi() {

    }

    @Override
    public void onMobile() {

    }

    @Override
    public void onDisConnect() {

    }

    @Override
    public void onNoAvailable() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null){
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null){
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null){
            player.onDestroy();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);


            if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {//横屏
                fullscreen(false);
                Rl.setVisibility(View.GONE);

            } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {//竖屏
                fullscreen(true);
                Rl.setVisibility(View.VISIBLE);



            }
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }


    public void UrlPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urlMin, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        liveItemPlay = gson.fromJson(result, new TypeToken<LiveItemPlay>(){}.getType());
                        handler.sendEmptyMessage(200);
                    }
                });
            }
        }).start();
    }

    private void fullscreen(boolean enable) {
        if (enable) { //显示状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else { //隐藏状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(lp);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }





}
