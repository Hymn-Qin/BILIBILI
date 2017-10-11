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

import projectedit.lanou.com.bilibili.Beans.LiveBoomerangIn;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class LiveBoomAdapter extends BaseAdapter {

    Context context;
    List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> livesBeanList;
    public LiveBoomAdapter(Context context,
                           List<LiveBoomerangIn.DataBean.PartitionsBean.LivesBean> livesBeanList){
        this.context = context;
        this.livesBeanList = livesBeanList;
    }
    @Override
    public int getCount() {
        return livesBeanList != null ? livesBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return livesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChooseViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_live_boom_grid_item, parent, false);
            holder = new ChooseViewHolder();
            holder.StartImage = (ImageView) convertView.findViewById(R.id.item_image_1);
            holder.titleNmae = (TextView) convertView.findViewById(R.id.item_name_1);
            holder.author = (TextView) convertView.findViewById(R.id.author_1);
            holder.likers = (TextView) convertView.findViewById(R.id.num_like_1);
            convertView.setTag(holder);
        }else {
            holder = (ChooseViewHolder) convertView.getTag();
        }

        LiveBoomerangIn.DataBean.PartitionsBean.LivesBean livesBean = livesBeanList.get(position);

        holder.author.setText(livesBean.getOwner().getName());
        holder.likers.setText(livesBean.getOnline() + "");
        holder.titleNmae.setText(livesBean.getTitle());
        ImageLoader.getInstance().displayImage
                (livesBean.getCover().getSrc(),holder.StartImage);










        return convertView;
    }


    class ChooseViewHolder{
        ImageView StartImage;
        TextView titleNmae;
        TextView author;
        TextView likers;
    }
}
