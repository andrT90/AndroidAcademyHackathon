package app.c.team.hackathon.presentation.vacancies;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

import app.c.team.hackathon.model.domain.Vacancy;

public class VacancyListAdapter extends ListDelegationAdapter<List<Object>> {
    public VacancyListAdapter(Callback callback) {
        delegatesManager.addDelegate(new VacancyListAdapterDelegate(callback));
    }

    public void setData(List<Object> data) {
        setItems(data);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onEventClick(Vacancy vacancy);
    }
}