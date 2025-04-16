Table login {
user_id integer [primary key]
username varchar // String
admin_access bool
created_at timestamp
first_name varchar
last_name varchar
password varchar

}

Table userDietInfo {
user_id int
current_Weight double
daily_calorie_intake int
caloric_delta int // can be positive or negative
goal_Weight double
target_Protein double
target_Carbs double
target_Fats double
}

Table food_entry {
food_id integer [primary key]
food_name varchar // String
total_Calories_per_Serving int
}

Table food_nutrition {
food_id integer
food_name varchar
macro_Fats double
macro_Protein double
macro_Carbs double
}
Table current_day_meal_log{

user_id int
unique_log_id int [primary key]
current_calorie day
fats_macros_for_day double
carbs_macros_for_day double
protein_macros_for_day double
created_at timestamp
}

Ref: login.user_id - userDietInfo.user_id
Ref: login.user_id - current_day_meal_log.user_id
Ref: food_entry.food_id - food_nutrition.food_id