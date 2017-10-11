package projectedit.lanou.com.bilibili.OtherActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.LiveSortItemAdapter;
import projectedit.lanou.com.bilibili.Adapter.LiveSortItemRecyclerAdapter;
import projectedit.lanou.com.bilibili.Beans.LiveChooseHeadler;
import projectedit.lanou.com.bilibili.Beans.LiveSortItem;
import projectedit.lanou.com.bilibili.Beans.LiveSortItemChange;
import projectedit.lanou.com.bilibili.Beans.SelectedBean;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.utils.HttpUtils;

public class LiveSortItemActivity extends AppCompatActivity implements LiveSortItemRecyclerAdapter.OnItemClickListener, View.OnClickListener, View.OnKeyListener{
    String id;
    String sign;
    String url1 = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=";
    String url2 = "&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=";

    String url;
    String name;
    LiveSortItem liveSortItem;

    Handler handler;
    boolean is;

    LiveSortItemAdapter adapter;
    TextView titleName;
    ImageView imageView, errorBg, caidan;
    GridView gridView;
    View view;
    PopupWindow pop;
    List<LiveSortItem.DataBean> dataBeanList;
    RecyclerView recyclerView;
    List<LiveSortItemChange> liveSortItemChangeList = new ArrayList<>();
    List<SelectedBean> selectedBeanList = new ArrayList<>();
    LiveSortItemRecyclerAdapter recyclerAdapter, recyclerAdaptercaidan;
    LinearLayoutManager manager_h;
    String re = "";
    String ne = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_sort_item);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        sign = intent.getStringExtra("sign");
        name = intent.getStringExtra("name");
        url = url1 + id + url2 + sign;
        initView();
        UrlPath();
        initData();
    }

    private void initView() {
        caidan = (ImageView) findViewById(R.id.caidan_item);
        errorBg = (ImageView) findViewById(R.id.error_bg);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        titleName = (TextView) findViewById(R.id.sort_item_name);
        gridView = (GridView) findViewById(R.id.sort_item_grid);
        imageView = (ImageView) findViewById(R.id.sort_back);
        titleName.setText(name);

        manager_h = new LinearLayoutManager(this);
        //设置线型布局的方向
        manager_h.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager_h);

    }

    private void initData() {
        caidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(caidan);
            }
        });


        switch (id){
            case "11":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=e448634cff18235a200a90920c6a9e26";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=11&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=a954a4a5724f2ba35250d8e4f5af2f67";
                LiveSortItemChange all11 = new LiveSortItemChange();
                all11.setName("全部");
                all11.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_" +
                        "id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "sign=e448634cff18235a200a90920c6a9e26");
                liveSortItemChangeList.add(0, all11);
//                SelectedBean s0 = new SelectedBean();
//                selectedBeanList.add(0,s0);
                LiveSortItemChange travel = new LiveSortItemChange();
                travel.setName("户外旅行");
                travel.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_" +
                        "id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E6%88%B7%E5%A4%96%E6%97%85%E8%A1%8C&" +
                        "sign=8f6ae04619740706b233bd7332351281");
                liveSortItemChangeList.add(1, travel);
//                SelectedBean s1 = new SelectedBean();
//                selectedBeanList.add(1,s1);


                LiveSortItemChange haiwai = new LiveSortItemChange();
                haiwai.setName("海外留学");
                haiwai.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_" +
                        "id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E6%B5%B7%E5%A4%96%E7%95%99%E5%AD%A6&" +
                        "sign=e020487063f4ef4f218fe8efc6d8a304");
                liveSortItemChangeList.add(2, haiwai);
//                SelectedBean s2 = new SelectedBean();
//                selectedBeanList.add(2,s2);
                LiveSortItemChange music = new LiveSortItemChange();
                music.setName("才艺表演");
                music.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_" +
                        "id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E6%89%8D%E8%89%BA%E8%A1%A8%E6%BC%94&" +
                        "sign=cc165e053014941dab4ea1cba27c9c22");
                liveSortItemChangeList.add(3, music);
//                SelectedBean s3 = new SelectedBean();
//                selectedBeanList.add(3,s3);
                LiveSortItemChange geren = new LiveSortItemChange();
                geren.setName("个人自拍");
                geren.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_" +
                        "id=11&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E4%B8%AA%E4%BA%BA%E8%87%AA%E6%8B%8D&" +
                        "sign=87ecf33da1f5916ebb0463b8f7fefa70");
                liveSortItemChangeList.add(4, geren);
//                SelectedBean s4 = new SelectedBean();
//                selectedBeanList.add(4,s4);

                break;
            case "12":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=91bbbcc9537329e6c20334d86687488d";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=1bbe36f5a6df394dba59094b71f671ef";
                LiveSortItemChange all12 = new LiveSortItemChange();
                all12.setName("全部");
                all12.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&sign=91bbbcc9537329e6c20334d86687488d");
                liveSortItemChangeList.add(0, all12);
                LiveSortItemChange yionyangshi = new LiveSortItemChange();
                yionyangshi.setName("阴阳师");
                yionyangshi.setUrl(" http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb85" +
                        "6c97ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E9%98%B4%E9%98%B3%E5%B8%88&" +
                        "sign=f8799ebbf76b66ab196beca0d1fa1783");
                liveSortItemChangeList.add(1, yionyangshi);
                LiveSortItemChange GO = new LiveSortItemChange();
                GO.setName("Fate/GO");
                GO.setUrl(" http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97cc" +
                        "b8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=Fate%2FGO&" +
                        "sign=950505c6fdf591c3be58af87def84c18\n");
                liveSortItemChangeList.add(2, GO);
                LiveSortItemChange meng = new LiveSortItemChange();
                meng.setName("梦100");
                meng.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&tag=%E6%A2%A6100&sign=8c2e6d875aed36970bfbea2f08b24f12");
                liveSortItemChangeList.add(3, meng);
                LiveSortItemChange girl = new LiveSortItemChange();
                girl.setName("少女前线");
                girl.setUrl(" http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E5%B0%91%E5%A5%B3%E5%89%8D%E7%BA%BF&" +
                        "sign=cc9f7c172fe6e49dcb53874833805727");
                liveSortItemChangeList.add(4, girl);
                LiveSortItemChange ICHU = new LiveSortItemChange();
                ICHU.setName("ICHU");
                ICHU.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=ICHU&" +
                        "sign=3294d7332fc0fdd895845918c86119b9");
                liveSortItemChangeList.add(5, ICHU);
                LiveSortItemChange cang = new LiveSortItemChange();
                cang.setName("苍之骑士团");
                cang.setUrl(" http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&" +
                        "tag=%E8%8B%8D%E4%B9%8B%E9%AA%91%E5%A3%AB%E5%9B%A2&" +
                        "sign=9e650f9db25dc6bae4a28e568723bb47");
                liveSortItemChangeList.add(6, cang);
                LiveSortItemChange xiaoyuan = new LiveSortItemChange();
                xiaoyuan.setName("魔法少女小圆");
                xiaoyuan.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=12&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&" +
                        "tag=%E9%AD%94%E6%B3%95%E5%B0%91%E5%A5%B3%E5%B0%8F%E5%9C%86&" +
                        "sign=b00f8eab3ea0355ec6600ac6463d1a34");
                liveSortItemChangeList.add(7, xiaoyuan);

                break;
            case "8":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=8&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=98978547a23ffd93e61d4fbc3faf205f";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=8&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=30c2d7d334d93472b21404e011c4e178";
                LiveSortItemChange all8 = new LiveSortItemChange();
                all8.setName("全部");
                all8.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856" +
                        "c97ccb8d2&appkey=1d8b6e7d45233436&area_id=8&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&" +
                        "sign=98978547a23ffd93e61d4fbc3faf205f");
                liveSortItemChangeList.add(0, all8);
                LiveSortItemChange liaotian = new LiveSortItemChange();
                liaotian.setName("聊天");
                liaotian.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=8&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E8%81%8A%E5%A4%A9&" +
                        "sign=045c8bc85b6c12d8a0cbf60a483c1fb6");
                liveSortItemChangeList.add(1, liaotian);
                LiveSortItemChange music11 = new LiveSortItemChange();
                music11.setName("音乐");
                music11.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=8&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E9%9F%B3%E4%B9%90&" +
                        "sign=c5dffb532d5ce20ee8e6182a377eba4b");
                liveSortItemChangeList.add(2, music11);
                break;
            case "9":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=d06cdf4b582876fcba266a8c342dcbbe";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=a420de32b3655695180714e2efc5e7f3";
                LiveSortItemChange all9 = new LiveSortItemChange();
                all9.setName("全部");
                all9.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&sign=d06cdf4b582876fcba266a8c342dcbbe");
                liveSortItemChangeList.add(0, all9);
                LiveSortItemChange huihua = new LiveSortItemChange();
                huihua.setName("绘画");
                huihua.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E7%BB%98%E7%94%BB&" +
                        "sign=bba74d0560a248b0d69ffbc1ec3f621a");
                liveSortItemChangeList.add(1, huihua);
                LiveSortItemChange dachu = new LiveSortItemChange();
                dachu.setName("大触");
                dachu.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E5%A4%A7%E8%A7%A6&" +
                        "sign=6f1b09b8463547dc1955463f1111ae43");
                liveSortItemChangeList.add(2, dachu);
                LiveSortItemChange shouhui = new LiveSortItemChange();
                shouhui.setName("手绘");
                shouhui.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E6%89%8B%E7%BB%98&" +
                        "sign=62eaf17ed417428f5437bc3ca34b8e70");
                liveSortItemChangeList.add(3, shouhui);
                LiveSortItemChange banhui = new LiveSortItemChange();
                banhui.setName("板绘");
                banhui.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E6%9D%BF%E7%BB%98&" +
                        "sign=3048dc394fd8004d0d4e6b8235d358c7");
                liveSortItemChangeList.add(4, banhui);
                LiveSortItemChange sumiao = new LiveSortItemChange();
                sumiao.setName("素描");
                sumiao.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E7%B4%A0%E6%8F%8F&" +
                        "sign=a1f7f0fd9290f78747510628b042d2f6");
                liveSortItemChangeList.add(5, sumiao);
                LiveSortItemChange gangbi = new LiveSortItemChange();
                gangbi.setName("钢笔画");
                gangbi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=9&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E9%92%A2%E7%AC%94%E7%94%BB&" +
                        "sign=1738b2bc6f0bbbb18d965ef08f9adf02");
                liveSortItemChangeList.add(6, gangbi);
                break;
            case "3":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=410267097542e151c66861459dda84db";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=77967d8d4f90e2ef80a8796b71574432";
                LiveSortItemChange quanbu3 = new LiveSortItemChange();
                quanbu3.setName("全部");
                quanbu3.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&mobi_app=android&page=1&" +
                        "platform=android&sort=hottest&sign=410267097542e151c66861459dda84db");
                liveSortItemChangeList.add(0, quanbu3);
                LiveSortItemChange shouwang = new LiveSortItemChange();
                shouwang.setName("守望先锋");
                shouwang.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&mobi_app=android&page=1&" +
                        "platform=android&sort=hottest&tag=%E5%AE%88%E6%9C%9B%E5%85%88%E9%94%8B&" +
                        "sign=0049f2b2680167465f6d86c714074f79");
                liveSortItemChangeList.add(1, shouwang);
                LiveSortItemChange lushi = new LiveSortItemChange();
                lushi.setName("炉石传说");
                lushi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97" +
                        "ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&mobi_app=android&" +
                        "page=1&platform=android&sort=hottest&tag=%E7%82%89%E7%9F%B3%E4%BC%A0%E8%AF%B4&" +
                        "sign=36d1fa3426496612c1a1aec15c2e3e11");
                liveSortItemChangeList.add(2, lushi);
                LiveSortItemChange sanguosha = new LiveSortItemChange();
                sanguosha.setName("三国杀");
                sanguosha.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=" +
                        "ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&" +
                        "mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E4%B8%89%E5%9B%BD%E6%9D%80&sign=107946517635ff0be2d7dc678b282900");
                liveSortItemChangeList.add(3, sanguosha);
                LiveSortItemChange tanke = new LiveSortItemChange();
                tanke.setName("坦克世界");
                tanke.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_hwid=" +
                        "ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=427000&" +
                        "mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E5%9D%A6%E5%85%8B%E4%B8%96%E7%95%8C&" +
                        "sign=72ab421f684ed53350de9f8833b8e82d");
                liveSortItemChangeList.add(4, tanke);
                LiveSortItemChange jianwang = new LiveSortItemChange();
                jianwang.setName("剑网3");
                jianwang.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_" +
                        "hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id" +
                        "=3&build=427000&mobi_app=android&page=1&platform=android&sort=" +
                        "hottest&tag=%E5%89%91%E7%BD%913&sign=c38f6b480accdba78ec3cabb84a46b72");
                liveSortItemChangeList.add(5, jianwang);
                LiveSortItemChange zhanjain = new LiveSortItemChange();
                zhanjain.setName("战舰世界");
                zhanjain.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&build=" +
                        "427000&mobi_app=android&page=1&platform=android&sort=hottest&" +
                        "tag=%E6%88%98%E8%88%B0%E4%B8%96%E7%95%8C&" +
                        "sign=a9c299fc48263d8298eb5efea000d721");
                liveSortItemChangeList.add(6, zhanjain);
                LiveSortItemChange zuihzong = new LiveSortItemChange();
                zuihzong.setName("最终幻想14");
                zuihzong.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E6%9C%80%E7%BB%88%E5%B9%BB%E6%83%B314&" +
                        "sign=a854cabb3cca614678fd1799ad861d30");
                liveSortItemChangeList.add(7, zuihzong);
                LiveSortItemChange DNF = new LiveSortItemChange();
                DNF.setName("DNF");
                DNF.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=3&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=DNF&sign=7369df088007b84df5dfab454bccb51c");
                liveSortItemChangeList.add(8, DNF);
                break;
            case "1":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=20a57ca017312f1b36647bd2a9953391";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=217d5bb1091bd025cbdc6b7b0fe4f3b6";
                LiveSortItemChange quanbu1 = new LiveSortItemChange();
                quanbu1.setName("全部");
                quanbu1.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=20a57ca017312f1b36647bd2a9953391");
                liveSortItemChangeList.add(0, quanbu1);
                LiveSortItemChange quanjing = new LiveSortItemChange();
                quanjing.setName("全境封锁");
                quanjing.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%85%A8%E5%A2%83%E5%B0%81%E9%94%81&" +
                        "sign=28611af696f6be22c46f0edb8ec3b401");
                liveSortItemChangeList.add(1, quanjing);
                LiveSortItemChange min = new LiveSortItemChange();
                min.setName("minecraft");
                min.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=minecraft&" +
                        "sign=13ee42e3f9c548d64ceccb57e05fb587");
                liveSortItemChangeList.add(2, min);
                LiveSortItemChange yisa = new LiveSortItemChange();
                yisa.setName("以撒");
                yisa.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E4%BB%A5%E6%92%92&" +
                        "sign=5e95fbe15ea9c1e576b6874dc5891d0a");
                liveSortItemChangeList.add(3, yisa);
                LiveSortItemChange dongfang = new LiveSortItemChange();
                dongfang.setName("东方");
                dongfang.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E4%B8%9C%E6%96%B9&" +
                        "sign=5149d165cb76ee8f3151249f5ee932e9");
                liveSortItemChangeList.add(4, dongfang);
                LiveSortItemChange H1Z1 = new LiveSortItemChange();
                H1Z1.setName("H1Z1");
                H1Z1.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=H1Z1&sign=a79bfd60cdc1f25c30e600d52632ec17");
                liveSortItemChangeList.add(5, H1Z1);
                LiveSortItemChange L4D2 = new LiveSortItemChange();
                L4D2.setName("L4D2");
                L4D2.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=1&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=L4D2&sign=bb53d606c0486daaa5cedc1dc48430f1");
                liveSortItemChangeList.add(6, L4D2);
                break;
            case "4":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=7be5d5b743ed3e250ab5f424ec573ff3";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=ad4614a440cfe25f3c53c9a663955870";
                LiveSortItemChange quanbu4 = new LiveSortItemChange();
                quanbu4.setName("全部");
                quanbu4.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=7be5d5b743ed3e250ab5f424ec573ff3");
                liveSortItemChangeList.add(0, quanbu4);
                LiveSortItemChange LOL = new LiveSortItemChange();
                LOL.setName("英雄联盟");
                LOL.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E8%8B%B1%E9%9B%84%E8%81%94%E7%9B%9F&" +
                        "sign=7e20d23d755252c37b248f5c5073d16d");
                liveSortItemChangeList.add(1, LOL);
                LiveSortItemChange DOTA2 = new LiveSortItemChange();
                DOTA2.setName("DOTA2");
                DOTA2.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=DOTA2&sign=98e99016214f9e0b635db8ae789a33fe");
                liveSortItemChangeList.add(2, DOTA2);
                LiveSortItemChange xingji = new LiveSortItemChange();
                xingji.setName("星际争霸2");
                xingji.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E6%98%9F%E9%99%85%E4%BA%89%E9%9C%B82&" +
                        "sign=680a74a04aab9ea3e5a82ffc2b963c1f");
                liveSortItemChangeList.add(3, xingji);
                LiveSortItemChange CSGO = new LiveSortItemChange();
                CSGO.setName("CSGO");
                CSGO.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=CSGO&sign=cb919a9b75dc877c5283b6e640dc3630");
                liveSortItemChangeList.add(4, CSGO);
                LiveSortItemChange fengbao = new LiveSortItemChange();
                fengbao.setName("风暴英雄");
                fengbao.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E9%A3%8E%E6%9A%B4%E8%8B%B1%E9%9B%84&" +
                        "sign=32baf6fb9795b644dd2ce93424fa1b3a");
                liveSortItemChangeList.add(5, fengbao);
                LiveSortItemChange CF = new LiveSortItemChange();
                CF.setName("CF");
                CF.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=CF&sign=944f783654e01094ce6f4904cd3feec1");
                liveSortItemChangeList.add(6, CF);
                LiveSortItemChange shegn = new LiveSortItemChange();
                shegn.setName("神之浩劫");
                shegn.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=4&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%A5%9E%E4%B9%8B%E6%B5%A9%E5%8A%AB&" +
                        "sign=bf01c152c7f662225e6e1680655e2f8d");
                liveSortItemChangeList.add(7, shegn);
                break;
            case "10":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=7b4dce4bacfd39302c807eda362c1a3f";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=2b88f8e1a589038fc8ec244a865c0a1b";
                LiveSortItemChange quanbu10 = new LiveSortItemChange();
                quanbu10.setName("全部");
                quanbu10.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=7b4dce4bacfd39302c807eda362c1a3f ");
                liveSortItemChangeList.add(0, quanbu10);
                LiveSortItemChange zhaiwu = new LiveSortItemChange();
                zhaiwu.setName("宅舞");
                zhaiwu.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%AE%85%E8%88%9E&" +
                        "sign=ca0a4de710f32f748e1050543773a7e3");
                liveSortItemChangeList.add(1, zhaiwu);
                LiveSortItemChange changge = new LiveSortItemChange();
                changge.setName("唱歌");
                changge.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%94%B1%E6%AD%8C&" +
                        "sign=3eb825ef7b9b10a6f78357c1d12febd0");
                liveSortItemChangeList.add(2, changge);
                LiveSortItemChange yueqi = new LiveSortItemChange();
                yueqi.setName("乐器");
                yueqi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=10&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E4%B9%90%E5%99%A8&" +
                        "sign=7beb20e38931c010d906c578d00b39a4");
                liveSortItemChangeList.add(3, yueqi);
                break;
            case "6":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=d50cb4b671b6546ec97237860f566ecd";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=5ef8c7b2a36d4ac58fd8a84d8bcf7416";
                LiveSortItemChange quanbu6 = new LiveSortItemChange();
                quanbu6.setName("全部");
                quanbu6.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=d50cb4b671b6546ec97237860f566ecd");
                liveSortItemChangeList.add(0, quanbu6);
                LiveSortItemChange majiang = new LiveSortItemChange();
                majiang.setName("麻将");
                majiang.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E9%BA%BB%E5%B0%86&" +
                        "sign=f80279c209c72a6043e7ea635a8e1e6a");
                liveSortItemChangeList.add(1, majiang);
                LiveSortItemChange chuyi = new LiveSortItemChange();
                chuyi.setName("厨艺");
                chuyi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%8E%A8%E8%89%BA&" +
                        "sign=82b74509bf8660e77c392251202740c5");
                liveSortItemChangeList.add(2, chuyi);
                LiveSortItemChange zixun = new LiveSortItemChange();
                zixun.setName("咨询");
                zixun.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%92%A8%E8%AF%A2&" +
                        "sign=e9fa89278bb80f68bc24af3061b6769f");
                liveSortItemChangeList.add(3, zixun);
                LiveSortItemChange zongyi = new LiveSortItemChange();
                zongyi.setName("综艺");
                zongyi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%BB%BC%E8%89%BA&" +
                        "sign=86150ab804a453994a1d75d1832b8915");
                liveSortItemChangeList.add(4, zongyi);
                LiveSortItemChange jishi = new LiveSortItemChange();
                jishi.setName("纪实");
                jishi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%BA%AA%E5%AE%9E&" +
                        "sign=ed5c21a7fb07042b79eb9c9c39910a15");
                liveSortItemChangeList.add(5, jishi);
                LiveSortItemChange chongwu = new LiveSortItemChange();
                chongwu.setName("宠物");
                chongwu.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=6&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%AE%A0%E7%89%A9&" +
                        "sign=b08a4456455c6d319e7d093c832cc779");
                liveSortItemChangeList.add(6, chongwu);
                break;
            case "2":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=b8d6bb7ea6f765334db76326d608baaa";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=99a16b049a36455c83e5a4e6c814e5b2";
                LiveSortItemChange quanbu2 = new LiveSortItemChange();
                quanbu2.setName("全部");
                quanbu2.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=b8d6bb7ea6f765334db76326d608baaa");
                liveSortItemChangeList.add(0, quanbu2);
                LiveSortItemChange moxing = new LiveSortItemChange();
                moxing.setName("模型制作");
                moxing.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E6%A8%A1%E5%9E%8B%E5%88%B6%E4%BD%9C&" +
                        "sign=df13b4fbd0290ac89eeb32546ed90f3d");
                liveSortItemChangeList.add(1, moxing);
                LiveSortItemChange shouban = new LiveSortItemChange();
                shouban.setName("手办");
                shouban.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E6%89%8B%E5%8A%9E&" +
                        "sign=b55b44e24f834a9013f1ef2e01c48ec8");
                liveSortItemChangeList.add(2, shouban);
                LiveSortItemChange shengyou = new LiveSortItemChange();
                shengyou.setName("声优");
                shengyou.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E5%A3%B0%E4%BC%98&" +
                        "sign=903adf9b46058e0437bc4b6d555d6524");
                liveSortItemChangeList.add(3, shengyou);
                LiveSortItemChange cos = new LiveSortItemChange();
                cos.setName("cosplay");
                cos.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&" +
                        "area_id=2&build=427000&mobi_app=android&page=1&" +
                        "platform=android&sort=hottest&tag=cosplay&" +
                        "sign=6b26019ed18d4f9d22384297bd360a37");
                liveSortItemChangeList.add(4, cos);
                LiveSortItemChange ASMR = new LiveSortItemChange();
                ASMR.setName("ASMR");
                ASMR.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&_" +
                        "hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=2&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=ASMR&sign=f5d511112825e50ec50d1cf585732ade");
                liveSortItemChangeList.add(5, ASMR);
                break;
            case "7":
                re = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=bf67c4ba12e9741188763783690c3b69";
                ne = "http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&build=427000&mobi_app=android&page=1&platform=android&sort=latest&sign=c3b8b1c82ad23abbc8cb580229312e2b";
                LiveSortItemChange quanbu7 = new LiveSortItemChange();
                quanbu7.setName("全部");
                quanbu7.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&sign=bf67c4ba12e9741188763783690c3b69");
                liveSortItemChangeList.add(0, quanbu7);
                LiveSortItemChange dian = new LiveSortItemChange();
                dian.setName("电影");
                dian.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%94%B5%E5%BD%B1&" +
                        "sign=23359c64a8b5abf602603b314643d277");
                liveSortItemChangeList.add(1, dian);
                LiveSortItemChange dianshi = new LiveSortItemChange();
                dianshi.setName("电视");
                dianshi.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%94%B5%E8%A7%86&" +
                        "sign=abd11bb3f483781e1f553dc8367ce651");
                liveSortItemChangeList.add(2, dianshi);
                LiveSortItemChange diange = new LiveSortItemChange();
                diange.setName("点歌台");
                diange.setUrl("http://live.bilibili.com/mobile/rooms?_device=android&" +
                        "_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=7&" +
                        "build=427000&mobi_app=android&page=1&platform=android&" +
                        "sort=hottest&tag=%E7%82%B9%E6%AD%8C%E5%8F%B0&" +
                        "sign=4f1b0e34fbbb7292969ec909b3c06736");
                liveSortItemChangeList.add(3, diange);

                break;

        }


        for (int i = 0; i < liveSortItemChangeList.size(); i++) {
            SelectedBean s = new SelectedBean();
            if (i == 0){
                s.setIsSelected(1);
            }
            selectedBeanList.add(i,s);
        }

        recyclerAdapter = new LiveSortItemRecyclerAdapter(this, liveSortItemChangeList, selectedBeanList);
        recyclerAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(recyclerAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){
                    dataBeanList = liveSortItem.getData();

                    if (dataBeanList.size() != 0 && dataBeanList != null){
                        errorBg.setVisibility(View.GONE);
                        adapter = new LiveSortItemAdapter(getApplicationContext(), dataBeanList);
                        gridView.setAdapter(adapter);
                    }else {
                        errorBg.setVisibility(View.VISIBLE);
                    }
                }

                if (msg.what == 300){
                    dataBeanList = liveSortItem.getData();
                    if ( dataBeanList != null && dataBeanList.size() !=0){
                        errorBg.setVisibility(View.GONE);
                        adapter.setChangeAdapter(dataBeanList);
                    }else {
                        errorBg.setVisibility(View.VISIBLE);
                        adapter.setChangeAdapter(dataBeanList);
                    }

                }
                return false;
            }
        });

    }

    public void UrlPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(url, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        liveSortItem = gson.fromJson(result, new TypeToken<LiveSortItem>(){}.getType());

                        handler.sendEmptyMessage(200);
                    }
                });
            }
        }).start();
    }

    public void UrlPathChange(final String urls){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(urls, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        liveSortItem = gson.fromJson(result, new TypeToken<LiveSortItem>(){}.getType());
                        handler.sendEmptyMessage(300);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onItemClickListener(int position) {

        UrlPathChange(liveSortItemChangeList.get(position).getUrl());
        smoothMoveToPosition(position);

    }
    private void smoothMoveToPosition(int position) {
        int firstPosition = manager_h.findFirstVisibleItemPosition();
        int lastPosition = manager_h.findLastVisibleItemPosition();
        if(position <= lastPosition && position >= firstPosition){
            int left = recyclerView.getChildAt(position - firstPosition).getLeft();
            recyclerView.smoothScrollBy(left, 0);
        } else if (position < firstPosition) {
            recyclerView.scrollToPosition(0);
        } else {
            recyclerView.scrollToPosition(liveSortItemChangeList.size() - 1);
        }

    }



    private void showPopUp(View v) {

        LayoutInflater inflater = LayoutInflater.from(this);
        view = inflater.inflate(R.layout.sort_item_menu_up_window, null);
        ImageView diss = (ImageView) view.findViewById(R.id.diss);
        final TextView textViewN = (TextView) view.findViewById(R.id.new_02);
        final TextView textViewR = (TextView) view.findViewById(R.id.re_02);
        final CardView cardViewN = (CardView) view.findViewById(R.id.new_01);
        final CardView cardViewR = (CardView) view.findViewById(R.id.re_01);
        textViewN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewN.setVisibility(View.VISIBLE);
                cardViewR.setVisibility(View.GONE);
                UrlPathChange(ne);
            }
        });
        textViewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewR.setVisibility(View.VISIBLE);
                cardViewN.setVisibility(View.GONE);
                UrlPathChange(re);
            }
        });
        diss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.caidan_recycler);

        StaggeredGridLayoutManager staggeredGridLayoutManager_v = new
                StaggeredGridLayoutManager(
                2, //每行显示的个数
                StaggeredGridLayoutManager.HORIZONTAL);//方向

        recyclerView1.setLayoutManager(staggeredGridLayoutManager_v);

//        manager_h = new LinearLayoutManager(this);
//        //设置线型布局的方向
//        manager_h.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView1.setLayoutManager(manager_h);
        recyclerAdaptercaidan = new LiveSortItemRecyclerAdapter(this, liveSortItemChangeList, selectedBeanList);
        recyclerView1.setAdapter(recyclerAdaptercaidan);

        recyclerAdaptercaidan.setOnItemClickListener(new LiveSortItemRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {

                pop.dismiss();

                recyclerAdapter.notifyDataSetChanged();
                UrlPathChange(liveSortItemChangeList.get(position).getUrl());
                smoothMoveToPosition(position);
            }
        });

        view.setFocusableInTouchMode(true);
        view.setOnKeyListener(this);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        pop.setBackgroundDrawable(dw);


//        pop.setBackgroundDrawable(new BitmapDrawable());

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        pop.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - v.getHeight()/ 4);

        final WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = 0.7f;
        getWindow().setAttributes(layoutParams);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams layoutParams1 = getWindow().getAttributes();
                layoutParams1.alpha = 1f;
                getWindow().setAttributes(layoutParams1);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }


}
