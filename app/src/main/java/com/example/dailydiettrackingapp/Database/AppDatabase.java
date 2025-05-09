package com.example.dailydiettrackingapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dailydiettrackingapp.Database.entities.DietTip;
import com.example.dailydiettrackingapp.Database.entities.DietTracking;
import com.example.dailydiettrackingapp.Database.entities.Meal;
import com.example.dailydiettrackingapp.Database.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@Database(entities = {Meal.class, DietTip.class, User.class, DietTracking.class}, version = 4, exportSchema = false)


public abstract class AppDatabase extends RoomDatabase {
    public static final String DIET_TIP_TABLE = "dietTipTable";


    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile AppDatabase INSTANCE;

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = androidx.room.Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(androidx.sqlite.db.SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                // Add default diet tips
                DietTipDAO dietTipDAO = INSTANCE.dietTipDAO();
                dietTipDAO.insert(new DietTip("Stay Hydrated", "Drink at least 8 glasses of water daily."));
                dietTipDAO.insert(new DietTip("Eat More Vegetables", "Aim for 5 servings of vegetables per day."));
                dietTipDAO.insert(new DietTip("Portion Control", "Use smaller plates to control portion sizes."));

                //add default meals or users here if needed

                // Insert default data for User table
                UserDAO userDAO = INSTANCE.userDAO();
                userDAO.insert(new User("admin", "admin"));
                userDAO.insert(new User("user1", "user1"));




                // Insert default data for DietTracking table
                DietTrackingDAO dietTrackingDAO = INSTANCE.dietTrackingDAO();
                for (int i = 1; i <= 50; i++) {
                    dietTrackingDAO.insert(new DietTracking("Meal " + i, "2023-10-" + (i % 30 + 1), 100 + i * 10));
                }
                dietTrackingDAO.insert(new DietTracking("Breakfast", "2023-10-01", 300));
                dietTrackingDAO.insert(new DietTracking("Lunch", "2023-10-01", 600));
            });
        }

    };


    public abstract MealDAO mealDAO();

    public abstract DietTipDAO dietTipDAO();

    public abstract UserDAO userDAO();

    public abstract DietTrackingDAO dietTrackingDAO();
}