package com.example.finalprojectexpensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MSPV3.initHelper(this);
    }
}