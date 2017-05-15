package com.example.khalyl.olive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.khalyl.olive.utils.Utility;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Drawer drawer;
    private Toolbar mToolbar;
    private FastItemAdapter<ProductItems> mFastAdapter;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar); // Set action
        setupDrawerNavigation(savedInstanceState);
        setupRecyclerView();

    }

    private void setupRecyclerView() {

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        mFastAdapter = new FastItemAdapter<>();
        mFastAdapter.withSelectable(true);
        mFastAdapter.withSelectOnLongClick(false);
        //create our ItemAdapter which will host our items

        //configure our fastAdapter
        //get our recyclerView and do basic setup
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFastAdapter);

        List<ProductItems> items = Utility.getDataFromJson();
        mFastAdapter.add(items);
        mRecyclerView.getItemAnimator().setAddDuration(500);
        mRecyclerView.getItemAnimator().setRemoveDuration(500);
    }

    public void setupDrawerNavigation(@Nullable Bundle savedInstanceState) {
        new DrawerBuilder().withActivity(this).build();
        /*final ToggleDrawerItem waveItem = new ToggleDrawerItem().withIdentifier(9)
                .withName(R.string.drawer_item_wave).withIcon(R.drawable.ic_shake).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener);
        ToggleDrawerItem shakeItem = new ToggleDrawerItem().withIdentifier(10).
                withName(R.string.drawer_item_shake).withIcon(R.drawable.ic_shake).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener);
*/
        // add the items created to the navigation drawer
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                // .withHeader(R.layout.footer) //  header instead create your own header
                .withActionBarDrawerToggleAnimated(true)
                .withSelectedItem(1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("Acceuil"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("Profil"),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withIdentifier(4).withName("A propos"),
                        new SecondaryDrawerItem().withIdentifier(5).withName("Contacte")
                )
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withIdentifier(6).withName("Deconnexion")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            int id = (int) drawerItem.getIdentifier();
                            switch (id) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:

                                    break;
                                case 4:
                                    intent = new Intent(MainActivity.this, ContactActivity.class);
                                    startActivity(intent);
                                    break;
                                case 5:
                                    intent = new Intent(MainActivity.this, CompanyActivity.class);
                                    startActivity(intent);
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    break;
                                case 8:
                                    break;
                                case 9:
                                    return false;
                                case 10:
                                    return false;
                                case 11:
                                    break;
                                case 0:
                                    break;
                            }
//                            if (intent != null) {
//                            }
                            return true;
                        }
                        return false;
                    }

                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

}
