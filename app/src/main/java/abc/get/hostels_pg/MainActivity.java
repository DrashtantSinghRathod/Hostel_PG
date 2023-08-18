package abc.get.hostels_pg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    NavigationView nv;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    LinearLayout lls,llrl;
    ImageView imageView,imageView2;
    AdView mAdView;
    MenuItem login,home;
    CardView card1,card2,card3,cards1,cards2;
    ViewFlipper flipper;
    TextView textView18;
    ImageButton imageButton11,imageButton22;
    TextView email11;
    MenuItem profile;
    ConstraintLayout rl;
    Fragment fragment;
    DatabaseReference reference;


    int  i=1;
    String email1;
    MenuItem email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        drawer=findViewById(R.id.drawer);
        card1=findViewById(R.id.card1);
        imageView=findViewById(R.id.imageView);
        email11=findViewById(R.id.email11);
        card2=findViewById(R.id.card2);
        lls=findViewById(R.id.lls);
        lls.setVisibility(View.VISIBLE);
        email=findViewById(R.id.email);
        llrl=findViewById(R.id.llrl);
        llrl.setVisibility(View.GONE);
        card1.setVisibility(View.GONE);
        card2.setVisibility(View.GONE);
        cards1=findViewById(R.id.cards1);
        cards2=findViewById(R.id.cards2);
        cards1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llrl.setVisibility(View.VISIBLE);
                card1.setVisibility(View.VISIBLE);
                lls.setVisibility(View.GONE);
            }
        });
        cards2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llrl.setVisibility(View.VISIBLE);
                card2.setVisibility(View.VISIBLE);
                lls.setVisibility(View.GONE);
            }
        });
        assert user != null;
        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if (account!=null) {

            email1 = user.getEmail();
            email11.setText(email1);
        }
        else {
            email11.setText("Signed Out");
        }
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        rl=findViewById(R.id.rl);

        imageButton11=findViewById(R.id.imageButton11);
        imageButton22=findViewById(R.id.imageButton22);

        flipper=findViewById(R.id.flipper);

        int images[] ={R.drawable.ads1,R.drawable.ads2,R.drawable.ads7,R.drawable.ads6};
        for (int i=0;i<images.length;i++)
        {
            FlipperImage(images[i]);
        }






        login=findViewById(R.id.login);
        profile=findViewById(R.id.proflie);

        textView18=findViewById(R.id.textView18);

        home=findViewById(R.id.home);
        nv=findViewById(R.id.nv);

        toggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(MainActivity.this);


                    if (account != null) {

                        Intent i = new Intent(MainActivity.this,adddetail.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "please sign In first To add Your Hostel/PG", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(MainActivity.this, signin.class);
                        i.putExtra("type","add");
                        startActivity(i);
                    }



            }
        });

        card1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {



                GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(MainActivity.this);
                if (account != null) {
                    Intent i = new Intent(MainActivity.this,Search.class);
                    startActivity(i);




                } else {
                    Toast.makeText(MainActivity.this, "please sign In first To add Your Hostel/PG", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(MainActivity.this, signin.class);
                    i.putExtra("type","search");
                    startActivity(i);
                }




            }
        });
        nv.setNavigationItemSelectedListener(this);

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i=i-1;
                if (i==0)
                {
                    i=3;
                }
                textView18.setText(i+" of 3");
                flipper.stopFlipping();
                flipper.setOutAnimation(MainActivity.this,android.R.anim.fade_out);
                flipper.setInAnimation(MainActivity.this,android.R.anim.fade_in);
                flipper.showPrevious();
            }
        });
        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 i=i+1;
                if (i==4)
                {
                    i=1;
                }
                textView18.setText(i+" of 3");
                flipper.stopFlipping();
                flipper.setOutAnimation(MainActivity.this,android.R.anim.fade_out);
                flipper.setInAnimation(MainActivity.this,android.R.anim.fade_in);
                flipper.showNext();
            }
        });




    }

    private void FlipperImage(int image) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        flipper.addView(imageView);
        flipper.setFlipInterval(1300);
        flipper.setAutoStart(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (toggle.onOptionsItemSelected(item)) {
            return true;
            }
        int id = item.getItemId();
        if (id == R.id.proflie) {
            GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(MainActivity.this);
            if (account != null) {
                Intent i = new Intent(MainActivity.this,Profile.class);
                startActivity(i);




            } else {
                Toast.makeText(MainActivity.this, "please sign In first To add Your Hostel/PG", Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, signin.class);
                i.putExtra("type","profile");
                startActivity(i);
            }

        }
    return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();

        if (id==R.id.login)
        {
            Intent i = new Intent(this,AboutUs.class);
            startActivity(i);
        }
        if (id==R.id.about)
        {
            Intent i = new Intent(this,ContactUs.class);
            startActivity(i);
        }
        if (id==R.id.home)
        {
            mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(MainActivity.this,"Signed out successfully",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
        if (id==R.id.saved)
        {
            Intent i = new Intent(this,Saved.class);
            startActivity(i);
        }
        if (id==R.id.bookings)
        {
            Intent i = new Intent(this,MyBookings.class);
            startActivity(i);
        }

        return true;
    }




}
