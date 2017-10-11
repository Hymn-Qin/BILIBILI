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

import projectedit.lanou.com.bilibili.Beans.HisPlayUp;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class HisPlayPreAdapter extends BaseAdapter {

    Context context;
    List<HisPlayUp.ResultBean.PreviousBean.ListBean> lists;
    public HisPlayPreAdapter(Context context,
                             List<HisPlayUp.ResultBean.PreviousBean.ListBean> lists){
        this.context = context;
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return lists != null ? lists.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HisUpViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_his_play_up_item, parent, false);
            holder = new HisUpViewHolder();
            holder.titleImage = (ImageView) convertView.findViewById(R.id.his_item_image);
            holder.titleNmae = (TextView) convertView.findViewById(R.id.his_item_name);
            holder.numOnLone = (TextView) convertView.findViewById(R.id.his_item_num);
            holder.numNew = (TextView) convertView.findViewById(R.id.his_item_xin);
            convertView.setTag(holder);
        }else {
            holder = (HisUpViewHolder) convertView.getTag();
        }

        HisPlayUp.ResultBean.PreviousBean.ListBean listBean = lists.get(position);

        holder.titleNmae.setText(listBean.getTitle());
        String num = listBean.getFavourites();
        int n = Integer.valueOf(num);
        int a ;
        float p;
        if (n > 10000){
            a = n / 1000;
            p = (float) a / 10;
            holder.numOnLone.setText(p+ "万人追番");
        }else {
            holder.numOnLone.setText(n + "人追番");
        }




        ImageLoader.getInstance().displayImage
                (listBean.getCover(), holder.titleImage);










        return convertView;
    }


    class HisUpViewHolder{
        ImageView titleImage;
        TextView titleNmae;
        TextView numOnLone;
        TextView numNew;
    }
}
