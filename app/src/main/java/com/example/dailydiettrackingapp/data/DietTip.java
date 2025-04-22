package com.example.dailydiettrackingapp.data;

@Entity(tableName = AppDatabase.DIET_TIP_TABLE)
public class DietTip {
    @PrimaryKey(autoGenerate = true)

    private String title;
    private String description;

}
