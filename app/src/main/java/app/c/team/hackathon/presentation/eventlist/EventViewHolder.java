package app.c.team.hackathon.presentation.eventlist;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseViewHolder;
import app.c.team.hackathon.util.DateUtil;
import app.c.team.hackathon.util.ViewUtil;
import butterknife.BindView;
import butterknife.OnClick;

public class EventViewHolder extends BaseViewHolder {
    private EventItem eventItem;
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

    @BindView(R.id.line_top)
    View lineTop;

    @BindView(R.id.line_bottom)
    View lineBottom;

    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.circle)
    View circle;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(v -> callback.onEventClick(eventItem.getItem()));
    }

    public void bind(EventItem event, EventListAdapter.Callback callback) {
        this.eventItem = event;
        this.callback = callback;

        name.setText(eventItem.getItem().getTitle());
        location.setText(eventItem.getItem().getLocation().getTitle());
        mentor.setText(eventItem.getItem().getMentor().getFullName());
        date.setText(DateUtil.getDayOfMonth(eventItem.getItem().getStartDate()));
        month.setText(DateUtil.getMonth(eventItem.getItem().getStartDate()).substring(0, 3).toUpperCase());
        time.setText(DateUtil.getTime(eventItem.getItem().getStartDate()));
        number.setText(String.format("#%s", String.valueOf(eventItem.getItem().getNumber())));


        ViewUtil.viewSetVisibleOrInvisible(lineTop, eventItem.isFirst());
        ViewUtil.viewSetVisibleOrInvisible(lineBottom, eventItem.isLast());

        if (eventItem.isVisited()) {
            ViewUtil.viewSetVisibleOrInvisible(status, true);
            status.setText(R.string.event_list_check_in);
            ViewUtil.setLeftDrawble(status, R.drawable.circle_check_green);
        } else if (eventItem.getItem().isRegistered()) {
            ViewUtil.viewSetVisibleOrInvisible(status, true);
            status.setText(R.string.event_list_registered);
            ViewUtil.setLeftDrawble(status, R.drawable.circle_yellow);
        } else ViewUtil.viewSetVisibleOrInvisible(status, false);

        circle.setBackgroundResource(
                DateUtil.compareToNow(eventItem.getItem().getStartDate()) > 1
                        ? R.drawable.circle_green
                        : R.drawable.circle_gray);
    }

    @OnClick(R.id.location)
    void onLocationClick() {
        callback.onLocationClick(eventItem.getItem());
    }
}
