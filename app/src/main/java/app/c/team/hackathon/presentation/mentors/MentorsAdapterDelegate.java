//package app.c.team.hackathon.presentation.mentors;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
//
//import java.util.List;
//
//import app.c.team.hackathon.R;
//import app.c.team.hackathon.model.domain.User;
//
//public class MentorsAdapterDelegate extends AdapterDelegate<List<User>> {
//
//    private LayoutInflater inflater;
//
//    public MentorsAdapterDelegate(Activity activity) {
//        inflater = activity.getLayoutInflater();
//    }
//
//    @Override
//    public boolean isForViewType(@NonNull List<User> items, int position) {
//        return items.get(position) instanceof User;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
//        //todo layout for viewHolder
//        return new CatViewHolder(inflater.inflate(R.layout.item_cat, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull List<User> items, int position,
//                                 @NonNull RecyclerView.ViewHolder holder,
//                                 @Nullable List<Object> payloads) {
//
//        CatViewHolder vh = (CatViewHolder) holder;
//        Cat cat = (Cat) items.get(position);
//
//        vh.name.setText(cat.getName());
//    }
//
//    static class CatViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView name;
//
//        public CatViewHolder(View itemView) {
//            super(itemView);
//            name = (TextView) itemView.findViewById(R.id.name);
//        }
//    }
//}