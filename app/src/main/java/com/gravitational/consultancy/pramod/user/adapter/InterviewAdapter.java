package com.gravitational.consultancy.pramod.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.gravitational.consultancy.pramod.user.R;


import com.gravitational.consultancy.pramod.user.dash.Job_Description;
import com.gravitational.consultancy.pramod.user.model.ListItem;

import java.util.List;




public class InterviewAdapter extends RecyclerView.Adapter<InterviewAdapter.ViewHolder>{
    private List<ListItem> listItems;
    private Context context;

    public InterviewAdapter(List<ListItem> listItems, Context context) {

        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ittem,parent,false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ListItem listItem = listItems.get(position);

        Log.d("listItem",listItem.getJobTitle());
            final String  company = listItem.getCompany();
            holder.Condidate_company.setText(company);



        holder.Condidate_job.setText(listItem.getJobTitle());
        holder.Condidate_adress.setText(listItem.getAddress());


        holder.Condidate_experience.setText(listItem.getExperience());
        holder.Condidate_post_date.setText(listItem.getPostDate());
        holder.Condidate_post.setText(listItem.getPost());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String  company = listItem.getCompany();
                final String  jobtitle = listItem.getJobTitle();
                final String  date = listItem.getPostDate();
                final String  address = listItem.getAddress();
                final String  experience = listItem.getExperience();
                final String  salary = listItem.getSalary();
                final String  Contact_name = listItem.getContract_name();
                final String  contract_mob = listItem.getContract_mobile();
                final String  comment = listItem.getComment();
                Intent i = new Intent(context, Job_Description.class);

                i.putExtra("COMPANY_KEY",company);
                i.putExtra("JOBTITLE_KEY",jobtitle);
                i.putExtra("DATE_KEY",date);
                i.putExtra("ADDRESS_KEY",address);
                i.putExtra("EXIPERENCE_KEY",experience);
                i.putExtra("SALARY_KEY",salary);
                i.putExtra("CONTRACT_NAME",Contact_name);
                i.putExtra("CONTRACT_MOBILE",contract_mob);
                i.putExtra("COMMENT_KEY",comment);
                context.startActivity(i);

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


            Condidate_company = itemView.findViewById(R.id.company);
            Condidate_job = itemView.findViewById(R.id.noida_naukari);
            Condidate_adress = itemView.findViewById(R.id.address);
            Condidate_experience = itemView.findViewById(R.id.experience);
            Condidate_post_date = itemView.findViewById(R.id.post_date);
            Condidate_post = itemView.findViewById(R.id.Post);

            linearLayout = itemView.findViewById(R.id.liner);

        }
    }

}