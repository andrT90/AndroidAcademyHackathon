package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import app.c.team.hackathon.R;
import app.c.team.hackathon.model.domain.Event;
import app.c.team.hackathon.presentation.base.BaseViewHolder;
import butterknife.BindView;

public class EventViewHolder extends BaseViewHolder {
    private Event item;
    private EventListAdapter.Callback callback;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.location)
    TextView location;

    @BindView(R.id.mentor)
    TextView mentor;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.month)
    TextView month;

    @BindView(R.id.time)
    TextView time;

    @BindView(R.id.number)
    TextView number;

    public void bind(Event event, EventListAdapter.Callback callback) {
        this.item = event;
        this.callback = callback;

        name.setText(item.getTitle());
    }

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
