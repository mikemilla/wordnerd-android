package com.mikemilla.wordnerd.activities;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikemilla.wordnerd.R;

public class PageFragment extends android.support.v4.app.Fragment {

    public static String TIP_KEY = "tip";

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(getArguments().getString(TIP_KEY));

        return view;
    }

    public static PageFragment newInstance(String tip) {

        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TIP_KEY, tip);
        fragment.setArguments(bundle);

        return fragment;
    }


}
