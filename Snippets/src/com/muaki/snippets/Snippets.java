package com.muaki.snippets;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Snippets extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snippets);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_snippets, menu);
        return true;
    }
}
