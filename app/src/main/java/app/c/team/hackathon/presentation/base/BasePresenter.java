package app.c.team.hackathon.presentation.base;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<View extends BaseView> extends MvpPresenter<View> {

    @NonNull
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposables.dispose();
    }

    protected void addToComposite(Disposable d) {
        disposables.add(d);
    }
}
