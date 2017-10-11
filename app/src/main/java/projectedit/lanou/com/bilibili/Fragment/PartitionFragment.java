package projectedit.lanou.com.bilibili.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projectedit.lanou.com.bilibili.R;


/**
 * Created by lanouhn on 2016/10/18.
 */

public class PartitionFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_partition, container, false);
        return view;
    }
}
