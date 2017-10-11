package projectedit.lanou.com.bilibili.OtherActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import projectedit.lanou.com.bilibili.R;

public class HisPlayUpItemActivity extends AppCompatActivity {



    // 推荐  http://bangumi.bilibili.com/api/season/recommend/5430.json?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1477621794000

    // 正文 http://bangumi.bilibili.com/api/season_v4?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&season_id=5430&ts=1477621794000&type=bangumi&sign=bbc786cbd616c71da1a8338d8197326a
    // 评论 http://api.bilibili.com/x/v2/reply?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&nohot=1&oid=6559760&platform=android&pn=1&ps=3&sort=2&type=1


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his_play);
    }
}
