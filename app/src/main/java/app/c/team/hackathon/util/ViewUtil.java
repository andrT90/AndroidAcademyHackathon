package app.c.team.hackathon.util;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ViewUtil {
    private ViewUtil() {
        //no instance
    }

    public static void viewSetVisibleOrGone(@NonNull View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public static void viewSetVisibleOrInvisible(@NonNull View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    public static boolean viewIsVisible(@NonNull View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    public static View inflate(@NonNull ViewGroup parent, @LayoutRes int id) {
        return LayoutInflater.from(parent.getContext()).inflate(id, parent, false);
    }

    public static void loadImage(ImageView portrait, String imageUrl) {
        Picasso.get().load(imageUrl).into(portrait);
    }
}
