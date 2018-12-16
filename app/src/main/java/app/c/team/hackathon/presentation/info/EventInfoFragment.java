package app.c.team.hackathon.presentation.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.bottom.BottomNavView;
import app.c.team.hackathon.util.ViewUtil;
import butterknife.BindView;

public class EventInfoFragment extends BaseFragment implements BackButtonListener, EventInfoView {


    private static final String KEY_EVENT = "EVENT";
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
        return new EventInfoPresenter(((BottomNavView) getActivity()).getRouter(), getArguments().getParcelable(KEY_EVENT));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_event_info;
    }


    public static EventInfoFragment newInstance(Event event) {
        Bundle args = new Bundle();
        EventInfoFragment fragment = new EventInfoFragment();
        args.putParcelable(KEY_EVENT, event);
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


    @Override
    public void showEvent(Event event) {
        // photo
        if (event.getMentor() != null && event.getMentor().getPhoto() != null) {
            ViewUtil.loadImage(mentorPhoto, event.getMentor().getPhoto());
            mentorPhoto.setVisibility(View.VISIBLE);
        } else {
            mentorPhoto.setVisibility(View.GONE);
        }

        // name
        if (event.getMentor() != null && event.getMentor().getName() != null) {
            mentorName.setText(event.getMentor().getName());
            mentorName.setVisibility(View.VISIBLE);
        } else {
            mentorName.setVisibility(View.GONE);
        }

        // title
        if (event.getTitle() != null) {
            eventTitle.setText(event.getTitle());
            eventTitle.setVisibility(View.VISIBLE);
        } else {
            eventTitle.setVisibility(View.GONE);
        }

        // add to calendar
        addToCalendarButton.setOnClickListener(view -> {
            // todo intent
            event.getStartDate();
        });

        // date
        // todo format
        date.setText("" + event.getStartDate());

        // time
        // todo format
        time.setText("" + event.getStartDate());


        // description
        if (event.getDescription() != null) {
            description.setText(event.getMentor().getName());
            description.setVisibility(View.VISIBLE);
        } else {
            description.setVisibility(View.GONE);
        }

        //location
        if (event.getLocation() != null && event.getLocation().getTitle() != null) {
            location.setText(event.getLocation().getTitle());
            location.setOnClickListener(view -> {
                // todo open map
            });
            location.setVisibility(View.VISIBLE);
        } else {
            location.setVisibility(View.GONE);
        }


        // wifiName
        if (event.getLocation() != null && event.getLocation().getWifi() != null && event.getLocation().getWifi().getName() != null) {
            wifiName.setText("Wi-fi: " + event.getLocation().getWifi().getName());
            wifiName.setOnClickListener(view -> {
                ViewUtil.copyToBuffer(getContext(), event.getLocation().getWifi().getName());
            });
            wifiName.setVisibility(View.VISIBLE);
        } else {
            wifiName.setVisibility(View.GONE);
        }

        // wifiLogin
        if (event.getLocation() != null && event.getLocation().getWifi() != null && event.getLocation().getWifi().getLogin() != null) {
            wifiLogin.setText("LOGIN: " + event.getLocation().getWifi().getLogin());
            wifiLogin.setOnClickListener(view -> {
                ViewUtil.copyToBuffer(getContext(), event.getLocation().getWifi().getLogin());
            });
            wifiLogin.setVisibility(View.VISIBLE);
        } else {
            wifiLogin.setVisibility(View.GONE);
        }

        // wifiPassword
        if (event.getLocation() != null && event.getLocation().getWifi() != null && event.getLocation().getWifi().getPassword() != null) {
            wifiPassword.setText("PASSWORD: " + event.getLocation().getWifi().getPassword());
            wifiPassword.setOnClickListener(view -> {
                ViewUtil.copyToBuffer(getContext(), event.getLocation().getWifi().getPassword());
            });
            wifiPassword.setVisibility(View.VISIBLE);
        } else {
            wifiPassword.setVisibility(View.GONE);
        }

        // todo status


        // register button
        //todo if status not reg and time not past
        fab.setOnClickListener(view -> {
            // todo register
        });

    }
}
