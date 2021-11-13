package com.example.rquizadmin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rquizadmin.R;

public class quiz_list_adapter extends RecyclerView.Adapter<quiz_list_adapter.quiz_list_adapter_viewholder> {
    @NonNull
    @Override
    public quiz_list_adapter_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_card_for_list,parent,false);
        return new quiz_list_adapter_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull quiz_list_adapter_viewholder holder, int position) {
        holder.text_quizname.setText("Android");
        holder.cardView.animate().scaleX(1).scaleY(1).alpha(1).setDuration(500);
    }

    @Override
    public int getItemCount() {
        return 17;
    }

    public static class quiz_list_adapter_viewholder extends RecyclerView.ViewHolder{
        TextView text_quizname, text_quizID;
        CardView cardView;
        public quiz_list_adapter_viewholder(@NonNull View itemView) {
            super(itemView);
            text_quizname = itemView.findViewById(R.id.text_quizname);
            text_quizID = itemView.findViewById(R.id.text_quizID);
            cardView = itemView.findViewById(R.id.card_quiz_id);
        }
    }
}
