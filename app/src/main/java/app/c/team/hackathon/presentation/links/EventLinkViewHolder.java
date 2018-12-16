package app.c.team.hackathon.presentation.links;

import android.view.View;
import android.widget.TextView;

import app.c.team.hackathon.R;
import app.c.team.hackathon.presentation.base.BaseViewHolder;
import butterknife.BindView;

public class EventLinkViewHolder extends BaseViewHolder {

    EventLinkItem eventLinkItem;
    EventLinkListAdapter.Callback callback;


    @BindView(R.id.event_link_item_title)
    TextView title;

    public void bind(EventLinkItem item, EventLinkListAdapter.Callback callback) {
        this.eventLinkItem = item;
        this.callback = callback;
        title.setText(item.getTitle());
        itemView.setOnClickListener(v -> {

        });
    }

    public EventLinkViewHolder(View itemView) {
        super(itemView);
    }
}
