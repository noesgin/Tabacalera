package com.example.noelia.tabacalera.workshops;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.noelia.tabacalera.R;
import com.example.noelia.tabacalera.events.EventsActivity;
import com.example.noelia.tabacalera.events.EventsDetailActivity;

import java.util.ArrayList;

/**
 * Created by Noelia on 13/08/2016.
 */
public class WorkshopsRecyclerAdapter extends RecyclerView.Adapter<WorkshopsRecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<WorkshopsDataProvider> list = new ArrayList<>();
    private Context context;
    private final String type;

    public WorkshopsRecyclerAdapter(ArrayList<WorkshopsDataProvider> list, Context context, String type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutResId = 0;
        if (type.equals(WorkshopsActivity.class.getSimpleName())) {
            layoutResId = R.layout.item_workshops;
        } else if (type.equals(EventsActivity.class.getSimpleName())) {
            layoutResId = R.layout.item_events;
        }

        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(itemView, context, list, type);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        WorkshopsDataProvider dataProvider = list.get(position);
        holder.tvName.setText(dataProvider.getName());
        holder.tvSchedule.setText(dataProvider.getSchedule());
//        holder.tvDescription.setText(dataProvider.getDescription());
        Glide.with(context)
                .load(list.get(position).getIconUrl())
                .into(holder.ivImage);

//        Picasso.with(context).load(list.get(position).getIconUrl()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivImage;
        TextView tvName, tvSchedule, tvDescription;
        ArrayList<WorkshopsDataProvider> list = new ArrayList<>();
        Context context;
        private String type;

        public RecyclerViewHolder(View itemLayoutView, Context context, ArrayList<WorkshopsDataProvider> list, String type) {
            super(itemLayoutView);
            this.list = list;
            this.context = context;
            this.type= type;
            itemLayoutView.setOnClickListener(this);
            ivImage = (ImageView) itemLayoutView.findViewById(R.id.ivImage);
            tvName = (TextView) itemLayoutView.findViewById(R.id.tvName);
            tvSchedule = (TextView) itemLayoutView.findViewById(R.id.tvSchedule);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            WorkshopsDataProvider taller = this.list.get(position);

            if (type.equals(WorkshopsActivity.class.getSimpleName())) {
                Intent intent = new Intent(context, WorkshopsDetailActivity.class);
                intent.putExtra(WorkshopsDetailActivity.IMAGE, taller.getImageUrl());
                intent.putExtra(WorkshopsDetailActivity.NAME, taller.getName());
                intent.putExtra(WorkshopsDetailActivity.SCHEDULE, taller.getSchedule());
                intent.putExtra(WorkshopsDetailActivity.DESCRIPTION, taller.getDescription());
                this.context.startActivity(intent);
                ((WorkshopsActivity)context).overridePendingTransition(R.anim.left_in, R.anim.left_out);

            }else if (type.equals(EventsActivity.class.getSimpleName())) {
                Intent intent = new Intent(context, EventsDetailActivity.class);
                intent.putExtra(EventsDetailActivity.IMAGE, taller.getIconUrl());
                this.context.startActivity(intent);
                ((WorkshopsActivity)context).overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
            }
/*            intent.putExtra(WorkshopsDetailActivity.IMAGE, taller.getImage());*/
        }
    }
}


