package com.example.finalprojectexpensemanager.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.List;

import com.example.finalprojectexpensemanager.Entity.ExpenseTable;
import com.example.finalprojectexpensemanager.Repository.ExpenseRepository;

public class AllExpenseViewModel extends AndroidViewModel {
    private ExpenseRepository expenseRepository;
    private List<ExpenseTable> AllExpense;

    public AllExpenseViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        AllExpense = expenseRepository.getAllExpenses();
    }

    public List<ExpenseTable> getAllExpense() {
        AllExpense = ExpenseRepository.getAllExpenses();
        return AllExpense;
    }

    public ExpenseTable myDelete(int adapterPosition) {
        return expenseRepository.myDelete(adapterPosition);
    }

    public ExpenseTable editExpense(int adapterPosition) {
        return expenseRepository.editExpense(adapterPosition);
    }
}
