package com.example.charavidhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.charavidhi.databinding.ActivitySellingDetailsBinding;
import com.example.charavidhi.databinding.ActivityTransportBinding;

public class TransportActivity extends AppCompatActivity {

    ActivityTransportBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_transportconfirmation_layout, null, false);
        builder.setView(view);
        builder.setTitle("Transport");
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        }).create().show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}