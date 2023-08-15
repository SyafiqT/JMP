package com.example.kampusku;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ListDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        TextView nameTextView = findViewById(R.id.nameTextView);

        String number = getIntent().getStringExtra("number");
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String gender = getIntent().getStringExtra("gender");
        String birthDate = getIntent().getStringExtra("birthDate");

        nameTextView.setText(name);

        nameTextView.setOnClickListener(view -> {
            String[] options = {"Lihat Data", "Update Data", "Hapus Data"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(name)
                    .setItems(options, (dialogInterface, which) -> {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(ListDataActivity.this, DetailDataActivity.class);
                                intent.putExtra("number", number);
                                intent.putExtra("name", name);
                                intent.putExtra("address", address);
                                intent.putExtra("gender", gender);
                                intent.putExtra("birthDate", birthDate);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent updateIntent = new Intent(ListDataActivity.this, UpdateDataActivity.class);
                                updateIntent.putExtra("number", number);
                                updateIntent.putExtra("name", name);
                                updateIntent.putExtra("address", address);
                                updateIntent.putExtra("gender", gender);
                                updateIntent.putExtra("birthDate", birthDate);
                                startActivity(updateIntent);
                                break;
                            case 2:
                                AlertDialog.Builder deleteConfirmationBuilder = new AlertDialog.Builder(this);
                                deleteConfirmationBuilder.setTitle("Konfirmasi Hapus")
                                        .setMessage("Apakah Anda yakin ingin menghapus data ini?")
                                        .setPositiveButton("Iya", (dialogInterface1, i) -> {
                                            Intent intent1 = getIntent();
                                            intent1.removeExtra("number");
                                            intent1.removeExtra("name");
                                            intent1.removeExtra("address");
                                            intent1.removeExtra("gender");
                                            intent1.removeExtra("birthDate");

                                            Intent intent2 = new Intent(ListDataActivity.this, ListDataActivity.class);
                                            startActivity(intent2);
                                        })
                                        .setNegativeButton("Tidak", null);
                                deleteConfirmationBuilder.show();
                                break;
                        }
                    });
            builder.show();
        });

        Button inputDataButton = findViewById(R.id.inputDataButton);
        inputDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(ListDataActivity.this, InputDataActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
