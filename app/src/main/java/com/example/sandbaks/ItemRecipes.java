package com.example.sandbaks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRecipes extends AppCompatActivity {

    private RecyclerView itemRecipes;
    private SearchView searchItemRecipes;
    private ElementsCombination combinations = new ElementsCombination();
    private HashMap<List<String>, List<String>> allCombinations = new HashMap<>();
    private ArrayList<ItemRecipeCards> itemRecipeCardsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_recipes);
        init();
    }

    void init(){
        itemRecipes = findViewById(R.id.itemRecipe);
        searchItemRecipes = findViewById(R.id.searchItem);

        combinations.paleolithicAge();
        combinations.BronzeAge();
        combinations.IronAge();
        combinations.SpanishEra();
        combinations.AmericanEra();
        combinations.JapaneseEra();
        combinations.SelfRule();

        allCombinations = combinations.getAllCombinations();

        setupItemRecipes();

        ItemRecipeAdapter adapter = new ItemRecipeAdapter(this, itemRecipeCardsArrayList);

        itemRecipes.setAdapter(adapter);

        itemRecipes.setLayoutManager(new LinearLayoutManager(this));


        searchItemRecipes.clearFocus();
        searchItemRecipes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    void setupItemRecipes(){
        List<Map.Entry<List<String>, List<String>>> entryList = new ArrayList<>(allCombinations.entrySet());
        entryList.sort(Comparator.comparing(entry -> String.join(", ", entry.getValue())));

        itemRecipeCardsArrayList.clear();

        for (Map.Entry<List<String>, List<String>> entry : entryList) {
            List<String> key = entry.getKey();
            List<String> value = entry.getValue();

            String keyString = String.join(", ", key);
            String valueString = String.join(", ", value);

            itemRecipeCardsArrayList.add(new ItemRecipeCards(valueString, keyString));
        }
    }

    void filterList(String newText) {
        newText = newText.toLowerCase().trim();

        ArrayList<ItemRecipeCards> filteredList = new ArrayList<>();

        for (Map.Entry<List<String>, List<String>> entry : allCombinations.entrySet()) {
            List<String> key = entry.getKey();
            List<String> value = entry.getValue();

            String keyString = String.join(", ", key);
            String valueString = String.join(", ", value);

            if (keyString.toLowerCase().contains(newText) || valueString.toLowerCase().contains(newText)) {
                filteredList.add(new ItemRecipeCards(valueString, keyString));
            }
        }

        ItemRecipeAdapter adapter = new ItemRecipeAdapter(this, filteredList);
        itemRecipes.setAdapter(adapter);
    }
}