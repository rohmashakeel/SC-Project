package com.example.rohma.secureit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ReportCrime extends AppCompatActivity {

    EditText nature_editText;
    EditText otherinfo_editText;
    FloatingActionButton fab;
    Spinner area_spinner;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference crimeRef;
    //DatabaseReference mNatureRef = mRootRef.child("Nature");
    //DatabaseReference mOtherInfoRef = mRootRef.child("Other Information");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportcrime);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        crimeRef = FirebaseDatabase.getInstance().getReference();
        //crimeRef = ref.child("crimes");
        nature_editText = (EditText) findViewById(R.id.nature_editText);
        otherinfo_editText = (EditText) findViewById(R.id.otherinfo_editText);
        area_spinner = (Spinner) findViewById(R.id.spinner);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.bringToFront();

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                String crimeID = crimeRef.push().getKey();
//
//                ReportCrimeClass newRC = new ReportCrimeClass();
//                newRC.setCrimeID(crimeID);
//                newRC.setNature(nature_editText.getText().toString());
//                newRC.setArea(area_spinner.getSelectedItem().toString());
//                newRC.setOtherInfo(otherinfo_editText.getText().toString());
//                crimeRef.child("Crime").child(crimeID).setValue(newRC);
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

               addCrime(view);


                Log.v("myTag","FAB Clicked");
            }
        });
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                addCrime();
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addCrime(View view) {

        String nature = nature_editText.getText().toString();
        String area = area_spinner.getSelectedItem().toString();
        String other_info = otherinfo_editText.getText().toString();

        if (!TextUtils.isEmpty(nature)) {
            String crimeID = crimeRef.push().getKey();
            ReportCrimeClass reportCrime = new ReportCrimeClass();
            reportCrime.setNature(nature);
            reportCrime.setArea(area);
            reportCrime.setOtherInfo(other_info);

            DatabaseReference dbref = crimeRef.child("crimes");
            dbref.push().setValue(reportCrime, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if(databaseError!=null){
                        System.out.println("Data could not be saved" + databaseError.getMessage());
                    }
                    else{
                        System.out.println("Data saved successfully");
                    }
                }
            });

//            crimeRef.child("crimes");
//            crimeRef.push().setValue(reportCrime, new DatabaseReference.CompletionListener() {
//                @Override
//                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                    if(databaseError!=null){
//                        System.out.println("Data could not be saved" + databaseError.getMessage());
//                    }
//                    else{
//                        System.out.println("Data saved successfully");
//                    }
//                }
//            });

            System.out.print(reportCrime);
//            crimeRef.push().setValue(new ReportCrimeClass(crimeID, nature, area, other_info), new DatabaseReference.CompletionListener() {
//                @Override
//                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                    if(databaseError!=null){
//                        System.out.println("Data could not be saved" + databaseError.getMessage());
//                    }
//                    else{
//                        System.out.println("Data saved successfully");
//                    }
//                }
//            });
//            crimeRef.push().setValue(reportCrime, new DatabaseReference.CompletionListener() {
//                @Override
//                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                    if (databaseError != null) {
//                        System.out.println("Data could not be saved " + databaseError.getMessage());
//                    } else {
//                        System.out.println("Data saved successfully.");
//                    }
//                }

//            });
            Toast.makeText(this, "Crime Reported!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Fields can't be blank", Toast.LENGTH_LONG).show();
        }
    }
//            crimeRef.child("crimes").child(crimeID).addValueEventListener(new ValueEventListener() {
//
//                @Override
//               public void onDataChange(DataSnapshot dataSnapshot) {
//
//

                    //  ReportCrimeClass reportCrime = dataSnapshot.getValue(ReportCrimeClass.class);
                  //  crimeRef.setValue(reportCrime);
                    //if(reportCrime!=null){
                    //    writeNewPost(crimeID, nature, area, other_info);
                    //}
               // }

//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
////            Toast.makeText(this, "Crime Reported!", Toast.LENGTH_LONG).show();
////        }
////
////        else{
////            Toast.makeText(this, "Enter Nature", Toast.LENGTH_LONG).show();
////        }
//        }


//    private void writeNewPost(String crimeID, String nature, String area, String other_info){
//        ReportCrimeClass newRC = new ReportCrimeClass(crimeID, nature, area, other_info);
//        Map <String, Object> newRCMap = newRC.toMap();
//        crimeRef.updateChildren(newRCMap);

    @Override
    protected void onStart(){
        super.onStart();
//        mNatureRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                nature_editText.setText(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        mOtherInfoRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                otherinfo_editText.setText(text);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
