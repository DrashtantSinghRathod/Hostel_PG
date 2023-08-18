package abc.get.hostels_pg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyBookings extends AppCompatActivity{
ArrayList<Word1> words2=new ArrayList<>();
Button button8;
    ListView listView;
    String uid;
    ProgressBar progressBar2;
    AdView mAdView;
    DatabaseReference reference,reference2;
    FirebaseDatabase fd = FirebaseDatabase.getInstance();
    FirebaseUser user1= FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        listView=findViewById(R.id.list3);
        progressBar2=findViewById(R.id.progressBar2);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null)
        {
            uid = user1.getUid();
            reference = fd.getReference("Users");
            reference2 = fd.getReference("Colonies");
            reference.child(uid).child("bookdetails").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getChildrenCount()==0)
                    {
                        progressBar2.setVisibility(View.GONE);
                        Toast.makeText(MyBookings.this, "No Bookings found", Toast.LENGTH_LONG).show();
                    }
                    for (DataSnapshot snapshot1:snapshot.getChildren())
                    {

                        String i = (String) snapshot1.getKey();

                        reference.child(uid).child("bookdetails").child(i).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Word1 n=new Word1();
                                n = snapshot.getValue(Word1.class);
                                words2.add(n);

                                WorAdapter1 adapter=new WorAdapter1(MyBookings.this,words2);

                                listView.setAdapter(adapter);
                                progressBar2.setVisibility(View.GONE);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else
        {
            progressBar2.setVisibility(View.GONE);
            Toast.makeText(this, "Sign In first to see Booking details.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,signin.class);
            startActivity(intent);
        }



    }
}
