package com.huaye.odyandroidstore.imitate.taobao;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huaye.odyandroidstore.R;
import com.huaye.odyandroidstore.base.BaseActivity;
import com.huaye.odyandroidstore.retrofit.taobao.ProductAdapter;
import com.huaye.odyandroidstore.retrofit.taobao.TaoBaoProductBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 高仿淘宝搜索结果页
 * Samuel
 */
public class TaobaoSearchResultActivity extends BaseActivity implements SearchResultView {

    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.tabs)
    LinearLayout tabs;

    @BindView(R.id.mps)
    RecyclerView mps;
    private int page = 1;
    private ProductAdapter adapter;
    private SearchResultPresenter presenter;

    @Override
    protected void init() {
        super.init();
        adapter = new ProductAdapter();
        presenter = new SearchResultPresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_taobao_search_result;
    }


    @Override
    protected void initView() {
        ButterKnife.bind(this);
        toolBar.setNavigationIcon(R.mipmap.taobao_back);
        toolBar.setTitle("");
        setSupportActionBar(toolBar);

        mps.setLayoutManager(new LinearLayoutManager(this));
        mps.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getProductList("SD卡", page);
    }

    @Override
    protected void initListener() {
        super.initListener();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getProductList("SD卡", ++page);
            }
        }, mps);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_taobao, menu);
        return true;
    }

    @Override
    public void showProduct(List<TaoBaoProductBean.Product> list) {
        adapter.setNewData(list);
    }

    @Override
    public void addProduct(List<TaoBaoProductBean.Product> list) {
        adapter.addData(list);
        adapter.loadMoreComplete();
    }
}
