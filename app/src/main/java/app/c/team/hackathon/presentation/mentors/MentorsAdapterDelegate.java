//package app.c.team.hackathon.presentation.mentors;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//
//public class MentorsAdapterDelegate extends AdapterDelegate<List<MentorsPresenter>> {
//
//  private LayoutInflater inflater;
//
//  public MentorsAdapterDelegate(Activity activity) {
//    inflater = activity.getLayoutInflater();
//  }
//
//  @Override public boolean isForViewType(@NonNull List<Animal> items, int position) {
//    return items.get(position) instanceof Cat;
//  }
//
//  @NonNull @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
//    return new CatViewHolder(inflater.inflate(R.layout.item_cat, parent, false));
//  }
//
//  @Override public void onBindViewHolder(@NonNull List<Animal> items, int position,
//      @NonNull RecyclerView.ViewHolder holder, @Nullable List<Object> payloads) {
//
//    CatViewHolder vh = (CatViewHolder) holder;
//    Cat cat = (Cat) items.get(position);
//
//    vh.name.setText(cat.getName());
//  }
//
//  static class CatViewHolder extends RecyclerView.ViewHolder {
//
//    public TextView name;
//
//    public CatViewHolder(View itemView) {
//      super(itemView);
//      name = (TextView) itemView.findViewById(R.id.name);
//    }
//  }
//}