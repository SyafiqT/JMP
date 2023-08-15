package com.example.kampusku;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class UpdateDataActivity extends AppCompatActivity {

    private TextInputEditText numberEditText;
    private TextInputEditText nameEditText;
    private TextInputEditText birthDateEditText;
    private TextInputEditText addressEditText;
    private RadioGroup genderRadioGroup;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        numberEditText = findViewById(R.id.numberEditText);
        nameEditText = findViewById(R.id.nameEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        addressEditText = findViewById(R.id.addressEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String gender = intent.getStringExtra("gender");
        String birthDate = intent.getStringExtra("birthDate");

        numberEditText.setText(number);
        nameEditText.setText(name);
        birthDateEditText.setText(birthDate);
        addressEditText.setText(address);
        if (gender.equals("Laki-laki")) {
            genderRadioGroup.check(R.id.maleRadioButton);
        } else if (gender.equals("Perempuan")) {
            genderRadioGroup.check(R.id.femaleRadioButton);
        }

        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(
                        UpdateDataActivity.this,
                        (view1, year, month, dayOfMonth) -> {
                            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            birthDateEditText.setText(selectedDate);
                        },
                        2000, 0, 1
                );
                datePicker.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedNumber = numberEditText.getText().toString();
                String updatedName = nameEditText.getText().toString();
                String updatedAddress = addressEditText.getText().toString();
                String updatedGender = "";
                int checkedRadioButtonId = genderRadioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.maleRadioButton) {
                    updatedGender = "Laki-laki";
                } else if (checkedRadioButtonId == R.id.femaleRadioButton) {
                    updatedGender = "Perempuan";
                }
                String updatedBirthDate = birthDateEditText.getText().toString();

                Intent intent = new Intent(UpdateDataActivity.this, ListDataActivity.class);
                intent.putExtra("number", updatedNumber);
                intent.putExtra("name", updatedName);
                intent.putExtra("address", updatedAddress);
                intent.putExtra("gender", updatedGender);
                intent.putExtra("birthDate", updatedBirthDate);
                startActivity(intent);
            }
        });
    }
}
