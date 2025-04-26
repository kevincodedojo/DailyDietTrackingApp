package com.example.dailydiettrackingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailydiettrackingapp.Database.entities.DietTip;
import com.example.dailydiettrackingapp.R;

import java.util.List;

public class DietTipsAdapter extends RecyclerView.Adapter<DietTipsAdapter.DietTipViewHolder> {

    private List<DietTip> dietTips;

    public DietTipsAdapter(List<DietTip> dietTips) {
        this.dietTips = dietTips;
    }

    public void setDietTips(List<DietTip> tips) {
        this.dietTips = tips;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DietTipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_diet_tip, parent, false);
        return new DietTipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DietTipViewHolder holder, int position) {
        DietTip tip = dietTips.get(position);
        holder.tipTitleTextView.setText(tip.getTitle());
        holder.tipDescriptionTextView.setText(tip.getDescription());
    }

    @Override
    public int getItemCount() {
        return dietTips != null ? dietTips.size() : 0;
    }

    static class DietTipViewHolder extends RecyclerView.ViewHolder {
        TextView tipTitleTextView, tipDescriptionTextView;

        public DietTipViewHolder(@NonNull View itemView) {
            super(itemView);
            tipTitleTextView = itemView.findViewById(R.id.tipTitleTextView);
            tipDescriptionTextView = itemView.findViewById(R.id.tipDescriptionTextView);
        }
    }
}