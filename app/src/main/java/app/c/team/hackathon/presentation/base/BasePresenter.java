package app.c.team.hackathon.presentation.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

public class BasePresenter<View extends BaseView> extends MvpPresenter<View> {
    @Nullable
    protected final Router mainRouter;

    @Nullable
    protected final Router localRouter;

    public BasePresenter(@Nullable Router mainRouter, @Nullable Router localRouter) {
        this.mainRouter = mainRouter;
        this.localRouter = localRouter;
    }

    @NonNull
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.dispose();
    }


    public void backClicked() {
        if (localRouter != null) localRouter.exit();
        else if (mainRouter != null) mainRouter.exit();
    }

    protected void addToComposite(Disposable d) {
        disposables.add(d);
    }
}
