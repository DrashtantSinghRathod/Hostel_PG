package abc.get.hostels_pg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class Saved extends AppCompatActivity implements AdapterView.OnItemClickListener {
    DatabaseReference reference,reference2;
    FirebaseDatabase fd = FirebaseDatabase.getInstance();
    FirebaseUser user1= FirebaseAuth.getInstance().getCurrentUser();
    ListView list;
    ArrayList<UserHostel> words = new ArrayList<>();
    ProgressBar progressBar5;
    UserHostel userHostel;
    AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        list = findViewById(R.id.list);
        progressBar5=findViewById(R.id.progressBar5);
        list.setOnItemClickListener(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null)
        {
            String uid = user1.getUid();
            reference = fd.getReference("Saved");
            reference2 = fd.getReference("Colonies");
            reference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getChildrenCount()==0)
                    {
                        progressBar5.setVisibility(View.GONE);
                        Toast.makeText(Saved.this, "No Saved Data Found", Toast.LENGTH_SHORT).show();
                    }
                    for (DataSnapshot snapshot1:snapshot.getChildren())
                    {
                        String colony = (String) snapshot1.child("colony").getValue();
                        String uid = (String) snapshot1.child("uid").getValue();

                        reference2.child(colony).child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                UserHostel w = new UserHostel();
                                w = snapshot.getValue(UserHostel.class);
                                words.add(w);
                                WorAdapter adapter = new WorAdapter(Saved.this,words);
                                list.setAdapter(adapter);
                                progressBar5.setVisibility(View.GONE);
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
            progressBar5.setVisibility(View.GONE);
            Toast.makeText(this, "Sign In first to see Saved details.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,signin.class);
            startActivity(intent);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        userHostel = words.get(position);
        String type = userHostel.getType();
        String uid=userHostel.getUid();
        String colony=userHostel.getColony();
        //Toast.makeText(this,type,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Saved.this,showdetail.class);
        intent.putExtra("type",type);
        intent.putExtra("colony",colony);
        intent.putExtra("uid",uid);
        startActivity(intent);
    }
}
