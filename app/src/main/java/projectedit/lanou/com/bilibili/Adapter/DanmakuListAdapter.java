package projectedit.lanou.com.bilibili.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projectedit.lanou.com.bilibili.Beans.LivePlayDanmaku;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/26.
 */
public class DanmakuListAdapter extends BaseAdapter {
    Context context;
    List<LivePlayDanmaku.DataBean.RoomBean> roomBeanList;
    public DanmakuListAdapter (Context context,
            List<LivePlayDanmaku.DataBean.RoomBean> roomBeanList){
        this.context = context;
        this.roomBeanList = roomBeanList;

    }
    @Override
    public int getCount() {
        return roomBeanList != null ? roomBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return roomBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DanmakuViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_live_play_danmaku_item, parent, false);
            holder = new DanmakuViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name_dan);
            holder.danmaku = (TextView) convertView.findViewById(R.id.danmaku_text);
            holder.dengji = (TextView) convertView.findViewById(R.id.dengji);
            holder.touxian = (TextView) convertView.findViewById(R.id.touxian);
            holder.chengjiu = (ImageView) convertView.findViewById(R.id.chengjiu);
            convertView.setTag(holder);
        }

        holder = (DanmakuViewHolder) convertView.getTag();
        ImageView imageView = (ImageView) convertView.findViewById(R.id.chengjiu);
        LivePlayDanmaku.DataBean.RoomBean roomBean = roomBeanList.get(position);
        holder.danmaku.setText(roomBean.getText());
        holder.name.setText(roomBean.getNickname() + " :");
        if (position == 0 || position == 3 || position == 5){
            imageView.setVisibility(View.GONE);

        }else {
            imageView.setVisibility(View.VISIBLE);
        }





        return convertView;
    }

    class DanmakuViewHolder{
        TextView name, danmaku, dengji, touxian;
        ImageView chengjiu;
    }
}
