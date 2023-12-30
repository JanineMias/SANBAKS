package com.example.sandbaks;

public class PlayerData {

    public static void addItemEra(String item){
        if (Utils.findItemEra(item).equalsIgnoreCase("Stone")){
            addStoneItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("Bronze")){
            addBronzeItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("Iron")){
            addIronItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("Spanish")){
            addSpanishItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("American")){
            addAmericanItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("Japanese")){
            addJapaneseItems(item);
        }

        else if (Utils.findItemEra(item).equalsIgnoreCase("PH")){
            addPHItems(item);
        }
    }

    public static void initialItems(){
        initialStoneItems();
    }

    public static void initialStoneItems(){
        addStoneItems("Wood");
        addStoneItems("Stone");
        addStoneItems("Air");
        addStoneItems("Water");
        addStoneItems("Soil");
        addStoneItems("Human");
        addStoneItems("Animal");
    }

    public static void addStoneItems(String item){
        StoneFragment.addItem(item);
        StoneFragment.setupStoneAge();
    }

    public static void addBronzeItems(String item){
        BronzeFragment.addItem(item);
        BronzeFragment.setupBronzeAge();
    }

    public static void addIronItems(String item){
        IronFragment.addItem(item);
        IronFragment.setupIronAge();
    }

    public static void initialSpanishItems(){
        addStoneItems("Abacus");
        addStoneItems("Curanderos");
        addStoneItems("Spaniards");
        addStoneItems("Nipa Leaf");
    }

    public static void addSpanishItems(String item){
        SpanishFragment.addItem(item);
        SpanishFragment.setupSpanishAge();
    }

    public static void initialAmericanItems(){
        addStoneItems("American");
        addStoneItems("Car");
        addStoneItems("Technology");
    }

    public static void addAmericanItems(String item){
        AmericanFragment.addItem(item);
        AmericanFragment.setupAmericanAge();
    }

    public static void initialJapaneseItems(){
        addStoneItems("Literature");
        addStoneItems("Filipino");
        addStoneItems("Japanese");
    }
    public static void addJapaneseItems(String item){
        JapanFragment.addItem(item);
        JapanFragment.setupJapanAge();
    }

    public static void initialPHItems(){
        addStoneItems("Democracy");
        addStoneItems("Quantum");
        addStoneItems("PC Chip");
    }

    public static void addPHItems(String item){
        SelfFragment.addItem(item);
        SelfFragment.setupSelfAge();
    }
}
