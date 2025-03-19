package com.example.enhancingexpensetrackerapp;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    private List<Expense> expenses;

    public ExpenseAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.tvAmount.setText("Amount: " + expense.getAmount());
        holder.tvCurrency.setText("Currency: " + expense.getCurrency());
        holder.tvCreateDate.setText("Date: " + expense.getCreateDate());
        holder.tvCategory.setText("Category: " + expense.getCategory());
        holder.tvRemark.setText("Remark: " + expense.getRemark());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAmount, tvCurrency, tvCreateDate, tvCategory, tvRemark;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvCurrency = itemView.findViewById(R.id.tvCurrency);
            tvCreateDate = itemView.findViewById(R.id.tvCreateDate);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvRemark = itemView.findViewById(R.id.tvRemark);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Expense expense = expenses.get(position);
                    Intent intent = new Intent(v.getContext(), DetailExpenseActivity.class);
                    intent.putExtra("expenseId", expense.getId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}