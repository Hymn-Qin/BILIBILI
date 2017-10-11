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

import projectedit.lanou.com.bilibili.Beans.HisPlayDown;
import projectedit.lanou.com.bilibili.Beans.LiveBoomerangIn;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class HisPalyDownAdapter extends BaseAdapter {

    Context context;
    List<HisPlayDown.ResultBean> resultBeanList;
    public HisPalyDownAdapter(Context context,
                              List<HisPlayDown.ResultBean> resultBeanList){
        this.context = context;
        this.resultBeanList = resultBeanList;
    }
    @Override
    public int getCount() {
        return resultBeanList != null ? resultBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return resultBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HisDownViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_his_play_down_item, parent, false);
            holder = new HisDownViewHolder();
            holder.titleImage = (ImageView) convertView.findViewById(R.id.item_image_his_down);
            holder.titleNmae = (TextView) convertView.findViewById(R.id.item_name_his_down);
            holder.text1 = (TextView) convertView.findViewById(R.id.item_text1_his_down);

            convertView.setTag(holder);
        }else {
            holder = (HisDownViewHolder) convertView.getTag();
        }

        HisPlayDown.ResultBean resultBean = resultBeanList.get(position);

        holder.titleNmae.setText(resultBean.getTitle());
        holder.text1.setText(resultBean.getDesc());
        ImageLoader.getInstance().displayImage
                (resultBean.getCover(),holder.titleImage);










        return convertView;
    }


    class HisDownViewHolder{
        ImageView titleImage;
        TextView titleNmae;
        TextView text1;

    }
}
