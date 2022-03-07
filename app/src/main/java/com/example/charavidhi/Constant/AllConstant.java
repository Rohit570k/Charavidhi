package com.example.charavidhi.Constant;

import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface AllConstant {
    List<CattlesModel> cattleslist=new ArrayList<>(
            Arrays.asList(
                    new CattlesModel("Rajesh","Tharparkar Ox", R.drawable.cow_tharparkar, (long) 50000,
                            "Patna",8,"Female",30,true,5,420,(long)1352505079),
                    new CattlesModel("Rohan ","Gir Cow",R.drawable.cow_gir, (long) 30000,
                            "Patna",5,"Female",20,false,0,320,(long)1234567890),
                    new CattlesModel("Shiv","Brahma Ox", R.drawable.ox_brahma,(long) 15000,
                            "Danapur Patna 800006",5,"Male",0,false,0,600,(long)1234567890),
                    new CattlesModel("Rohit K","Rathi Breed Cow", R.drawable.cow_rathi,(long) 50000,
                            "Patna",3,"Female",0,false,0,600,(long)1234567890),
                    new CattlesModel("Vivek","Ongole Ox", R.drawable.ox_ongole,(long) 150000,
                            "Danapur Patna 800006",3,"Male",0,false,0,600,(long)1234567890),
                    new CattlesModel("Mantu ","HF  Cow",R.drawable.cow_hf, (long) 30000,
                            "Patna",3,"Female",20,true,4,420,(long)1234567890),
                    new CattlesModel("Vikas","Sindhi breed Cow",R.drawable.cow_sindhi,(long)20000,
                            "Hajipur ",4,"Female",20,true,3,330,(long)1234567890),
                    new CattlesModel("Vikas","Jersey breed Cow",R.drawable.cow_jersey,(long)20000,
                            "Sunderpur,Dharbhanga  ",4,"Female",20,true,7,600,(long)1234567890),
                    new CattlesModel("Nayak","Sahiwal breed Cow",R.drawable.cow_sahiwal,(long)20000,
                            "Hajipur ",4,"Female",18,false,0,330,(long)1234567890),
                    new CattlesModel("Akash","Vechur breed Cow",R.drawable.cow_vechur,(long)20000,
                            "Hajipur ",4,"Female",20,true,3,330,(long)1234567890)

            )
    );
}
