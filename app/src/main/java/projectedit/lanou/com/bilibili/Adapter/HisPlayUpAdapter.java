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
import projectedit.lanou.com.bilibili.Beans.LiveBoomerangIn;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class HisPlayUpAdapter extends BaseAdapter {

    Context context;
    List<HisPlayUp.ResultBean.SerializingBean> serializingXinList;;
    public HisPlayUpAdapter(Context context,
                            List<HisPlayUp.ResultBean.SerializingBean> serializingXinList){
        this.context = context;
        this.serializingXinList = serializingXinList;
    }
    @Override
    public int getCount() {
        return serializingXinList != null ? serializingXinList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return serializingXinList.get(position);
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

        HisPlayUp.ResultBean.SerializingBean serializingBean = serializingXinList.get(position);

        holder.titleNmae.setText(serializingBean.getTitle());
        holder.numOnLone.setText(serializingBean.getWatching_count() + "人在看");
        holder.numNew.setVisibility(View.VISIBLE);
        holder.numNew.setText("更新至第" + serializingBean.getNewest_ep_index() + "话");
        ImageLoader.getInstance().displayImage
                (serializingBean.getCover(), holder.titleImage);










        return convertView;
    }


    class HisUpViewHolder{
        ImageView titleImage;
        TextView titleNmae;
        TextView numOnLone;
        TextView numNew;
    }
}
