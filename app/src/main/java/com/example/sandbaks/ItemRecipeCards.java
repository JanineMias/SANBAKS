package com.example.sandbaks;

public class ItemRecipeCards {
    String combinationResult, combinationItems;

    public ItemRecipeCards(String combinationResult, String combinationItems){
        this.combinationItems = combinationItems;
        this.combinationResult = combinationResult;
    }

    public String getCombinationResult() {
        return combinationResult;
    }

    public String getCombinationItems() {
        return combinationItems;
    }
}
