package com.cheryl.petit;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//用在卡路里和我的最愛
public class PagerAdapter extends FragmentPagerAdapter {
    private  int numOfTabs;

    public  PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new daily();
            case 1:
                return new permeal();
            case 2:
                return new favorite_album();
            case 3:
                return new favorite_place();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public  int getItemPosition(@NonNull Object object){
        return POSITION_NONE;
    }
}
