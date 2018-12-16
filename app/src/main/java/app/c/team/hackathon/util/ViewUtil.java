package app.c.team.hackathon.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public static void setLeftDrawble(@NonNull TextView textView, @DrawableRes int id) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(id, 0, 0, 0);
    }

    public static void copyToBuffer(View view, Context context, String s) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text", s);
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
        }
        Snackbar.make(view, "Скопировано", Snackbar.LENGTH_LONG).show();
    }

    public static void geoIntent(Context context, double lat, double lon) {
        Uri uri = Uri.parse("geo:" + lat + "," + lon);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        if (mapIntent.resolveActivity(context.getPackageManager()) != null)
            context.startActivity(mapIntent);
    }
}
