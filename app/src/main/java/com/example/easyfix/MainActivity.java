package com.example.easyfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.maintenance, R.drawable.brakes, R.drawable.engines,
            R.drawable.batteries, R.drawable.tires, R.drawable.steering,
            R.drawable.cooling, R.drawable.transmission};
    private String[] name = {"Basic maintenance", "Brakes",
            "Engines", "Batteries", "Tires",
            "Steering", "Cooling", "Transmission"};
    private String[] description = {"Preventive car maintenance is a necessary expense to keep your vehicle in good running condition. Following the scheduled maintenance recommendations in your owner's manual, checking fluid levels regularly and changing the fluids and filters periodically can minimize the risks of breakdowns and prolong the life of the engine, transmission, cooling system and brakes. So if you are driving a \"maintenance challenged\" vehicle, you need to pay closer attention to your fluids and filters.", "Brake work is one of many maintenance procedures you will have to perform over the lifespan of your vehicle. It also happens to be one of the most important. Without properly working brakes, you risk both your own safety and the safety of others on the road. Once you accept the reality that you have to pay for brake repair every so often, you need to budget accordingly. How much do brakes cost, and how often will you need to foot that bill?",
            "When your vehicle starts to act up and is no longer reliable, it can be difficult to pinpoint exactly where the issue is coming from. Knowing the signs of an engine going bad will help your mechanic know where to look under the hood to get the problem resolved quickly and with the minimum amount of inconvenience.The engine of your vehicle is a complicated system and therefore requires regular engine service to keep it running at optimum power.", "A typical vehicle battery can cost in the neighborhood of $50 to $120, although some specialty batteries can cost upwards of $90 to $200. There are more than 40 types of batteries available, and several factors affect the cost.e", "Once you know what size tires can fit your car, you need to be able to choose among the different types of tires. Tires may look similar, but they can be optimized to perform for very different conditions and usages",
            "f you’ve ever tried to drive a car without power steering, you know just how vital this important system is for modern driving. Power steering makes maneuvering your car easier, safer, and more comfortable for you and your passengers. It gives you the ability to swerve to avoid obstacles or unexpected intruders on the road such as animals, other vehicles, or pedestrians who aren’t paying attention. Your power steering plays a significant role when it comes to the safety and agility of your vehicle, meaning it needs to be dependable.", "When your air conditioner suddenly stops working, it can be cause for alarm or it can be something as simple as a blown fuse or tripped circuit breaker.While many problems with your air conditioner will require a professional technician to repair the issue, we find that sometimes a homeowner can fix simple problems with a little troubleshooting.", "Rebuilding a transmission can save you a lot of money over the short-term, while keeping car payments out of your monthly budget. For many, rebuilding their transmission is worth the initial cost. Rebuilding a transmission may cost you twenty-five hundred dollars or more, which is a significant chunk of change"};
    private List<itemModal> itemModalList = new ArrayList<>();

    GridView gridView;
    CustomAdapter customAdapter;
    private DrawerLayout drawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

//        toolbar = findViewById(R.id.toolbar);
//        Menu menu = findViewById(R.id.menu);v
//        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar
//                R.string.open_navigation_drawer, R.string.close_navigation_drawer);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        gridView = findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),GriditemActivity.class);

                intent.putExtra("name",name[position]);
                intent.putExtra("image",images[position]);
                intent.putExtra("description",description[position]);

                startActivity(intent);
            }
        });



       BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
       bottomNav.setOnNavigationItemSelectedListener(navListener);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(navigationViewListener);

       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
               new HomeFragment()).commit();



        for (int i = 0; i < name.length; i++) {

            itemModal itemModal = new itemModal(images[i], name[i], description[i]);
            itemModalList.add(itemModal);

            gridView = findViewById(R.id.gridview);

            customAdapter = new CustomAdapter(itemModalList, this);

            gridView.setAdapter(customAdapter);

        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorite:
                            selectedFragment = new FavoriteFragement();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_location:
                            selectedFragment = new LocaitonFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    private NavigationView.OnNavigationItemSelectedListener navigationViewListener =
            new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_favorite:
                    selectedFragment = new FavoriteFragement();
                    break;
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.nav_location:
                    selectedFragment = new LocaitonFragment();
                    break;
                case R.id.nav_email:
                    selectedFragment = new EmailFragement();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };



    public class CustomAdapter extends BaseAdapter {

        private List<itemModal> itemModalList;
        private Context context;

        public CustomAdapter(List<itemModal> itemModalList, Context context) {
            this.itemModalList = itemModalList;
            this.context = context;
        }

        public CustomAdapter() {

        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return itemModalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            itemModal itemModal = itemModalList.get(i);


                view1 = LayoutInflater.from(context).inflate(R.layout.row_data, viewGroup, false);
                ImageView imageView = view1.findViewById(R.id.tvimageName);
                TextView tvName = view1.findViewById(R.id.tvName);

                String name = itemModal.getName();
                int image = itemModal.getImage();

                imageView.setImageResource(image);
                tvName.setText(name);


            return view1;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      switch (item.getItemId()) {
            case R.id.action_Login:
                Intent login = new Intent(this, Login.class);
                startActivity(login);
                Toast.makeText(this, "Login", Toast.LENGTH_LONG).show();
                 break;
                 case R.id.action_Settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_signup:
                Intent signup = new Intent(this, SignUp.class);
               startActivity(signup);
                Toast.makeText(this, "Signup", Toast.LENGTH_LONG).show();
               break;
               case R.id.share:
                   ApplicationInfo api = getApplicationContext().getApplicationInfo();
                   String apkPath = api.sourceDir;
                   Intent intent = new Intent(Intent.ACTION_SEND);
                   intent.setType("application/vnd.android.package-archive");
                   intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkPath)));
                   startActivity(Intent.createChooser(intent, "Share"));
         default:

        }

       return super.onOptionsItemSelected(item);

   }
    @Override
    public void onBackPressed() {
       if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}
