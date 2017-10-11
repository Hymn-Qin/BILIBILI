package projectedit.lanou.com.bilibili.Fragment;

;import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.DanmakuListAdapter;
import projectedit.lanou.com.bilibili.Beans.LivePlayDanmaku;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.utils.HttpUtils;

/**
 * Created by lanouhn on 16/10/26.
 */
public class LivePlayItemDanmaku extends Fragment {
    //  评论区发言人前面的图片成就http://live.bilibili.com/appUser/getTitle?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xhdpi&sign=5c740758766395e1467c9c900e025f05

    //  弹幕http://live.bilibili.com/AppRoom/msg?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=5170&sign=6ff6e1bd8970d5bf105cae5000a7ba43

    //礼物  http://live.bilibili.com/AppIndex/getAllItem?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&scale=xhdpi&sign=5c740758766395e1467c9c900e025f05

    ListView listView;
    View view;
    String url = "http://live.bilibili.com/AppRoom/msg?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=5170&sign=6ff6e1bd8970d5bf105cae5000a7ba43";
    Handler handler;
    //弹幕
    LivePlayDanmaku danmaku, danmakuNew;
    List<LivePlayDanmaku.DataBean.RoomBean> roomBeanList;
    DanmakuListAdapter adapter;
    String id;
    boolean is=true;
    int visibleLastIndex = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live_play_danmaku , container, false);



        initView();
        UrlPath();

        initData();
        return view;
    }
    public LivePlayItemDanmaku (String id){
        this.id = id;
        Log.d("LivePlayItemDanmaku", id);

    }

    private void initView() {
        listView = (ListView) view.findViewById(R.id.danmaku);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int itemsLastIndex = adapter.getCount() - 1; // 数据集最后一项的索引
                int lastIndex = itemsLastIndex + 1;
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && visibleLastIndex == lastIndex){
                    NewUrlPath();
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                    visibleLastIndex = firstVisibleItem + visibleItemCount - 1;

                }
        });

    }

    private void initData() {

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 400){
                    roomBeanList = danmaku.getData().getRoom();
                    adapter = new DanmakuListAdapter(getActivity(), roomBeanList);
                    listView.setAdapter(adapter);

                }
                if (msg.what == 500){
                    List<LivePlayDanmaku.DataBean.RoomBean> roomBeanListNEW = new ArrayList<>();
                    if (danmakuNew.getData() != null && danmakuNew.getData().getRoom() != null && danmakuNew.getData().getRoom().get(0) != null  ){
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        roomBeanListNEW = danmakuNew.getData().getRoom();

                        try {
                            Date date = format.parse(roomBeanListNEW.get(0).getTimeline());
                            Date date1 = format.parse(roomBeanList.get(roomBeanList.size() - 1).getTimeline());


                            if (date.getTime() >= date1.getTime()){


                                roomBeanList.addAll(roomBeanListNEW);
                                adapter.notifyDataSetChanged();

                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


//
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
                        danmaku = gson.fromJson(result, new TypeToken<LivePlayDanmaku>(){}.getType());
                        handler.sendEmptyMessage(400);
                    }
                });
            }
        }).start();

    }
    public void NewUrlPath(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                    HttpUtils.doGetAsyn(url, new HttpUtils.CallBack() {
                        @Override
                        public void onRequestComplete(String result) {
                            Gson gson = new Gson();
                            danmakuNew = gson.fromJson(result, new TypeToken<LivePlayDanmaku>(){}.getType());

                            handler.sendEmptyMessage(500);


                        }
                    });


            }
        }).start();

    }
}
