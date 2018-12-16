package app.c.team.hackathon.presentation.vacancies;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.util.ViewUtil;

public class VacancyListAdapterDelegate extends AbsListItemAdapterDelegate<VacancyItem, Object, VacancyViewHolder> {

    private final VacancyListAdapter.Callback callback;

    public VacancyListAdapterDelegate(VacancyListAdapter.Callback callback) {
        this.callback = callback;
    }

    @Override
    public boolean isForViewType(Object item, @NonNull List<Object> items, int position) {
        return item instanceof VacancyItem;
    }


    @NonNull
    @Override
    public VacancyViewHolder onCreateViewHolder(ViewGroup parent) {
        return new VacancyViewHolder(ViewUtil.inflate(parent, R.layout.vacancies_list_item));
    }

    @Override
    protected void onBindViewHolder(@NonNull VacancyItem item, @NonNull VacancyViewHolder holder, @NonNull List<Object> payloads) {
        holder.bind(item, callback);
    }
}