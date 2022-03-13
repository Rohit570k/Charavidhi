package com.example.charavidhi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.charavidhi.databinding.ActivityCattleDetailsBinding;
import com.example.charavidhi.databinding.ActivitySellingDetailsBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Objects;

public class SellingDetails extends AppCompatActivity {
    //String[] items =  {"Material","Design","Components","Android","5.0 Lollipop"};
    String[] cattleGenderItems ;
    String[] cattleAgeItems;
    String[] cattleLactationItems;
    ArrayAdapter<String> adapterGender;
    ArrayAdapter<String > adapterAge;
    ArrayAdapter<String > adapterLactation;
    private ActivitySellingDetailsBinding binding;
    private Uri uri1,uri2,uri3,uri4;
    private String sellerName,sellerPlace;
  private int  cattleweight,cattleMilk,sellerPrice;
  private  long sellerPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySellingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cattleGenderItems = getResources().getStringArray(R.array.cattleGender);
         cattleAgeItems=getResources().getStringArray(R.array.cattleAge);
         cattleLactationItems=getResources().getStringArray(R.array.cattleLactation);

        binding.cattleGenderEdt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
//                if(id==0){
//                    Log.e("TAG", "onItemSelected: "+parent.getId()+id);
//                }
//                Log.e("TAG", "onItemSelected: "+parent.getId());
              //  Toast  .makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
                if(item.equals("Male")){
                    binding.pregConstraint.setVisibility(View.GONE);
                }
                else{
                    if((binding.cattleAgeEdt.getText().toString().equals(adapterAge.getItem(0)))){
                        binding.pregConstraint.setVisibility(View.GONE);
                    }else {
                        binding.pregConstraint.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        binding.cattleAgeEdt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(item.equals("Less than 1")){
                    binding.pregConstraint.setVisibility(View.GONE);
                }else {
                    if(binding.cattleGenderEdt.getText().toString().equals("Male")){
                        binding.pregConstraint.setVisibility(View.GONE);
                    }else{
                        binding.pregConstraint.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
        binding.cattlePregnanatEdt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    binding.textView35.setVisibility(View.VISIBLE);
                    binding.textInputLayout2.setVisibility(View.VISIBLE);
                    binding.textView36.setVisibility(View.VISIBLE);
                    binding.editTextNumber.setVisibility(View.VISIBLE);
                }else{
                    binding.textView35.setVisibility(View.INVISIBLE);
                    binding.textInputLayout2.setVisibility(View.INVISIBLE);
                    binding.textView36.setVisibility(View.INVISIBLE);
                    binding.editTextNumber.setVisibility(View.INVISIBLE);
                }
            }
        });

        binding.uploadFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(SellingDetails.this)
                        .crop(4f,3f)
                        .compress(1024)	//Final image size will be less than 1 MB
                        // .saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)) ////  Path: /storage/sdcard0/Android/data/package/files/Pictures
                        .start(100);
            }
        });
        binding.uploadSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(SellingDetails.this)
                        .crop(4f,3f)
                        .compress(1024)	//Final image size will be less than 1 MB
                        // .saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)) ////  Path: /storage/sdcard0/Android/data/package/files/Pictures
                        .start(200);
            }
        });
        binding.uploadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(SellingDetails.this)
                        .crop(4f,3f)
                        .compress(1024)	//Final image size will be less than 1 MB
                        // .saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)) ////  Path: /storage/sdcard0/Android/data/package/files/Pictures
                        .start(300);
            }
        });
        binding.uploadAngled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(SellingDetails.this)
                        .crop(4f,3f)
                        .compress(1024)	//Final image size will be less than 1 MB
                        // .saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)) ////  Path: /storage/sdcard0/Android/data/package/files/Pictures
                        .start(400);
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (areFieldReady()) {
                    if ( uri2 != null ) {
                        formSubmission();
                    } else {
                        Toast.makeText(SellingDetails.this, "Upload Side Image", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterGender = new ArrayAdapter<String>(this, R.layout.spinner_dropdown_item,cattleGenderItems);
//        adapterItems.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.cattleGenderEdt.setAdapter(adapterGender);
        binding.cattleGenderEdt.setText(adapterGender.getItem(0),false);
        Log.e("TAG", "onCreate: "+adapterGender.getItem(0)+binding.cattleGenderEdt.getText().toString());
        //Toast  .makeText(this,"Item: "+autoCompleteTxt.getText().toString(),Toast.LENGTH_SHORT).show();

        adapterAge=new ArrayAdapter<String >(this,R.layout.spinner_dropdown_item,cattleAgeItems);
        binding.cattleAgeEdt.setAdapter(adapterAge);
        binding.cattleAgeEdt.setText(adapterAge.getItem(0),false);

        adapterLactation= new ArrayAdapter<String>(this,R.layout.spinner_dropdown_item,cattleLactationItems);
        binding.cattlelactationEdt.setAdapter(adapterLactation);
        binding.cattlelactationEdt.setText(adapterLactation.getItem(0),false);
    }

    private boolean areFieldReady() {
//        cattleweight =Integer.parseInt(binding.cattleweightEdt.getText().toString().trim());
//        cattleMilk =Integer.parseInt(binding.editTextNumber.getText().toString().trim());
//        sellerPrice =Integer.parseInt(binding.sellerPriceEdt.getText().toString().trim());
//
        sellerName =binding.fullName.getText().toString().trim();
//        sellerPlace =binding.sellerPlaceEdt.getText().toString().trim();
//        sellerPhone =Long.parseLong(binding.mobileNo.getText().toString().trim());

        boolean flag = false;
        View requestView = null;

        if(sellerName.isEmpty()){
            binding.fullName.setError("Field is Required");
            flag=true;
            requestView=binding.fullName;
        }else if(binding.sellerPlaceEdt.getText().toString().trim().isEmpty()){
            binding.sellerPlaceEdt.setError("Field is Required");
            flag=true;
            requestView=binding.sellerPlaceEdt;
        }else if(binding.sellerPriceEdt.getText().toString().trim().isEmpty()){
            binding.sellerPriceEdt.setError("Field is Required");
            flag=true;
            requestView=binding.sellerPriceEdt;
        }else if(binding.mobileNo.getText().toString().trim().isEmpty()){
            binding.mobileNo.setError("Field is Required");
            flag=true;
            requestView=binding.mobileNo;
        }else if(binding.cattleweightEdt.getText().toString().trim().isEmpty()){
            binding.cattleweightEdt.setError("Field is Required");
            flag=true;
            requestView=binding.cattleweightEdt;
        }else if(binding.pregConstraint.getVisibility()==View.VISIBLE && binding.cattlePregnanatEdt.isChecked()){
            if(binding.editTextNumber.getText().toString().trim().isEmpty()){
                binding.editTextNumber.setError("Field is Required");
                flag=true;
                requestView=binding.editTextNumber;
            }
        }
        if (flag) {
            requestView.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void formSubmission() {
        confirmationDialog();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if(requestCode==100){
                uri1 =data.getData();
                binding.cattleFrontImageEdt.setImageURI(uri1);
                binding.cattleFrontImageEdt.setVisibility(View.VISIBLE);
                binding.uploadFront.setText("Replace Front Image");
            }
            else  if(requestCode==200){
                uri2 =data.getData();
                binding.cattleSideImageEdt.setImageURI(uri2);
                binding.cattleSideImageEdt.setVisibility(View.VISIBLE);
                binding.uploadSide.setText("Replace Side Image");
            }else if(requestCode==300){
                uri3 =data.getData();
                binding.cattleBackImageEdt.setImageURI(uri3);
                binding.cattleBackImageEdt.setVisibility(View.VISIBLE);
                binding.uploadBack.setText("Replace Back Image");
            }else if(requestCode==400){
                uri4 =data.getData();
                binding.cattleAngledImageEdt.setImageURI(uri4);
                binding.cattleAngledImageEdt.setVisibility(View.VISIBLE);
                binding.uploadAngled.setText("Replace Angled Image");
            }

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    private void confirmationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_sell_confirmation_layout, null, false);
        builder.setView(view);
        builder.setCancelable(false);
        builder.setTitle("Cattle Added SuccessFully");
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(SellingDetails.this, MainActivity.class));
                finish();
            }

        }).create().show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}