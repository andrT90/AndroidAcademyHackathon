package app.c.team.hackathon.presentation.mentors;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;

import java.util.List;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.User;
import app.c.team.hackathon.util.ViewUtil;

public class MentorListAdapterDelegate extends AbsListItemAdapterDelegate<MentorItem, Object, MentorViewHolder> {

    private final MentorListAdapter.Callback callback;

    public MentorListAdapterDelegate(MentorListAdapter.Callback callback) {
        this.callback = callback;
    }

    @Override
    public boolean isForViewType(Object item, @NonNull List<Object> items, int position) {
        return items instanceof User;
    }


    @NonNull
    @Override
    public MentorViewHolder onCreateViewHolder(ViewGroup parent) {
        return new MentorViewHolder(ViewUtil.inflate(parent, R.layout.mentors_list_item));
    }

    @Override
    protected void onBindViewHolder(@NonNull MentorItem item, @NonNull MentorViewHolder holder, @NonNull List<Object> payloads) {
        holder.bind(item, callback);
    }
}