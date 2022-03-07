package com.example.charavidhi.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charavidhi.R;
import com.example.charavidhi.databinding.FragmentMoreBinding;
import com.example.charavidhi.databinding.FragmentTransportBinding;


public class TransportFragments extends Fragment {
      FragmentTransportBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentTransportBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.submit =(Button)view.findViewById(R.id.submit);
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationDialog();
                binding.fullName.getText().clear();
                binding.mobileNo.getText().clear();
                binding.email.getText().clear();
                binding.address.getText().clear();
                binding.destinationAddress.getText().clear();
                binding.cattleBreed.getText().clear();
                binding.cattleWeight.getText().clear();

            }
        });
    }


    private void confirmationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_transportconfirmation_layout, null, false);
        builder.setView(view);
        builder.setTitle("Transport");
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        }).create().show();
    }
}