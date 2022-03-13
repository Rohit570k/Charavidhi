package com.example.charavidhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.databinding.ActivityCattleDetailsBinding;

public class CattleDetails extends AppCompatActivity {
 private ActivityCattleDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCattleDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CattlesModel cattlesModel=getIntent().getParcelableExtra("CattlesModel");
        getSupportActionBar().setTitle(cattlesModel.getNameBreed());
        getSupportActionBar().setSubtitle(cattlesModel.getSeller());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.cattleImageDetails.setImageResource(cattlesModel.getImage());
        binding.cattleNameDetails.setText(cattlesModel.getNameBreed());
        binding.cattlePriceDetails.setText("Rs: " +cattlesModel.getPrice());
        binding.sellerplacesDetails.setText(cattlesModel.getPlace());


        binding.cattleAgeDetails.setText(cattlesModel.getAge()+" Year");
        binding.cattleGenderDetails.setText(cattlesModel.getGender());
        binding.cattleWeightDetails.setText(cattlesModel.getWeight()+" Kg");
        if(cattlesModel.getGender().equals("Male")){
            binding.cattleMilkDetails.setVisibility(View.INVISIBLE);
            binding.cattlePregnantDetails.setVisibility(View.INVISIBLE);
            binding.cattlelactationDetails.setVisibility(View.INVISIBLE);
        }


        binding.cattleMilkDetails.setText(" "+cattlesModel.getMilkQuantity());
        if(cattlesModel.getPregnanat()){
            binding.cattlePregnantDetails.setText("Yes");
            binding.cattlelactationDetails.setText(" "+cattlesModel.getLactation());
        }else{

            binding.cattlePregnantDetails.setText("No");
            binding.cattlePregnantDetails.setVisibility(View.INVISIBLE);
            binding.cattlelactationDetails.setVisibility(View.INVISIBLE);
        }

        binding.sellerNameDetail.setText(cattlesModel.getSeller());

        String breed=cattlesModel.getNameBreed();
        if(breed.contains("Tharparkar"))
            binding.cattlegeneralInfo.setText(R.string.cow_tharparkar);
        else if(breed.contains("Gir"))
            binding.cattlegeneralInfo.setText(R.string.cow_gir);
        else if(breed.contains("Rathi"))
            binding.cattlegeneralInfo.setText(R.string.cow_rathi);
        else if(breed.contains("HF"))
            binding.cattlegeneralInfo.setText(R.string.cow_hf);
        else if(breed.contains("Sindhi"))
            binding.cattlegeneralInfo.setText(R.string.cow_sindhi);
        else if(breed.contains("Jersey"))
            binding.cattlegeneralInfo.setText(R.string.cow_jersy);
        else if(breed.contains("Sahiwal"))
            binding.cattlegeneralInfo.setText(R.string.cow_sahiwal);
        else if(breed.contains("Vechur"))
            binding.cattlegeneralInfo.setText(R.string.cow_vechur);
        else if(breed.contains("Brahma"))
            binding.cattlegeneralInfo.setText(R.string.ox_brahma);
        else if(breed.contains("Ongole"))
            binding.cattlegeneralInfo.setText(R.string.ox_ongole);

        String lactation = String.valueOf(cattlesModel.getLactation());
        if(cattlesModel.getLactation()==1)
            lactation+="st";
        else if(cattlesModel.getLactation()==2)
            lactation+="nd";
        else if(cattlesModel.getLactation()==3)
            lactation+="rd";
        else
            lactation+="th";

        String cattleDescription="";
        if(cattlesModel.getGender().equals("Male")){
            cattleDescription=getString(R.string.cow_male_description,cattlesModel.getNameBreed(),
                    cattlesModel.getAge(),cattlesModel.getPlace(),cattlesModel.getPrice());
        }else if(cattlesModel.getGender().equals("Female") && cattlesModel.getPregnanat()){
             cattleDescription=getString(R.string.cow_female_y_description,cattlesModel.getNameBreed(),
                    cattlesModel.getAge(),cattlesModel.getPlace(),cattlesModel.getPrice(),
                    lactation,cattlesModel.getMilkQuantity());
        }else if(cattlesModel.getGender().equals("Female")&& !cattlesModel.getPregnanat()){
            cattleDescription=getString(R.string.cow_female_n_description,cattlesModel.getNameBreed(),
                    cattlesModel.getAge(),cattlesModel.getPlace(),cattlesModel.getPrice(),
                    cattlesModel.getMilkQuantity());
        }
        binding.cattleDescription.setText(cattleDescription);


        String phoneNumber = String.valueOf(cattlesModel.getSellerPhoneNumber());
        binding.callforBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}