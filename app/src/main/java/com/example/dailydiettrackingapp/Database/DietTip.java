package com.example.dailydiettrackingapp.Database;

@Entity(tableName = AppDatabase.DIET_TIP_TABLE)
public class DietTip {
    @PrimaryKey(autoGenerate = true)

    private String title;
    private String description;

}
