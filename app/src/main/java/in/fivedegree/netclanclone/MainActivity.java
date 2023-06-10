package in.fivedegree.netclanclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;
import in.fivedegree.netclanclone.Fragments.ChatFragment;
import in.fivedegree.netclanclone.Fragments.ContactFragment;
import in.fivedegree.netclanclone.Fragments.ExploreFragment;
import in.fivedegree.netclanclone.Fragments.GroupsFragment;
import in.fivedegree.netclanclone.Fragments.NetworkFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout refineBtn;
    TextView welcomeTv, locationTv, drawName, drawCode, drawAvailability;
    ImageView drawerBtn, drawSettingsBtn;
    CircleImageView drawDp;
    LinearProgressIndicator profileCompletion;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(new ExploreFragment());

//        ==============================
//        ACTIONBAR START
//        ==============================

//        customizing action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View customToolbarView = getLayoutInflater().inflate(R.layout.main_action_bar, toolbar, false);
        toolbar.addView(customToolbarView);

        refineBtn = customToolbarView.findViewById(R.id.refine_btn);
        welcomeTv = customToolbarView.findViewById(R.id.welcome_tv);
        locationTv = customToolbarView.findViewById(R.id.location_tv);
        drawerBtn = customToolbarView.findViewById(R.id.drawer_btn);

//        setting values in Action bar texts  (will have to set values dynamically in real app)
        welcomeTv.setText("Howdy Nitesh Gupta Netclan !!");
        locationTv.setText("Mumbai, Maharashtra");

//        making action bar buttons functioning
        drawerBtn.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
        refineBtn.setOnClickListener(v -> {
            Intent refineIntent = new Intent(this, RefineActivity.class);
            startActivity(refineIntent);
        });

//        ==============================
//        ACTIONBAR END
//        ==============================



//        ==============================
//        NAVIGATION DRAWER START
//        ==============================

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        drawDp = navigationView.getHeaderView(0).findViewById(R.id.draw_Iv);
        drawName = navigationView.getHeaderView(0).findViewById(R.id.draw_nameTV);
        drawCode = navigationView.getHeaderView(0).findViewById(R.id.draw_codeTv);
        profileCompletion = navigationView.getHeaderView(0).findViewById(R.id.draw_progress);
        drawAvailability = navigationView.getHeaderView(0).findViewById(R.id.draw_availability);
        drawSettingsBtn = navigationView.getHeaderView(0).findViewById(R.id.draw_settings);

//        setting values in drawer header (will have to set values dynamically in real app)
        drawName.setText("Nitesh Gupta Netclan");
        drawCode.setText("nnmumb0021000");
        profileCompletion.setProgress(24);
        drawAvailability.setText(R.string.available);

//        making drawer header button functioning
        drawSettingsBtn.setOnClickListener(v ->{
            makeSnackbar("Settings");
            drawerLayout.closeDrawer(GravityCompat.START);
        });

//        making menu items functioning
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case (R.id.edit_profile):
                    makeSnackbar("Edit Profile");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.my_network):
                    makeSnackbar("My Network");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.switch_business):
                    makeSnackbar("Switch to Business");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.switch_merchant):
                    makeSnackbar("Switch to Merchant");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.dating):
                    makeSnackbar("Dating");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.matrimony):
                    makeSnackbar("Matrimony");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.buy_sell_rent):
                    makeSnackbar("Buy Sell Rent");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.jobs):
                    makeSnackbar("Jobs");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.business_card):
                    makeSnackbar("Business Card");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.nc_groups):
                    makeSnackbar("Netclan Groups");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.notes):
                    makeSnackbar("Notes");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case (R.id.location):
                    makeSnackbar("Live Location");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            return true;
        });

//        ==============================
//        NAVIGATION DRAWER END
//        ==============================




//        ==============================
//        BOTTOM NAVIGATION VIEW START
//        ==============================

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.explore_nav_item:
                    item.setIcon(R.drawable.nav_explore_selector);
                    openFragment(new ExploreFragment());
                    break;
                case R.id.network_nav_item:
                    item.setIcon(R.drawable.nav_network_selector);
                    openFragment(new NetworkFragment());
                    break;
                case R.id.chat_nav_item:
                    item.setIcon(R.drawable.nav_chat_selector);
                    openFragment(new ChatFragment());
                    break;
                case R.id.contacts_nav_item:
                    item.setIcon(R.drawable.nav_contact_selector);
                    openFragment(new ContactFragment());
                    break;
                case R.id.groups_nav_item:
                    item.setIcon(R.drawable.nav_groups_selector);
                    openFragment(new GroupsFragment());
                    break;
            }
            return true;
        });
        bottomNavigationView.setSelectedItemId(R.id.explore_nav_item);

//        ==============================
//        BOTTOM NAVIGATION VIEW END
//        ==============================
    }

    private void openFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

    }

    private void makeSnackbar(String msg) {
        View v = findViewById(R.id.drawer_layout);
        Snackbar.make(v, msg, Snackbar.LENGTH_LONG)
                .setBackgroundTint(getResources().getColor(R.color.blue_001))
                .setTextColor(getResources().getColor(R.color.white_001))
                .show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}