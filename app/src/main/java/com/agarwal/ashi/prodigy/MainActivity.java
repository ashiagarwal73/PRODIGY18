package com.agarwal.ashi.prodigy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements
        Register.OnFragmentInteractionListener,
        Gallery.OnFragmentInteractionListener,
        AboutUs.OnFragmentInteractionListener,
        ContactUs.OnFragmentInteractionListener,
        Prodigy.OnFragmentInteractionListener,
        Departments.OnFragmentInteractionListener,
        LiveUpdates.OnFragmentInteractionListener,
        Membership.OnFragmentInteractionListener,
        Sponsors.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isOnline())
        {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.prodigy);
        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frames, new Prodigy());
        ft.commit();
    }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.aboutus) {
            fragment=new AboutUs();

        } else if (id == R.id.gallery) {
            fragment=new Gallery();

        } else if (id == R.id.prodigy) {
            fragment=new Prodigy();

        } else if (id == R.id.register) {
            fragment=new Register();

        } else if (id == R.id.liveupdates) {
            fragment=new LiveUpdates();

        } else if (id == R.id.departments) {
            fragment=new Departments();

        }else if (id == R.id.membership) {
            fragment=new Membership();

        }else if (id == R.id.conactus) {
            fragment=new ContactUs();

        }else if (id == R.id.sponsors) {
            fragment=new Sponsors();
        }
        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frames, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String title) {
        getSupportActionBar().setTitle(title);
    }
    public void onBackPressed() {
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Close Application!");
        b.setMessage("Do you Really want to close the App?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                startActivity(a);
            }
        });
        b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        b.show();

    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ad=new AlertDialog.Builder(this);
            ad.setTitle("No Internet!");
            ad.setMessage("Check your Internet connection and restart the app");
            ad.setNegativeButton(android.R.string.cancel, null);
            ad.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }
            ).create().show();

            return false;
        }
        return true;
    }
}

