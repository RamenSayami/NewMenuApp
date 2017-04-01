package com.example.ramen.menupart2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramen.menupart2.Model.MenuItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramen on 3/27/17.
 */

public class drinksFragment extends Fragment {
    View myView;
    private List<MenuItems> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MenuAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private Fragment globalFrag = this;

//    private Activity mainActivity;
//    FragmentManager fragmentManager = getFragmentManager();

//    final FragmentController mFragments = FragmentController.createController(new FragmentActivity.HostCallbacks());

    public drinksFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initDataset();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.drink_layout, container, false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(globalFrag.getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) myView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


//        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view_drinks);
//        mLayoutManager = new LinearLayoutManager(getActivity());
//
//        mAdapter = new MenuAdapter(menuList);
//
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//
//
//        mAdapter.notifyDataSetChanged();

        return myView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static List<MenuItems> drinksList = new ArrayList<MenuItems>();

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static drinksFragment.PlaceholderFragment newInstance(String title) {
            drinksList = initDataset(title);
            drinksFragment.PlaceholderFragment fragment = new drinksFragment.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NUMBER, title);
            fragment.setArguments(args);
            return fragment;
        }

        private static List<MenuItems> initDataset(String label) {
            List<MenuItems> listMenu = new ArrayList<>();


            if (label.equals("Cold")) {
                listMenu.add(new MenuItems("Fanta", 250, R.drawable.carlsberg, 4));
                listMenu.add(new MenuItems("Coke", 350, R.drawable.carlsberg, 3));
            } else if (label.equals("Hard")) {
                listMenu.add(new MenuItems("Tuborg Beer", 250, R.drawable.carlsberg, 4));
                listMenu.add(new MenuItems("Carlsberg Beer", 350, R.drawable.carlsberg, 3));
            } else if (label.equals("Hot")) {
                listMenu.add(new MenuItems("Tea", 250, R.drawable.carlsberg, 4));
                listMenu.add(new MenuItems("Coffee", 350, R.drawable.carlsberg, 3));
            } else {
                listMenu.add(new MenuItems("Default Case", 250, R.drawable.carlsberg, 4));
            }

            return listMenu;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.drinks_layout, container, false);
            List<MenuItems> menuList = new ArrayList<>();

//            menuList = initDataset();
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_drinks);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

//            RecyclerView.LayoutManager
            MenuAdapter mAdapter = new MenuAdapter(drinksList);

            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return drinksFragment.PlaceholderFragment.newInstance(getPageTitle(position));
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public String getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Hard";
                case 1:
                    return "Cold";
                case 2:
                    return "Hot";
            }

            return null;
        }
    }


//    private void initDataset() {
//
//
////        menuList.add(new MenuItems("Guacamole and Chips", 200, R.drawable.guacamolenchips,3));
////        menuList.add(new MenuItems("Barbecue Chicken Nachos", 200, R.drawable.bbq_chicken_nachos,3));
////        menuList.add(new MenuItems("Pigs in a Blanket", 200, R.drawable.pigs_in_blanket,3));
////
////        menuList.add(new MenuItems("Bacon-Wrapped Potatoes With Creamy Dill Sauce ", 200, R.drawable.bacon_potato,3));
////        menuList.add(new MenuItems("Barbecue Meatball Sliders ", 200, R.drawable.meatball_slider,3));
////        menuList.add(new MenuItems("Sausage Sliders With Spinach and Peppers ", 200, R.drawable.sausage_sliders,3));
////        menuList.add(new MenuItems("Spiced Tortilla Crisps With Hummus ", 200, R.drawable.tortilla_hummus,3));
////        menuList.add(new MenuItems("Papad", 200, R.drawable.papad,3));
//
////        menuList.add(new MenuItems("Chicken Roast", 200, R.drawable.chicken_roast,3));
////        menuList.add(new MenuItems("Fried Rice", 140, R.drawable.friedrice,5));
////        menuList.add(new MenuItems("Buff Momo", 200, R.drawable.momo,5));
////        menuList.add(new MenuItems("Buff Sizzler", 200, R.drawable.sizzler_sizzler,3));
////        menuList.add(new MenuItems("Chicken Chow mein", 350, R.drawable.recipechicken_chow_mein,3));
////        menuList.add(new MenuItems("Chicken Momo", 180, R.drawable.chicken_momo,3));
////
////        menuList.add(new MenuItems("Fried Momo", 350, R.drawable.friedmomo,3));
////        menuList.add(new MenuItems("Coke", 70, R.drawable.coke,3));
//
//
////        menuList.add(new MenuItems("Tuborg Beer", 350, R.drawable.tuborg,3));
//        menuList.add(new MenuItems("Carlsberg Beer", 350, R.drawable.carlsberg, 3));
//
//
//    }
}
