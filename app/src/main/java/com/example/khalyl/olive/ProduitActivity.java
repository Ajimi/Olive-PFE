package com.example.khalyl.olive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.khalyl.olive.utils.Utility;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

/**
 * Created by selim on 5/17/2017.
 */

public class ProduitActivity extends AppCompatActivity {
    private Drawer drawer;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produit);
        mToolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(mToolbar); // Set action
        setupDrawerNavigation(savedInstanceState);
        ArrayList<ProductData> products = Utility.getProducts(this);
        ProductAdapter productAdapter =
                new ProductAdapter(this, products);

        ListView lv = (ListView) findViewById(R.id.productListView);
        lv.setAdapter(productAdapter);

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
                        new PrimaryDrawerItem().withIdentifier(1).withName("Produit"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("Profil"),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withIdentifier(3).withName("Contacte")
                )
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withIdentifier(4).withName("Parametres"),
                        new SecondaryDrawerItem().withIdentifier(5).withName("Deconnexion")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            int id = (int) drawerItem.getIdentifier();
                            switch (id) {
                                case 1:
                                    drawer.closeDrawer();
                                    return true;
                                case 2:
                                    intent = new Intent(ProduitActivity.this, ProfileActivity.class);
                                    startActivity(intent);
                                    break;
                                case 3:

                                    break;
                                case 4:
                                    intent = new Intent(ProduitActivity.this, SettingsActivity.class);
                                    startActivity(intent);
                                    startActivity(intent);
                                    break;
                                case 5:
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
                            return true;
                        }
                        return false;
                    }

                })
                .withSavedInstance(savedInstanceState)
                .build();
    }
}
