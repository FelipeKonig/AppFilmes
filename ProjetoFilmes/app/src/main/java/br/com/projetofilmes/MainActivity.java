package br.com.projetofilmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import br.com.projetofilmes.fragments.PeopleFragment;
import br.com.projetofilmes.fragments.FilmFragment;
import br.com.projetofilmes.fragments.RegisterFilmFragment;
import br.com.projetofilmes.fragments.RegisterPersonFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FilmFragment.onFragmentBtnSelected{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        drawerLayout = findViewById( R.id.drawer );
        navigationView = findViewById( R.id.navigationView );
        navigationView.setNavigationItemSelectedListener( this );

        actionBarDrawerToggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener( actionBarDrawerToggle );
        actionBarDrawerToggle.setDrawerIndicatorEnabled( true );
        actionBarDrawerToggle.syncState();

        initializeFragment( new FilmFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer( GravityCompat.START );

        if(menuItem.getItemId() == R.id.home)
            initializeFragment( new FilmFragment());

        if(menuItem.getItemId() == R.id.actor)
            initializeFragment( new PeopleFragment( "actor"));

        if(menuItem.getItemId() == R.id.director)
            initializeFragment( new PeopleFragment( "director"));

        return true;
    }

    @Override
    public void onButtonSelected(String item) {
        if (item.contentEquals( "film" ))
            initializeFragment(new RegisterFilmFragment() );
        if (item.contentEquals( "director" ))
            initializeFragment(  new RegisterPersonFragment( "director" ) );

        if (item.contentEquals( "actor" ))
            initializeFragment( new RegisterPersonFragment( "actor" ) );
    }

    public void initializeFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.container_fragment, fragment);
        fragmentTransaction.commit();
    }
}
