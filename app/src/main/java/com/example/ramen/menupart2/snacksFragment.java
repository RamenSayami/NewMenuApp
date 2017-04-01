package com.example.ramen.menupart2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ramen.menupart2.Model.MenuItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramen on 3/27/17.
 */

public class snacksFragment extends Fragment {
    View myView;
    private List<MenuItems> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.snacks_layout,container,false);

        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());

        mAdapter = new MenuAdapter(menuList);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        mAdapter.notifyDataSetChanged();

        return myView;
    }


    private void initDataset() {


        menuList.add(new MenuItems("Guacamole and Chips", 200, R.drawable.guacamolenchips,3));
        menuList.add(new MenuItems("Barbecue Chicken Nachos", 200, R.drawable.bbq_chicken_nachos,3));
        menuList.add(new MenuItems("Pigs in a Blanket", 200, R.drawable.pigs_in_blanket,3));

        menuList.add(new MenuItems("Bacon-Wrapped Potatoes With Creamy Dill Sauce ", 200, R.drawable.bacon_potato,3));
        menuList.add(new MenuItems("Barbecue Meatball Sliders ", 200, R.drawable.meatball_slider,3));
        menuList.add(new MenuItems("Sausage Sliders With Spinach and Peppers ", 200, R.drawable.sausage_sliders,3));
        menuList.add(new MenuItems("Spiced Tortilla Crisps With Hummus ", 200, R.drawable.tortilla_hummus,3));
        menuList.add(new MenuItems("Papad", 200, R.drawable.papad,3));

//        menuList.add(new MenuItems("Chicken Roast", 200, R.drawable.chicken_roast,3));
//        menuList.add(new MenuItems("Fried Rice", 140, R.drawable.friedrice,5));
//        menuList.add(new MenuItems("Buff Momo", 200, R.drawable.momo,5));
//        menuList.add(new MenuItems("Buff Sizzler", 200, R.drawable.sizzler_sizzler,3));
//        menuList.add(new MenuItems("Chicken Chow mein", 350, R.drawable.recipechicken_chow_mein,3));
//        menuList.add(new MenuItems("Chicken Momo", 180, R.drawable.chicken_momo,3));
//
//        menuList.add(new MenuItems("Fried Momo", 350, R.drawable.friedmomo,3));
//        menuList.add(new MenuItems("Coke", 70, R.drawable.coke,3));


//        menuList.add(new MenuItems("Tuborg Beer", 350, R.drawable.tuborg,3));
//        menuList.add(new MenuItems("Carlsberg Beer", 350, R.drawable.carlsberg,3));


    }
}
