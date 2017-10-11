package projectedit.lanou.com.bilibili.Utility.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import projectedit.lanou.com.bilibili.R;
import projectedit.lanou.com.bilibili.Utility.utils.ScreenUtils;

/**
 * Created by lanouhn on 16/9/7.
 */
public class SlidingMenuView extends HorizontalScrollView {
    //侧滑菜单距离右边的距离
    private int mRightPaddingWidth;
    //屏幕宽度
    private int mScreenWidth;
    //侧滑菜单的宽度
    private int mMenuWidth;
    //菜单一半的宽度,用于判断滑动的临界值
    private int mHalfMenuWidth;
    //内容的宽度
    private int mContentWith;
    //菜单是否打开
    private boolean isMenuOpen;
    //是否第一次加载
    private boolean isFirst;

    //菜单的视图
    ViewGroup mMenu;

    //内容的而试图
    ViewGroup mContent;
    public SlidingMenuView(Context context) {
        this(context, null, 0);
    }

    public SlidingMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取对应的属性的数组
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SlidingMenuView,
                defStyleAttr,
                0);
        //获取长度
        int count = array.getIndexCount();

        for (int i = 0; i < count; i++) {
            //获取对应属性id
            int attr = array.getIndex(i);
            //根据属性id
            switch (attr){
                case R.styleable.SlidingMenuView_myRightPadding:
                    //获取对应的数值
                    mRightPaddingWidth = array.getDimensionPixelSize(
                            attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_DIP,
                                    50,
                                    getResources().getDisplayMetrics()));
                    break;
            }
        }
        //释放
        array.recycle();


        //获取屏幕的宽度
        mScreenWidth = ScreenUtils.getScreenWidth(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isFirst){
            //获取第一层的子控件
            LinearLayout all = (LinearLayout) getChildAt(0);
            //获取子布局里面对应的嵌套的布局
            mMenu = (ViewGroup) all.getChildAt(0);
            mContent = (ViewGroup) all.getChildAt(1);
            //菜单的宽度
            mMenuWidth = mScreenWidth - mRightPaddingWidth;
            mHalfMenuWidth = mMenuWidth / 2;
            mContentWith = mScreenWidth;

            //设置对应控件的相应的宽度
            mMenu.getLayoutParams().width = mMenuWidth;

            mContent.getLayoutParams().width = mContentWith;

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed){
            //滑动到隐藏菜单的距离
            smoothScrollTo(mMenuWidth, 0);
            //菜单打开的状态的更改
            isMenuOpen = false;
            //不再是的第一次进入
            isFirst = true;
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //l滑动的x的位置  t滑动的y的位置  oldl以前x的位置  oldt以前y的位置
        //获取滑动过程中的比例关系
        float scale = l * 1.0f / mMenuWidth;
        float leftScale = 1 - 0.3f * scale;
        float rightScale = 0.8f + 0.2f * scale;
        //设置菜单的变化比例  缩放
//        ViewHelper.setScaleX(mMenu, leftScale);
////        ViewHelper.setScaleY(mMenu, leftScale);
//        //菜单栏的平移动画
//        ViewHelper.setTranslationX(mMenu, mMenuWidth * scale * 0.6f);
//
//        //内容的缩放动画
//        ViewHelper.setPivotX(mContent, 0);
////        ViewHelper.setPivotY(mContent, mContent.getHeight() / 2);
//        ViewHelper.setScaleX(mContent, rightScale);
////        ViewHelper.setScaleY(mContent, rightScale);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                changeScrollState(scrollX);
                return true;
        }
        return super.onTouchEvent(ev);


    }

    //判断是否滑动到对应的状态
    private void changeScrollState(int scrollX) {
        if (scrollX > mHalfMenuWidth){
            this.smoothScrollTo(mMenuWidth, 0);
            isMenuOpen = false;
        }else {
            this.smoothScrollTo(0, 0);
            isMenuOpen = true;
        }
    }

    /**
     * 关闭菜单
     */
    public void closeMenu(){
        if (isMenuOpen){
            this.smoothScrollTo(mMenuWidth, 0);
            isMenuOpen = false;

        }
    }

    /**
     * 打开菜单
     */
    public void openMenu(){
        if (!isMenuOpen){
            this.smoothScrollTo(0 , 0);
            isMenuOpen = true;
        }
    }

    /**
     * 菜单状态切换
     */
    public void toggleMenu(){
        if (isMenuOpen){
            closeMenu();
        }else {
            openMenu();
        }
    }
}
