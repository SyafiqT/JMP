package com.example.kampusku;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button lihatDataButton = findViewById(R.id.lihatDataButton);
        Button inputDataButton = findViewById(R.id.inputDataButton);
        Button informasiButton = findViewById(R.id.informasiButton);

        lihatDataButton.setOnClickListener(this);
        inputDataButton.setOnClickListener(this);
        informasiButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lihatDataButton:
                Intent lihatDataIntent = new Intent(this, ListDataActivity.class);
                startActivity(lihatDataIntent);
                break;
            case R.id.inputDataButton:
                Intent inputDataIntent = new Intent(this, InputDataActivity.class);
                startActivity(inputDataIntent);
                break;
            case R.id.informasiButton:
                Intent informasiIntent = new Intent(this, InformasiActivity.class);
                startActivity(informasiIntent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
