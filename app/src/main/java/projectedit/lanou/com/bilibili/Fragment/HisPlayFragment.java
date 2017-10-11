package projectedit.lanou.com.bilibili.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.HisPalyDownAdapter;
import projectedit.lanou.com.bilibili.Adapter.HisPlayChinaAdapter;
import projectedit.lanou.com.bilibili.Adapter.HisPlayPreAdapter;
import projectedit.lanou.com.bilibili.Adapter.HisPlayUpAdapter;
import projectedit.lanou.com.bilibili.Beans.HisPlayDown;
import projectedit.lanou.com.bilibili.Beans.HisPlayUp;
import projectedit.lanou.com.bilibili.Beans.LiveBoomerangIn;
import projectedit.lanou.com.bilibili.OtherActivity.CarouselWebActivity;
import projectedit.lanou.com.bilibili.OtherActivity.HisPlayUpItemActivity;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.Utility.view.NetworkImageHolderView;
import projectedit.lanou.com.bilibili.Utility.view.NoScrollGridView;
import projectedit.lanou.com.bilibili.utils.HttpUtils;


/**
 * Created by lanouhn on 2016/10/18.
 */

public class HisPlayFragment extends Fragment implements View.OnClickListener, OnItemClickListener, AdapterView.OnItemLongClickListener, ViewPager.OnPageChangeListener{
    View view;
    ConvenientBanner convenientBanner;
    RelativeLayout zhuifanH, fangsongH, suoyinH;
    RelativeLayout lianzai, china, qiyue, choose;
    NoScrollGridView lianzaiHis, chinaHis, qiyueHis, chooseHis;
    String url1 = "http://bangumi.bilibili.com/api/app_index_page_v4_2?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1477530790000&sign=75d3a562e62b50b285e88b05d10b35d5";
    String url2 = "http://bangumi.bilibili.com/api/bangumi_recommend?appkey=1d8b6e7d45233436&build=427000&cursor=-1&mobi_app=android&pagesize=10&platform=android&ts=1477530790000&sign=7a6a6591ab298e7ab4c85d38c5e2dca4";

    HisPlayUp hisPlayUp;
    HisPlayDown hisPlayDown;
    Handler handler;
    List<HisPlayUp.ResultBean.AdBean.HeadBean> headBeanList;
    List<String> networkImage = new ArrayList<>();

    HisPlayUpAdapter upAdapter;
    HisPlayChinaAdapter chinaAdapter;
    HisPlayPreAdapter preAdapter;
    HisPalyDownAdapter downAdapter;
    List<HisPlayUp.ResultBean.SerializingBean> serializingXinList;
    List<HisPlayUp.ResultBean.ChinaBean> chinaBeanList;
    List<HisPlayUp.ResultBean.PreviousBean.ListBean> lists;
    List<HisPlayDown.ResultBean> resultBeanList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_his_play, container, false);
        initView();
        UrlPath();
        initData();
        return view;
    }


    private void initView() {
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.pager_hisPlay);

        zhuifanH = (RelativeLayout) view.findViewById(R.id.zhuifan);
        fangsongH = (RelativeLayout) view.findViewById(R.id.fangsong);
        suoyinH = (RelativeLayout) view.findViewById(R.id.suoyin);

        lianzai = (RelativeLayout) view.findViewById(R.id.lianzai);
        china = (RelativeLayout) view.findViewById(R.id.china);
        qiyue = (RelativeLayout) view.findViewById(R.id.qiyue);
        choose = (RelativeLayout) view.findViewById(R.id.choose);

        lianzaiHis = (NoScrollGridView) view.findViewById(R.id.xinfan_his_play);
        chinaHis = (NoScrollGridView) view.findViewById(R.id.china_his_play);
        qiyueHis = (NoScrollGridView) view.findViewById(R.id.qiyue_his_play);
        chooseHis = (NoScrollGridView) view.findViewById(R.id.choose_his_play);

        zhuifanH.setOnClickListener(this);
        fangsongH.setOnClickListener(this);
        suoyinH.setOnClickListener(this);

    }

    private void initData() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 300){
                    headBeanList = hisPlayUp.getResult().getAd().getHead();
                    for (HisPlayUp.ResultBean.AdBean.HeadBean headBean : headBeanList){
                        networkImage.add(networkImage.size(), headBean.getImg());
                    }
                    convenientBanner
                            //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                            .setPageIndicator(new int[]{R.drawable.ic_page_indicator,R.drawable.ic_page_indicator_focused})
                            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                            .setOnPageChangeListener(HisPlayFragment.this)
                            .setOnItemClickListener(HisPlayFragment.this)
                            .setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                                @Override
                                public NetworkImageHolderView createHolder() {
                                    return new NetworkImageHolderView();
                                }
                            },networkImage);

                    serializingXinList = hisPlayUp.getResult().getSerializing();
                    chinaBeanList = hisPlayUp.getResult().getChina();
                    lists = hisPlayUp.getResult().getPrevious().getList();

                    upAdapter = new HisPlayUpAdapter(getActivity(), serializingXinList);
                    lianzaiHis.setAdapter(upAdapter);

                    chinaAdapter = new HisPlayChinaAdapter(getActivity(), chinaBeanList);
                    chinaHis.setAdapter(chinaAdapter);

                    preAdapter = new HisPlayPreAdapter(getActivity(), lists);
                    qiyueHis.setAdapter(preAdapter);


                }
                if (msg.what == 400){
                    resultBeanList = hisPlayDown.getResult();
                    downAdapter = new HisPalyDownAdapter(getActivity(), resultBeanList);
                    chooseHis.setAdapter(downAdapter);

                }
                return false;
            }
        });
    }
    private void UrlPath() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(url1, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        hisPlayUp = gson.fromJson(result, new TypeToken<HisPlayUp>(){}.getType());
                        handler.sendEmptyMessage(300);

                    }
                });
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(url2, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        Gson gson = new Gson();
                        hisPlayDown = gson.fromJson(result, new TypeToken<HisPlayDown>(){}.getType());
                        handler.sendEmptyMessage(400);

                    }
                });
            }
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhuifan:
                Toast.makeText(getActivity(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fangsong:
                break;
            case R.id.suoyin:
                break;
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), HisPlayUpItemActivity.class);

        //http://bangumi.bilibili.com/api/season/recommend/5430.json?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1477621794000&sign=fc7cdeb834c8a5d9701e7e265a88b40d

        //http://bangumi.bilibili.com/api/season_v4?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&season_id=5430&ts=1477621794000&type=bangumi&sign=bbc786cbd616c71da1a8338d8197326a
        //http://api.bilibili.com/x/v2/reply?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&nohot=1&oid=6559760&platform=android&pn=1&ps=3&sort=2&type=1&sign=96633ffc37a624209d6dfe67e46c0b94
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
