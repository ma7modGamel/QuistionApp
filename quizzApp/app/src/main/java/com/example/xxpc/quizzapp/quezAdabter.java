package com.example.xxpc.quizzapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class quezAdabter extends RecyclerView.Adapter<quezAdabter.holder> {
    Context context;
    ArrayList<modelQuestions> modelQuestionsArrayList;

    public quezAdabter(Context context, ArrayList<modelQuestions> modelQuestionsArrayList) {
        this.context = context;
        this.modelQuestionsArrayList = modelQuestionsArrayList;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_of_question_design, parent, false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {

        modelQuestions questions = modelQuestionsArrayList.get(position);
        holder.valueOfNumQuis.setText(position+1+"");
        holder.typeOfQuis.setText(questions.typeQ+"");
        if(holder.typeOfQuis.getText().equals("r")){
            holder.typeOfQuis.setText("RadioButton");
        }else if(holder.typeOfQuis.getText().equals("e")){
            holder.typeOfQuis.setText("EditText");
        }else if(holder.typeOfQuis.getText().equals("c")){
            holder.typeOfQuis.setText("CheckBox");
        }else{
            Toast.makeText(context, holder.typeOfQuis.getText()+"010", Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public int getItemCount() {
        return modelQuestionsArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {


        TextView stateOfQuis;
        TextView valueOfNumQuis;
        TextView typeOfQuis;
        ImageView imgQuz;
        public holder(View itemView) {
            super(itemView);
            typeOfQuis = itemView.findViewById(R.id.typeOfQuis);
            valueOfNumQuis = itemView.findViewById(R.id.valueOfNumQuis);
            stateOfQuis = itemView.findViewById(R.id.stateOfQuis);
            imgQuz = itemView.findViewById(R.id.img);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int adapterPosition = getAdapterPosition();
                    Intent intent=new Intent(view.getContext(),ShowQuisActivity.class);
                    modelQuestions modelQuestions = modelQuestionsArrayList.get(adapterPosition);
                     intent.putExtra("modelQuestions" , modelQuestions);
                    ((Activity)view.getContext()).startActivityForResult(intent,1);
                }
            });

        }

    }
}
