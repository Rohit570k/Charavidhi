package com.example.charavidhi.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charavidhi.Models.CattleNameBreed;
import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.R;

import java.util.List;

public class CattleNameBreedAdapter extends RecyclerView.Adapter<CattleNameBreedAdapter.ViewHolder>{

    List<CattleNameBreed> cattleNameBreedModelList;
    NameBreedClickInterface clickInterfaceListener;

    public CattleNameBreedAdapter(List<CattleNameBreed> cattleNameBreedModelList, NameBreedClickInterface clickInterfaceListener) {
        this.cattleNameBreedModelList = cattleNameBreedModelList;
        this.clickInterfaceListener = clickInterfaceListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cattle_breed_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CattleNameBreed model =cattleNameBreedModelList.get(position);
        holder.cattleBreedImage.setImageResource(model.getImage());
        holder.cattleBreedName.setText(model.getBreedName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterfaceListener.onItemClick(cattleNameBreedModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(cattleNameBreedModelList!=null){
            return cattleNameBreedModelList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cattleBreedImage;
        TextView cattleBreedName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cattleBreedImage=itemView.findViewById(R.id.cattle_breedImage);
            cattleBreedName=itemView.findViewById(R.id.cattle_breedName);
        }
    }

    public  interface NameBreedClickInterface{
        public void onItemClick(CattleNameBreed cattleNameBreedModel);
    }
}
