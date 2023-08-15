package com.example.kampusku;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        String number = getIntent().getStringExtra("number");
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String gender = getIntent().getStringExtra("gender");
        String birthDate = getIntent().getStringExtra("birthDate");

        TextView numberTextView = findViewById(R.id.numberTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);
        TextView birthDateTextView = findViewById(R.id.birthDateTextView);

        numberTextView.setText("Nomor: " + number);
        nameTextView.setText("Nama: " + name);
        addressTextView.setText("Alamat: " + address);
        genderTextView.setText("Jenis Kelamin: " + gender);
        birthDateTextView.setText("Tanggal Lahir: " + birthDate);
    }
}
