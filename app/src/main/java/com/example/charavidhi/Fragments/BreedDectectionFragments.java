package com.example.charavidhi.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.charavidhi.R;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class BreedDectectionFragments extends Fragment {
    private static final String TAG ="CHECKING SHARED PREF" ;
    ImageView imagePicker;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.breed_dectection_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagePicker=view.findViewById(R.id.imagepicker);

//        imagePicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImagePicker.with(requireActivity())
//                        .crop(4f,3f)
//                        .compress(1024)	//Final image size will be less than 1 MB
//                        // .saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)) ////  Path: /storage/sdcard0/Android/data/package/files/Pictures
//                        .start();
//            }
//        });
        // SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);
//        // Retrieving the value using its keys the file name
//// must be same in both saving and retrieving the data
//        SharedPreferences sh = getSharedPreferences("prefs", MODE_PRIVATE);
//        String uriString =preferences.getString("image",null);
//        Log.d(TAG, "onCreate: "+uriString);
//        if(uriString!=null)
//        imagePicker.setImageURI(Uri.parse(uriString));
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK) {
//            Uri uri =data.getData();
//            imagePicker.setImageURI(uri);
////        SharedPreferences pref=getSharedPreferences("prefs", Context.MODE_PRIVATE);
////
////        SharedPreferences.Editor editor = pref.edit();
////        editor.putString("image",String.valueOf(uri));
////        editor.commit();
//        } else if (resultCode == ImagePicker.RESULT_ERROR) {
//            Toast.makeText(getContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getContext(), "Task Cancelled", Toast.LENGTH_SHORT).show();
//        }
//    }

}