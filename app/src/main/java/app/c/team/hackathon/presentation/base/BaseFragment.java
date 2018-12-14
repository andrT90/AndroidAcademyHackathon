package app.c.team.hackathon.presentation.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import app.c.team.hackathon.R;
import app.c.team.hackathon.util.ViewUtil;
import app.c.team.hackathon.view.MessageDelegate;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {
    public abstract int getLayoutResId();

    private MessageDelegate messageDelegate;

    @Nullable
    @BindView(R.id.loading)
    protected View loading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        messageDelegate = new MessageDelegate(getContext());

    }

    @Override
    public void onDestroyView() {
        messageDelegate = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showError(int id) {
        messageDelegate.showError(id);
    }

    @Override
    public void showError(String text) {
        messageDelegate.showError(text);
    }

    @Override
    public void showLoading(boolean show) {
        ViewGroup vg = (ViewGroup) getView();
        if (vg == null) return;
        TransitionManager.beginDelayedTransition(vg, new Fade());
        if (loading != null) ViewUtil.viewSetVisibleOrInvisible(loading, show);
    }

    @Override
    public void showMessage(int id) {
        messageDelegate.showMessage(id);
    }

    @Override
    public void showMessage(String text) {
        messageDelegate.showMessage(text);
    }
}
