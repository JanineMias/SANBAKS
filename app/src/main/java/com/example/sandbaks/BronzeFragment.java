package com.example.sandbaks;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BronzeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BronzeFragment extends Fragment implements ItemRecyclerViewInterface {

    ArrayList<ItemCards> itemCardsArrayList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BronzeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bronzeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BronzeFragment newInstance(String param1, String param2) {
        BronzeFragment fragment = new BronzeFragment();
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
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bronze, container, false);
        setupBronzeAge();

        RecyclerView recyclerView = view.findViewById(R.id.bronzeAgeRView);

        ItemRecyclerViewAdapater adapter = new ItemRecyclerViewAdapater(MainActivity.context, itemCardsArrayList, this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));

        return view;
    }

    private void setupBronzeAge() {
        String[] itemNames = getResources().getStringArray(R.array.bronze_age_items);

        for (int i = 0; i < itemNames.length; i++) {
            try {
                itemCardsArrayList.add(
                        new ItemCards(
                                itemNames[i],
                                Utils.getBitmapFromAssets(itemNames[i] + ".png")));
            } catch (IOException e) {
                Log.e("Failed to get Image", e.toString());
            }
        }
    }

    @Override
    public void onItemSelected(int position) {

    }
}