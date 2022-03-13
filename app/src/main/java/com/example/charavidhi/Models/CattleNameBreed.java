package com.example.charavidhi.Models;

public class CattleNameBreed {
    private int image;
    private String breedName;

    public CattleNameBreed(int image, String breedName) {
        this.image = image;
        this.breedName = breedName;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}
