package com.intrixtech.unlok.view.Fragments;

/**
 * Created by Arti Verma on 06/04/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.intrixtech.unlok.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class UnlockTourFragment extends Fragment {

    final static String LAYOUT_ID = "layoutid";
    final static String IMAGE_POSITION = "position";

    private Integer[] mImage = {
            R.drawable.image1, R.drawable.image2,
            R.drawable.image3};

    public static UnlockTourFragment newInstance(int layoutId, int position) {
        UnlockTourFragment pane = new UnlockTourFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        args.putInt(IMAGE_POSITION, position);
        pane.setArguments(args);
        return pane;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(getArguments().getInt(LAYOUT_ID, -1), container, false);

        if (getArguments().getInt(IMAGE_POSITION, 0) < 3) {
            final ImageView category_image = (ImageView) rootView.findViewById(R.id.imageView);
            ImageLoader imageLoader = ImageLoader.getInstance();
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .build();

            imageLoader.displayImage("drawable://" + mImage[getArguments().getInt(IMAGE_POSITION, 0)], category_image, options);
        }

        return rootView;
    }
}
