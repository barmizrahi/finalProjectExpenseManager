package com.example.finalprojectexpensemanager.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectexpensemanager.R;

import java.util.ArrayList;
import java.util.List;

import com.example.finalprojectexpensemanager.Entity.ExpenseTable;
import com.example.finalprojectexpensemanager.Repository.ExpenseRepository;

public class AllTransactionAdapter extends RecyclerView.Adapter<AllTransactionAdapter.ExpenseHolder> {
    private List<ExpenseTable> expenses = new ArrayList<>();
    ExpenseAdapter.OnItemClickListner listner;

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_all_item, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {
        ExpenseTable expenseTable = expenses.get(position);
        holder.expenseName.setText(expenseTable.getExpenseName());
        holder.desc.setText(expenseTable.getDescription());
        holder.amount.setText(expenseTable.getAmount() + ExpenseRepository.coin);
        holder.date.setText(expenseTable.getDate());
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

        public ExpenseHolder(View view) {
            super(view);
            expenseName = view.findViewById(R.id.expenseName);
            amount = view.findViewById(R.id.amount);
            desc = view.findViewById(R.id.desc);
            date = view.findViewById(R.id.date);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION)
                        listner.onItemClick(expenses.get(position));
                }
            });
        }
    }

}
