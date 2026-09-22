package com.example.finalmadexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

/**
 * STEP 5 — Heritage Site Picker.
 * Back button → CulturalHeritageActivity.
 * Tapping a site → MapActivity.
 */
public class LocationPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_picker);

        // Back button
        LinearLayout btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        RecyclerView recyclerView = findViewById(R.id.rv_sites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Map<String, List<HeritagePlace>> grouped = HeritagePlaces.getGrouped();
        recyclerView.setAdapter(new HeritageSiteAdapter(grouped, place -> {
            Intent intent = new Intent(LocationPickerActivity.this, MapActivity.class);
            intent.putExtra("label",       place.name);
            intent.putExtra("desc",        place.address + "\n\n" + place.description);
            intent.putExtra("lat",         place.lat);
            intent.putExtra("lng",         place.lng);
            intent.putExtra("zoom",        place.zoom);
            intent.putExtra("category",    place.category);
            intent.putExtra("drawableRes", place.drawableRes);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }));
    }

    // ── Inner Adapter ─────────────────────────────────────────────────────────

    interface OnPlaceClickListener {
        void onPlaceClick(HeritagePlace place);
    }

    static class HeritageSiteAdapter
            extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM   = 1;

        private final java.util.List<Object> flatList;
        private final OnPlaceClickListener listener;

        HeritageSiteAdapter(Map<String, List<HeritagePlace>> grouped,
                            OnPlaceClickListener listener) {
            this.listener = listener;
            flatList = new java.util.ArrayList<>();
            for (Map.Entry<String, List<HeritagePlace>> entry : grouped.entrySet()) {
                flatList.add(entry.getKey());
                flatList.addAll(entry.getValue());
            }
        }

        @Override
        public int getItemViewType(int position) {
            return flatList.get(position) instanceof String ? TYPE_HEADER : TYPE_ITEM;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            if (viewType == TYPE_HEADER) {
                View v = inflater.inflate(R.layout.item_category_header, parent, false);
                return new HeaderVH(v);
            } else {
                View v = inflater.inflate(R.layout.item_heritage_site, parent, false);
                return new SiteVH(v);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof HeaderVH) {
                ((HeaderVH) holder).tvCategory.setText((String) flatList.get(position));
            } else {
                HeritagePlace place = (HeritagePlace) flatList.get(position);
                SiteVH vh = (SiteVH) holder;
                vh.tvName.setText(place.name);
                vh.tvAddress.setText(place.address);
                vh.itemView.setOnClickListener(v -> listener.onPlaceClick(place));
            }
        }

        @Override
        public int getItemCount() { return flatList.size(); }

        static class HeaderVH extends RecyclerView.ViewHolder {
            TextView tvCategory;
            HeaderVH(View v) { super(v); tvCategory = v.findViewById(R.id.tv_category); }
        }

        static class SiteVH extends RecyclerView.ViewHolder {
            TextView tvName, tvAddress;
            SiteVH(View v) {
                super(v);
                tvName    = v.findViewById(R.id.tv_site_name);
                tvAddress = v.findViewById(R.id.tv_site_address);
            }
        }
    }
}