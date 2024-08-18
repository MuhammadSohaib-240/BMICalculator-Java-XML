package com.example.bmicalculator;

import com.example.bmicalculator.databinding.ActivityResultBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.os.Bundle;

@SuppressWarnings("All")
public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;
    double BMI;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        String gender = bundle.getString("gender");
        int height = bundle.getInt("height");
        int weight = bundle.getInt("weight");
        int age = bundle.getInt("age");

        BMI = (weight / Math.pow(2, (height * 0.01)));

        if (BMI <= 18.5) {
            binding.bmiText.setText(String.format("%.3f", BMI));
            binding.genderText.setText(gender);
            binding.bmiStatus.setText("Underweight");
            binding.bmiStatus.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.blue));
            binding.warningImages.setBackgroundResource(R.drawable.blue_warning);
            binding.tipText.setText("Tip: Gain some weight by building muscles.");
        }

        else if (BMI > 18.5 && BMI <= 25) {
            binding.bmiText.setText(String.format("%.3f", BMI));
            binding.genderText.setText(gender);
            binding.bmiStatus.setText("Normal");
            binding.bmiStatus.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.green));
            binding.warningImages.setBackgroundResource(R.drawable.green_warning);
            binding.tipText.setText("Tip: Your BMI is normal. Just keep yourself maintain.");
        }

        else if (BMI > 25 && BMI <= 30) {
            binding.bmiText.setText(String.format("%.3f", BMI));
            binding.genderText.setText(gender);
            binding.bmiStatus.setText("Overweight");
            binding.bmiStatus.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.yellow));
            binding.warningImages.setBackgroundResource(R.drawable.yellow_warning);
            binding.tipText.setText("Tip: You should reduce your weight by focusing on basic exercises." +
                    " And by follow basic diet program.");
        }

        else if (BMI > 30) {
            binding.bmiText.setText(String.format("%.3f", BMI));
            binding.genderText.setText(gender);
            binding.bmiStatus.setText("Obese");
            binding.bmiStatus.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.red));
            binding.warningImages.setBackgroundResource(R.drawable.red_warning);
            binding.tipText.setText("Tip: You need to workout hard, and also follow a strict diet plan.");
        }
    }
}