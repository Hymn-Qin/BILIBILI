package projectedit.lanou.com.bilibili.OtherActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.Utility.view.NoScrollGridView;

public class LiveSortActivity extends AppCompatActivity implements View.OnClickListener {

    //           http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=b8d6bb7ea6f765334db76326d608baaa
    // 手机直播   11  sign=e448634cff18235a200a90920c6a9e26
    // 手游直播  12  sign=91bbbcc9537329e6c20334d86687488d
    // 萌宅推荐   8  sign=98978547a23ffd93e61d4fbc3faf205f
    // 绘画专区   9  sign=d06cdf4b582876fcba266a8c342dcbbe
    // 网络游戏   3  sign=410267097542e151c66861459dda84db
    // 单机联机   1  sign=20a57ca017312f1b36647bd2a9953391
    // 电子竞技   4  sign=7be5d5b743ed3e250ab5f424ec573ff3
    // 唱见舞见   10  sign=7b4dce4bacfd39302c807eda362c1a3f
    // 生活娱乐   6  sign=d50cb4b671b6546ec97237860f566ecd
    // 御宅文化   2  sign=b8d6bb7ea6f765334db76326d608baaa
    // 放映厅    7  sign=bf67c4ba12e9741188763783690c3b69

    LinearLayout paintChange, phoneChange, musicChange, phoneGameChange, oneMachineChange,
            gameOlChange, eSportChange, cultureChange, screeningChange, mengChange, leChaneg;

    String paintID = "9";
    String phoneID = "11";
    String musicID = "10";
    String phoneGameID = "12";
    String oneMachineID = "1";
    String gameOlID = "3";
    String eSportID = "4";
    String cultureID = "2";
    String screeningID = "7";
    String mengID = "8";
    String leID = "6";
    String paintS = "d06cdf4b582876fcba266a8c342dcbbe";
    String phoneS = "e448634cff18235a200a90920c6a9e26";
    String musicS = "7b4dce4bacfd39302c807eda362c1a3f";
    String phoneGameS = "91bbbcc9537329e6c20334d86687488d";
    String oneMachineS = "20a57ca017312f1b36647bd2a9953391";
    String gameOlS = "410267097542e151c66861459dda84db";
    String eSportS= "7be5d5b743ed3e250ab5f424ec573ff3";
    String cultureS = "b8d6bb7ea6f765334db76326d608baaa";
    String screeningS = "bf67c4ba12e9741188763783690c3b69";
    String mengS = "98978547a23ffd93e61d4fbc3faf205f";
    String leS = "d50cb4b671b6546ec97237860f566ecd";


    ImageView back;
    ImageView phone, phoneGame, meng, paint, gameol, machine, esport, music, le, culture, screening;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_sort);
        initView();
        initData();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.sort_back);
        paintChange = (LinearLayout) findViewById(R.id.paints);
        phoneChange = (LinearLayout) findViewById(R.id.phones);
        musicChange = (LinearLayout) findViewById(R.id.musics);
        phoneGameChange = (LinearLayout) findViewById(R.id.phone_games);
        oneMachineChange = (LinearLayout) findViewById(R.id.machines);
        gameOlChange = (LinearLayout) findViewById(R.id.gameols);
        eSportChange = (LinearLayout) findViewById(R.id.esports);
        cultureChange = (LinearLayout) findViewById(R.id.cultures);
        screeningChange = (LinearLayout) findViewById(R.id.screenings);
        mengChange = (LinearLayout) findViewById(R.id.mengs);
        leChaneg = (LinearLayout) findViewById(R.id.les);
        phone = (ImageView) findViewById(R.id.sort_phone_image);
        phoneGame = (ImageView) findViewById(R.id.sort_phonegame_image);
        meng = (ImageView) findViewById(R.id.sort_meng_image);
        paint = (ImageView) findViewById(R.id.sort_paint_image);
        gameol = (ImageView) findViewById(R.id.sort_gameol_image);
        machine = (ImageView) findViewById(R.id.sort_machine_image);
        esport = (ImageView) findViewById(R.id.sort_esport_image);
        music = (ImageView) findViewById(R.id.sort_music_image);
        le = (ImageView) findViewById(R.id.sort_le_image);
        culture = (ImageView) findViewById(R.id.sort_culture_image);
        screening = (ImageView) findViewById(R.id.sort_screen_image);
        BitmapDrawable bd = (BitmapDrawable)getResources().getDrawable(R.drawable.phone);
        bd.setAntiAlias(true);
        phone.setImageDrawable(bd);
        BitmapDrawable phg = (BitmapDrawable)getResources().getDrawable(R.drawable.phone_game);
        phg.setAntiAlias(true);
        phoneGame.setImageDrawable(phg);
        BitmapDrawable ch = (BitmapDrawable)getResources().getDrawable(R.drawable.ic_group_recommend_header);
        ch.setAntiAlias(true);
        meng.setImageDrawable(ch);
        BitmapDrawable pt = (BitmapDrawable)getResources().getDrawable(R.drawable.paint);
        pt.setAntiAlias(true);
        paint.setImageDrawable(pt);
        BitmapDrawable go = (BitmapDrawable)getResources().getDrawable(R.drawable.gameol);
        go.setAntiAlias(true);
        gameol.setImageDrawable(go);
        BitmapDrawable mc = (BitmapDrawable)getResources().getDrawable(R.drawable.machine);
        mc.setAntiAlias(true);
        machine.setImageDrawable(mc);
        BitmapDrawable es = (BitmapDrawable)getResources().getDrawable(R.drawable.esport);
        es.setAntiAlias(true);
        esport.setImageDrawable(es);
        BitmapDrawable mu = (BitmapDrawable)getResources().getDrawable(R.drawable.music);
        mu.setAntiAlias(true);
        music.setImageDrawable(mu);
        BitmapDrawable yl = (BitmapDrawable)getResources().getDrawable(R.drawable.search_result_ic_bangumi);
        yl.setAntiAlias(true);
        le.setImageDrawable(yl);
        BitmapDrawable cu = (BitmapDrawable)getResources().getDrawable(R.drawable.culture);
        cu.setAntiAlias(true);
        culture.setImageDrawable(cu);
        BitmapDrawable sc = (BitmapDrawable)getResources().getDrawable(R.drawable.screen);
        sc.setAntiAlias(true);
        screening.setImageDrawable(sc);
    }

    private void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        paintChange.setOnClickListener(this);
        phoneChange.setOnClickListener(this);
        musicChange.setOnClickListener(this);
        phoneGameChange.setOnClickListener(this);
        oneMachineChange.setOnClickListener(this);
        gameOlChange.setOnClickListener(this);
        eSportChange.setOnClickListener(this);
        cultureChange.setOnClickListener(this);
        screeningChange.setOnClickListener(this);
        mengChange.setOnClickListener(this);
        leChaneg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LiveSortActivity.this, LiveSortItemActivity.class);
        switch (v.getId()){
            case R.id.phones:
                intent.putExtra("id", phoneID);
                intent.putExtra("sign",phoneS);
                intent.putExtra("name","手机直播");
                break;
            case R.id.phone_games:
                intent.putExtra("id", phoneGameID);
                intent.putExtra("sign",phoneGameS);
                intent.putExtra("name","手游直播");
                break;
            case R.id.mengs:
                intent.putExtra("id", mengID);
                intent.putExtra("sign",mengS);
                intent.putExtra("name","萌宅推荐");
                break;
            case R.id.paints:
                intent.putExtra("id", paintID);
                intent.putExtra("sign",paintS);
                intent.putExtra("name","绘画专区");
                break;
            case R.id.gameols:
                intent.putExtra("id", gameOlID);
                intent.putExtra("sign",gameOlS);
                intent.putExtra("name","网络游戏");
                break;
            case R.id.machines:
                intent.putExtra("id", oneMachineID);
                intent.putExtra("sign",oneMachineS);
                intent.putExtra("name","单机联机");
                break;
            case R.id.esports:
                intent.putExtra("id", eSportID);
                intent.putExtra("sign",eSportS);
                intent.putExtra("name","电子竞技");
                break;
            case R.id.musics:
                intent.putExtra("id", musicID);
                intent.putExtra("sign",musicS);
                intent.putExtra("name","唱见舞见");
                break;
            case R.id.les:
                intent.putExtra("id", leID);
                intent.putExtra("sign",leS);
                intent.putExtra("name","生活娱乐");
                break;
            case R.id.cultures:
                intent.putExtra("id", cultureID);
                intent.putExtra("sign",cultureS);
                intent.putExtra("name","御宅文化");
                break;
            case R.id.screenings:
                intent.putExtra("id", screeningID);
                intent.putExtra("sign",screeningS);
                intent.putExtra("name","放映厅");
                break;

        }
        startActivity(intent);
    }
}
