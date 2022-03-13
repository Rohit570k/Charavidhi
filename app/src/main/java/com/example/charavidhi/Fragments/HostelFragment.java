package com.example.charavidhi.Fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charavidhi.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import de.hdodenhof.circleimageview.CircleImageView;

public class
HostelFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hostel, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CircleImageView fab = (CircleImageView) getView().findViewById(R.id.charavidhi_whatsapp);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean installed=isInstalled("com.whatsapp");
                if(installed){
                     whatsapp("Hello Charavidhi \nI am interested in your Cattle hostel facility " +
                             "\nI want more detail about that");
                }else {
                    Snackbar.make(view, "Whatsapp Not Installed", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
//               openWhatsApp("Hello Charavidhi \nI am interested in your Cattle hostel facility " +
//                       "\nI want more detail about that");
            }
        });
    }

    private void whatsapp(String msg) {
        Intent i =new Intent(Intent.ACTION_VIEW);
        try {
            i.setData(Uri.parse("https://api.whatsapp.com/send?phone="+"+91 8285134971" +"&text=" + URLEncoder.encode(msg, "UTF-8")));
            startActivity(i);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private boolean isInstalled(String s) {
        PackageManager pm=getActivity().getPackageManager();
        boolean is_installed;
        try {
            pm.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
            is_installed=true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            is_installed=false;
        }
        return is_installed;

    }

    private void openWhatsApp(String mensaje){

        try{
            PackageManager packageManager = getActivity().getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone="+ "+91 8285134971" +"&text=" + URLEncoder.encode(mensaje, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i);
            }else {
                Snackbar.make(getView(), "Whatsapps Not Installed", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        } catch(Exception e) {
            Log.e("ERROR WHATSAPP",e.toString());
//           KToast.errorToast(getActivity(), getString(R.string.no_whatsapp), Gravity.BOTTOM, KToast.LENGTH_SHORT);
        }

    }

}