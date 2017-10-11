package projectedit.lanou.com.bilibili.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import projectedit.lanou.com.bilibili.Beans.LivePlayDanmaku;
import projectedit.lanou.com.bilibili.Beans.RedH;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/26.
 */
public class RedListAdapter extends BaseAdapter {
    Context context;
    List<RedH.DataBean.ListBean> listBeanList;
    public RedListAdapter(Context context,
                          List<RedH.DataBean.ListBean> listBeanList){
        this.context = context;
        this.listBeanList = listBeanList;

    }
    @Override
    public int getCount() {
        return listBeanList != null ? listBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return listBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RedViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_live_play_red_item, parent, false);
            holder = new RedViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name_red);
            holder.num = (TextView) convertView.findViewById(R.id.xunzhang_num);
            holder.mingci = (ImageView) convertView.findViewById(R.id.mingci_image);
            holder.xunzhang = (ImageView) convertView.findViewById(R.id.xunzhang);
            convertView.setTag(holder);
        }
        RedH.DataBean.ListBean listBean = listBeanList.get(position);
        holder = (RedViewHolder) convertView.getTag();
        holder.name.setText(listBean.getUname());
        holder.num.setText(listBean.getScore() + "");
        ImageLoader.getInstance().displayImage(listBean.getCoin_url().getSrc(), holder.mingci);
        ImageLoader.getInstance().displayImage(listBean.getCoin1_url().getSrc(), holder.xunzhang);





        return convertView;
    }

    class RedViewHolder{
        TextView name, num;
        ImageView mingci, xunzhang;
    }
}
