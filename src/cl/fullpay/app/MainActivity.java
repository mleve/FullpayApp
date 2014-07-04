package cl.fullpay.app;


import java.util.ArrayList;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends Activity {
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlanetTitles = getResources().getStringArray(R.array.menu_options);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        
		//Declaramos el header el caul sera el layout de header.xml
        View header = getLayoutInflater().inflate(R.layout.menu_header, null);
        mDrawerList.addHeaderView(header);
        
        ArrayList<String> menuItems= new ArrayList<String>();
        menuItems.add("Juzgado 1");
        menuItems.add("Juzgado 2");
        menuItems.add("juzgado 3");

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.menu_item, menuItems));

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		loadFragment(position);
        	}
        
		});
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(
        		this,
        		mDrawerLayout,
        		R.drawable.ic_drawer,
        		R.string.app_name,
        		R.string.hello_world){
        	public void onDrawerClosed(View view){
        		super.onDrawerClosed(view);
        		//getActionBar().setTitle(mTitle);
        		invalidateOptionsMenu();
        	}
        	
        	public void onDrawerOpened(View drawerView){
        		super.onDrawerOpened(drawerView);
        		getActionBar().setTitle(R.string.app_name);
        		invalidateOptionsMenu();
        	}
        	
        };
         mDrawerLayout.setDrawerListener(mDrawerToggle);
        
         if (savedInstanceState == null) {
             loadFragment(0);
         }       
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);    	
    }
    
	protected void loadFragment(int position) {
			Fragment fragment = new TribunalFragment();
			Bundle args = new Bundle();
			args.putInt(TribunalFragment.ARG_TRIBUNAL_ID, position);
			fragment.setArguments(args);
			FragmentManager fManager = getFragmentManager();
			fManager.beginTransaction()
					.replace(R.id.content_frame, fragment)
					.commit();
			
		    // Highlight the selected item, update the title, and close the drawer
		    mDrawerList.setItemChecked(position, true);
		    setTitle("Juzgado: "+position);
		    mDrawerLayout.closeDrawer(mDrawerList);			
			
					
	}
	
	@Override
	public void setTitle(CharSequence title){
		getActionBar().setTitle(title);
	}
	
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
}