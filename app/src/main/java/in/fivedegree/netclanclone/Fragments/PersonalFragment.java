package in.fivedegree.netclanclone.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

    ConstraintLayout fabBg;
    FloatingActionButton fab, fabNotes, fabJobs, fabGroups, fabCards, fabBuySellRent, fabMatrimony, fabDating;
    TextView tvNotes, tvJobs, tvGroups, tvCards, tvBuySellRent, tvMatrimony, tvDating;
    int alpha = View.GONE;
    Float translateY = 200f;
    Boolean isMenuOpen = false;
    Long duration = Long.valueOf(100);

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

//        ==============================
//        Floating Action Menu
//        ==============================
//        typecasting all fab & textview
        fab = view.findViewById(R.id.fab);
        fabNotes = view.findViewById(R.id.fab_notes);
        fabJobs = view.findViewById(R.id.fab_jobs);
        fabGroups = view.findViewById(R.id.fab_groups);
        fabCards = view.findViewById(R.id.fab_cards);
        fabBuySellRent = view.findViewById(R.id.fab_buy_sell_rent);
        fabMatrimony = view.findViewById(R.id.fab_matrimony);
        fabDating = view.findViewById(R.id.fab_dating);
        tvNotes = view.findViewById(R.id.tv_notes);
        tvJobs = view.findViewById(R.id.tv_jobs);
        tvGroups = view.findViewById(R.id.tv_groups);
        tvCards = view.findViewById(R.id.tv_cards);
        tvBuySellRent = view.findViewById(R.id.tv_buy_sell_rent);
        tvMatrimony = view.findViewById(R.id.tv_matrimony);
        tvDating = view.findViewById(R.id.tv_dating);

        fabBg = view.findViewById(R.id.fab_bg);

//        making all menu fab & tv disappear
        fabNotes.setVisibility(alpha);
        fabJobs.setVisibility(alpha);
        fabGroups.setVisibility(alpha);
        fabCards.setVisibility(alpha);
        fabBuySellRent.setVisibility(alpha);
        fabMatrimony.setVisibility(alpha);
        fabDating.setVisibility(alpha);

        tvNotes.setVisibility(alpha);
        tvJobs.setVisibility(alpha);
        tvGroups.setVisibility(alpha);
        tvCards.setVisibility(alpha);
        tvBuySellRent.setVisibility(alpha);
        tvMatrimony.setVisibility(alpha);
        tvDating.setVisibility(alpha);

//        placing all menu fab & tv little below
        fabNotes.setTranslationY(translateY);
        fabJobs.setTranslationY(translateY);
        fabGroups.setTranslationY(translateY);
        fabCards.setTranslationY(translateY);
        fabBuySellRent.setTranslationY(translateY);
        fabMatrimony.setTranslationY(translateY);
        fabDating.setTranslationY(translateY);

        tvNotes.setTranslationY(translateY);
        tvJobs.setTranslationY(translateY);
        tvGroups.setTranslationY(translateY);
        tvCards.setTranslationY(translateY);
        tvBuySellRent.setTranslationY(translateY);
        tvMatrimony.setTranslationY(translateY);
        tvDating.setTranslationY(translateY);

        fab.setOnClickListener(v -> {
            if (isMenuOpen){
                closeMenu();
            }
            else {
                openMenu();
            }
        });
        fabBg.setOnClickListener(v ->{
            closeMenu();
        });

        //making all fab menu functional
        fabNotes.setOnClickListener(v -> {
            makeSnackbar("Notes");
            closeMenu();
        });
        tvNotes.setOnClickListener(v ->{
            makeSnackbar("Notes");
            closeMenu();
        });
        fabJobs.setOnClickListener(v -> {
            makeSnackbar("Jobs");
            closeMenu();
        });
        tvJobs.setOnClickListener(v ->{
            makeSnackbar("Jobs");
            closeMenu();
        });
        fabGroups.setOnClickListener(v -> {
            makeSnackbar("Groups");
            closeMenu();
        });
        tvGroups.setOnClickListener(v ->{
            makeSnackbar("Groups");
            closeMenu();
        });
        fabCards.setOnClickListener(v -> {
            makeSnackbar("Business Cards");
            closeMenu();
        });
        tvCards.setOnClickListener(v ->{
            makeSnackbar("Business Cards");
            closeMenu();
        });
        fabBuySellRent.setOnClickListener(v -> {
            makeSnackbar("Buy-Sell-Rent");
            closeMenu();
        });
        tvBuySellRent.setOnClickListener(v ->{
            makeSnackbar("Buy-Sell-Rent");
            closeMenu();
        });
        fabMatrimony.setOnClickListener(v -> {
            makeSnackbar("Matrimony");
            closeMenu();
        });
        tvMatrimony.setOnClickListener(v ->{
            makeSnackbar("Matrimony");
            closeMenu();
        });
        fabDating.setOnClickListener(v -> {
            makeSnackbar("Dating");
            closeMenu();
        });
        tvDating.setOnClickListener(v ->{
            makeSnackbar("Dating");
            closeMenu();
        });

        return view;
    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen; // changing variable to true
        fabBg.setVisibility(View.VISIBLE);
        fabBg.setBackgroundColor(getResources().getColor(R.color.transparent_white)); //setting white transparent bg
        fab.setRotation(1125); // rotating icon so it appears as close
        // making all fabs & tv visible and placing them at original position.
        fabNotes.setVisibility(View.VISIBLE);
        fabJobs.setVisibility(View.VISIBLE);
        fabGroups.setVisibility(View.VISIBLE);
        fabCards.setVisibility(View.VISIBLE);
        fabBuySellRent.setVisibility(View.VISIBLE);
        fabMatrimony.setVisibility(View.VISIBLE);
        fabDating.setVisibility(View.VISIBLE);

        tvNotes.setVisibility(View.VISIBLE);
        tvJobs.setVisibility(View.VISIBLE);
        tvGroups.setVisibility(View.VISIBLE);
        tvCards.setVisibility(View.VISIBLE);
        tvBuySellRent.setVisibility(View.VISIBLE);
        tvMatrimony.setVisibility(View.VISIBLE);
        tvDating.setVisibility(View.VISIBLE);
        OvershootInterpolator interpolator = new OvershootInterpolator();
        fabNotes.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabJobs.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabGroups.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabCards.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabBuySellRent.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabMatrimony.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        fabDating.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvNotes.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvJobs.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvGroups.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvCards.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvBuySellRent.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvMatrimony.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
        tvDating.animate().translationY(0f).setInterpolator(interpolator).setDuration(duration).start();
    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen; // changing variable to false
        fabBg.setVisibility(View.GONE);
        fabBg.setBackgroundColor(getResources().getColor(R.color.transparent)); //removing white bg
        fab.setRotation(0); // rotating icon so it appears as plus
        // making all fabs & tv invisible and placing them below.
        fabNotes.setVisibility(alpha);
        fabJobs.setVisibility(alpha);
        fabGroups.setVisibility(alpha);
        fabCards.setVisibility(alpha);
        fabBuySellRent.setVisibility(alpha);
        fabMatrimony.setVisibility(alpha);
        fabDating.setVisibility(alpha);

        tvNotes.setVisibility(alpha);
        tvJobs.setVisibility(alpha);
        tvGroups.setVisibility(alpha);
        tvCards.setVisibility(alpha);
        tvBuySellRent.setVisibility(alpha);
        tvMatrimony.setVisibility(alpha);
        tvDating.setVisibility(alpha);
        OvershootInterpolator interpolator = new OvershootInterpolator();
        fabNotes.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabJobs.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabGroups.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabCards.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabBuySellRent.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabMatrimony.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        fabDating.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvNotes.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvJobs.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvGroups.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvCards.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvBuySellRent.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvMatrimony.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
        tvDating.animate().translationY(translateY).setInterpolator(interpolator).setDuration(duration).start();
    }

    private void makeSnackbar(String msg) {
        View v = getView().findViewById(R.id.fragment_personal_layout);
        Snackbar.make(v, msg, Snackbar.LENGTH_LONG)
                .setBackgroundTint(getResources().getColor(R.color.blue_001))
                .setTextColor(getResources().getColor(R.color.white_001))
                .show();
    }
}