package in.fivedegree.netclanclone.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import in.fivedegree.netclanclone.R;

public class PersonalFragment extends Fragment {

    EditText SearchInp;
    ImageView filterBtn, clearSearchBtn;
    RecyclerView recyclerView;
    adapter adapter;
    ArrayList<model> data;
    model e;

    FloatingActionButton fab;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_personal, container, false);

//        displaying data to user
        data = new ArrayList<>();
        for(int i = 0; i< 20; i++){
            e = new model("Image Url","Nitesh Gupta", "Mumbai", "Android Developer","2 KM", "48", "Hi Community! I am open to new connections.","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer condimentum elit at orci molestie, eget interdum elit commodo. Praesent commodo, odio a tincidunt auctor, nisi ipsum");
            data.add(e);
        }
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new adapter(data, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


//        making filter button functioning
        filterBtn = view.findViewById(R.id.filter);
        filterBtn.setOnClickListener(v -> {
            Snackbar.make(view, "Filter", Snackbar.LENGTH_LONG)
                    .setBackgroundTint(getResources().getColor(R.color.blue_001))
                    .setTextColor(getResources().getColor(R.color.white_001))
                    .show();
        });

//        search input
        SearchInp = view.findViewById(R.id.search_Inp);
        clearSearchBtn = view.findViewById(R.id.clear_search);
        SearchInp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!SearchInp.getText().toString().equals("")){
                    clearSearchBtn.setVisibility(View.VISIBLE);
                }
                else {clearSearchBtn.setVisibility(View.GONE);}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        clearSearchBtn.setOnClickListener(v -> {
            SearchInp.setText("");
        });


        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {

        });

        return view;
    }
}