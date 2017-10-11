package projectedit.lanou.com.bilibili.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.LiveBoomAdapter;
import projectedit.lanou.com.bilibili.Adapter.LiveChooseAdapter;
import projectedit.lanou.com.bilibili.Beans.LiveBoomerangIn;
import projectedit.lanou.com.bilibili.Beans.LiveChooseHeadler;
import projectedit.lanou.com.bilibili.OtherActivity.CarouselWebActivity;
import projectedit.lanou.com.bilibili.OtherActivity.ChannelActivity;
import projectedit.lanou.com.bilibili.OtherActivity.LIvePlayItemActivity;
import projectedit.lanou.com.bilibili.OtherActivity.LiveSortActivity;
import projectedit.lanou.com.bilibili.OtherActivity.LiveSortItemActivity;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.Utility.view.NetworkImageHolderView;
import projectedit.lanou.com.bilibili.Utility.view.NoScrollGridView;
import projectedit.lanou.com.bilibili.utils.HttpUtils;


/**
 * Created by lanouhn on 2016/10/18.
 */

public class LiveFragment extends Fragment implements View.OnClickListener, OnItemClickListener , AdapterView.OnItemLongClickListener, ViewPager.OnPageChangeListener{
    View view;
    private ConvenientBanner convenientBanner;
    private List<String> networkImage = new ArrayList<>();
    RelativeLayout chooseIn, paintIn, phoneIn, musicIn, phoneGameIn, oneMachineIn,
            gameOlIn, eSportIn, cultureIn, screeningIn;
    RelativeLayout chooseLoad, paintLoad, phoneLoad, musicLoad, phoneGameLoad, oneMachineLoad,
    gameOlLoad, eSportLoad, cultureLoad, screeningLoad;
    LinearLayout chooseChange, paintChange, phoneChange, musicChange, phoneGameChange, oneMachineChange,
            gameOlChange, eSportChange, cultureChange, screeningChange;
    LinearLayout focus, center, search, sort;


    NoScrollGridView chooseView, chooseViewOther, paintView, phoneView, musicView, phoneGameView, oneMachineView,
    gameOlView, eSportView, cultureView, screeningView;


    Button chooseLoadB, paintLoadB, phoneLoadB, musicLoadB, phoneGameLoadB, oneMachineLoadB,
            gameOlLoadB, eSportLoadB, cultureLoadB, screeningLoadB;

    LiveBoomerangIn.DataBean.PartitionsBean paint, phone, music, phoneGame, oneMachine,
            gameOl, eSport, culture, screening;

    LiveChooseAdapter chooseAdapter, chooseAdapterOther;

    List<LiveBoomerangIn.DataBean.BannerBean> bannerBeanList;



    LiveBoomAdapter paintAdapter, phoneAdapter, musicAdapter, phoneGameAdapter, oneMachineAdapter,
            gameOlAdapter, eSportAdapter, cultureAdapter, screeningAdapter;

    String url1 = "http://live.bilibili.com/AppNewIndex/recommend?_device=android&_hwid=" +
            "ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=" +
            "android&platform=android&scale=xhdpi&sign=5c740758766395e1467c9c900e025f05";
    String url2 = "http://live.bilibili.com/AppNewIndex/common?_device=android&platform=android&scale=xhdpi";

    LiveChooseHeadler chooseHeadler;//推荐主播
    LiveBoomerangIn boomerangIn;//频道
    Handler handlerChoose, handlerBoomerang;

    CardView cha;
    LiveChooseHeadler.DataBean.RecommendDataBean.BannerDataBean bannerDataBean;



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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live, container, false);

        initView();
        UrlPath();
        initData();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }

    private void initView() {
        cha = (CardView) view.findViewById(R.id.cha_live);

        convenientBanner= (ConvenientBanner) view.findViewById(R.id.pager_live);

        focus = (LinearLayout) view.findViewById(R.id.focus);
        center = (LinearLayout) view.findViewById(R.id.center);
        search = (LinearLayout) view.findViewById(R.id.search);
        sort = (LinearLayout) view.findViewById(R.id.sort);


        chooseIn = (RelativeLayout) view.findViewById(R.id.choose_int);
        paintIn = (RelativeLayout) view.findViewById(R.id.paint_int);
        phoneIn = (RelativeLayout) view.findViewById(R.id.phone_int);
        musicIn = (RelativeLayout) view.findViewById(R.id.music_int);
        phoneGameIn = (RelativeLayout) view.findViewById(R.id.game_phone_int);
        oneMachineIn = (RelativeLayout) view.findViewById(R.id.one_machine_int);
        gameOlIn = (RelativeLayout) view.findViewById(R.id.game_ol_int);
        eSportIn = (RelativeLayout) view.findViewById(R.id.e_sports_int);
        cultureIn = (RelativeLayout) view.findViewById(R.id.culture_int);
        screeningIn = (RelativeLayout) view.findViewById(R.id.screening_int);


        chooseLoad = (RelativeLayout) view.findViewById(R.id.choose_load);
        paintLoad = (RelativeLayout) view.findViewById(R.id.paint_load);
        phoneLoad = (RelativeLayout) view.findViewById(R.id.phone_load);
        musicLoad = (RelativeLayout) view.findViewById(R.id.music_load);
        phoneGameLoad = (RelativeLayout) view.findViewById(R.id.game_phone_load);
        oneMachineLoad = (RelativeLayout) view.findViewById(R.id.one_machine_load);
        gameOlLoad = (RelativeLayout) view.findViewById(R.id.game_ol_load);
        eSportLoad = (RelativeLayout) view.findViewById(R.id.e_sports_load);
        cultureLoad = (RelativeLayout) view.findViewById(R.id.culture_load);
        screeningLoad = (RelativeLayout) view.findViewById(R.id.screening_load);


        chooseChange = (LinearLayout) view.findViewById(R.id.b_change_choose);
        paintChange = (LinearLayout) view.findViewById(R.id.b_change_paint);
        phoneChange = (LinearLayout) view.findViewById(R.id.b_change_phone);
        musicChange = (LinearLayout) view.findViewById(R.id.b_change_music);
        phoneGameChange = (LinearLayout) view.findViewById(R.id.b_change_game_phone);
        oneMachineChange = (LinearLayout) view.findViewById(R.id.b_change_machine);
        gameOlChange = (LinearLayout) view.findViewById(R.id.b_change_gameOl);
        eSportChange = (LinearLayout) view.findViewById(R.id.b_change_eSports);
        cultureChange = (LinearLayout) view.findViewById(R.id.b_change_culture);
        screeningChange = (LinearLayout) view.findViewById(R.id.b_change_screening);


        chooseView = (NoScrollGridView) view.findViewById(R.id.choose_01);
        chooseViewOther = (NoScrollGridView) view.findViewById(R.id.choose_02);
        paintView = (NoScrollGridView) view.findViewById(R.id.paint);
        phoneView = (NoScrollGridView) view.findViewById(R.id.phone);
        musicView = (NoScrollGridView) view.findViewById(R.id.music);
        phoneGameView = (NoScrollGridView) view.findViewById(R.id.game_phone);
        oneMachineView = (NoScrollGridView) view.findViewById(R.id.one_machine);

        gameOlView = (NoScrollGridView) view.findViewById(R.id.game_ol);
        eSportView = (NoScrollGridView) view.findViewById(R.id.e_sports);
        cultureView = (NoScrollGridView) view.findViewById(R.id.culture);
        screeningView = (NoScrollGridView) view.findViewById(R.id.screening);

        chooseView.setFocusable(false);
        chooseViewOther.setFocusable(false);
        paintView.setFocusable(false);
        phoneView.setFocusable(false);
        musicView.setFocusable(false);
        phoneGameView.setFocusable(false);
        oneMachineView.setFocusable(false);
        gameOlView.setFocusable(false);
        eSportView.setFocusable(false);
        cultureView.setFocusable(false);
        screeningView.setFocusable(false);



        chooseLoadB = (Button) view.findViewById(R.id.b_into_choose);
        paintLoadB = (Button) view.findViewById(R.id.b_into_paint);
        phoneLoadB = (Button) view.findViewById(R.id.b_into_phone);
        musicLoadB = (Button) view.findViewById(R.id.b_into_music);
        phoneGameLoadB = (Button) view.findViewById(R.id.b_into_game_phone);
        oneMachineLoadB = (Button) view.findViewById(R.id.b_into_machine);
        gameOlLoadB = (Button) view.findViewById(R.id.b_into_gameOl);
        eSportLoadB = (Button) view.findViewById(R.id.b_into_eSports);
        cultureLoadB = (Button) view.findViewById(R.id.b_into_culture);
        screeningLoadB = (Button) view.findViewById(R.id.b_into_screening);

        cha.setOnClickListener(this);
        focus.setOnClickListener(this);
        center.setOnClickListener(this);
        search.setOnClickListener(this);
        sort.setOnClickListener(this);

        chooseIn.setOnClickListener(this);
        paintIn.setOnClickListener(this);
        phoneIn.setOnClickListener(this);
        musicIn.setOnClickListener(this);
        phoneGameIn.setOnClickListener(this);
        oneMachineIn.setOnClickListener(this);
        gameOlIn.setOnClickListener(this);
        eSportIn.setOnClickListener(this);
        cultureIn.setOnClickListener(this);
        screeningIn.setOnClickListener(this);

        chooseLoadB.setOnClickListener(this);
        paintLoadB.setOnClickListener(this);
        musicLoadB.setOnClickListener(this);
        phoneGameLoadB.setOnClickListener(this);
        oneMachineLoadB.setOnClickListener(this);
        gameOlLoadB.setOnClickListener(this);
        eSportLoadB.setOnClickListener(this);
        cultureLoadB.setOnClickListener(this);
        screeningLoadB.setOnClickListener(this);
        phoneLoadB.setOnClickListener(this);


        chooseChange.setOnClickListener(this);
        paintChange.setOnClickListener(this);
        musicChange.setOnClickListener(this);
        phoneGameChange.setOnClickListener(this);
        oneMachineChange.setOnClickListener(this);
        gameOlChange.setOnClickListener(this);
        eSportChange.setOnClickListener(this);
        cultureChange.setOnClickListener(this);
        screeningChange.setOnClickListener(this);
        phoneChange.setOnClickListener(this);









    }

    private void initData() {

        handlerChoose = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 200){
                    LiveChooseHeadler.DataBean.RecommendDataBean.PartitionBean partition = chooseHeadler.getData().getRecommend_data().getPartition();
                    ImageView chooseImage = (ImageView) view.findViewById(R.id.icon_title_choose);
                    TextView chooseName = (TextView) view.findViewById(R.id.title_name_choose);
                    TextView choosNum = (TextView) view.findViewById(R.id.live_num_choose);
                    TextView choosNew = (TextView) view.findViewById(R.id.b_num_choose);

                    List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList = invertOnLine(chooseHeadler.getData().getRecommend_data().getLives());
                    ////////
                    Log.d("LiveFragment", partition.getName());
                    ImageLoader.getInstance().displayImage
                            (partition.getSub_icon().getSrc(),chooseImage);
                    chooseName.setText(partition.getName());
                    choosNum.setText(partition.getCount() + "");
                    final List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList1 = new ArrayList<>();
                    List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList2 = new ArrayList<>();
                    int a = livesBeanList.size();
                    for (int i = 0; i < a; i++) {
                        if (i < a / 2){
                            livesBeanList1.add(livesBeanList1.size(),livesBeanList.get(i));
                        }else {
                            livesBeanList2.add(livesBeanList2.size(),livesBeanList.get(i));
                        }

                    }
                    chooseAdapter = new LiveChooseAdapter(getActivity(), livesBeanList1);
                    chooseView.setAdapter(chooseAdapter);
                    chooseAdapterOther = new LiveChooseAdapter(getActivity(),livesBeanList2);
                    chooseViewOther.setAdapter(chooseAdapterOther);

                    chooseView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",livesBeanList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",livesBeanList1.get(position).getPlayurl());
                            intent.putExtra("title",livesBeanList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });





                    List<LiveChooseHeadler.DataBean.RecommendDataBean.BannerDataBean> bannerDataBeanList =
                            chooseHeadler.getData().getRecommend_data().getBanner_data();
                    bannerDataBean = bannerDataBeanList.get(0);
                    //cha
                    ImageView imageViewCha = (ImageView) view.findViewById(R.id.title_cha);
                    TextView liveNameCha = (TextView) view.findViewById(R.id.live_cha);
                    TextView titleNameCha = (TextView) view.findViewById(R.id.name_cha);
                    TextView addressName = (TextView) view.findViewById(R.id.adress_cha);
                    TextView numCha = (TextView) view.findViewById(R.id.num_cha);
                    ImageLoader.getInstance().displayImage
                            (bannerDataBean.getCover().getSrc(),imageViewCha);
                    liveNameCha.setText(bannerDataBean.getArea());
                    titleNameCha.setText(bannerDataBean.getTitle());
                    addressName.setText(bannerDataBean.getOwner().getName());
                    numCha.setText(bannerDataBean.getOnline() + "");





                }
                return false;
            }
        });
        handlerBoomerang = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 300){

                    List<LiveBoomerangIn.DataBean.PartitionsBean> partitionsBeanList =
                            boomerangIn.getData().getPartitions();



                    //轮播图
                    bannerBeanList = boomerangIn.getData().getBanner();

                    for (LiveBoomerangIn.DataBean.BannerBean banner : bannerBeanList){
                        networkImage.add(networkImage.size(), banner.getImg());
                    }
                    convenientBanner
                            //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                            .setPageIndicator(new int[]{R.drawable.ic_page_indicator,R.drawable.ic_page_indicator_focused})
                            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                            .setOnPageChangeListener(LiveFragment.this)
                            .setOnItemClickListener(LiveFragment.this)
                            .setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                                @Override
                                public NetworkImageHolderView createHolder() {
                                    return new NetworkImageHolderView();
                                }
                            },networkImage);




                    for (LiveBoomerangIn.DataBean.PartitionsBean partitionsBean : partitionsBeanList){
                        switch (partitionsBean.getPartition().getId()){
                            case 9:
                                paint = partitionsBean;
                                break;
                            case 11:
                                phone = partitionsBean;
                                break;
                            case 10:
                                music = partitionsBean;
                                break;
                            case 12:
                                phoneGame = partitionsBean;
                                break;
                            case 1:
                                oneMachine = partitionsBean;
                                break;
                            case 3:
                                gameOl = partitionsBean;
                                break;
                            case 4:
                                eSport = partitionsBean;
                                break;
                            case 2:
                                culture = partitionsBean;
                                break;
                            case 7:
                                screening = partitionsBean;
                                break;
                        }
                    }
                    //绘画
                    TextView paintLiveNum = (TextView) view.findViewById(R.id.live_num_paint);
                    TextView paintNewNum = (TextView) view.findViewById(R.id.b_num_choose);
                    paintLiveNum.setText(paint.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> paintList = BoomOnLine(paint.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> paintList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        paintList1.add(paintList1.size(), paintList.get(i));
                    }

                    paintAdapter = new LiveBoomAdapter(getActivity(),paintList1);
                    paintView.setAdapter(paintAdapter);

                    paintView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",paintList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",paintList1.get(position).getPlayurl());
                            intent.putExtra("title",paintList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });



                    //手机直播
                    TextView phoneLiveNum = (TextView) view.findViewById(R.id.live_num_phone);
                    TextView phoneNewNum = (TextView) view.findViewById(R.id.b_num_phone);
                    phoneLiveNum.setText(phone.getPartition().getCount() + "");


                    phoneLiveNum.setText(phone.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> phoneList = BoomOnLine(phone.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> phoneList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        phoneList1.add(phoneList1.size(), phoneList.get(i));
                    }

                    phoneAdapter = new LiveBoomAdapter(getActivity(),phoneList1);
                    phoneView.setAdapter(phoneAdapter);



                    phoneView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",phoneList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",phoneList1.get(position).getPlayurl());
                            intent.putExtra("title",phoneList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });










                    //常见歌唱
                    TextView musicLiveNum = (TextView) view.findViewById(R.id.live_num_music);
                    TextView musicNewNum = (TextView) view.findViewById(R.id.b_num_music);
                    musicLiveNum.setText(music.getPartition().getCount() + "");


                    musicLiveNum.setText(music.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> musicList = BoomOnLine(music.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> musicList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        musicList1.add(musicList1.size(), musicList.get(i));
                    }

                    musicAdapter = new LiveBoomAdapter(getActivity(),musicList1);
                    musicView.setAdapter(musicAdapter);


                    musicView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",musicList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",musicList1.get(position).getPlayurl());
                            intent.putExtra("title",musicList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });




                    //手游
                    TextView phoneGameLiveNum = (TextView) view.findViewById(R.id.live_num_phone_game);
                    TextView phoneGameNewNum = (TextView) view.findViewById(R.id.b_num_game_phone);
                    phoneGameLiveNum.setText(phoneGame.getPartition().getCount() + "");


                    phoneGameLiveNum.setText(phoneGame.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> phoneGameList = BoomOnLine(phoneGame.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> phoneGameList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        phoneGameList1.add(phoneGameList1.size(), phoneGameList.get(i));
                    }

                    phoneGameAdapter = new LiveBoomAdapter(getActivity(),phoneGameList1);
                    phoneGameView.setAdapter(phoneGameAdapter);


                    phoneGameView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",phoneGameList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",phoneGameList1.get(position).getPlayurl());
                            intent.putExtra("title",phoneGameList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });




                    //单机
                    TextView machineLiveNum = (TextView) view.findViewById(R.id.live_num_machine);
                    TextView machineNewNum = (TextView) view.findViewById(R.id.b_num_machine);
                    machineLiveNum.setText(oneMachine.getPartition().getCount() + "");


                    machineLiveNum.setText(oneMachine.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> oneMachineList = BoomOnLine(oneMachine.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> oneMachineList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        oneMachineList1.add(oneMachineList1.size(), oneMachineList.get(i));
                    }

                    oneMachineAdapter = new LiveBoomAdapter(getActivity(),oneMachineList1);
                    oneMachineView.setAdapter(oneMachineAdapter);



                    oneMachineView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",oneMachineList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",oneMachineList1.get(position).getPlayurl());
                            intent.putExtra("title",oneMachineList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });




                    //网友
                    TextView gameOlLiveNum = (TextView) view.findViewById(R.id.live_num_gameOl);
                    TextView gameOlNewNum = (TextView) view.findViewById(R.id.b_num_gameOl);
                    gameOlLiveNum.setText(gameOl.getPartition().getCount() + "");



                    gameOlLiveNum.setText(gameOl.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> gameOlList = BoomOnLine(gameOl.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> gameOlList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        gameOlList1.add(gameOlList1.size(), gameOlList.get(i));
                    }

                    gameOlAdapter = new LiveBoomAdapter(getActivity(),gameOlList1);
                    gameOlView.setAdapter(gameOlAdapter);

                    gameOlView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",gameOlList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",gameOlList1.get(position).getPlayurl());
                            intent.putExtra("title",gameOlList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });




                    //竞技
                    TextView eSportLiveNum = (TextView) view.findViewById(R.id.live_num_eSports);
                    TextView eSportNewNum = (TextView) view.findViewById(R.id.b_num_eSports);
                    eSportLiveNum.setText(eSport.getPartition().getCount() + "");


                    eSportLiveNum.setText(eSport.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> eSportList = BoomOnLine(eSport.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> eSportList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        eSportList1.add(eSportList1.size(), eSportList.get(i));
                    }

                    eSportAdapter = new LiveBoomAdapter(getActivity(),eSportList1);
                    eSportView.setAdapter(eSportAdapter);

                    eSportView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",eSportList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",eSportList1.get(position).getPlayurl());
                            intent.putExtra("title",eSportList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });




                    //御宅
                    TextView cultureLiveNum = (TextView) view.findViewById(R.id.live_num_culture);
                    TextView cultureNewNum = (TextView) view.findViewById(R.id.b_num_culture);
                    cultureLiveNum.setText(culture.getPartition().getCount() + "");


                    cultureLiveNum.setText(culture.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> cultureList = BoomOnLine(culture.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> cultureList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        cultureList1.add(cultureList1.size(), cultureList.get(i));
                    }

                    cultureAdapter = new LiveBoomAdapter(getActivity(),cultureList1);
                    cultureView.setAdapter(cultureAdapter);

                    cultureView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",cultureList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",cultureList1.get(position).getPlayurl());
                            intent.putExtra("title",cultureList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });



                    //放映厅
                    TextView screeningLiveNum = (TextView) view.findViewById(R.id.live_num_screening);
                    TextView screeningNewNum = (TextView) view.findViewById(R.id.b_num_screening);
                    screeningLiveNum.setText(screening.getPartition().getCount() + "");


                    screeningLiveNum.setText(screening.getPartition().getCount() + "");
                    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> screeningList = BoomOnLine(screening.getLives());
                    final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> screeningList1 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        screeningList1.add(screeningList1.size(), screeningList.get(i));
                    }

                    screeningAdapter = new LiveBoomAdapter(getActivity(),screeningList1);
                    screeningView.setAdapter(screeningAdapter);


                    screeningView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), LIvePlayItemActivity.class);
                            intent.putExtra("id",screeningList1.get(position).getRoom_id() + "");
                            intent.putExtra("playurl",screeningList1.get(position).getPlayurl());
                            intent.putExtra("title",screeningList1.get(position).getOwner().getName());
                            startActivity(intent);
                        }
                    });


                }
                return false;
            }
        });

    }



    public void UrlPath(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(url1, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {

                        Gson gson = new Gson();
                        chooseHeadler = gson.fromJson(result, new TypeToken<LiveChooseHeadler>(){}.getType());
                        handlerChoose.sendEmptyMessage(200);
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
                        boomerangIn = gson.fromJson(result, new TypeToken<LiveBoomerangIn>(){}.getType());
                        handlerBoomerang.sendEmptyMessage(300);

                    }
                });
            }
        }).start();

    }

    public void UrlPathChangeC(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.doGetAsyn(url1, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {

                        Gson gson = new Gson();
                        chooseHeadler = gson.fromJson(result, new TypeToken<LiveChooseHeadler>(){}.getType());
                        handlerChoose.sendEmptyMessage(400);
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
                        boomerangIn = gson.fromJson(result, new TypeToken<LiveBoomerangIn>(){}.getType());
                        List<LiveBoomerangIn.DataBean.PartitionsBean> partitionsBeanList =
                                boomerangIn.getData().getPartitions();
                        for (LiveBoomerangIn.DataBean.PartitionsBean partitionsBean : partitionsBeanList){
                            switch (partitionsBean.getPartition().getId()){
                                case 9:
                                    paint = partitionsBean;
                                    break;
                                case 11:
                                    phone = partitionsBean;
                                    break;
                                case 10:
                                    music = partitionsBean;
                                    break;
                                case 12:
                                    phoneGame = partitionsBean;
                                    break;
                                case 1:
                                    oneMachine = partitionsBean;
                                    break;
                                case 3:
                                    gameOl = partitionsBean;
                                    break;
                                case 4:
                                    eSport = partitionsBean;
                                    break;
                                case 2:
                                    culture = partitionsBean;
                                    break;
                                case 7:
                                    screening = partitionsBean;
                                    break;
                            }
                        }


                        List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> paintList = BoomOnLine(paint.getLives());
                        final List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> paintList1 = new ArrayList<>();
                        for (int i = 0; i < 4; i++) {
                            paintList1.add(paintList1.size(), paintList.get(i));
                        }



                    }
                });
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        Intent intentP = new Intent(getActivity(), LiveSortItemActivity.class);
        switch (v.getId()){
            case R.id.cha_live:
                Intent intentB = new Intent(getActivity(), LIvePlayItemActivity.class);
                intentB.putExtra("id",bannerDataBean.getRoom_id() + "");
                intentB.putExtra("playurl",bannerDataBean.getPlayurl());
                intentB.putExtra("title", bannerDataBean.getOwner().getName());
                startActivity(intentB);
                break;
            case R.id.focus:
                //关注
                break;
            case R.id.center:
                //直播中心
                break;
            case R.id.search:
                //搜索

                break;
            case R.id.sort:
                Intent intent = new Intent(getActivity(), LiveSortActivity.class);
                startActivity(intent);
                break;
            case R.id.choose_int:
                Intent intentC = new Intent(getActivity(), ChannelActivity.class);
                intentC.putExtra("url","http://live.bilibili.com/mobile/rooms?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&area_id=0&build=427000&mobi_app=android&page=1&platform=android&sort=hottest&sign=c1743a0e9e2f85e6ca9d744f1cd84b89");
                startActivity(intentC);
                break;
            case R.id.paint_int:

                intentP.putExtra("id", paintID);
                intentP.putExtra("sign",paintS);
                intentP.putExtra("name","绘画专区");
                startActivity(intentP);
                break;
            case R.id.phone_int:
                intentP.putExtra("id", phoneID);
                intentP.putExtra("sign",phoneS);
                intentP.putExtra("name","手机直播");
                startActivity(intentP);
                break;
            case R.id.music_int:

                intentP.putExtra("id", musicID);
                intentP.putExtra("sign",musicS);
                intentP.putExtra("name","唱见舞见");
                startActivity(intentP);
                break;
            case R.id.game_phone_int:

                intentP.putExtra("id", phoneGameID);
                intentP.putExtra("sign",phoneGameS);
                intentP.putExtra("name","手游直播");
                startActivity(intentP);
                break;
            case R.id.one_machine_int:

                intentP.putExtra("id", oneMachineID);
                intentP.putExtra("sign",oneMachineS);
                intentP.putExtra("name","单机联机");
                startActivity(intentP);
                break;
            case R.id.game_ol_int:

                intentP.putExtra("id", gameOlID);
                intentP.putExtra("sign",gameOlS);
                intentP.putExtra("name","网络游戏");
                startActivity(intentP);
                break;
            case R.id.e_sports_int:

                intentP.putExtra("id", eSportID);
                intentP.putExtra("sign",eSportS);
                intentP.putExtra("name","电子竞技");
                startActivity(intentP);
                break;
            case R.id.culture_int:

                intentP.putExtra("id", cultureID);
                intentP.putExtra("sign",cultureS);
                intentP.putExtra("name","御宅文化");
                startActivity(intentP);
                break;
            case R.id.screening_int:

                intentP.putExtra("id", screeningID);
                intentP.putExtra("sign",screeningS);
                intentP.putExtra("name","放映厅");
                startActivity(intentP);
                break;


            case R.id.b_into_choose:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_into_paint:
                intentP.putExtra("id", paintID);
                intentP.putExtra("sign",paintS);
                intentP.putExtra("name","绘画专区");
                startActivity(intentP);
                break;
            case R.id.b_into_phone:
                intentP.putExtra("id", phoneID);
                intentP.putExtra("sign",phoneS);
                intentP.putExtra("name","手机直播");
                startActivity(intentP);
                break;
            case R.id.b_into_music:
                intentP.putExtra("id", musicID);
                intentP.putExtra("sign",musicS);
                intentP.putExtra("name","唱见舞见");
                startActivity(intentP);
                break;
            case R.id.b_into_game_phone:
                intentP.putExtra("id", phoneGameID);
                intentP.putExtra("sign",phoneGameS);
                intentP.putExtra("name","手游直播");
                startActivity(intentP);
                break;
            case R.id.b_into_machine:
                intentP.putExtra("id", oneMachineID);
                intentP.putExtra("sign",oneMachineS);
                intentP.putExtra("name","单机联机");
                startActivity(intentP);
                break;
            case R.id.b_into_gameOl:
                intentP.putExtra("id", gameOlID);
                intentP.putExtra("sign",gameOlS);
                intentP.putExtra("name","网络游戏");
                startActivity(intentP);
                break;
            case R.id.b_into_eSports:
                intentP.putExtra("id", eSportID);
                intentP.putExtra("sign",eSportS);
                intentP.putExtra("name","电子竞技");
                startActivity(intentP);
                break;
            case R.id.b_into_culture:
                intentP.putExtra("id", cultureID);
                intentP.putExtra("sign",cultureS);
                intentP.putExtra("name","御宅文化");
                startActivity(intentP);
                break;
            case R.id.b_into_screening:
                intentP.putExtra("id", screeningID);
                intentP.putExtra("sign",screeningS);
                intentP.putExtra("name","放映厅");
                startActivity(intentP);
                break;


            case R.id.b_change_choose:
                UrlPath();
                chooseAdapter.notifyDataSetChanged();
                chooseAdapterOther.notifyDataSetChanged();
                break;
            case R.id.b_change_paint:


                break;
            case R.id.b_change_phone:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_music:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_game_phone:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_machine:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_gameOl:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_eSports:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_culture:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b_change_screening:
                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                break;


        }

    }



    //根据点击数排序
    public List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> invertOnLine(List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList){
        Collections.sort(livesBeanList, new Comparator<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean>() {
            @Override
            public int compare(LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean lhs, LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean rhs) {
                return  rhs.getOnline() - lhs.getOnline();
            }
        });


        return livesBeanList;
    }

    public List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> BoomOnLine(List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> livesBeanList){
        Collections.sort(livesBeanList, new Comparator<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean>() {
            @Override
            public int compare(LiveBoomerangIn.DataBean.PartitionsBean.LivesBean lhs, LiveBoomerangIn.DataBean.PartitionsBean.LivesBean rhs) {
                return rhs.getOnline() - lhs.getOnline();
            }
        });
        return livesBeanList;
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(getActivity(), CarouselWebActivity.class);
        String title = bannerBeanList.get(position).getTitle();
        String url = bannerBeanList.get(position).getLink();
        intent.putExtra("title",title);
        intent.putExtra("url",url);
        startActivity(intent);

    }


    // 轮播图点击事件
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
