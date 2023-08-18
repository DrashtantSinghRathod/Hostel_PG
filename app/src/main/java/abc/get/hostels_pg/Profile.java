package abc.get.hostels_pg;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LinearLayout linearLayout4,linearLayout5,linearLayout6,llh,llh2,llh3,llp,lls,llo,llh4,llh5,ll1;
    TextView textView1,textView2,textView3,textView4,textView5,textView7,textView9,textView12,textView14,textView19,textView17,
            textView22,textView24,textView25,textView26,textView27,textView28,textView29,
            textView32,textView35,textView37,textView38,textView260,textView270,textView280,textView290,textView120,
            textView320,textView370,textView380,textView107,textView90,textView900,textView8,textView140,textView147,
            textView13,textView18,textView119,textView94;
    ImageView imageView11,imageView12,imageView13,imageView21,imageView22,imageView23,
            imageView31,imageView32,imageView33,imageView41,imageView42,imageView43,imageView410,imageView420,imageView430,imageView45,
             imageView46;
    ImageView imageView27,imageView28,imageView29,imageView30,imageView35,imageView36,imageView37,imageView38,imageView39,
            imageView50,imageView51,imageView52,imageView53,imageView54,imageView55,imageView56,imageView57,imageView58,imageView59,
            imageView500,imageView510,imageView520,imageView530,imageView540,imageView550,imageView560,imageView570,imageView580,imageView590;
    ImageView[] iv1;
    ImageView[] iv5;
    ImageView[] iv2;
    ImageView[] iv3;
    ImageView[] iv4;
    Spinner spinner4;
    AdView mAdView;
    CardView cards1,cards2,cardprof,cardbook,icard1,icard2,icard3;
    ArrayList<Word2> words3= new ArrayList<Word2>();
    ArrayList<String> colonys = new ArrayList<>();
    RadioGroup radioGroup,radioGroup2,radioGroup3,radioGroup4,radioGroup5;
    Button button4,button6,button7,button9,button8,button10,button3,button12,button13,button14,button40,button400;
    ListView list4;
    ImageButton imageButton5,imageButton6,imageButton7,imageButton8,imageButton9;
    DatabaseReference reference;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    RadioButton radioButton;
    ProgressBar progressBar,progressBar7;
    FirebaseAuth mAuth;
    String uid,a,ouid,item,college,clny,type;
    String ac,sweeper,ro,water_heater,laundry,ebill,cooler,bed,matress,kitchen,wifi,gym;

    int r=0,i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i=getIntent();
        final String colony =i.getStringExtra("colony");
        reference = fd.getReference();
        final FirebaseUser user = mAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        linearLayout5=findViewById(R.id.linearLayout5);
        linearLayout4=findViewById(R.id.linearLayout4);
        linearLayout6=findViewById(R.id.linearLayout6);
        llh=findViewById(R.id.llh);
        llo=findViewById(R.id.llo);
        llh2=findViewById(R.id.llh2);
        llh3=findViewById(R.id.llh3);
        llh4=findViewById(R.id.llh4);
        llh5=findViewById(R.id.llh5);
        llp=findViewById(R.id.llp);
        lls=findViewById(R.id.lls);
        ll1=findViewById(R.id.ll1);

        cards1=findViewById(R.id.cards1);
        cards2=findViewById(R.id.cards2);
        cardbook=findViewById(R.id.cardbook);
        cardprof=findViewById(R.id.cardprof);
        icard1=findViewById(R.id.icard1);
        icard2=findViewById(R.id.icard2);
        icard3=findViewById(R.id.icard3);

        button4=findViewById(R.id.button4);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button9=findViewById(R.id.button9);
        button8=findViewById(R.id.button8);
        button12=findViewById(R.id.button12);
        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button10=findViewById(R.id.button10);
        button3=findViewById(R.id.button3);
        button40=findViewById(R.id.button40);
        button400=findViewById(R.id.button400);

        spinner4=findViewById(R.id.spinner4);

        list4=findViewById(R.id.list4);

        imageButton5=findViewById(R.id.imageButton5);
        imageButton6=findViewById(R.id.imageButton6);
        imageButton7=findViewById(R.id.imageButton7);
        imageButton8=findViewById(R.id.imageButton8);
        imageButton9=findViewById(R.id.imageButton9);

        imageView27 = findViewById(R.id.imageView27);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        imageView30 = findViewById(R.id.imageView30);
        imageView35 = findViewById(R.id.imageView35);
        imageView36 = findViewById(R.id.imageView36);
        imageView37 = findViewById(R.id.imageView37);
        imageView38 = findViewById(R.id.imageView38);
        imageView39 = findViewById(R.id.imageView39);

        imageView50=findViewById(R.id.imageView50);
        imageView51=findViewById(R.id.imageView51);
        imageView52=findViewById(R.id.imageView52);
        imageView53=findViewById(R.id.imageView53);
        imageView54=findViewById(R.id.imageView54);
        imageView55=findViewById(R.id.imageView55);
        imageView56=findViewById(R.id.imageView56);
        imageView57=findViewById(R.id.imageView57);
        imageView58=findViewById(R.id.imageView58);
        imageView59=findViewById(R.id.imageView59);

        imageView500=findViewById(R.id.imageView500);
        imageView510=findViewById(R.id.imageView510);
        imageView520=findViewById(R.id.imageView520);
        imageView530=findViewById(R.id.imageView530);
        imageView540=findViewById(R.id.imageView540);
        imageView550=findViewById(R.id.imageView550);
        imageView560=findViewById(R.id.imageView560);
        imageView570=findViewById(R.id.imageView570);
        imageView580=findViewById(R.id.imageView580);
        imageView590=findViewById(R.id.imageView590);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView7=findViewById(R.id.textView7);
        textView9=findViewById(R.id.textView9);
        textView12 = findViewById(R.id.textView12);
        textView14 = findViewById(R.id.textView14);
        textView19 = findViewById(R.id.textView19);
        textView17 = findViewById(R.id.textView17);
        textView22 = findViewById(R.id.textView22);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView32 = findViewById(R.id.textView32);
        textView35 = findViewById(R.id.textView35);
        textView37 = findViewById(R.id.textView37);
        textView38 = findViewById(R.id.textView38);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView32 = findViewById(R.id.textView32);
        textView35 = findViewById(R.id.textView35);
        textView37 = findViewById(R.id.textView37);
        textView38 = findViewById(R.id.textView38);
        textView260 = findViewById(R.id.textView260);
        textView270 = findViewById(R.id.textView270);
        textView280 = findViewById(R.id.textView280);
        textView290 = findViewById(R.id.textView290);
        textView320 = findViewById(R.id.textView320);
        textView370 = findViewById(R.id.textView370);
        textView380 = findViewById(R.id.textView380);
        textView107 = findViewById(R.id.textView107);
        textView119=findViewById(R.id.textView119);
        textView120 = findViewById(R.id.textView120);
        textView90 = findViewById(R.id.textView90);
        textView94 = findViewById(R.id.textView94);
        textView900 = findViewById(R.id.textView900);
        textView8=findViewById(R.id.textView8);
        textView13=findViewById(R.id.textView13);
        textView18=findViewById(R.id.textView18);
        textView140 = findViewById(R.id.textView140);
        textView147 = findViewById(R.id.textView147);

        radioGroup=findViewById(R.id.radioGroup);
        radioGroup2=findViewById(R.id.radioGroup2);
        radioGroup3=findViewById(R.id.radioGroup3);
        radioGroup4=findViewById(R.id.radioGroup4);
        radioGroup5=findViewById(R.id.radioGroup5);

        progressBar=findViewById(R.id.progressBar);
        progressBar7=findViewById(R.id.progressBar7);


        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView21 = findViewById(R.id.imageView21);
        imageView22 = findViewById(R.id.imageView22);
        imageView23 = findViewById(R.id.imageView23);
        imageView31 = findViewById(R.id.imageView31);
        imageView32 = findViewById(R.id.imageView32);
        imageView33 = findViewById(R.id.imageView33);
        imageView41 = findViewById(R.id.imageView41);
        imageView42 = findViewById(R.id.imageView42);
        imageView43 = findViewById(R.id.imageView43);
        imageView410 = findViewById(R.id.imageView410);
        imageView420 = findViewById(R.id.imageView420);
        imageView430 = findViewById(R.id.imageView430);
        imageView45 = findViewById(R.id.imageView45);
        imageView46 = findViewById(R.id.imageView46);

        iv1= new ImageView[3];
        iv2= new ImageView[3];
        iv3= new ImageView[3];
        iv4= new ImageView[3];
        iv5= new ImageView[5];

        iv1[0]=imageView11;
        iv1[1]=imageView12;
        iv1[2]=imageView13;

        iv2[0]=imageView21;
        iv2[1]=imageView22;
        iv2[2]=imageView23;

        iv3[0]=imageView31;
        iv3[1]=imageView32;
        iv3[2]=imageView33;

        iv4[0]=imageView41;
        iv4[1]=imageView42;
        iv4[2]=imageView43;

        iv5[0]=imageView410;
        iv5[1]=imageView420;
        iv5[2]=imageView430;
        iv5[3]=imageView45;
        iv5[4]=imageView46;

        llh.setVisibility(View.GONE);

        llh2.setVisibility(View.GONE);
        llh3.setVisibility(View.GONE);
        llh4.setVisibility(View.GONE);
        llh5.setVisibility(View.GONE);
        llo.setVisibility(View.GONE);
        lls.setVisibility(View.GONE);
        llp.setVisibility(View.GONE);
        list4.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);
        button9.setVisibility(View.GONE);
        button13.setVisibility(View.VISIBLE);
        textView147.setVisibility(View.GONE);
        textView140.setVisibility(View.GONE);
        button14.setVisibility(View.GONE);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView9);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        a=textView140.getText().toString();
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null)
        {
            reference.child("UID").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1:snapshot.getChildren())
                    {
                        if (uid.equals(snapshot1.getKey()))
                        {
                            llo.setVisibility(View.VISIBLE);
                            progressBar7.setVisibility(View.GONE);
                            r=1;
                        }

                    }
                    if (r==0)
                    {
                        lls.setVisibility(View.VISIBLE);
                        progressBar7.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            reference.child("Owner").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1:snapshot.getChildren())
                    {
                        Toast.makeText(Profile.this, "inside", Toast.LENGTH_SHORT).show();
                        Word2 word3 = new Word2();
                        word3 = snapshot1.getValue(Word2.class);
                        words3.add(word3);
                    }
                    WordAdapter2 adapter2 = new WordAdapter2(Profile.this,words3);
                    list4.setAdapter(adapter2);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            reference.child("UID").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1 : snapshot.getChildren())
                    {
                        String colonysp = snapshot1.getKey();
                        colonys.add(colonysp);
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Profile.this,android.R.layout.simple_spinner_item,colonys);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner4.setAdapter(adapter);
                    button13.setVisibility(View.VISIBLE);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            spinner4.setOnItemSelectedListener(this);



            Intent intent = getIntent();
            final String ouid=intent.getStringExtra("ouid");


            imageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId;
                    radioId= radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    textView9.setText(radioButton.getText().toString());
                    String sa=textView9.getText().toString();
                    if (sa.equals("Available"))
                    {
                        textView9.setTextColor(Color.parseColor("#00ff00"));
                    }
                    if (sa.equals("Not Available"))
                    {
                        textView9.setTextColor(Color.parseColor("#ff0000"));


                    }

                    llh.setVisibility(View.GONE);
                    reference.child("Colonies").child(a).child(uid).child("savail").setValue(textView9.getText().toString());
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Profile.this,adddetail.class);

                    startActivity(i);
                }
            });
            button12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Profile.this,adddetail.class);

                    startActivity(i);
                }
            });
            button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Profile.this,adddetail.class);

                    startActivity(i);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llh.setVisibility(View.VISIBLE);

                }
            });
            imageButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId;
                    radioId= radioGroup2.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    textView14.setText(radioButton.getText().toString());
                    String sa=textView14.getText().toString();
                    if (sa.equals("Available"))
                    {
                        textView14.setTextColor(Color.parseColor("#00ff00"));
                    }
                    if (sa.equals("Not Available"))
                    {
                        textView14.setTextColor(Color.parseColor("#ff0000"));
                    }
                    llh2.setVisibility(View.GONE);
                    reference.child("Colonies").child(a).child(uid).child("davail").setValue(textView14.getText().toString());
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llh2.setVisibility(View.VISIBLE);

                }
            });
            imageButton7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId;
                    radioId= radioGroup3.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    textView19.setText(radioButton.getText().toString());
                    String sa=textView19.getText().toString();
                    if (sa.equals("Available"))
                    {
                        textView19.setTextColor(Color.parseColor("#00ff00"));
                    }
                    if (sa.equals("Not Available"))
                    {
                        textView19.setTextColor(Color.parseColor("#ff0000"));


                    }
                    llh3.setVisibility(View.GONE);
                    reference.child("Colonies").child(a).child(uid).child("tavail").setValue(textView19.getText().toString());
                }
            });
            button40.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llh4.setVisibility(View.VISIBLE);

                }
            });
            imageButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId;
                    radioId= radioGroup4.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    textView90.setText(radioButton.getText().toString());
                    String sa=textView90.getText().toString();
                    if (sa.equals("Available"))
                    {
                        textView90.setTextColor(Color.parseColor("#00ff00"));
                    }
                    if (sa.equals("Not Available"))
                    {
                        textView90.setTextColor(Color.parseColor("#ff0000"));


                    }
                    llh4.setVisibility(View.GONE);
                    reference.child("Colonies").child(a).child(uid).child("savail").setValue(textView90.getText().toString());
                }
            });
            button400.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llh5.setVisibility(View.VISIBLE);

                }
            });
            imageButton9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int radioId;
                    radioId= radioGroup5.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    textView900.setText(radioButton.getText().toString());
                    String sa=textView900.getText().toString();
                    if (sa.equals("Available"))
                    {
                        textView900.setTextColor(Color.parseColor("#00ff00"));
                    }
                    if (sa.equals("Not Available"))
                    {
                        textView900.setTextColor(Color.parseColor("#ff0000"));


                    }
                    llh5.setVisibility(View.GONE);
                    reference.child("Colonies").child(a).child(uid).child("savail").setValue(textView900.getText().toString());
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    llh3.setVisibility(View.VISIBLE);

                }
            });
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list4.setVisibility(View.VISIBLE);
                    textView147.setVisibility(View.GONE);
                    llp.setVisibility(View.GONE);
                    cardbook.setCardBackgroundColor(Color.parseColor("#EEE6EBBF"));

                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item= (String) spinner4.getSelectedItem();
                    textView147.setVisibility(View.GONE);
                    reference.child("UID").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            reference.child("Colonies").child(item).child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    UserHostel userHostel = snapshot.getValue(UserHostel.class);

                                    assert userHostel != null;
                                    type = userHostel.getType();
                                    clny = userHostel.getColony();

                                    textView2.setText(userHostel.hname);
                                    textView1.setText(userHostel.gender+" Hostel");
                                    textView3.setText(userHostel.oname);
                                    textView4.setText(userHostel.no1);
                                    textView5.setText(userHostel.no2);
                                    textView9.setText(userHostel.savail);
                                    textView12.setText(userHostel.srent);
                                    textView17.setText(userHostel.drent);
                                    textView22.setText(userHostel.trent);
                                    textView25.setText(userHostel.fulladd);
                                    textView9.setText(userHostel.savail);

                                    ac = userHostel.getAc();
                                    sweeper = userHostel.getSweeper();
                                    ro = userHostel.getRo();
                                    laundry = userHostel.getLaundry();
                                    ebill = userHostel.getEbill();
                                    water_heater = userHostel.getWater_heater();
                                    cooler =userHostel.getCooler();
                                    bed = userHostel.getBed();
                                    matress = userHostel.getMatress();
                                    kitchen = userHostel.getKitchen();

                                    setHostel();
                                    setPG();
                                    setFlat();

                                    String sa=userHostel.savail;
                                    if (sa.equals("Available"))
                                    {
                                        textView9.setTextColor(Color.parseColor("#00ff00"));
                                    }
                                    if (sa.equals("Not Available"))
                                    {
                                        textView9.setTextColor(Color.parseColor("#ff0000"));
                                    }
                                    if (sa.equals("Not Added"))
                                    {
                                        textView8.setVisibility(View.GONE);
                                        icard1.setVisibility(View.GONE);
                                    }
                                    textView14.setText(userHostel.davail);
                                    String sa2=userHostel.davail;
                                    if (sa2.equals("Available"))
                                    {
                                        textView14.setTextColor(Color.parseColor("#00ff00"));
                                    }
                                    if (sa2.equals("Not Available"))
                                    {
                                        textView14.setTextColor(Color.parseColor("#ff0000"));
                                    }
                                    if (sa2.equals("Not Added"))
                                    {
                                        textView13.setVisibility(View.GONE);
                                        icard2.setVisibility(View.GONE);
                                    }
                                    textView19.setText(userHostel.tavail);
                                    String sa3=userHostel.tavail;
                                    if (sa3.equals("Available"))
                                    {
                                        textView19.setTextColor(Color.parseColor("#00ff00"));
                                    }
                                    if (sa3.equals("Not Available"))
                                    {
                                        textView19.setTextColor(Color.parseColor("#ff0000"));
                                    }
                                    if (sa3.equals("Not Added"))
                                    {
                                        textView18.setVisibility(View.GONE);
                                        icard3.setVisibility(View.GONE);
                                    }

                                    textView26.setText(userHostel.gender+" PG");
                                    textView27.setText(userHostel.hname);
                                    textView28.setText(userHostel.no1);
                                    textView29.setText(userHostel.no2);
                                    textView32.setText(userHostel.srent);
                                    textView90.setText(userHostel.savail);
                                    textView120.setText(userHostel.detail);
                                    textView35.setText(userHostel.drent);
                                    textView38.setText(userHostel.fulladd);

                                    textView260.setText(userHostel.gender+" Flat");
                                    textView107.setText(userHostel.oname);
                                    textView270.setText(userHostel.hname);
                                    textView280.setText(userHostel.no1);
                                    textView290.setText(userHostel.no2);
                                    textView119.setText(userHostel.detail);
                                    textView900.setText(userHostel.savail);
                                    textView320.setText(userHostel.srent);
                                    textView380.setText(userHostel.fulladd);



                                    String type = userHostel.getType();
                                    if (type.equals("HOSTEL"))
                                    {
                                        linearLayout5.setVisibility(View.GONE);
                                        linearLayout6.setVisibility(View.GONE);
                                        linearLayout4.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.GONE);

                                    }
                                    if (type.equals("PG"))
                                    {
                                        linearLayout5.setVisibility(View.VISIBLE);
                                        linearLayout4.setVisibility(View.GONE);
                                        linearLayout6.setVisibility(View.GONE);
                                        progressBar.setVisibility(View.GONE);
                                    }
                                    if (type.equals("FLAT"))
                                    {
                                        linearLayout5.setVisibility(View.GONE);
                                        linearLayout4.setVisibility(View.GONE);
                                        linearLayout6.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.GONE);
                                    }

                                    FirebaseStorage fs=FirebaseStorage.getInstance();
                                    StorageReference sr=fs.getReferenceFromUrl("gs://hostelspg.appspot.com/");

                                    String[] s={"single/","double/","triple/","pg/","flat/","flat1/"};


                                    for (final  String t:s){
                                        long l=1024*1024;
                                        sr.child(uid).child(t).child("1").getBytes(l).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                            @Override
                                            public void onSuccess(byte[] bytes) {
                                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                                if (t.equals("single/"))
                                                {
                                                    iv1[0].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("double/"))
                                                {
                                                    iv2[0].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("triple/"))
                                                {
                                                    iv3[0].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("pg/"))
                                                {
                                                    iv4[0].setImageBitmap(bitmap);
                                                }
                                                if (t.equals("flat/"))
                                                {
                                                    iv5[0].setImageBitmap(bitmap);
                                                }
                                                if (t.equals("flat1/"))
                                                {
                                                    iv5[3].setImageBitmap(bitmap);
                                                }

                                            }
                                        });
                                        sr.child(uid).child(t).child("2").getBytes(l).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                            @Override
                                            public void onSuccess(byte[] bytes) {
                                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                                if (t.equals("single/"))
                                                {
                                                    iv1[1].setImageBitmap(bitmap);
                                                }
                                                if (t.equals("double/"))
                                                {
                                                    iv2[1].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("triple/"))
                                                {
                                                    iv3[1].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("pg/"))
                                                {
                                                    iv4[1].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("flat/"))
                                                {
                                                    iv5[1].setImageBitmap(bitmap);
                                                }
                                                if (t.equals("flat1/"))
                                                {
                                                    iv5[4].setImageBitmap(bitmap);
                                                }
                                            }
                                        });

                                        sr.child(uid).child(t).child("3").getBytes(l).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                            @Override
                                            public void onSuccess(byte[] bytes) {
                                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                                if (t.equals("single/"))
                                                {
                                                    iv1[2].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("double/"))
                                                {
                                                    iv2[2].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("triple/"))
                                                {
                                                    iv3[2].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("pg/"))
                                                {
                                                    iv4[2].setImageBitmap(bitmap);

                                                }
                                                if (t.equals("flat/"))
                                                {
                                                    iv5[2].setImageBitmap(bitmap);
                                                }
                                            }
                                        });
                                    }


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    llp.setVisibility(View.VISIBLE);
                    list4.setVisibility(View.GONE);
                    cardprof.setCardBackgroundColor(Color.parseColor("#E9E4F1"));
                }
            });
            button13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView94.setVisibility(View.GONE);
                    String cl=spinner4.getSelectedItem().toString();
                    textView140.setText(cl);
                    ll1.setVisibility(View.GONE);
                    button13.setVisibility(View.GONE);
                    button14.setVisibility(View.VISIBLE);
                    textView147.setVisibility(View.VISIBLE);
                    textView140.setVisibility(View.VISIBLE);
                    button8.setVisibility(View.VISIBLE);
                    button9.setVisibility(View.VISIBLE);

                }
            });
            button14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView94.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.VISIBLE);
                    button13.setVisibility(View.VISIBLE);
                    button14.setVisibility(View.GONE);
                    textView147.setVisibility(View.GONE);
                    textView140.setVisibility(View.GONE);
                    button8.setVisibility(View.GONE);
                    button9.setVisibility(View.GONE);
                    llp.setVisibility(View.GONE);
                    list4.setVisibility(View.GONE);
                }
            });
            cards1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Profile.this,MyBookings.class);
                    startActivity(i);
                }
            });
            cards2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(Profile.this,Saved.class);
                    startActivity(i);
                }
            });
        }
        else
        {
            Toast.makeText(this,"Please Sign In first to see profile", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,signin.class);
            startActivity(intent);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item= (String) spinner4.getSelectedItem();
//        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void setHostel() {
        if (ac.equals("false")){
            imageView27.setImageAlpha(60);
        }
        if (sweeper.equals("false")){
            imageView28.setImageAlpha(60);
        }
        if (ro.equals("false")){
            imageView29.setImageAlpha(60);
        }
        if (laundry.equals("false")){
            imageView30.setImageAlpha(60);
        }
        if (ebill.equals("false")){
            imageView35.setImageAlpha(60);
        }
        if (water_heater.equals("false")){
            imageView36.setImageAlpha(60);
        }
        if (cooler.equals("false")){
            imageView37.setImageAlpha(60);
        }
    }

    private void setPG() {
        if (ac.equals("false")){
            imageView50.setImageAlpha(60);
        }
        if (sweeper.equals("false")){
            imageView51.setImageAlpha(60);
        }
        if (ro.equals("false")){
            imageView52.setImageAlpha(60);
        }
        if (laundry.equals("false")){
            imageView53.setImageAlpha(60);
        }
        if (ebill.equals("false")){
            imageView54.setImageAlpha(60);
        }
        if (water_heater.equals("false")){
            imageView55.setImageAlpha(60);
        }
        if (cooler.equals("false")){
            imageView56.setImageAlpha(60);
        }
        if (bed.equals("false")){
            imageView57.setImageAlpha(60);
        }
        if (matress.equals("false")){
            imageView58.setImageAlpha(60);
        }
        if (kitchen.equals("false")){
            imageView59.setImageAlpha(60);
        }
    }
    private void setFlat() {
        if (ac.equals("false")) {
            imageView500.setImageAlpha(60);
        }
        if (sweeper.equals("false")) {
            imageView510.setImageAlpha(60);
        }
        if (ro.equals("false")) {
            imageView520.setImageAlpha(60);
        }
        if (laundry.equals("false")) {
            imageView530.setImageAlpha(60);
        }
        if (ebill.equals("false")) {
            imageView540.setImageAlpha(60);
        }
        if (water_heater.equals("false")) {
            imageView550.setImageAlpha(60);
        }
        if (cooler.equals("false")) {
            imageView560.setImageAlpha(60);
        }
        if (bed.equals("false")) {
            imageView570.setImageAlpha(60);
        }
        if (matress.equals("false")) {
            imageView580.setImageAlpha(60);
        }
        if (kitchen.equals("false")) {
            imageView590.setImageAlpha(60);
        }
    }
}
