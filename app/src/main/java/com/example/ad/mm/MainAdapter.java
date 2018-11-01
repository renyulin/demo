package com.example.ad.mm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private CallBack callBack;

    public MainAdapter(Context context, CallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_main, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        mHolder.adapter_item.setLayoutParams(params);
        mHolder.adapter_item_name.setText("this item is :" + position);
        mHolder.adapter_item_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout adapter_item;
        TextView adapter_item_name;
        TextView adapter_item_do;

        public ViewHolder(View itemView) {
            super(itemView);
            adapter_item = itemView.findViewById(R.id.adapter_item);
            adapter_item_name = itemView.findViewById(R.id.adapter_item_name);
            adapter_item_do = itemView.findViewById(R.id.adapter_item_do);
        }
    }

    public interface CallBack {
        public void click(int position);
    }
}
