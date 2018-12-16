package app.c.team.hackathon.presentation.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseFragment;
import butterknife.BindView;

public class ProfileFragment extends BaseFragment {

    private List<Integer> androids = new ArrayList<>(Arrays.asList(
            R.drawable.android_1,
            R.drawable.android_2,
            R.drawable.android_3,
            R.drawable.android_4,
            R.drawable.android_5,
            R.drawable.android_6,
            R.drawable.android_blur_1,
            R.drawable.android_blur_2,
            R.drawable.android_blur_3,
            R.drawable.android_blur_4,
            R.drawable.android_blur_5,
            R.drawable.android_blur_6
    ));

    private List<Integer> wordsRes = new ArrayList<>(Arrays.asList(
            R.string.profile_word_1,
            R.string.profile_word_2,
            R.string.profile_word_3
    ));

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.robot)
    ImageView robot;

    @BindView(R.id.words)
    TextView words;

    @BindView(R.id.toolbar_title)
    TextView title;


    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        words.setText(wordsRes.get(0));
        robot.setImageResource(androids.get(0));
        title.setText(R.string.profile_title);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int i = tab.getPosition();
                words.setText(wordsRes.get(i % wordsRes.size()));
                robot.setImageResource(androids.get(i % androids.size()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabs.removeAllTabs();
        for (int i = 0; i < 12; i++) {
            TabLayout.Tab tab = tabs.newTab();
            DecimalFormat df = new DecimalFormat("#00");
            tab.setText(df.format(i + 1));
            tabs.addTab(tab);
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.profile;
    }
}
