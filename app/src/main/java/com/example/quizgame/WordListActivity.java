package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_word_list);

      // สร้าง Layout manager
      LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);

      // สร้าง Adapter object
      MyAdapter adapter = new MyAdapter();

      // เข้าถึง  RecyclerView ใน layout
      RecyclerView rv = findViewById(R.id.word_list_recycler_view);
      rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
      rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView

   }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private WordItem[] items = {
         new WordItem(R.drawable.baby_mild, "Baby Mild","เบบี้มายด์"),
         new WordItem(R.drawable.comfort, "Comfort","คอมฟอร์ท"),
         new WordItem(R.drawable.d_nee, "D-nee","ดี-นี่"),
         new WordItem(R.drawable.downy, "Downy","ดาวน์นี่"),
         new WordItem(R.drawable.essence, "Essence","เอสเซ้นซ์"),
         new WordItem(R.drawable.fineline, "Fineline", "ไฟน์ไลน์ "),
         new WordItem(R.drawable.fresh_soft, "Fresh & Soft","เฟรช แอนด์ ซอฟท์"),
         new WordItem(R.drawable.hi_class, "Hi Class","ไฮคลาส"),
         new WordItem(R.drawable.hygiene, "Hygiene","ไฮยีน"),
         new WordItem(R.drawable.pipper, "Pipper","พิพเพอร์"),


   };


   MyAdapter() {

   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_word, parent, false);
      MyViewHolder vh = new MyViewHolder(v);
      return vh;
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.imageView.setImageResource(items[position].imageResId);
      holder.wordTextView.setText(items[position].word);
      holder.THwordTextview.setText(items[position].THword);

   }

   @Override
   public int getItemCount() {
      return items.length;
   }

   static class MyViewHolder extends RecyclerView.ViewHolder {
     public ImageView imageView;
     public TextView wordTextView;
     public TextView THwordTextview;

      MyViewHolder(@NonNull View itemView) {
         super(itemView);
         imageView = itemView.findViewById(R.id.image_view);
         wordTextView = itemView.findViewById(R.id.word_text_view);
         THwordTextview = itemView.findViewById(R.id.THword_text_view);
      }
   }
}