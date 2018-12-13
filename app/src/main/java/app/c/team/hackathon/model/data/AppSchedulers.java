package app.c.team.hackathon.model.data;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppSchedulers {
    public Scheduler io() {
        return Schedulers.io();
    }

    public Scheduler main() {
        return AndroidSchedulers.mainThread();
    }

    public Scheduler computation() {
        return Schedulers.computation();
    }
}
