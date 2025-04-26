package com.example.dailydiettrackingapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.example.dailydiettrackingapp.Database.AppDatabase;
import com.example.dailydiettrackingapp.Database.DietTipDAO;
import com.example.dailydiettrackingapp.adapters.DietTipsAdapter;
import com.example.dailydiettrackingapp.Database.entities.DietTip;
import java.util.List;
import android.os.Handler;
import android.os.Looper;

public class ViewDietTipsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DietTipsAdapter adapter;
    private AppDatabase db;
    private DietTipDAO dietTipDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet_tips);

        recyclerView = findViewById(R.id.dietTipsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DietTipsAdapter(null);
        recyclerView.setAdapter(adapter);

        // Instantiate the Room database and DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").build();
        dietTipDAO = db.dietTipDAO();

        loadDietTips();
    }

    private void loadDietTips() {
        new Thread(() -> {
            List<DietTip> tips = dietTipDAO.getAllRecords();
            // Update the RecyclerView on the main thread
            new Handler(Looper.getMainLooper()).post(() ->
                    adapter.setDietTips(tips)
            );
        }).start();
    }
}