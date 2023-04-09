package com.example.employeedatasqliteapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.Normalizer;
import java.util.ArrayList;

public class FormRVAdapter extends RecyclerView.Adapter<FormRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<formModal> courseModalArrayList;
    private Context context;

    private DBHandler dbHandler;

    // constructor
    public FormRVAdapter(ArrayList<formModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.form_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        formModal modal = courseModalArrayList.get(position);
        holder.idTV.setText(String.valueOf(modal.getId()));
        holder.nameTV.setText(modal.getName());
        holder.dobTV.setText(modal.getDob());
        holder.salaryTV.setText(modal.getSalary());
        holder.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateFormActivity.class);
                // below we are passing all our values.
                i.putExtra("id1",modal.getId());
                i.putExtra("name", modal.getName());
                i.putExtra("dob", modal.getDob());
                i.putExtra("salary", modal.getSalary());

                // starting our activity.
                context.startActivity(i);
            }
        });
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler = new DBHandler(context);
                dbHandler.deleteForm(modal.getId());
                Toast.makeText(context, "Course Deleted..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(context, ViewForms.class);

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView idTV, nameTV, dobTV, salaryTV;
        private Button updateBtn, deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            idTV=itemView.findViewById(R.id.idTVId);
            nameTV = itemView.findViewById(R.id.idTVName);
            dobTV = itemView.findViewById(R.id.idTVDOB);
            salaryTV = itemView.findViewById(R.id.idTVSalary);
            updateBtn=itemView.findViewById(R.id.updateBtn);
            deleteBtn=itemView.findViewById(R.id.deleteBtn);
        }
    }
}

