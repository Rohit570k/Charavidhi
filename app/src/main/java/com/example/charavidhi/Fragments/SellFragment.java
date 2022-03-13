package com.example.charavidhi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.charavidhi.Adapters.CattleAnimalBreedAdapter;
import com.example.charavidhi.Adapters.CattleNameBreedAdapter;
import com.example.charavidhi.CattleDetails;
import com.example.charavidhi.Constant.AllConstant;
import com.example.charavidhi.MainActivity;
import com.example.charavidhi.Models.CattleNameBreed;
import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.R;
import com.example.charavidhi.SellingDetails;
import com.example.charavidhi.databinding.FragmentBuyBinding;
import com.example.charavidhi.databinding.FragmentSellBinding;

import java.util.List;

public class SellFragment extends Fragment implements CattleNameBreedAdapter.NameBreedClickInterface ,CattleAnimalBreedAdapter.AnimalBreedClickInterface {

    private FragmentSellBinding binding;
    private List<CattleNameBreed> cattleAnimalList;
    private List<CattleNameBreed> cattleAnimalBreedList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSellBinding.inflate(inflater, container, false);



        cattleAnimalList= AllConstant.animals;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CattleNameBreedAdapter animalNameAdapters= new CattleNameBreedAdapter(cattleAnimalList,this::onItemClick);

        binding.recyclerViewAnimal.setAdapter(animalNameAdapters);
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
       // GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        binding.recyclerViewAnimal.setLayoutManager(linearLayoutManager);

//        EditText yourEditText= (EditText)view.findViewById(R.id.mobileNo);
//        yourEditText.requestFocus();
//        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(yourEditText, InputMethodManager.SHOW_IMPLICIT);
//        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void onItemClick(CattleNameBreed cattleNameBreedModel) {
        switch (cattleNameBreedModel.getBreedName()) {
            case "Cow":
                cattleAnimalBreedList = AllConstant.cow_breed;
                break;
            case "Ox":
                cattleAnimalBreedList = AllConstant.ox_breed;
                break;
            case "Buffalo":
                cattleAnimalBreedList = AllConstant.buffalo_breed;
                break;
            case "Goat":
                cattleAnimalBreedList = AllConstant.goat_breed;
                break;
        }
        binding.recyclerViewAnimalBreed.setVisibility(View.VISIBLE);
        CattleAnimalBreedAdapter animalBreedAdapters = new CattleAnimalBreedAdapter(cattleAnimalBreedList,this::onItemClickAnimal);

        binding.recyclerViewAnimalBreed.setAdapter(animalBreedAdapters);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        binding.recyclerViewAnimalBreed.setLayoutManager(gridLayoutManager);
        Toast.makeText(getContext(), cattleNameBreedModel.getBreedName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClickAnimal(CattleNameBreed cattleAnimalBreedModel) {
        Toast.makeText(getContext(), cattleAnimalBreedModel.getBreedName(), Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(getContext(), SellingDetails.class);
        startActivity(intent);
    }
}