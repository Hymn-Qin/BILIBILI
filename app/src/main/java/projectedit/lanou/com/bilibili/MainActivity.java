package projectedit.lanou.com.bilibili;


import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;
import projectedit.lanou.com.bilibili.Adapter.StartTabAdapter;
import projectedit.lanou.com.bilibili.Fragment.FocusOnFragment;
import projectedit.lanou.com.bilibili.Fragment.FoundFragment;
import projectedit.lanou.com.bilibili.Fragment.HisPlayFragment;
import projectedit.lanou.com.bilibili.Fragment.LiveFragment;
import projectedit.lanou.com.bilibili.Fragment.PartitionFragment;
import projectedit.lanou.com.bilibili.Fragment.RecommendedFragment;
import projectedit.lanou.com.bilibili.Utility.view.MyViewPager;

public class MainActivity extends AppCompatActivity {
    MyViewPager viewPager;
    TabLayout tabLayout;
    List<String> titleList;
    List<Fragment> fragmentList;
    StartTabAdapter adapter;
    RelativeLayout topTitle;
    Toolbar tb;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    RelativeLayout open;
    LinearLayout login;
    ImageView riYue;
    View headerView;

    boolean isChange = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullscreen(true);
        initImageLoader();
        initView();
        initData();
    }
    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.drawable.huancun)
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }

    private void initView() {



        open = (RelativeLayout) findViewById(R.id.open_menu);
        tabLayout = (TabLayout) findViewById(R.id.tab_main);
        viewPager = (MyViewPager) findViewById(R.id.pager_main);
        topTitle = (RelativeLayout) findViewById(R.id.top_main);
        tb = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout, tb,
                R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);


        navigationView = (NavigationView) findViewById(R.id.navigation_header);



        disableNavigationViewScrollbars(navigationView);
        if (navigationView != null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.home:
                            Toast.makeText(MainActivity.this, "主页", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.my_vip:
                            break;
                        case R.id.load:
                            break;
                        case R.id.my_like:
                            break;
                        case R.id.old_look:
                            break;
                        case R.id.person_like:
                            break;
                        case R.id.money_box:
                            break;
                        case R.id.window:
                            break;
                        case R.id.apps:
                            break;
                        case R.id.helper:
                            break;

                    }
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    return false;
                }
            });
            headerViewClick();
        }

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });
    }

    public void headerViewClick(){
        headerView = navigationView.getHeaderView(0);
        login = (LinearLayout) headerView.findViewById(R.id.logn_in);
        riYue = (ImageView) headerView.findViewById(R.id.ri_yue);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        riYue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isChange){
                    riYue.setImageResource(R.mipmap.son);
                    isChange = !isChange;
                }else {
                    riYue.setImageResource(R.mipmap.yue);
                    isChange = !isChange;
                }


            }
        });

    }
    private void disableNavigationViewScrollbars(NavigationView navigationView){
        if (navigationView != null){
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null){
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    public void openDrawer(){
        if (drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }else {
            drawerLayout.openDrawer(navigationView);
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void initData() {

        titleList = new ArrayList<>();
        titleList.add("直播");//live
        titleList.add("推荐");//recommended
        titleList.add("番剧");//his play
        titleList.add("分区");//partition
        titleList.add("关注");//focus on
        titleList.add("发现");//found
        fragmentList = new ArrayList<>();
        fragmentList.add(new LiveFragment());
        fragmentList.add(new RecommendedFragment());
        fragmentList.add(new HisPlayFragment());
        fragmentList.add(new PartitionFragment());
        fragmentList.add(new FocusOnFragment());
        fragmentList.add(new FoundFragment());

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(5)));

        adapter = new StartTabAdapter(this.getSupportFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(3);

    }

    private void fullscreen(boolean enable) {
        if (enable) { //显示状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else { //隐藏状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(lp);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }



}