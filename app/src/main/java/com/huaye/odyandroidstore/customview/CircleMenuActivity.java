package com.huaye.odyandroidstore.customview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.huaye.circlemenu.CircleMenuLayout;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleMenuActivity extends BaseActivity {
    @BindView(R.id.id_menu_layout)
    CircleMenuLayout circleMenu;
    private List<Menu> menuList = new ArrayList<>();

    private String[] mItemTexts = new String[]{"安全中心 ", "特色服务", "投资理财",
            "转账汇款", "我的账户", "信用卡"};
    private int[] mItemImgs = new int[]{R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal, R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal, R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal};


    @Override
    protected int bindLayout() {
        return R.layout.activity_circle_menu;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);


    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < mItemTexts.length; i++) {
            Menu m = new Menu();
            m.imgId = mItemImgs[i];
            m.label = mItemTexts[i];
            menuList.add(m);
        }
        circleMenu.setMenus(menuList, new CircleMenuLayout.OnLoadResCallback() {

            @Override
            public void showItem(Object o, ImageView img, TextView txt) {
                Menu m = (Menu) o;
                Glide.with(mContext).load(m.imgId).into(img);
                txt.setText(m.label);
            }
        });
//        circleMenu.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
    }

    @Override
    protected void initListener() {
        super.initListener();
        circleMenu.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener(){

            @Override
            public void itemClick(View view, int pos)
            {
                Toast.makeText(CircleMenuActivity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void itemCenterClick(View view)
            {
                Toast.makeText(CircleMenuActivity.this,
                        "you can do something just like ccb  ",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    private static class Menu{
        public int imgId;
        public String label;
    }
}
