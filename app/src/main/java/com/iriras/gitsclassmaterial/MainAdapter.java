package com.iriras.gitsclassmaterial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iriras.gitsclassmaterial.dao.EatDao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irfan on 09/05/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    public List<EatDao> mData = new ArrayList<>();
    public Context mContext;

    public MainAdapter(Context mContext, List<EatDao> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_row, parent, false);
        MyViewHolder mHolder = new MyViewHolder(mView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final EatDao mItem = mData.get(position);
        holder.mTxtTitle.setText(mItem.getName());
        holder.mTxtDescription.setText(mItem.getDescription());
        holder.mTxtCheff.setText("by " + mItem.getCheff());
        holder.mTxtTime.setText(mItem.getTime_cooking() + " Min");
        holder.mTxtHeartCount.setText(mItem.getLike_count());
        holder.mTxtCommentCount.setText(mItem.getComment_count());
        Picasso.with(mContext)
                .load(mItem.getImage())
                .into(holder.mImgMain);
        holder.mLinRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptionsCompat mOptions = ActivityOptionsCompat
                        .makeSceneTransitionAnimation((Activity) mContext, holder.mImgMain, DetailActivity.EXTRA_IMAGE);
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_IMAGE, mItem.getImage());
                intent.putExtra(DetailActivity.EXTRA_NAME, mItem.getName());
                intent.putExtra(DetailActivity.EXTRA_DESC, mItem.getDescription());
                intent.putExtra(DetailActivity.EXTRA_CHEFF, mItem.getCheff());
                ActivityCompat.startActivity(mContext, intent, mOptions.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_main_title_row)
        TextView mTxtTitle;
        @BindView(R.id.txt_main_desc_row)
        TextView mTxtDescription;
        @BindView(R.id.txt_main_cheff_row)
        TextView mTxtCheff;
        @BindView(R.id.txt_main_time_row)
        TextView mTxtTime;
        @BindView(R.id.txt_main_heart_count_row)
        TextView mTxtHeartCount;
        @BindView(R.id.txt_main_comment_count_row)
        TextView mTxtCommentCount;
        @BindView(R.id.img_main_row)
        ImageView mImgMain;
        @BindView(R.id.lin_main_row)
        LinearLayout mLinRow;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
