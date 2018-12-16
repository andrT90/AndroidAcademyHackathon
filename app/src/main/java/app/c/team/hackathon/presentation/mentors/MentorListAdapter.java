package app.c.team.hackathon.presentation.mentors;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.List;

import app.c.team.hackathon.model.domain.User;

public class MentorListAdapter extends ListDelegationAdapter<List<Object>> {
    public MentorListAdapter(Callback callback) {
        delegatesManager.addDelegate(new MentorListAdapterDelegate(callback));
    }


    public interface Callback {
        void onEventClick(User user);
    }
}