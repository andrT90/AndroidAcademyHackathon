package app.c.team.hackathon.presentation.mentors;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import app.c.team.hackathon.presentation.login.LoginPresenter;
import app.c.team.hackathon.presentation.login.LoginView;
import butterknife.BindView;
import butterknife.OnTextChanged;
import ru.terrakok.cicerone.Router;

public class MentorsFragment extends BaseFragment implements BackButtonListener, MentorsView {


    @InjectPresenter
    LoginPresenter presenter;

    @Inject
    Router router;

    @ProvidePresenter
    MentorsPresenter provideTutorialPresenter() {
        return new MentorsPresenter(router);
    }


    public static MentorsFragment newInstance() {

        Bundle args = new Bundle();

        MentorsFragment fragment = new MentorsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentMainView = inflater.inflate(R.layout.mentors, container);
        return fragmentMainView;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
    }


    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }

}
