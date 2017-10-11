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

import projectedit.lanou.com.bilibili.Beans.LiveChooseHeadler;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class LiveChooseAdapter extends BaseAdapter {

    Context context;
    List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList;
    public LiveChooseAdapter(Context context,
            List<LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean> livesBeanList){
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
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_live_choose_grid_item, parent, false);
            holder = new ChooseViewHolder();
            holder.StartImage = (ImageView) convertView.findViewById(R.id.item_image);
            holder.name = (TextView) convertView.findViewById(R.id.item_boom);
            holder.titleNmae = (TextView) convertView.findViewById(R.id.item_name);
            holder.author = (TextView) convertView.findViewById(R.id.author);
            holder.likers = (TextView) convertView.findViewById(R.id.num_like);
            convertView.setTag(holder);
        }else {
            holder = (ChooseViewHolder) convertView.getTag();
        }

        LiveChooseHeadler.DataBean.RecommendDataBean.LivesBean livesBean = livesBeanList.get(position);

        holder.author.setText(livesBean.getOwner().getName());
        holder.likers.setText(livesBean.getOnline() + "");
        holder.name.setText(livesBean.getArea());
        String text = livesBean.getTitle();
        if (livesBean.getArea() != null && livesBean.getArea().length() != 0){
            int l = livesBean.getArea().length();
            for (int i = 0; i < l; i++) {
                text = "     " + text;
            }
        }

        holder.titleNmae.setText(text);
        ImageLoader.getInstance().displayImage
                (livesBean.getCover().getSrc(),holder.StartImage);










        return convertView;
    }


    class ChooseViewHolder{
        ImageView StartImage;
        TextView name;
        TextView titleNmae;
        TextView author;
        TextView likers;
    }
}
