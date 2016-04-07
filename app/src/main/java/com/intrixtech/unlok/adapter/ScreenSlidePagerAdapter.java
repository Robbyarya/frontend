package com.intrixtech.unlok.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.intrixtech.unlok.R;
import com.intrixtech.unlok.utils.Constants;
import com.intrixtech.unlok.view.Fragments.UnlockTourFragment;

/**
 * Created by Arti Verma on 06/04/16.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        UnlockTourFragment fm = new UnlockTourFragment();
        switch (position) {
            case 0:
                fm = UnlockTourFragment.newInstance(R.layout.tour_screen1, 0);
                break;
            case 1:
                fm = UnlockTourFragment.newInstance(R.layout.tour_screen2, 1);
                break;
            case 2:
                fm = UnlockTourFragment.newInstance(R.layout.tour_screen3, 2);
                break;
            case 3:
                fm = UnlockTourFragment.newInstance(R.layout.tour_screen4, 3);
                break;
        }

        return fm;
    }

    @Override
    public int getCount() {
        return Constants.NUM_PAGES;
    }
}
