
package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activitymodel extends AppCompatActivity {

    private String ActivityName;
    private String ActivityContent;
    private int Activityimage;

    public Activitymodel(String ActivityName, String ActivityContent,int Activityimage){
        this.ActivityName = ActivityName;
        this.ActivityContent = ActivityContent;
        this.Activityimage = Activityimage;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public String getActivityContent() {
        return ActivityContent;
    }

    public int getImage() {
        return Activityimage;
    }
}