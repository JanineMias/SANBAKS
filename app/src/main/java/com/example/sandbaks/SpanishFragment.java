package com.example.sandbaks;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpanishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpanishFragment extends Fragment implements ItemRecyclerViewInterface {

    static ArrayList<ItemCards> itemCardsArrayList = new ArrayList<>();

    public static ArrayList<String> items = new ArrayList<>();

    static DBHelper db = new DBHelper();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SpanishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment spanishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpanishFragment newInstance(String param1, String param2) {
        SpanishFragment fragment = new SpanishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        db.initDB(requireContext());
        getItems();
    }

    void getItems(){
        items = Utils.getItemsFromString(db.getSpanishItems(Utils.userID));
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_spanish, container, false);

        setupSpanishAge();

        RecyclerView recyclerView = view.findViewById(R.id.spanishAgeRView);

        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(MainActivity.context, itemCardsArrayList, this, Color.WHITE);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));

        return view;
    }

    public static void addItem(String item) {
        if (!items.contains(item) || items.isEmpty()) {
            items.add(item);

            String updatedItems = Utils.createSeparatedString(items);
            db.updateSpanishItems(Utils.userID, updatedItems);

            try {
                itemCardsArrayList.add(
                        new ItemCards(
                                item,
                                Utils.getBitmapFromAssets(item + ".png")));
            } catch (IOException e) {
                Log.e("Failed to get Image", e.toString());
            }
        }
    }

    public static void setupSpanishAge(){
        itemCardsArrayList.clear();
        Collections.sort(items, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < items.size(); i++) {
            try {
                itemCardsArrayList.add(
                        new ItemCards(
                                items.get(i),
                                Utils.getBitmapFromAssets(items.get(i) + ".png")));
            } catch (IOException e) {
                Log.e("Failed to get Image", e.toString());
            }
        }
    }
    @Override
    public void onItemSelected(int position) {

    }
}