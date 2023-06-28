package in.fivedegree.netclanclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class RefineActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView backBtn;
    String[] items = {"Available | Hey Let Us Connect", "Away | Stay Discreet And Watch", "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance HELP"};
    String[] purposeItems = {"Coffee", "Business", "Hobbies", "Friendship", "Movies", "Dinning", "Dating", "Matrimony"};
    AutoCompleteTextView autoComplete;

    EditText statusInp;
    TextView charIndicator;
    ChipGroup chipGroup;
    LinearLayout saveBtn;
    ArrayList<String> selectedPurpose = new ArrayList<String>() ;
    int distanceValue = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

//        ==============================
//        ACTIONBAR
//        ==============================
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View customToolbarView = getLayoutInflater().inflate(R.layout.refine_action_bar, toolbar, false);
        toolbar.addView(customToolbarView);

        backBtn = customToolbarView.findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> {
            finish();
        });

//        ==============================
//        DropDown
//        ==============================
        autoComplete = findViewById(R.id.autoComplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.single_dropdown_item, items);
        autoComplete.setAdapter(adapter);
        autoComplete.setText(items[0], false);

//        ==============================
//        Status Input
//        ==============================
        statusInp = findViewById(R.id.statusInp);
        charIndicator = findViewById(R.id.charIndicator);
        charIndicator.setText(statusInp.length() + "/250");
        statusInp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                charIndicator.setText(statusInp.length()+ "/250");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        ==============================
//        Location Distance Slider
//        ==============================
        Slider seekbar = findViewById(R.id.seekBar);

        seekbar.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                distanceValue = (int) seekbar.getValue();
            }
        });

//        ==============================
//        Purpose
//        ==============================
        chipGroup = findViewById(R.id.chip_group);

        for (int i =0;i< purposeItems.length;i++){
            Chip chip = new Chip(this);
            chip.setText(purposeItems[i]);

            chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.white_001)));
            chip.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.blue_001)));
            chip.setChipStrokeWidth(getResources().getDimension(R.dimen.chip_stroke_width));
            chip.setTextColor(getResources().getColor(R.color.blue_001));

            chip.setCheckable(true);
            chip.setClickable(true);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (chip.isChecked()){
                        selectedPurpose.add(chip.getText().toString());
                        chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.blue_001)));
                        chip.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.blue_001)));
                        chip.setChipStrokeWidth(getResources().getDimension(R.dimen.chip_stroke_width));
                        chip.setTextColor(getResources().getColor(R.color.white_001));
                        chip.setCheckedIcon(null);
                    }
                    else {
                        chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.white_001)));
                        chip.setChipStrokeColor(ColorStateList.valueOf(getResources().getColor(R.color.blue_001)));
                        chip.setChipStrokeWidth(getResources().getDimension(R.dimen.chip_stroke_width));
                        chip.setTextColor(getResources().getColor(R.color.blue_001));
                    }
                }
            });
            if (purposeItems[i] == "Coffee" || purposeItems[i] == "Business" || purposeItems[i] == "Friendship"){
                chip.setChecked(true);
                chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.blue_001)));
                chip.setTextColor(getResources().getColor(R.color.white_001));
            }
            chipGroup.addView(chip);

        }

//        ==============================
//        Save Button
//        ==============================
        saveBtn = findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(v ->{
            Toast.makeText(this, "Your Selected Availability: " + autoComplete.getText().toString() +
                    "\nYour Status: " + statusInp.getText().toString() +
                    "\n Your Selected Distance: "+ distanceValue +
                    "\n Your Selected Purposes: " + selectedPurpose.toString(), Toast.LENGTH_SHORT).show();
        });

    }
}