package com.example.charavidhi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.charavidhi.AboutActivity;
import com.example.charavidhi.AccountsActivity;
import com.example.charavidhi.R;
import com.example.charavidhi.TransportActivity;
import com.example.charavidhi.databinding.FragmentMoreBinding;

public class MoreFragment extends Fragment {

    private FragmentMoreBinding binding;
    HostelFragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentMoreBinding.inflate(inflater, container, false);




        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       fragment=new HostelFragment();
        Toolbar toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle(" ");

        binding.veterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });
        binding.nearbyDairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        binding.aboutus.setOnClickListener((new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Intent settingsIntent = new Intent(getContext(), AboutActivity.class);
                startActivity(settingsIntent);
            }
        }));

        binding.getTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(getContext(), TransportActivity.class);
                startActivity(settingsIntent);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.accountmenu) {
            Log.i("item id ", item.getItemId() + "");
            Intent settingsIntent = new Intent(getContext(), AccountsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.top_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}