package com.iriras.gitsclassmaterial;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.iriras.gitsclassmaterial.base.BaseActivity;
import com.iriras.gitsclassmaterial.dao.EatDao;
import com.iriras.gitsclassmaterial.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.rec_home_food)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.txt_toolbar_title)
    TextView mTxtToolbarTitle;

    public GridLayoutManager mGridLayoutManager;
    public MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        /**
         * init inject library
         */
        ButterKnife.bind(this);

        /**
         * setup toolbar
         */
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

            /**
             * toolbar title
             */
            mTxtToolbarTitle.setText("GITS Class v4 MD");
        }
        /**
         * init data for list item
         */
        List<EatDao> mData = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            if (i % 2 == 1) {
                mData.add(new EatDao("Chicken Cheese Mozarella",
                        Constant.DESCRIPTION_DUMMY,
                        Constant.IMAGE_DUMMY,
                        "46",
                        "123",
                        "10",
                        "Junna Wiryawan",
                        "Main Course"));
            } else {
                mData.add(new EatDao("Beef Cheese Mozarella",
                        Constant.DESCRIPTION_DUMMY,
                        "https://lh3.ggpht.com/fUphxSLURONhQ7UteLnVVF596L60JAZRi3cCPcGlb_NeOZPs6BRcB0QyyyurgSWoW1FKfCgKXt5r2SJeHXqe44w",
                        "25",
                        "100",
                        "15",
                        "Marinka Kolarov",
                        "Dessert"));
            }
        }

        /**
         * init list and set to recyclerview
         */
        mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mMainAdapter = new MainAdapter(MainActivity.this, mData);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mMainAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.act_home_search) {
            Toast.makeText(MainActivity.this, "Material Design App", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
