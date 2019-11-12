package com.nabin.tablayout.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.nabin.tablayout.R;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nabin.tablayout.adapter.ContactsAdapters;


import java.util.ArrayList;
import java.util.List;

import model.Contacts;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=root.findViewById(R.id.recyclerView);
        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("abc","9898466",R.drawable.kurt));
        contactsList.add(new Contacts("nabin","9898466",R.drawable.noimage));
        contactsList.add(new Contacts("shrestha","9898466",R.drawable.jim));
        contactsList.add(new Contacts("ram","9898466",R.drawable.john));
        contactsList.add(new Contacts("sita","9898466",R.drawable.kurt));
        contactsList.add(new Contacts("hari","9898466",R.drawable.jim));
        contactsList.add(new Contacts("mohan","9898466",R.drawable.john));
        contactsList.add(new Contacts("acer","9898466",R.drawable.noimage));
        contactsList.add(new Contacts("dell","9898466",R.drawable.noimage));
        contactsList.add(new Contacts("hero","9898466",R.drawable.jim));
        contactsList.add(new Contacts("jim","9898466",R.drawable.noimage));
        contactsList.add(new Contacts("kurt","9898466",R.drawable.noimage));
        contactsList.add(new Contacts("john","9898466",R.drawable.kurt));
        ContactsAdapters contactsAdapter = new ContactsAdapters(getActivity(),contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}