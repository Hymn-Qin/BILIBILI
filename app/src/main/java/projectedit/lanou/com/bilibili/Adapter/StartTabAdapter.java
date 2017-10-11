package projectedit.lanou.com.bilibili.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by lanouhn on 2016/10/18.
 */

public class StartTabAdapter extends FragmentPagerAdapter {
    List<String> titleList;
    List<Fragment> fragmentList;
    public StartTabAdapter(FragmentManager fm,List<String> titleList,
            List<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position % titleList.size());
    }
}
