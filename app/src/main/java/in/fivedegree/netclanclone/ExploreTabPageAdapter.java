package in.fivedegree.netclanclone;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import in.fivedegree.netclanclone.Fragments.BusinessFragment;
import in.fivedegree.netclanclone.Fragments.MerchantFragment;
import in.fivedegree.netclanclone.Fragments.PersonalFragment;

public class ExploreTabPageAdapter extends FragmentStateAdapter {

    public ExploreTabPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new PersonalFragment();
            case 1: return new BusinessFragment();
            case 2: return new MerchantFragment();
            default: return new PersonalFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}