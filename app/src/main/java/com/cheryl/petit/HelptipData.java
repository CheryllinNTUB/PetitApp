package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
//使用於小幫手
public class HelptipData extends AppCompatActivity {

    private String  help_name;
    private String  help_description;
    private int help_img;

    public HelptipData(String helpname,String helpdescription,int helpimg){
        this.help_name =  helpname;
        this.help_description = helpdescription;
        this.help_img =  helpimg;
    }

    public String getHelpname(){
        return help_name;
    }

    public String getHelpdescription(){
        return help_description;
    }

    public int getHelpimg(){
        return help_img;
    }

}
