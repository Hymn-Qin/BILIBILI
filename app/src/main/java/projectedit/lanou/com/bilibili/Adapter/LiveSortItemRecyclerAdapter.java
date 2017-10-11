package projectedit.lanou.com.bilibili.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.nio.charset.IllegalCharsetNameException;
import java.util.List;

import projectedit.lanou.com.bilibili.Beans.LiveSortItemChange;
import projectedit.lanou.com.bilibili.Beans.SelectedBean;
import projectedit.lanou.com.bilibili.R;

/**
 * Created by lanouhn on 16/10/22.
 */
public class LiveSortItemRecyclerAdapter extends RecyclerView.Adapter<LiveSortItemRecyclerAdapter.ViewHolder> {

    Context context;
    List<LiveSortItemChange> liveSortItemChangeList;
    List<SelectedBean> selectedBeanList;

    private int mSelectedPos = -1;

    public LiveSortItemRecyclerAdapter(Context context, List<LiveSortItemChange> liveSortItemChangeList,
                                       List<SelectedBean> selectedBeanList) {
        this.context = context;
        this.liveSortItemChangeList = liveSortItemChangeList;
        this.selectedBeanList = selectedBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_live_boom_recycler_item, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String name = liveSortItemChangeList.get(position).getName();
        holder.textView.setText(name);
        holder.textView01.setText(name);

        if (selectedBeanList.get(position).getIsSelected() == 1 && selectedBeanList.get(position) != null) {
            holder.textView01.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.GONE);
        } else {
            holder.textView01.setVisibility(View.GONE);
            holder.textView.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickListener.onItemClickListener(position);

                for (SelectedBean selectedBean : selectedBeanList) {
                    selectedBean.setIsSelected(0);
                }

                selectedBeanList.get(position).setIsSelected(1);
                notifyDataSetChanged();


            }
        });


    }

    @Override
    public int getItemCount() {
        return liveSortItemChangeList != null ? liveSortItemChangeList.size() : 0;
    }

    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClickListener(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView01;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_text);
            textView01 = (TextView) itemView.findViewById(R.id.title_text1);

        }
    }
}
