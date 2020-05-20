package com.cheryl.petit;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

int counttab;

    public PageAdapter(FragmentManager fm, int counttab){
        super(fm);
        this.counttab = counttab;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
            return new favorite_place();
            case 1:
            return new favorite_album();
            case 2:
            return new daily();
            case 3:
            return new per_meal();
            case 4:

            default:
                return  null;
        }
    }

    @Override
    public int getCount(){
        return  counttab;
    }

    @Override
    public int getItemPosition(@Nullable Object object){
        return POSITION_NONE;
    }
}
