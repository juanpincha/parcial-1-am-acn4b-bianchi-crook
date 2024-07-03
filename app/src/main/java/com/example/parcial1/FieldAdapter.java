package com.example.parcial1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.FieldViewHolder> {

    private List<String> fieldList;
    private OnFieldClickListener onFieldClickListener;

    public interface OnFieldClickListener {
        void onFieldClick(String fieldName);
    }

    public FieldAdapter(List<String> fieldList, OnFieldClickListener onFieldClickListener) {
        this.fieldList = fieldList;
        this.onFieldClickListener = onFieldClickListener;
    }

    @NonNull
    @Override
    public FieldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_field, parent, false);
        return new FieldViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FieldViewHolder holder, int position) {
        String fieldName = fieldList.get(position);
        holder.fieldNameTextView.setText(fieldName);
        holder.reserveButton.setOnClickListener(v -> onFieldClickListener.onFieldClick(fieldName));
    }

    @Override
    public int getItemCount() {
        return fieldList.size();
    }

    static class FieldViewHolder extends RecyclerView.ViewHolder {
        TextView fieldNameTextView;
        Button reserveButton;

        FieldViewHolder(@NonNull View itemView) {
            super(itemView);
            fieldNameTextView = itemView.findViewById(R.id.fieldNameTextView);
            reserveButton = itemView.findViewById(R.id.reserveButton);
        }
    }
}

