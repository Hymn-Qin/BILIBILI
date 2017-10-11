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

import projectedit.lanou.com.bilibili.Beans.RedH;
import projectedit.lanou.com.bilibili.Beans.SevenSale;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/26.
 */
public class SevenListAdapter extends BaseAdapter {
    Context context;
    List<SevenSale.DataBean.ListBean> listBeanList;
    public SevenListAdapter(Context context,
                            List<SevenSale.DataBean.ListBean> listBeanList){
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
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_live_play_seven_item, parent, false);
            holder = new RedViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name_seven);
            holder.num = (TextView) convertView.findViewById(R.id.xunzhang_num_seven);
            holder.mingciNum = (TextView) convertView.findViewById(R.id.mingci_num_seven);
            holder.mingci = (ImageView) convertView.findViewById(R.id.mingci_image_seven);
            holder.xunzhang = (ImageView) convertView.findViewById(R.id.xunzhang_seven);
            convertView.setTag(holder);
        }
        SevenSale.DataBean.ListBean listBean = listBeanList.get(position);
        holder = (RedViewHolder) convertView.getTag();
        holder.name.setText(listBean.getUname());
        holder.num.setText(listBean.getCoin() + "");
        if (position == 0){
            holder.mingci.setImageResource(R.mipmap.one);
            holder.mingci.setVisibility(View.VISIBLE);
            holder.mingciNum.setVisibility(View.GONE);
        }else if (position == 1){
            holder.mingci.setImageResource(R.mipmap.one_02);
            holder.mingci.setVisibility(View.VISIBLE);
            holder.mingciNum.setVisibility(View.GONE);
        }else if (position == 2){
            holder.mingci.setImageResource(R.mipmap.one_03);
            holder.mingci.setVisibility(View.VISIBLE);
            holder.mingciNum.setVisibility(View.GONE);
        }else if (position > 2){
            holder.mingci.setVisibility(View.GONE);
            holder.mingciNum.setVisibility(View.VISIBLE);
            holder.mingciNum.setText(position + 1 + "");
        }







        return convertView;
    }

    class RedViewHolder{
        TextView name, num, mingciNum;
        ImageView mingci, xunzhang;
    }
}
