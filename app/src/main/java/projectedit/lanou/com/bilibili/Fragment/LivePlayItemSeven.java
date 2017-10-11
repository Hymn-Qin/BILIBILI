package projectedit.lanou.com.bilibili.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import projectedit.lanou.com.bilibili.Adapter.RedListAdapter;
import projectedit.lanou.com.bilibili.Adapter.SevenListAdapter;
import projectedit.lanou.com.bilibili.Beans.RedH;
import projectedit.lanou.com.bilibili.Beans.SevenSale;
import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.utils.HttpUtils;

;

/**
 * Created by lanouhn on 16/10/26.
 */
public class LivePlayItemSeven extends Fragment {
    //  http://live.bilibili.com/AppRoom/opTop?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=5170&scale=xhdpi&type=redleaf&sign=80056ff550fed309eaa80a54e420eb43

    ListView listView;
    View view;
    String url = "http://live.bilibili.com/AppRoom/getGiftTop?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&room_id=5170&sign=6ff6e1bd8970d5bf105cae5000a7ba43";
    Handler handler;
    //弹幕
    SevenSale sevenSale;
    List<SevenSale.DataBean.ListBean> listBeanList;
    SevenListAdapter adapter;
    String id;
    boolean is=true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_live_play_seven , container, false);



        initView();
        UrlPath();

        initData();
        return view;
    }
    public LivePlayItemSeven(String id){
        this.id = id;
        Log.d("LivePlayItemDanmaku", id);

    }

    private void initView() {
        listView = (ListView) view.findViewById(R.id.seven);

    }

    private void initData() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 400){
                    listBeanList = sevenSale.getData().getList();
                    adapter = new SevenListAdapter(getActivity(), listBeanList);
                    listView.setAdapter(adapter);

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
                        sevenSale = gson.fromJson(result, new TypeToken<SevenSale>(){}.getType());
                        handler.sendEmptyMessage(400);
                    }
                });
            }
        }).start();

    }

}
