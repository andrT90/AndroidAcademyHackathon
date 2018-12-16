package app.c.team.hackathon.presentation.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
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
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BackButtonListener;
import app.c.team.hackathon.presentation.base.BaseFragment;
import butterknife.BindView;
import butterknife.OnTextChanged;
import ru.terrakok.cicerone.Router;

public class LoginFragment extends BaseFragment implements BackButtonListener, LoginView {


    @InjectPresenter
    LoginPresenter presenter;

    @Inject
    Router router;

    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.email)
    EditText emailView;
    @BindView(R.id.enter)
    Button enterBtn;
    @BindView(R.id.progress_bar_frame)
    FrameLayout progressBarFrame;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @ProvidePresenter
    LoginPresenter provideTutorialPresenter() {
        return new LoginPresenter(router);
    }


    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        ComponentsHolder.getInstance().appComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        enterBtn.setOnClickListener(v -> presenter.onAuthPressed());
    }

    @OnTextChanged(value = R.id.email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    protected void onTextChanged(Editable e){
        presenter.onTextChanged(e.toString());
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

    @Override
    public void validationFailed() {
        tilEmail.setErrorEnabled(true);
        tilEmail.setError(getString(R.string.email_validation_error));
    }
}
