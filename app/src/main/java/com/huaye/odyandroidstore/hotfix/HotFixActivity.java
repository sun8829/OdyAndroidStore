package com.huaye.odyandroidstore.hotfix;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotFixActivity extends BaseActivity {
    @BindView(R.id.toast)
    TextView toast;

    @BindView(R.id.download)
    Button download;

    @Override
    protected int bindLayout() {
        return R.layout.activity_hot_fix;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    private void showTip() {
        ToastUtils.showLongToast("new");
    }

    @Override
    protected void initListener() {
        super.initListener();
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTip();
            }
        });
    }
}
