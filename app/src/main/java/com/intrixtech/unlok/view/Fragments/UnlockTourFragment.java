package com.intrixtech.unlok.view.Fragments;

/**
 * Created by Arti Verma on 06/04/16.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UnlockTourFragment extends Fragment{

    final static String LAYOUT_ID = "layoutid";

    public static UnlockTourFragment newInstance(int layoutId) {
        UnlockTourFragment pane = new UnlockTourFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        pane.setArguments(args);
        return pane;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(getArguments().getInt(LAYOUT_ID, -1), container, false);
        return rootView;
    }
}