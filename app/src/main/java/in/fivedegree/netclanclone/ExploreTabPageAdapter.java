package in.fivedegree.netclanclone;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import in.fivedegree.netclanclone.Fragments.BusinessFragment;
import in.fivedegree.netclanclone.Fragments.MerchantFragment;
import in.fivedegree.netclanclone.Fragments.PersonalFragment;

public class ExploreTabPageAdapter extends FragmentPagerAdapter {

    int counts;
    public ExploreTabPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.counts = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new PersonalFragment();
            case 1 : return new BusinessFragment();
            case 2 : return new MerchantFragment();
            default: return new PersonalFragment();
        }
    }

    @Override
    public int getCount() {
        return counts;
    }
}
