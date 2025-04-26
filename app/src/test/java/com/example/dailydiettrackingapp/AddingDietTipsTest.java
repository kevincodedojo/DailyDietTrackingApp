package com.example.dailydiettrackingapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 33, manifest = "src/main/AndroidManifest.xml")
public class AddingDietTipsTest {

    @Test
    public void testAddingDietTipsActivityCreation() {
        AddingDietTips activity = Robolectric.buildActivity(AddingDietTips.class).create().get();
        assertNotNull("The AddingDietTips activity should be created", activity);
    }
}