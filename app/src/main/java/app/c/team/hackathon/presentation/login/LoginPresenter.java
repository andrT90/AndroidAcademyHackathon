package app.c.team.hackathon.presentation.login;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.Screens;
import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.model.data.Preferences;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.LoginRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {

    private String email;
    private final Router router;
    @Inject
    LoginRepository loginRepository;
    @Inject
    Preferences preferences;

    LoginPresenter(Router router) {
        super(router, null);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    public void onBackPressed() {
        router.exit();
    }

    void onAuthPressed() {
        if (isValidEmail(email)) {
            addToComposite(loginRepository.login(email)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(tokenResult -> {
                        preferences.setToken(tokenResult.getToken());
                        router.newRootScreen(new Screens.BottomNavScreen());
                    }, throwable -> getViewState().showError("Сорян, братан" )
            ));
        } else {
            getViewState().validationFailed();
        }
    }

    public void onTextChanged(String email) {
        this.email = email;
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
