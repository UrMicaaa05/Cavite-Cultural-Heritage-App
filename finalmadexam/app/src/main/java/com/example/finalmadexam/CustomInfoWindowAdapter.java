package com.example.finalmadexam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom info window that shows a photo thumbnail when a map marker is tapped.
 * Moved from com.fam.favlocation → com.example.finalmadexam.
 */
public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final Context context;
    private final Map<String, Bitmap> bitmapCache = new HashMap<>();

    private static final int WINDOW_WIDTH_DP = 130;

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null; // use default frame, custom content only
    }

    @Override
    public View getInfoContents(Marker marker) {
        String markerId = marker.getId();
        int widthPx = dpToPx(WINDOW_WIDTH_DP);

        if (bitmapCache.containsKey(markerId)) {
            Bitmap cached = bitmapCache.get(markerId);
            return makeBitmapView(cached, widthPx);
        }

        View view = LayoutInflater.from(context)
                .inflate(R.layout.info_window_place, null);
        view.setBackgroundColor(
                context.getResources().getColor(R.color.forest_deep, null));

        ImageView ivPhoto = view.findViewById(R.id.iw_photo);
        ivPhoto.setBackgroundColor(
                context.getResources().getColor(R.color.forest_mid, null));

        Object tag = marker.getTag();
        if (tag instanceof Integer) {
            ivPhoto.setImageResource((Integer) tag);
            ivPhoto.setVisibility(View.VISIBLE);
        } else {
            ivPhoto.setVisibility(View.GONE);
        }

        int wSpec = View.MeasureSpec.makeMeasureSpec(widthPx, View.MeasureSpec.EXACTLY);
        int hSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(wSpec, hSpec);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        Bitmap bmp = Bitmap.createBitmap(
                view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bmp));
        bitmapCache.put(markerId, bmp);

        return makeBitmapView(bmp, widthPx);
    }

    private ImageView makeBitmapView(Bitmap bmp, int widthPx) {
        ImageView iv = new ImageView(context);
        iv.setImageBitmap(bmp);
        iv.setBackgroundColor(
                context.getResources().getColor(R.color.forest_deep, null));
        iv.measure(
                View.MeasureSpec.makeMeasureSpec(widthPx, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(bmp.getHeight(), View.MeasureSpec.EXACTLY));
        iv.layout(0, 0, widthPx, bmp.getHeight());
        return iv;
    }

    private int dpToPx(int dp) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }
}