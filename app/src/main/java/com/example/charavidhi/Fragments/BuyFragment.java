package com.example.charavidhi.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.charavidhi.AccountsActivity;
import com.example.charavidhi.Adapters.CattlesBuyAdapter;
import com.example.charavidhi.Adapters.FrontAnimalAdapter;
import com.example.charavidhi.Adapters.SliderAdapter;
import com.example.charavidhi.CattleDetails;
import com.example.charavidhi.Constant.AllConstant;
import com.example.charavidhi.Models.CattleNameBreed;
import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.R;
import com.example.charavidhi.databinding.FragmentBuyBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.List;


public class BuyFragment extends Fragment implements CattlesBuyAdapter.CattlesClickInterface{

    private FragmentBuyBinding binding;
    private List<CattlesModel> cattlesModelList;
    private List<CattleNameBreed> frontAnimalList;

    int[] images = {R.drawable.buyorsellone,
            R.drawable.hostelfacilitestwo,
            R.drawable.transportfacilitesthree,
            R.drawable.bestlivestockfour,
            R.drawable.widevarietiescowfive};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= FragmentBuyBinding.inflate(inflater, container, false);



        cattlesModelList= AllConstant.cattleslist;
        frontAnimalList =AllConstant.animals;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        setHasOptionsMenu(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CattlesBuyAdapter adapter=new CattlesBuyAdapter(cattlesModelList,this::onItemClick);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);


        SliderAdapter sliderAdapter=new SliderAdapter(images);
        binding.imageSlider.setSliderAdapter(sliderAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        binding.imageSlider.startAutoCycle();

        FrontAnimalAdapter frontAnimalAdapter =new FrontAnimalAdapter(frontAnimalList);
        binding.recyclerViewFrontPage.setAdapter(frontAnimalAdapter);
        LinearLayoutManager frontLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        binding.recyclerViewFrontPage.setLayoutManager(frontLayoutManager);
    }


    @Override
    public void onItemClick(CattlesModel cattlesModel) {
        Toast.makeText(requireContext(),cattlesModel.getNameBreed()+" Clicked",Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(getContext(), CattleDetails.class);
        intent.putExtra("CattlesModel", cattlesModel);
        startActivity(intent);
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