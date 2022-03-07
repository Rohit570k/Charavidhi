package com.example.charavidhi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.charavidhi.Fragments.BuyFragment;
import com.example.charavidhi.Fragments.HostelFragment;
import com.example.charavidhi.Fragments.MoreFragment;
import com.example.charavidhi.Fragments.SellFragment;
import com.example.charavidhi.Fragments.TransportFragments;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
//import meow.bottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CheckingF KEYBOARD";
    private MeowBottomNavigation bnv_Main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // getWindow().setSoftInputMode(WindowManager.LayoutParams.S);
        bnv_Main=findViewById(R.id.bnv_main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.bottom_transport));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.bottom_sellwritten));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.bottom_cow));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.bottom_hostel));
        bnv_Main.add(new MeowBottomNavigation.Model(5,R.drawable.bottom_more));

        //After Starting app Show first Fragments
        replace(new BuyFragment());
        bnv_Main.show(3,true);
//        bnv_Main.setCount(4, "100");
//        bnv_Main.setCount(1,"4");
//        bnv_Main.setCount(2,"98");
        //Item Showing and replacing Fragments
        bnv_Main.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Log.d("mainActivity1122-show", String.valueOf(model.getId()));
                return null;
            }
        });
        //When item is selceted
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()) {
                    case 1:
                        replace(new TransportFragments());
                        Toast.makeText(getApplicationContext()
                                , "Transport Section"
                                , Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        replace(new SellFragment());
                        Toast.makeText(getApplicationContext()
                                , "Sell Cattle"
                                , Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        replace(new BuyFragment());
                        Toast.makeText(getApplicationContext()
                                , "Buy Cattle"
                                , Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        replace(new HostelFragment());
                        Toast.makeText(getApplicationContext()
                                , "Cattle Hostel"
                                , Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        replace(new MoreFragment());
                        Toast.makeText(getApplicationContext()
                                , "More"
                                , Toast.LENGTH_SHORT).show();
                        break;
                }

                return null;
            }
        });

//        //If item was reselected
//        bnv_Main.setOnReselectListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//            @Override
//            public Unit invoke(MeowBottomNavigation.Model model) {
//                Toast.makeText(MainActivity.this,
//                        "You reselected "+model.getId()
//                        ,Toast.LENGTH_SHORT).show();
//                return null;
//            }
//        });

 /**
 * This was being used for keyboard state event to hide bottom nav bar
 * but solved the issue
//        KeyboardVisibilityEvent.setEventListener(
//                this,
//                new KeyboardVisibilityEventListener() {
//                    @Override
//                    public void onVisibilityChanged(boolean isOpen) {
//                        Log.d(TAG,"onVisibilityChanged: Keyboard visibility changed");
//                        if(isOpen){
//                            Log.d(TAG, "onVisibilityChanged: Keyboard is open");
//                            bnv_Main.setVisibility(View.GONE);
//                            Log.d(TAG, "onVisibilityChanged: NavBar got Invisible");
//                        }else{
//                            Log.d(TAG, "onVisibilityChanged: Keyboard is closed");
//                            bnv_Main.setVisibility(View.VISIBLE);
//                            Log.d(TAG, "onVisibilityChanged: NavBar got Visible");
//                        }
//                    }
//                });

    }
**/
    }
    private void replace(Fragment fragment){
        FragmentTransaction transaction=  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }

}