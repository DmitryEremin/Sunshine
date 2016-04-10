package com.dmitry.eremin.sunshine;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            Fragment newFragment = new PlaceHolderFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.mainActivity, newFragment).commit();
        }
    }

    public static class PlaceHolderFragment extends Fragment {
        public PlaceHolderFragment(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.frame_main, container, false);

            String[] items = {
                    "Today - Sunny - 12/7",
                    "Tomorrow - Sunny - 13/8",
                    "12.04 - Cloud - 9/3",
                    "13.04 - Rain - 7/0",
                    "14.04 - Cloud - 9/3",
                    "15.04 - Rain - 7/0",
                    "16.04 - Cloud - 9/3",
                    "17.04 - Rain - 7/0",
                    "18.04 - Cloud - 9/3",
                    "19.04 - Rain - 7/0",
                    "20.04 - Cloud - 9/3",
                    "21.04 - Rain - 7/0",
                    "22.04 - Cloud - 9/3",
                    "23.04 - Rain - 7/0",
            };
            List<String> forecastList = new ArrayList<String>(Arrays.asList(items));

            ArrayAdapter<String> adapterArray = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    forecastList);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(adapterArray);

            return rootView;
        }
    }
}


