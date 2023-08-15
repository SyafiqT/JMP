package com.example.kampusku;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class InputDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        TextInputEditText numberEditText = findViewById(R.id.numberEditText);
        TextInputEditText nameEditText = findViewById(R.id.nameEditText);
        TextInputEditText birthDateEditText = findViewById(R.id.birthDateEditText);
        TextInputEditText addressEditText = findViewById(R.id.addressEditText);
        RadioGroup genderRadioGroup = findViewById(R.id.genderRadioGroup);


        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(
                        InputDataActivity.this,
                        (view1, year, month, dayOfMonth) -> {
                            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            birthDateEditText.setText(selectedDate);
                        },
                        2000, 0, 1
                );
                datePicker.show();
            }
        });

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = numberEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String selectedGender = "";
                int checkedRadioButtonId = genderRadioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.maleRadioButton) {
                    selectedGender = "Laki-laki";
                } else if (checkedRadioButtonId == R.id.femaleRadioButton) {
                    selectedGender = "Perempuan";
                }
                String birthDate = birthDateEditText.getText().toString();

                if (!number.isEmpty() && !name.isEmpty() && !address.isEmpty() && !selectedGender.isEmpty() && !birthDate.isEmpty()) {
                    Intent intent = new Intent(InputDataActivity.this, ListDataActivity.class);
                    intent.putExtra("number", number);
                    intent.putExtra("name", name);
                    intent.putExtra("address", address);
                    intent.putExtra("gender", selectedGender);
                    intent.putExtra("birthDate", birthDate);
                    startActivity(intent);
                } else {
                    Toast.makeText(InputDataActivity.this, "Semua input harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
