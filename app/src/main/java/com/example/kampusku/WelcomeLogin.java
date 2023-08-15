package com.example.kampusku;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeLogin extends AppCompatActivity {

    private long delayMillis = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_login);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeLogin.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
