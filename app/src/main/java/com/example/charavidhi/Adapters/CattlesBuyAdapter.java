package com.example.charavidhi.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.charavidhi.Models.CattlesModel;
import com.example.charavidhi.R;

import java.util.List;

public class CattlesBuyAdapter extends RecyclerView.Adapter<CattlesBuyAdapter.ViewHolder> {


    List<CattlesModel> cattlesModelList;
    CattlesClickInterface clickInterfaceListener;

    public CattlesBuyAdapter(List<CattlesModel> cattlesModelList,CattlesClickInterface clickInterfaceListener) {
        this.cattlesModelList = cattlesModelList;
        this.clickInterfaceListener=clickInterfaceListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_cattle_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CattlesModel model=cattlesModelList.get(position);
        holder.sellerName.setText(model.getSeller());
        holder.price.setText("Rs: " +model.getPrice());
        holder.sellerPlace.setText(model.getPlace());
        holder.cattleImage.setImageResource(model.getImage());
        holder.cattleName.setText(model.getNameBreed());
        holder.milkAmount.setText(model.getMilkQuantity()+" Ltr/Day");
        holder.cattleAge.setText(model.getAge()+" Years");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterfaceListener.onItemClick(cattlesModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
       if(cattlesModelList!=null){
           return cattlesModelList.size();
       }
       return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView sellerName;
        TextView price;
        TextView sellerPlace;
        ImageView cattleImage;
        TextView cattleName;
        TextView milkAmount;
        TextView cattleAge;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sellerName=itemView.findViewById(R.id.sellerName);
            price=itemView.findViewById(R.id.price);
            sellerPlace=itemView.findViewById(R.id.sellerPlace);
            cattleImage=itemView.findViewById(R.id.cattleImage);
            cattleName=itemView.findViewById(R.id.cattleName);
            milkAmount=itemView.findViewById(R.id.milkAmountTv);
            cattleAge=itemView.findViewById(R.id.cattleAgeTv);
        }
    }

    public  interface CattlesClickInterface{
        public void onItemClick(CattlesModel cattlesModel);
    }
}
