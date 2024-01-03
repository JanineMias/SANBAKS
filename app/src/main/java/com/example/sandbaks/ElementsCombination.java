package com.example.sandbaks;

import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ElementsCombination {
    private HashMap<List<String>, List<String>> combinations = new HashMap<>();

    public List<String> getCombination(String element1, String element2) {

        List<String> key = Arrays.asList(element1, element2);

        if (this.combinations.containsKey(key)){
            return this.combinations.get(key);
        }

        key = Arrays.asList(element2, element1);

        return this.combinations.get(key);
    }

    public HashMap<List<String>, List<String>> getAllCombinations(){
        return combinations;
    }

    void paleolithicAge(){
        // End Goal
        combinations.put(Arrays.asList("Copper", "Metallurgy"), List.of("Bronze"));

        combinations.put(Arrays.asList("Wood", "Wood"), List.of("Fire"));
        combinations.put(Arrays.asList("Soil", "Water"), List.of("Mud", "Time"));
        combinations.put(Arrays.asList("Wood", "Stone"), List.of("Stone Tools"));
        combinations.put(Arrays.asList("Mud", "Fire"), List.of("Clay"));
        combinations.put(Arrays.asList("Stone", "Stone"), List.of("Sand"));
        combinations.put(Arrays.asList("Sand", "Fire"), List.of("Glass"));
        combinations.put(Arrays.asList("Soil", "Soil"), List.of("Land"));
        combinations.put(Arrays.asList("Wood", "Fire"), Arrays.asList("Ash", "Torch"));
        combinations.put(Arrays.asList("Land", "Water"), List.of("Lake"));
        combinations.put(Arrays.asList("Water", "Air"), List.of("Vapor"));
        combinations.put(Arrays.asList("Vapor", "Vapor"), List.of("Clouds"));
        combinations.put(Arrays.asList("Clouds", "Water"), List.of("Rain"));
        combinations.put(Arrays.asList("Stone", "Clay"), List.of("Stone House"));
        combinations.put(Arrays.asList("Land", "Land"), List.of("Mountain"));
        combinations.put(Arrays.asList("Land", "Fire"), List.of("Volcano"));
        combinations.put(Arrays.asList("Air", "Air"), List.of("Atmosphere"));
        combinations.put(Arrays.asList("Atmosphere", "Atmosphere"), List.of("Outer Space"));
        combinations.put(Arrays.asList("Human", "Mountain"), List.of("Mining"));
        combinations.put(Arrays.asList("Animal", "Stone Tools"), List.of("Animal Skin"));
        combinations.put(Arrays.asList("Animal Skin", "Stone Tools"), List.of("Clothing"));
        combinations.put(Arrays.asList("Wood", "Water"), List.of("Paper"));
        combinations.put(Arrays.asList("Human", "Human"), List.of("Family"));
        combinations.put(Arrays.asList("Stone", "Mining"), List.of("Mineral"));
        combinations.put(Arrays.asList("Fire", "Mineral"), List.of("Metallurgy"));
        combinations.put(Arrays.asList("Mineral", "Stone Tools"), List.of("Copper"));
        combinations.put(Arrays.asList("Family", "Family"), List.of("Barangay"));
        combinations.put(Arrays.asList("Lake", "Lake"), List.of("Sea"));
        combinations.put(Arrays.asList("Sea", "Sea"), List.of("Ocean"));
        Log.e("New Era", "Unlocked Paleolithic Age");
    }

    void BronzeAge(){
        // End Goal
        combinations.put(Arrays.asList("Meteor", "Metallurgy"), List.of("Iron"));

        combinations.put(Arrays.asList("Human", "Land"), List.of("Corpse"));
        combinations.put(Arrays.asList("Animal", "Land"), List.of("Corpse"));
        combinations.put(Arrays.asList("Corpse", "Time"), List.of("Fossil Fuel"));
        combinations.put(Arrays.asList("Wood", "Axle"), List.of("Wheel"));
        combinations.put(Arrays.asList("Land", "Lake"), List.of("Field"));

        combinations.put(Arrays.asList("Wheel", "Bronze"), List.of("Car"));
        combinations.put(Arrays.asList("Wheel", "Steel"), List.of("Car"));
        combinations.put(Arrays.asList("Wheel", "Copper"), List.of("Car"));
        combinations.put(Arrays.asList("Wheel", "Iron"), List.of("Car"));

        combinations.put(Arrays.asList("Metallurgy", "Bronze"), Arrays.asList("Axle", "Bronze Tools"));
        combinations.put(Arrays.asList("Stone", "Outer Space"), List.of("Meteor"));
        combinations.put(Arrays.asList("Animal", "Field"), List.of("Farm"));
        combinations.put(Arrays.asList("Farm", "Time"), List.of("Food Stock"));
        combinations.put(Arrays.asList("Clay", "Fire"), List.of("Brick"));
        combinations.put(Arrays.asList("Barangay", "Barangay"), List.of("City"));
        combinations.put(Arrays.asList("City", "City"), List.of("Nation"));
        combinations.put(Arrays.asList("Sun", "Glass"), List.of("Light"));
        Log.e("New Era", "Unlocked Bronze Age");
    }

    void IronAge(){
        // End Goal
        combinations.put(Arrays.asList("Human", "Weaponry"), List.of("Soldiers", "Spaniards"));

        combinations.put(Arrays.asList("Iron", "Bronze"), List.of("Steel"));
        combinations.put(Arrays.asList("Stone Tools", "Iron"), List.of("Farming Tools"));
        combinations.put(Arrays.asList("Smithing", "Iron"), List.of("Weaponry"));
        combinations.put(Arrays.asList("Iron", "Trade"), List.of("Coins"));
        combinations.put(Arrays.asList("Iron", "Wood"), List.of("Mallet"));
        combinations.put(Arrays.asList("Mallet", "Iron"), List.of("Smithing"));
        combinations.put(Arrays.asList("Glass", "Fire"), List.of("Beads"));
        combinations.put(Arrays.asList("Animal Skin", "Food Stock"), List.of("Trade"));
        Log.e("New Era", "Unlocked Iron Age");
    }

    void SpanishEra(){
        // End Goal
        combinations.put(Arrays.asList("School", "Teachers"), List.of("Education"));

        combinations.put(Arrays.asList("Soldiers", "Spaniards"), List.of("Spanish Era"));
        combinations.put(Arrays.asList("Nipa Leaf", "Wood"), List.of("Bahay Kubo"));
        combinations.put(Arrays.asList("Bahay Kubo", "Brick"), List.of("House"));
        combinations.put(Arrays.asList("Plants", "Curanderos"), List.of("Medicine"));
        combinations.put(Arrays.asList("Curanderos", "Medicine"), List.of("Hospital"));
        combinations.put(Arrays.asList("Spaniards", "Religious Text"), List.of("Religion"));
        combinations.put(Arrays.asList("House", "Religion"), Arrays.asList("Church", "Convent"));
        combinations.put(Arrays.asList("Convent", "Human"), Arrays.asList("Scholar", "School"));
        combinations.put(Arrays.asList("Human", "Religion"), List.of("Parish"));
        combinations.put(Arrays.asList("School", "Spaniards"), List.of("Teachers"));
        combinations.put(Arrays.asList("Spaniards", "Book"), List.of("Religious Text"));
        combinations.put(Arrays.asList("Paper", "Paper"), List.of("Book", "Telephone"));
        combinations.put(Arrays.asList("Air", "Car"), List.of("Plane"));
        Log.e("New Era", "Unlocked Spanish Era");
    }

    void AmericanEra(){
        // End Goal
        combinations.put(Arrays.asList("Japanese", "Education"), List.of("Literature"));

        combinations.put(Arrays.asList("Telephone", "Technology"), List.of("Pager"));
        combinations.put(Arrays.asList("Education", "American"), List.of("English"));
        combinations.put(Arrays.asList("Water", "Boat"), List.of("Port"));
        combinations.put(Arrays.asList("Water", "Car"), List.of("Boat"));
        combinations.put(Arrays.asList("Road", "Iron"), List.of("Rail"));
        combinations.put(Arrays.asList("Car", "Land"), List.of("Road"));
        combinations.put(Arrays.asList("Education", "House"), List.of("Architecture"));
        combinations.put(Arrays.asList("Steam", "Food Stock"), List.of("Processed Food"));
        combinations.put(Arrays.asList("Technology", "Abacus"), List.of("Computer"));
        combinations.put(Arrays.asList("American", "Time"), List.of("Japanese"));
        Log.e("New Era", "Unlocked America Era");
    }

    void JapaneseEra(){
        // End Goal
        combinations.put(Arrays.asList("Independence", "Puppet Government"), List.of("Democracy"));

        combinations.put(Arrays.asList("Paper", "Trade"), List.of("Mickey Mouse Money"));
        combinations.put(Arrays.asList("Filipino", "Soldiers"), List.of("Guerilla"));
        combinations.put(Arrays.asList("American", "Soldiers"), List.of("US Army"));
        combinations.put(Arrays.asList("US Army", "Guerilla"), List.of("Independence"));
        combinations.put(Arrays.asList("Politics", "Japanese"), List.of("Puppet Government"));
        combinations.put(Arrays.asList("Japanese", "Farm"), List.of("Cotton"));
        combinations.put(Arrays.asList("Filipino", "Literature"), List.of("Filipino Literature"));
        combinations.put(Arrays.asList("Literature", "Japanese"), List.of("Poems"));
        combinations.put(Arrays.asList("Nation", "Education"), List.of("Politics"));
        Log.e("New Era", "Unlocked Japanese Era");
    }

    void SelfRule(){
        combinations.put(Arrays.asList("Videophone", "Technology"), List.of("Smart Phone"));
        combinations.put(Arrays.asList("Human", "Computer"), List.of("Artificial Intelligence"));
        combinations.put(Arrays.asList("Car", "Outer Space"), List.of("Rocket"));
        combinations.put(Arrays.asList("Sea", "Light"), List.of("Salt Light"));
        combinations.put(Arrays.asList("Telephone", "Television"), List.of("Videophone"));
        combinations.put(Arrays.asList("Camera", "Outer Space"), List.of("Satellite"));
        combinations.put(Arrays.asList("PC Chip", "Screen"), List.of("Camera"));
        combinations.put(Arrays.asList("Glass", "Technology"), List.of("Screen"));

        Log.e("New Era", "Unlocked Self Rule");
    }
}