package com.example.amyhan.myfifthapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import layout.CustomViewFragment;
import layout.MainViewFragment;
import layout.MoreViewsFragment;

public class NavigationDrawerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mDrawerListView = (ListView) inflater.inflate(R.layout.content_navigation_drawer_fragment, container, false);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
                loadFragmentLayout(position);
            }
        });
    }

    /*
        Displaying fragment view for selectd nav drawer list item
         */
    private void loadFragmentLayout(int position){
        //update the main content by replacing fragments
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MainViewFragment();
                break;
            case 1:
                fragment = new CustomViewFragment();
                break;
            case 2:
                fragment = new MoreViewsFragment();
                break;
            default:
                break;
        }
        if(fragment != null){
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            //update selected item and title, then close the drawer
            mDrawerListView.setItemChecked(position, true);
            mDrawerListView.setSelection(position);
            mDrawerLayout.closeDrawer(Gravity.LEFT);

        }else{
            Log.e("Navigation Drawer", "Error in creating fragment");
        }
    }

}
