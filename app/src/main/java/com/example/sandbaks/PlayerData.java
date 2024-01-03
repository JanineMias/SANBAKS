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

    public static void addStoneItems(String item){
        StoneFragment.addItem(item);
        StoneFragment.setupStoneAge();
    }

    public static void addBronzeItems(String item){
        if (item.equalsIgnoreCase("Bronze")){
            EraUnlocker.unlockBronze(false);
        }
        BronzeFragment.addItem(item);
        BronzeFragment.setupBronzeAge();
    }

    public static void addIronItems(String item){
        if (item.equalsIgnoreCase("Iron")){
            EraUnlocker.unlockIron(false);
        }

        IronFragment.addItem(item);
        IronFragment.setupIronAge();
    }

    public static void addSpanishItems(String item){
        if (item.equalsIgnoreCase("Spaniards")){
            EraUnlocker.unlockSpanish(false);
        }

        SpanishFragment.addItem(item);
        SpanishFragment.setupSpanishAge();
    }

    public static void addAmericanItems(String item){
        if (item.equalsIgnoreCase("Education")){
            EraUnlocker.unlockAmerican(false);
        }

        AmericanFragment.addItem(item);
        AmericanFragment.setupAmericanAge();
    }

    public static void addJapaneseItems(String item){
        if (item.equalsIgnoreCase("Literature")){
            EraUnlocker.unlockJapan(false);
        }

        JapanFragment.addItem(item);
        JapanFragment.setupJapanAge();
    }

    public static void addPHItems(String item){
        if (item.equalsIgnoreCase("Democracy")){
            EraUnlocker.unlockPH(false);
        }
        SelfFragment.addItem(item);
        SelfFragment.setupSelfAge();
    }
}
