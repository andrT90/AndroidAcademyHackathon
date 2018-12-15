package app.c.team.hackathon.presentation.login;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import app.c.team.hackathon.di.ComponentsHolder;
import app.c.team.hackathon.presentation.base.BasePresenter;
import app.c.team.hackathon.repository.LoginRepository;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class LoginPresenter extends BasePresenter<LoginView> {

    private String email;
    private final Router router;
    @Inject
    LoginRepository loginRepository;

    LoginPresenter(Router router) {
        super(router, null);
        ComponentsHolder.getInstance().appComponent().inject(this);
        this.router = router;
    }

    public void onBackPressed() {
        router.exit();
    }

    void onAuthPressed() {
        if(isValidEmail(email)){
            //TODO Server request login`
        }
        else {
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
