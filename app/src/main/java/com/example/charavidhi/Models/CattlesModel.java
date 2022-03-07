package com.example.charavidhi.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CattlesModel implements Parcelable {
    private String seller;
   private  String nameBreed ;
   private int Image;
   private Long price;
   private String place;
   private int age;
   private String gender;
    private int milkQuantity;
   private Boolean isPregnanat;
   private int Lactation;
   private int weight;
   private Long sellerPhoneNumber;


    public CattlesModel(String seller, String nameBreed, int image, Long price, String place, int age,
                        String gender, int milkQuantity, Boolean isPregnanat, int lactation, int weight,Long sellerPhoneNumber) {
        this.seller = seller;
        this.nameBreed = nameBreed;
        Image = image;
        this.price = price;
        this.place = place;
        this.age = age;
        this.gender = gender;
        this.milkQuantity = milkQuantity;
        this.isPregnanat = isPregnanat;
        Lactation = lactation;
        this.weight = weight;
        this.sellerPhoneNumber=sellerPhoneNumber;
    }

    protected CattlesModel(Parcel in) {
        seller = in.readString();
        nameBreed = in.readString();
        Image = in.readInt();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readLong();
        }
        place = in.readString();
        age = in.readInt();
        gender = in.readString();
        milkQuantity = in.readInt();
        byte tmpIsPregnanat = in.readByte();
        isPregnanat = tmpIsPregnanat == 0 ? null : tmpIsPregnanat == 1;
        Lactation = in.readInt();
        weight = in.readInt();
        if (in.readByte() == 0) {
            sellerPhoneNumber = null;
        } else {
            sellerPhoneNumber = in.readLong();
        }
    }

    public static final Creator<CattlesModel> CREATOR = new Creator<CattlesModel>() {
        @Override
        public CattlesModel createFromParcel(Parcel in) {
            return new CattlesModel(in);
        }

        @Override
        public CattlesModel[] newArray(int size) {
            return new CattlesModel[size];
        }
    };

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getNameBreed() {
        return nameBreed;
    }

    public void setNameBreed(String nameBreed) {
        this.nameBreed = nameBreed;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public Boolean getPregnanat() {
        return isPregnanat;
    }

    public void setPregnanat(Boolean pregnanat) {
        isPregnanat = pregnanat;
    }

    public int getLactation() {
        return Lactation;
    }

    public void setLactation(int lactation) {
        Lactation = lactation;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setSellerPhoneNumber(long sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(seller);
        parcel.writeString(nameBreed);
        parcel.writeInt(Image);
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(price);
        }
        parcel.writeString(place);
        parcel.writeInt(age);
        parcel.writeString(gender);
        parcel.writeInt(milkQuantity);
        parcel.writeByte((byte) (isPregnanat == null ? 0 : isPregnanat ? 1 : 2));
        parcel.writeInt(Lactation);
        parcel.writeInt(weight);
        if (sellerPhoneNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(sellerPhoneNumber);
        }
    }
}
