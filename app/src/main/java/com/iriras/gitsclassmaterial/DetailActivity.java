package com.iriras.gitsclassmaterial;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.iriras.gitsclassmaterial.base.BaseActivity;
import com.iriras.gitsclassmaterial.util.SmoothScrollBehavior;
import com.iriras.gitsclassmaterial.util.SquareImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_CHEFF = "EXTRA_CHEFF";
    public static final String EXTRA_DESC = "EXTRA_DESC";
    public String mUrlImage, mName, mDesc, mDateCheff;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.img_detail)
    SquareImageView mImgDetail;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.txt_detail_name)
    TextView mTxtName;
    @BindView(R.id.txt_detail_desc)
    TextView mTxtDesc;
    @BindView(R.id.txt_detail_date_cheff)
    TextView mTxtDateCheff;
    @BindView(R.id.nested_detail)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.fab_comment)
    FloatingActionButton mFabComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        /**
         * toolbar config
         */
        setToolbar();

        /**
         * get intent image end set to view
         */
        mUrlImage = getIntent().getStringExtra(EXTRA_IMAGE);
        mName = getIntent().getStringExtra(EXTRA_NAME);
        mDesc = getIntent().getStringExtra(EXTRA_DESC);
        mDateCheff = getIntent().getStringExtra(EXTRA_CHEFF);

        ViewCompat.setTransitionName(mImgDetail, EXTRA_IMAGE);
        ViewCompat.setTransitionName(mTxtName, EXTRA_NAME);
        ViewCompat.setTransitionName(mTxtDesc, EXTRA_DESC);
        ViewCompat.setTransitionName(mTxtDateCheff, EXTRA_CHEFF);

        Picasso.with(DetailActivity.this).load(mUrlImage).into(mImgDetail);
        mTxtName.setText(mName);
        mTxtDesc.setText(mDesc);
        mTxtDateCheff.setText("Friday, 02 Oct 1992 - by " + mDateCheff);

        /**
         * smooth collapsing with nestedscrollview config
         */
        CoordinatorLayout.LayoutParams mParams = (CoordinatorLayout.LayoutParams) mAppBarLayout.getLayoutParams();
        mParams.setBehavior(new SmoothScrollBehavior(R.id.nested_detail));

        /**
         * bottom sheet config
         */
        final BottomSheetDialogFragment myBottomSheet = MyBottomSheetDialogFragment.newInstance("Modal Bottom Sheet");
        mFabComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBottomSheet.show(getSupportFragmentManager(), myBottomSheet.getTag());
            }
        });
    }

    public void setToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            supportFinishAfterTransition();
        }
        return super.onOptionsItemSelected(item);
    }
}
