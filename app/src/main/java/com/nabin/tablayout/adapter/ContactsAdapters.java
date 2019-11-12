package com.nabin.tablayout.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nabin.tablayout.DisplayMain;
import com.nabin.tablayout.R;

import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import model.Contacts;

public class ContactsAdapters extends RecyclerView.Adapter<ContactsAdapters.ContactsViewHolder> {
    Context context;
    List<Contacts> contactsList;

    public ContactsAdapters(Context context, List<Contacts> contactsList) {
        this.context = context;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contacts,parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final Contacts contacts = contactsList.get(position);
        holder.img.setImageResource(contacts.getImage());
        holder.txname.setText(contacts.getName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayMain.class);
                intent.putExtra("image",contacts.getImage());
                intent.putExtra("name",contacts.getName());
                intent.putExtra("number",contacts.getNumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView txname,txnumber;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.circleimg);
            txname=itemView.findViewById(R.id.txtname);
            txnumber=itemView.findViewById(R.id.txtnumber);
        }
    }
}

