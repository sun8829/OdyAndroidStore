package com.huaye.odyandroidstore.expandablelist;

import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;

import java.util.List;

public class ExpandableActivity extends BaseActivity implements ExpandView {
    private RecyclerView fileRv;
    private FileAdapter adapter;
    private ExpandablePresenter presenter;

    @Override
    protected void init() {
        super.init();
        adapter = new FileAdapter();
        presenter = new ExpandablePresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_expandable;
    }

    @Override
    protected void initView() {
        fileRv = (RecyclerView) findViewById(R.id.fileRv);
        fileRv.setLayoutManager(new LinearLayoutManager(this));
        fileRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getFiles(-1, Environment.getExternalStorageDirectory().getAbsolutePath());

    }

    @Override
    protected void initListener() {
        super.initListener();
        fileRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                FilesMultiEntity entity = (FilesMultiEntity) adapter.getItem(position);
                if (entity.isExpand) {
                    adapter.collapse(position);
                } else {
                    presenter.getFiles(position, entity.directory);
                }
            }
        });
    }

    @Override
    public void fillData(int position, List<FilesMultiEntity> list) {
        adapter.setNewData(list);
        if (position > -1) {
            adapter.expand(position);
        }
    }

}
