package com.intrixtech.unlok.presenter.unlock;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.intrixtech.unlok.R;
import com.intrixtech.unlok.UnlockActivity;

/**
 * Created by prateekarora on 06/04/16.
 */
public class UnlockPresenterImpl implements UnlockPresenter {

    Context ctx;
    UnlockView unlockView;
    
    public UnlockPresenterImpl(Context ctx, UnlockView unlockView){
        this.ctx = ctx;
        this.unlockView = unlockView;
    }

    @Override
    public void navigateTo(Fragment fragment) {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.fragmentHolder, fragment);
        fts.addToBackStack(fragment.getClass().getSimpleName());
        fts.commit();
    }

    @Override
    public void navigateWithBundle(Fragment fragment, Bundle bundle) {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.fragmentHolder, fragment);
        fragment.setArguments(bundle);
        fts.addToBackStack(fragment.getClass().getSimpleName());
        fts.commit();
    }

    @Override
    public void navigateReplacingCurrentWithBundle(Fragment currentFragment, Fragment fragmentToNavigate, Bundle bundle) {
        fragmentToNavigate.setArguments(bundle);
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((UnlockActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void oneStepBack() {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = ((UnlockActivity) ctx).getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() >= 2) {
            fragmentManager.popBackStackImmediate();
            fts.commit();
        } else {
            ((UnlockActivity) ctx).finish();
        }
    }

    @Override
    public void navigateReplacingCurrent(Fragment currentFragment, Fragment fragmentToNavigate) {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((UnlockActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void navigateReplacingCurrentWithChild(Fragment currentFragment, Fragment fragmentToNavigate) {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        ((UnlockActivity) ctx).getSupportFragmentManager().popBackStack();
        fts.replace(R.id.fragmentHolder, fragmentToNavigate);
        fts.addToBackStack(fragmentToNavigate.getClass().getSimpleName());
        fts.remove(currentFragment).commit();
    }

    @Override
    public void hideBackNavigation() {
        unlockView.hideNavigationButton();
    }

    @Override
    public void showBackNavigation() {
        unlockView.showNavigationButton();
    }

    @Override
    public void backToParent() {
        FragmentTransaction fts = ((UnlockActivity) ctx).getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = ((UnlockActivity) ctx).getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStackImmediate();
        }
        fts.commit();
    }

    @Override
    public void changeTitle(String title) {
        unlockView.changeTitle(title);
    }
}
