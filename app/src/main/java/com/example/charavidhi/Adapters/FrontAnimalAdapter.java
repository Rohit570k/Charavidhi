package com.example.charavidhi.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charavidhi.Models.CattleNameBreed;
import com.example.charavidhi.R;

import java.util.List;

public class FrontAnimalAdapter extends RecyclerView.Adapter<FrontAnimalAdapter.ViewHolder> {
    List<CattleNameBreed> cattleNameBreedModelList;

    public FrontAnimalAdapter(List<CattleNameBreed> cattleNameBreedModelList) {
        this.cattleNameBreedModelList = cattleNameBreedModelList;
    }

    @NonNull
    @Override
    public FrontAnimalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fronthorizontal_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrontAnimalAdapter.ViewHolder holder, int position) {
        CattleNameBreed model = cattleNameBreedModelList.get(position);
        holder.cattleBreedImage.setImageResource(model.getImage());
        holder.cattleBreedName.setText(model.getBreedName());
    }

    @Override
    public int getItemCount() {
        if (cattleNameBreedModelList != null) {
            return cattleNameBreedModelList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cattleBreedImage;
        TextView cattleBreedName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cattleBreedImage = itemView.findViewById(R.id.frontanimalimage);
            cattleBreedName = itemView.findViewById(R.id.frontanimalname);
        }
    }
}

