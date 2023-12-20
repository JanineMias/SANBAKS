package com.example.sandbaks;

import android.util.Log;
import java.util.HashMap;

public class ElementsCombination {
    private HashMap<String[], String[]> combinations = new HashMap<>();

    String[] getNewElement(String element1, String element2){

        if (combinations.containsKey(new String[]{element1, element2})){
            return combinations.get(new String[]{element1, element2});
        }

        else if (combinations.containsKey(new String[]{element2, element1})){
            return combinations.get(new String[]{element2, element1});
        }

        return new String[]{};
    }

    void paleolithicAge(){
        // End Goal
        combinations.put(new String[]{"Copper", "Metallurgy"}, new String[]{"Bronze"});

        combinations.put(new String[]{"Wood", "Wood"}, new String[]{"Fire"});
        combinations.put(new String[]{"Soil", "Water"}, new String[]{"Mud"});
        combinations.put(new String[]{"Wood", "Stone"}, new String[]{"Stone Tools"});
        combinations.put(new String[]{"Mud", "Fire"}, new String[]{"Clay"});
        combinations.put(new String[]{"Stone", "Stone"}, new String[]{"Sand"});
        combinations.put(new String[]{"Sand", "Fire"}, new String[]{"Glass"});
        combinations.put(new String[]{"Soil", "Soil"}, new String[]{"Land"});
        combinations.put(new String[]{"Wood", "Fire"}, new String[]{"Ash", "Torch"});
        combinations.put(new String[]{"Land", "Water"}, new String[]{"Lake"});
        combinations.put(new String[]{"Water", "Air"}, new String[]{"Vapor"});
        combinations.put(new String[]{"Vapor", "Vapor"}, new String[]{"Clouds"});
        combinations.put(new String[]{"Clouds", "Water"}, new String[]{"Rain"});
        combinations.put(new String[]{"Stone", "Clay"}, new String[]{"Stone House"});
        combinations.put(new String[]{"Land", "Land"}, new String[]{"Mountain"});
        combinations.put(new String[]{"Land", "Fire"}, new String[]{"Volcano"});
        combinations.put(new String[]{"Air", "Air"}, new String[]{"Atmosphere"});
        combinations.put(new String[]{"Atmosphere", "Atmosphere"}, new String[]{"Outer Space"});
        combinations.put(new String[]{"Human", "Mountain"}, new String[]{"Mining"});
        combinations.put(new String[]{"Animal", "Stone Tools"}, new String[]{"Animal Skin"});
        combinations.put(new String[]{"Animal Skin", "Stone Tools"}, new String[]{"Clothing"});
        combinations.put(new String[]{"Wood", "Water"}, new String[]{"Paper"});
        combinations.put(new String[]{"Human", "Human"}, new String[]{"Family"});
        combinations.put(new String[]{"Stone", "Mining"}, new String[]{"Minerals"});
        combinations.put(new String[]{"Fire", "Minerals"}, new String[]{"Metallurgy"});
        combinations.put(new String[]{"Mineral", "Stone Tools"}, new String[]{"Copper"});
        combinations.put(new String[]{"Family", "Family"}, new String[]{"Barangay"});
        combinations.put(new String[]{"Lake", "Lake"}, new String[]{"Sea"});
        combinations.put(new String[]{"Sea", "Sea"}, new String[]{"Ocean"});
        Log.e("New Era", "Unlocked Paleolithic Age");
    }

    void BronzeAge(){
        // End Goal
        combinations.put(new String[]{"Meteor", "Metallurgy"}, new String[]{"Iron"});

        combinations.put(new String[]{"Human", "Land"}, new String[]{"Corpse"});
        combinations.put(new String[]{"Animal", "Land"}, new String[]{"Corpse"});
        combinations.put(new String[]{"Corpse", "Time"}, new String[]{"Fossil Fuel"});
        combinations.put(new String[]{"Wood", "Axle"}, new String[]{"Wheel"});
        combinations.put(new String[]{"Land", "Lake"}, new String[]{"Field"});
        // What metal?
        combinations.put(new String[]{"Wheel", "Any Metal"}, new String[]{"Car"});
        combinations.put(new String[]{"Metallurgy", "Bronze"}, new String[]{"Axle", "Bronze Tools"});
        combinations.put(new String[]{"Stone", "Outer Space"}, new String[]{"Meteor"});
        combinations.put(new String[]{"Animal", "Field"}, new String[]{"Farm"});
        combinations.put(new String[]{"Farm", "Time"}, new String[]{"Food Stock"});
        combinations.put(new String[]{"Clay", "Fire"}, new String[]{"Brick"});
        combinations.put(new String[]{"Barangay", "Barangay"}, new String[]{"City"});
        combinations.put(new String[]{"City", "City"}, new String[]{"Nation"});
        combinations.put(new String[]{"Sun", "Glass"}, new String[]{"Light"});
        Log.e("New Era", "Unlocked Bronze Age");
    }

    void IronAge(){
        // End Goal
        combinations.put(new String[]{"Soldiers", "Spaniards"}, new String[]{"Spanish Era"});

        combinations.put(new String[]{"Iron", "Bronze"}, new String[]{"Steel"});
        combinations.put(new String[]{"Stone Tools", "Iron"}, new String[]{"Farming Tools"});
        combinations.put(new String[]{"Smithing", "Iron"}, new String[]{"Weaponry"});
        combinations.put(new String[]{"Iron", "Trade"}, new String[]{"Coins"});
        combinations.put(new String[]{"Iron", "Wood"}, new String[]{"Mallet"});
        combinations.put(new String[]{"Mallett", "Iron"}, new String[]{"Smithing"});
        combinations.put(new String[]{"Glass", "Fire"}, new String[]{"Beads"});
        combinations.put(new String[]{"Animal Skin", "Food Stock"}, new String[]{"Trade"});
        combinations.put(new String[]{"Human", "Weaponry"}, new String[]{"Soldiers"});
        Log.e("New Era", "Unlocked Iron Age");
    }

    void SpanishEra(){
        // End Goal
        combinations.put(new String[]{"School", "Teachers"}, new String[]{"Education"});

        combinations.put(new String[]{"Soldiers", "Spaniards"}, new String[]{"Spanish Era"});
        combinations.put(new String[]{"Nipa Leaves", "Wood"}, new String[]{"Bahay Kubo"});
        combinations.put(new String[]{"Bahay Kubo", "Brick"}, new String[]{"House"});
        combinations.put(new String[]{"Plants", "Curanderos"}, new String[]{"Medicine"});
        combinations.put(new String[]{"Curanderos", "Medicine"}, new String[]{"Hospital"});
        combinations.put(new String[]{"Spaniards", "Religious Text"}, new String[]{"Religion"});
        combinations.put(new String[]{"House", "Religion"}, new String[]{"Church", "Convent"});
        combinations.put(new String[]{"Convent", "Human"}, new String[]{"Scholar", "School"});
        combinations.put(new String[]{"Human", "Religion"}, new String[]{"Parish"});
        combinations.put(new String[]{"School", "Spaniards"}, new String[]{"Teachers"});
        combinations.put(new String[]{"Spaniards", "Book"}, new String[]{"Religious Text"});
        combinations.put(new String[]{"Paper", "Paper"}, new String[]{"Book"});
        combinations.put(new String[]{"AIR", "Car"}, new String[]{"Plane"});
        Log.e("New Era", "Unlocked Spanish Era");
    }

    void AmericanEra(){
        // End Goal
        combinations.put(new String[]{"Japanese", "Education"}, new String[]{"Literature"});

        combinations.put(new String[]{"Telephone", "Technology"}, new String[]{"Pager"});
        combinations.put(new String[]{"Education", "American"}, new String[]{"English"});
        combinations.put(new String[]{"Water", "Boat"}, new String[]{"Port"});
        combinations.put(new String[]{"Water", "Car"}, new String[]{"Boat"});
        combinations.put(new String[]{"Road", "Iron"}, new String[]{"Rail"});
        combinations.put(new String[]{"Car", "Land"}, new String[]{"Road"});
        combinations.put(new String[]{"Education", "House"}, new String[]{"Architecture"});
        combinations.put(new String[]{"Steam", "Food Stock"}, new String[]{"Processed Food"});
        combinations.put(new String[]{"Technology", "Abacus"}, new String[]{"Computer"});
        combinations.put(new String[]{"American", "Time"}, new String[]{"Japanese"});
        combinations.put(new String[]{"Japanese", "Education"}, new String[]{"Literature"});
        Log.e("New Era", "Unlocked America Era");
    }

    void JapaneseEra(){
        // End Goal
        combinations.put(new String[]{"Independency", "Puppet Government"}, new String[]{"Democracy"});

        // Should I rename this to Mickey Mouse Money or just Bills?
        combinations.put(new String[]{"Paper", "Trade"}, new String[]{"Bills"});
        combinations.put(new String[]{"Filipino", "Soldiers"}, new String[]{"Guerilla"});
        combinations.put(new String[]{"American", "Soldiers"}, new String[]{"US Army"});
        combinations.put(new String[]{"US Army", "Guerilla"}, new String[]{"Independency"});
        combinations.put(new String[]{"Politics", "Japanese"}, new String[]{"Puppet Government"});
        combinations.put(new String[]{"Japanese", "Farm"}, new String[]{"Cotton"});
        combinations.put(new String[]{"Filipino", "Literature"}, new String[]{"Filipino Literature"});
        combinations.put(new String[]{"Literature", "Japanese"}, new String[]{"Poems"});
        combinations.put(new String[]{"Nation", "Education"}, new String[]{"Politics"});
        Log.e("New Era", "Unlocked Japanese Era");
    }

    void SelfRule(){
        combinations.put(new String[]{"Videophone", "Technology"}, new String[]{"Smart Phones"});
        combinations.put(new String[]{"Human", "Computer"}, new String[]{"Artificial Intelligence"});
        combinations.put(new String[]{"Car", "Outer Space"}, new String[]{"Rocket"});
        combinations.put(new String[]{"Sea", "Light"}, new String[]{"Salt Light"});
        combinations.put(new String[]{"Telephone", "Television"}, new String[]{"Videophone"});
        combinations.put(new String[]{"Camera", "Outer Space"}, new String[]{"Satellite"});
        combinations.put(new String[]{"PC Chip", "Screen"}, new String[]{"Camera"});
        combinations.put(new String[]{"Glass", "Technology"}, new String[]{"Screen"});

        Log.e("New Era", "Unlocked Self Rule");
    }
}