package com.example.bmicalculator;

import com.example.bmicalculator.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Objects;

@SuppressWarnings("All")
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String gender;
    int height = 150;
    int weight = 30;
    int age = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.female.setColorFilter(ContextCompat.getColor(getBaseContext(), R.color.light_white));
                binding.femaleText.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.light_white));
                binding.male.setColorFilter(ContextCompat.getColor(getBaseContext(), R.color.blue));
                binding.maleText.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.blue));
                gender = "Male";
            }
        });

        binding.female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.male.setColorFilter(ContextCompat.getColor(getBaseContext(), R.color.light_white));
                binding.maleText.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.light_white));
                binding.female.setColorFilter(ContextCompat.getColor(getBaseContext(), R.color.dark_pink));
                binding.femaleText.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.dark_pink));
                gender = "Female";
            }
        });

        binding.heightSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.heightValue.setText(String.valueOf(i));
                height = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //
            }
        });

        binding.decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight > 30) {
                    weight--;
                    binding.weightValue.setText(String.valueOf(weight));
                }
            }
        });

        binding.incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (weight <= 100) {
                    weight++;
                    binding.weightValue.setText(String.valueOf(weight));
                }
            }
        });

        binding.decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age > 16) {
                    age--;
                    binding.ageValue.setText(String.valueOf(age));
                }
            }
        });

        binding.incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age <= 100) {
                    age++;
                    binding.ageValue.setText(String.valueOf(age));
                }
            }
        });

        binding.calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(gender, "Male") || Objects.equals(gender, "Female")) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("gender", gender);
                    intent.putExtra("height", height);
                    intent.putExtra("weight", weight);
                    intent.putExtra("age", age);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select all fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}