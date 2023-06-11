package in.fivedegree.netclanclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RefineActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView backBtn;
    String[] items = {"Available | Hey Let Us Connect", "Away | Stay Discreet And Watch", "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance HELP"};
    AutoCompleteTextView autoComplete;

    EditText statusInp;
    TextView charIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View customToolbarView = getLayoutInflater().inflate(R.layout.refine_action_bar, toolbar, false);
        toolbar.addView(customToolbarView);

        backBtn = customToolbarView.findViewById(R.id.back_btn);
        backBtn.setOnClickListener(v -> {
            finish();
        });

        autoComplete = findViewById(R.id.autoComplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.single_dropdown_item, items);
        autoComplete.setAdapter(adapter);
        autoComplete.setText(items[0], false);

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

    }
}