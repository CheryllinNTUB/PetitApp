package com.cheryl.petit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Hospitalpage extends Activity {

    Intent intent = this.getIntent();
    Bundle bundle = intent.getExtras();
    Hospitalmodel hospitalmodel = (Hospitalmodel) bundle.getSerializable("key");
}
