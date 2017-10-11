package projectedit.lanou.com.bilibili.Adapter;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import projectedit.lanou.com.bilibili.Beans.HisPlayUp;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/21.
 */
public class HisPlayChinaAdapter extends BaseAdapter {

    Context context;
    List<HisPlayUp.ResultBean.ChinaBean> chinaBeanList;
    public HisPlayChinaAdapter(Context context,
                               List<HisPlayUp.ResultBean.ChinaBean> chinaBeanList){
        this.context = context;
        this.chinaBeanList = chinaBeanList;
    }
    @Override
    public int getCount() {
        return chinaBeanList != null ? chinaBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return chinaBeanList.get(position);
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

        HisPlayUp.ResultBean.ChinaBean chinaBean = chinaBeanList.get(position);

        holder.titleNmae.setText(chinaBean.getTitle());

        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time=new Long(chinaBean.getLast_time() );
        String d = format.format(time * 1000);
        try {
            Date date=format.parse(d);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int data = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int ss = calendar.get(Calendar.MINUTE);
            Time time1 = new Time();
            time1.setToNow();
            int yearN = time1.year;
            int monthN = time1.month;
            int dateN = time1.monthDay;
            String da = "";
            if (year == yearN  && month == monthN ){
                if (dateN - data == 1 ){
                    da = "昨天 " + hour;
                }
                if (dateN - data == 0){
                    da = "今天 " + hour + ":" + ss;
                }
            }else {
                da = year + "年" + month + "月";
            }

            holder.numOnLone.setText(da);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        ImageLoader.getInstance().displayImage
                (chinaBean.getCover(), holder.titleImage);










        return convertView;
    }


    class HisUpViewHolder{
        ImageView titleImage;
        TextView titleNmae;
        TextView numOnLone;
        TextView numNew;
    }
}
