package app.c.team.hackathon.presentation.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import butterknife.BindView;

public class EventInfoFragment extends BaseFragment implements BackButtonListener, EventInfoView {

    @InjectPresenter
    EventInfoPresenter presenter;
    @BindView(R.id.qr_container)
    FrameLayout qrContainer;
    @BindView(R.id.mentor_photo)
    ImageView mentorPhoto;
    @BindView(R.id.status)
    ImageView status;
    @BindView(R.id.mentor_name)
    TextView mentorName;
    @BindView(R.id.event_title)
    TextView eventTitle;
    @BindView(R.id.add_to_calendar_button)
    LinearLayout addToCalendarButton;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.location)
    Button location;
    @BindView(R.id.wifi_name)
    TextView wifiName;
    @BindView(R.id.wifi_login)
    TextView wifiLogin;
    @BindView(R.id.wifi_password)
    TextView wifiPassword;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @ProvidePresenter
    EventInfoPresenter provideTutorialPresenter() {
        return new EventInfoPresenter(((BottomNavView) getActivity()).getRouter());
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_info;
    }


    public static EventInfoFragment newInstance() {
        Bundle args = new Bundle();
        EventInfoFragment fragment = new EventInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }


    private void initViews() {

    }

    @Override
    public boolean onBackPressed() {
        presenter.backClicked();
        return true;

    }


}
