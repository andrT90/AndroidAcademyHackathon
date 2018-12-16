package app.c.team.hackathon.presentation.profile;

import android.os.Bundle;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseFragment;

public class ProfileFragment extends BaseFragment {

    public static ProfileFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public int getLayoutResId() {
        return R.layout.profile;
    }
}
