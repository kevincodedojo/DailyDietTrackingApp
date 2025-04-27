package com.example.dailydiettrackingapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class AddingDietTipsTest {

    @Test
    public void testAddingDietTipsActivityCreation() {
        AddingDietTips activity = Robolectric.setupActivity(AddingDietTips.class);
        assertNotNull("The AddingDietTips should be created", activity);
    }
}