package com.example.finalprojectexpensemanager.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectexpensemanager.R;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectexpensemanager.Entity.ExpenseTable;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseHolder> {
    private List<ExpenseTable> expenses = new ArrayList<>();
    OnItemClickListner listner;

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {
        ExpenseTable expenseTable = expenses.get(position);
        holder.expenseName.setText(expenseTable.getExpenseName());
        holder.desc.setText(expenseTable.getDescription());
        holder.amount.setText(expenseTable.getAmount());
        holder.date.setText(expenseTable.getDate());
        holder.categoryText.setText(expenseTable.getCategory());
        switch ((String) holder.categoryText.getText()) {
            case "Food":
                holder.categoryImage.setImageResource(R.drawable.img_black_food);
                break;
            case "Travel":
                holder.categoryImage.setImageResource(R.drawable.img_black_travel);
                break;
            case "Utilities":
                holder.categoryImage.setImageResource(R.drawable.img_black_utilities);
                break;
            case "Health":
                holder.categoryImage.setImageResource(R.drawable.img_black_health);
                break;
            case "Shopping":
                holder.categoryImage.setImageResource(R.drawable.img_black_shopping);
                break;
            case "Others":
                holder.categoryImage.setImageResource(R.drawable.img_black_other);
                break;


        }

    }

    public void setNotes(List<ExpenseTable> expenses) {
        this.expenses = expenses;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return expenses.size();
    }

    class ExpenseHolder extends RecyclerView.ViewHolder {
        private TextView expenseName;
        private TextView amount;
        private TextView desc;
        private TextView date;
        private TextView categoryText;
        private ImageView categoryImage;

        public ExpenseHolder(View view) {
            super(view);
            expenseName = view.findViewById(R.id.expenseName);
            amount = view.findViewById(R.id.amount);
            desc = view.findViewById(R.id.desc);
            date = view.findViewById(R.id.date);
            categoryImage = view.findViewById(R.id.categoryImage);
            categoryText = view.findViewById(R.id.categoryText);

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION)
                        listner.onItemClick(expenses.get(position));
                }
            });
        }
    }

    public interface OnItemClickListner {
        void onItemClick(ExpenseTable expense);
    }

}


