package com.gravitational.consultancy.pramod.user.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gravitational.consultancy.pramod.user.R;
import com.gravitational.consultancy.pramod.user.data.model.DownloadItem;

import java.util.List;

public class DowonloadAdapter extends RecyclerView.Adapter<DowonloadAdapter.ViewHolder>{
    private List<DownloadItem> listItems;
    private Context context;

    public DowonloadAdapter(List<DownloadItem> listItems, Context context) {

        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_download,parent,false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final DownloadItem listItem = listItems.get(position);

        Log.d("listItem",listItem.getPdf());
        final String  company = listItem.getPdf();
        holder.Condidate_adress.setText(company);



        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
    /***************************swipe throw date Remove****************/


    public void removeItem(int adapterPosition) {

        listItems.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView Condidate_company;
        public TextView Condidate_job;
        public TextView Condidate_adress;
        public TextView Condidate_experience;
        public TextView Condidate_post;

        public TextView Condidate_post_date;
        private LinearLayout linearLayout;




        public ViewHolder(View itemView) {
            super(itemView);


            Condidate_adress = itemView.findViewById(R.id.download_pdf_document);



            linearLayout = itemView.findViewById(R.id.liner);

        }
    }

}