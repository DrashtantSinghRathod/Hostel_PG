package abc.get.hostels_pg;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
import static android.provider.MediaStore.Images.Media.getBitmap;

public class adddetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Switch switch1,switch2,switch3;
    CardView card1,card2,icard1,icard2,icard3,card4;
    RadioGroup radioGroup,radioGroup2,radioGroup3,rg4,radioGroup4;
    RadioButton radioButton,radioButton2;
    Chip chip5,chip6,chip7,chip8,chip9,chip10,chip11,chip12,chip13,chip14,chip15,chip16,chip17,chip18,chip19,chip20,chip21,
            chip120,chip130,chip140,chip150,chip160,chip170,chip180,chip190,chip200,chip210;
    ChipGroup cg1,cg2,cg10;
    EditText editText,editText2,editText5,editText8,editText9,editText11,editText20,editText21,
    editText25,editText26,editText28,editText4,editText3,editText6,editText7,editText12,
            editText14,editText10,editText23,editText24,editText34,editText27,editText200,editText210,editText230,editText40,
            editText250,editText260,editText270,editText220,editText340;

    LinearLayout linearLayout,linearLayout2,linearLayout3,linearLayout4,linearLayout11,linearLayout22,
            llreset,llselect,linearLayout33,linearLayout44,linearLayout55,parentlinlay23,llfindclny,llspnr2,llset;
    CheckBox checkBox,checkBox2;
    Button button2,button10,button3,button,button15,button20,button16,button17,button19,button21;

    TextView textView24,textView25,textView26,textView15;
    Spinner spinner3,spinner,spinner2;
    ImageView imageView,imageView2,imageView33, imageView11,imageView22,imageView333, imageView111,
            imageView222,imageView3333,imageView12,imageView23,imageView34,imageView120,imageView230,
            imageView340,imageView44,imageView40;
    ImageView imv1[];
    ImageView[] imv4;
    ImageButton imageButton3,imageButton4;
    AdView mAdView;
    ImageView[] imv2;
    ImageView[] imv3;
    ImageView[] imv5;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference reference,reference2;

    FirebaseAuth mAuth;
    List<String> College2,College1,College3;
    ArrayAdapter<String> adapter31,adapter32,adapter33;
    ArrayList<String> num2;
    ArrayList<String> chips1 = new ArrayList<>();
    ArrayList<String> chips2 = new ArrayList<>();
    ArrayList<String> chips3 = new ArrayList<>();

    int i;
    String type,uid,Collegename,colonyname,string,college;
    String savail1="Not Added";
    String davail1="Not Added";
    String tavail1="Not Added";
    String ac1,cooler1,sweeper1,laundry1,ebill1,water_heater1,ro1,bed1,matress1,kitchen1,clgname;

    Bitmap bitmap;
    byte[] data1;
String path;

    FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();

    FirebaseStorage storage=FirebaseStorage.getInstance();
    StorageReference sref;
    UploadTask uploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetail);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup3=findViewById(R.id.radioGroup3);
        radioGroup2=findViewById(R.id.radioGroup2);
        switch1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        switch3=findViewById(R.id.switch3);

        card2 = findViewById(R.id.card2);
        button20 = findViewById(R.id.button20);
        checkBox2 = findViewById(R.id.checkBox2);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);

        chip5=findViewById(R.id.chip5);
        chip6=findViewById(R.id.chip6);
        chip7=findViewById(R.id.chip7);
        chip8=findViewById(R.id.chip8);
        chip9=findViewById(R.id.chip9);
        chip10=findViewById(R.id.chip10);
        chip11=findViewById(R.id.chip11);
        chip12=findViewById(R.id.chip12);
        chip13=findViewById(R.id.chip13);
        chip14=findViewById(R.id.chip14);
        chip15=findViewById(R.id.chip15);
        chip16=findViewById(R.id.chip16);
        chip17=findViewById(R.id.chip17);
        chip18=findViewById(R.id.chip18);
        chip19=findViewById(R.id.chip19);
        chip20=findViewById(R.id.chip20);
        chip21=findViewById(R.id.chip21);
        cg1=findViewById(R.id.cg1);

        chip120=findViewById(R.id.chip120);
        chip130=findViewById(R.id.chip130);
        chip140=findViewById(R.id.chip140);
        chip150=findViewById(R.id.chip150);
        chip160=findViewById(R.id.chip160);
        chip170=findViewById(R.id.chip170);
        chip180=findViewById(R.id.chip180);
        chip190=findViewById(R.id.chip190);
        chip200=findViewById(R.id.chip200);
        chip210=findViewById(R.id.chip210);


        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView33=findViewById(R.id.imageView33);
        imageView11=findViewById(R.id.imageView11);
        imageView22=findViewById(R.id.imageView22);
        imageView333=findViewById(R.id.imageView333);
        imageView111=findViewById(R.id.imageView111);
        imageView222=findViewById(R.id.imageView222);
        imageView3333=findViewById(R.id.imageView3333);
        imageView12=findViewById(R.id.imageView12);
        imageView23=findViewById(R.id.imageView23);
        imageView34=findViewById(R.id.imageView34);
        imageView120=findViewById(R.id.imageView120);
        imageView230=findViewById(R.id.imageView230);
        imageView340=findViewById(R.id.imageView340);
        imageView44=findViewById(R.id.imageView44);
        imageView40=findViewById(R.id.imageView40);

        imageButton3=findViewById(R.id.imageButton3);
        imageButton4=findViewById(R.id.imageButton4);

        editText200=findViewById(R.id.editText200);
        editText210=findViewById(R.id.editText210);
        editText230=findViewById(R.id.editText230);
        editText40=findViewById(R.id.editText40);
        editText250=findViewById(R.id.editText250);
        editText260=findViewById(R.id.editText260);
        editText270=findViewById(R.id.editText270);
        editText220=findViewById(R.id.editText220);
        rg4=findViewById(R.id.rg4);
        radioGroup4=findViewById(R.id.radioGroup4);


        spinner3=findViewById(R.id.spinner3);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText6=findViewById(R.id.editText6);
        editText7=findViewById(R.id.editText7);
        editText12=findViewById(R.id.editText12);
        editText14=findViewById(R.id.editText14);
        editText10=findViewById(R.id.editText10);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        editText8=findViewById(R.id.editText8);
        editText9=findViewById(R.id.editText9);
        editText11=findViewById(R.id.editText11);
        editText20=findViewById(R.id.editText20);
        editText21=findViewById(R.id.editText21);
        editText25=findViewById(R.id.editText25);
        editText26=findViewById(R.id.editText26);
        editText28=findViewById(R.id.editText28);
        editText23=findViewById(R.id.editText23);
        editText24=findViewById(R.id.editText24);
        editText34=findViewById(R.id.editText34);
        editText340=findViewById(R.id.editText340);
        editText27=findViewById(R.id.editText27);

        checkBox=findViewById(R.id.checkBox);
        textView24=findViewById(R.id.textView24);
        textView25=findViewById(R.id.textView25);
        textView26=findViewById(R.id.textView26);
        textView15=findViewById(R.id.textView15);

        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button10=findViewById(R.id.button10);
        button21=findViewById(R.id.button21);
        button19=findViewById(R.id.button19);
        button=findViewById(R.id.button);
        button15=findViewById(R.id.button15);

        card1=findViewById(R.id.card1);
        card4=findViewById(R.id.card4);
        icard1=findViewById(R.id.icard1);
        icard2=findViewById(R.id.icard2);
        icard3=findViewById(R.id.icard3);

        linearLayout=findViewById(R.id.linearLayout);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout.setVisibility(View.GONE);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);
        linearLayout11=findViewById(R.id.lladdimg1);
        linearLayout22=findViewById(R.id.lladdimg2);
        linearLayout33=findViewById(R.id.lladdimg3);
        linearLayout44=findViewById(R.id.lladdimg4);
        linearLayout55=findViewById(R.id.lladdimg5);
        parentlinlay23=findViewById(R.id.parentll23);
        llfindclny=findViewById(R.id.llfindclny);
        llspnr2=findViewById(R.id.llspnr2);
        llreset=findViewById(R.id.llreset);
        llselect=findViewById(R.id.llselect);
        llset=findViewById(R.id.llset);
        card4.setVisibility(View.GONE);

        imv1 = new ImageView[3];
        imv2 = new ImageView[3];
        imv3 = new ImageView[3];
        imv4 = new ImageView[3];
        imv5 = new ImageView[5];

        imv1[0]=imageView;
        imv1[1]=imageView2;
        imv1[2]=imageView33;
        imv2[0]=imageView11;
        imv2[1]=imageView22;
        imv2[2]=imageView333;
        imv3[0]=imageView111;
        imv3[1]=imageView222;
        imv3[2]=imageView3333;
        imv4[0]=imageView12;
        imv4[1]=imageView23;
        imv4[2]=imageView34;
        imv5[0]=imageView120;
        imv5[1]=imageView230;
        imv5[2]=imageView340;
        imv5[3]=imageView44;
        imv5[4]=imageView40;

        linearLayout2.setVisibility(View.GONE);
        linearLayout3.setVisibility(View.GONE);
        linearLayout4.setVisibility(View.GONE);
        card2.setVisibility(View.GONE);
        icard1.setVisibility(View.GONE);
        icard2.setVisibility(View.GONE);
        icard3.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
        llreset.setVisibility(View.GONE);
        imageButton4.setVisibility(View.GONE);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        ActivityCompat.requestPermissions(adddetail.this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAuth= FirebaseAuth.getInstance();
        type=textView24.getText().toString();


        spinner3.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        reference= firebaseDatabase.getReference();




        reference2 = firebaseDatabase.getReference("dbCOLLEGES/Ujjain Engg College");
        reference2.child("Motibagh Colony").setValue("1.1");
        reference2.child("Pawapuri Colony").setValue("1.8");
        reference2.child("AwantikaPuri Colony").setValue("1.4");
        reference2.child("Tripti Vihar").setValue("0.75");
        reference2.child("Kirti Nagar").setValue("1");
        reference2.child("Basant Nagar").setValue("1.5");
        reference2.child("Vasant Vihar").setValue("0.7");
        reference2.child("Taramandal").setValue("2.2");
        reference2.child("Mahananda | Mahashakti Nagar").setValue("2");
        reference2.child("New State Bank Colony").setValue("2.1");
        reference2.child("PVR Mall").setValue("2.3");
        reference2.child("Anand Nagar").setValue("1.9");
        reference2.child("NanaKheda").setValue("2");
        reference2.child("Ajad Nagar").setValue("1.8");
        reference2.child("Alakhnanda Nagar").setValue("2.2");
        reference2.child("NagJhiri").setValue("2.1");

        reference2 = firebaseDatabase.getReference("dbCOLLEGES/Saraswati College");
        reference2.child("Badshah Nagar").setValue("0.35");
        reference2.child("Shastri Nagar").setValue("0.45");
        reference2.child("Vyas Nagar").setValue("0.65");
        reference2.child("Sant Nagar").setValue("0.65");
        reference2.child("Ved Nagar").setValue("1.2");
        reference2.child("Makal Vanijya").setValue("1.8");
        reference2.child("Prem nagar ").setValue("1.9");
        reference2.child("Shnti Nagar").setValue("1");
        reference2.child("NanaKheda").setValue("1.9");
        reference2.child("Sindhi Colony").setValue("1.8");
        reference2.child("Sethi Nagar").setValue("2.4");
        reference2.child("Alkapuri").setValue("3.3");
        reference2.child("Adarsh Vikram Nagar").setValue("2.4");
        reference2.child("Vasant Vihar").setValue("3.2");
        reference2.child("AlakNanda Nagar").setValue("2.5");
        reference2.child("PVR Mall").setValue("2.3");
        reference2.child("Tower Chowk").setValue("1.6");



        ArrayList<String> num=new ArrayList<>();
        num.add("HOSTEL");
        num.add("PG");
        num.add("FLAT");
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,num);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(adapter);
        num2=new ArrayList<>();
        reference.child("dbCOLLEGES").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot1:snapshot.getChildren())
                {
                    String w=dataSnapshot1.getKey();
                    num2.add(w);
                }
                ArrayAdapter<String> adapter2=new ArrayAdapter<String>(adddetail.this,android.R.layout.simple_spinner_item,num2);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter2);
                imageButton4.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });


        CompoundButton.OnCheckedChangeListener checkedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    chips1.add(buttonView.getText().toString());
                }
                else
                {
                    chips1.remove(buttonView.getText().toString());
                }

            }
        };

        chip5.setOnCheckedChangeListener(checkedChangeListener);
        chip6.setOnCheckedChangeListener(checkedChangeListener);
        chip7.setOnCheckedChangeListener(checkedChangeListener);
        chip8.setOnCheckedChangeListener(checkedChangeListener);
        chip9.setOnCheckedChangeListener(checkedChangeListener);
        chip10.setOnCheckedChangeListener(checkedChangeListener);
        chip11.setOnCheckedChangeListener(checkedChangeListener);

        CompoundButton.OnCheckedChangeListener checkedChangeListener1=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    chips2.add(buttonView.getText().toString());
                }
                else
                {
                    chips2.remove(buttonView.getText().toString());
                }

            }
        };

        chip12.setOnCheckedChangeListener(checkedChangeListener1);
        chip13.setOnCheckedChangeListener(checkedChangeListener1);
        chip14.setOnCheckedChangeListener(checkedChangeListener1);
        chip15.setOnCheckedChangeListener(checkedChangeListener1);
        chip16.setOnCheckedChangeListener(checkedChangeListener1);
        chip17.setOnCheckedChangeListener(checkedChangeListener1);
        chip18.setOnCheckedChangeListener(checkedChangeListener1);
        chip19.setOnCheckedChangeListener(checkedChangeListener1);
        chip20.setOnCheckedChangeListener(checkedChangeListener1);
        chip21.setOnCheckedChangeListener(checkedChangeListener1);

        CompoundButton.OnCheckedChangeListener checkedChangeListener2=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    chips3.add(buttonView.getText().toString());
                }
                else
                {
                    chips3.remove(buttonView.getText().toString());
                }

            }
        };

        chip120.setOnCheckedChangeListener(checkedChangeListener2);
        chip130.setOnCheckedChangeListener(checkedChangeListener2);
        chip140.setOnCheckedChangeListener(checkedChangeListener2);
        chip150.setOnCheckedChangeListener(checkedChangeListener2);
        chip160.setOnCheckedChangeListener(checkedChangeListener2);
        chip170.setOnCheckedChangeListener(checkedChangeListener2);
        chip180.setOnCheckedChangeListener(checkedChangeListener2);
        chip190.setOnCheckedChangeListener(checkedChangeListener2);
        chip200.setOnCheckedChangeListener(checkedChangeListener2);
        chip210.setOnCheckedChangeListener(checkedChangeListener2);





        linearLayout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallery();
            }
        });
        linearLayout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery1();
            }
        });
        linearLayout33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery2();
            }
        });
        linearLayout44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery3();
            }
        });
        linearLayout55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery4();
            }
        });




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x=checkBox.isChecked();
                if (x)
                {
                  linearLayout2.setVisibility(View.GONE);
                  linearLayout3.setVisibility(View.GONE);
                    linearLayout4.setVisibility(View.GONE);
                  card1.setVisibility(View.GONE);
                  card2.setVisibility(View.VISIBLE);
                }
                else
                {
                    Toast.makeText(adddetail.this, "please agree terms and conditions", Toast.LENGTH_LONG).show();
                }

            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean y=checkBox.isChecked();
                if(y)
                {
                    linearLayout.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.GONE);
                }
                else
                {
                    Toast.makeText(adddetail.this, "please agree terms and conditions", Toast.LENGTH_LONG).show();
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adddetail.this,AboutUs.class);
                startActivity(i);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(adddetail.this,AboutUs.class);
                startActivity(i);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty())
                {
                    editText.setError("required");
                    editText.requestFocus();
                    return;
                }

                if (editText2.getText().toString().isEmpty())
                {
                    editText2.setError("required");
                    editText2.requestFocus();
                    return;
                }
                if (editText5.getText().toString().isEmpty())
                {
                    editText5.setError("required");
                    editText5.requestFocus();
                    return;
                }
                if (editText8.getText().toString().isEmpty())
                {
                    editText8.setError("required");
                    editText8.requestFocus();
                    return;
                }
                if (editText9.getText().toString().isEmpty())
                {
                    editText9.setError("required");
                    editText9.requestFocus();
                    return;
                }
                if (editText11.getText().toString().isEmpty())
                {
                    editText11.setError("required");
                    editText11.requestFocus();
                    return;
                }

                    uid=user1.getUid();
                    String type=textView24.getText().toString();

                    String clgname=textView25.getText().toString();
                    colonyname=textView26.getText().toString();
                    reference.child("Colleges").child(clgname).child(colonyname).setValue("my baby").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(adddetail.this,"successful Added",Toast.LENGTH_LONG).show();

                                reference= firebaseDatabase.getReference("UID");
                                reference.child(uid).child(colonyname).setValue(colonyname);

                                FirebaseMessaging.getInstance().subscribeToTopic(uid);

                            }
                            else
                            {
                                Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });




                    int radioId;
                    radioId= radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);



                Chip[] chips={chip5,chip6,chip7,chip8,chip9,chip10,chip11};
                ac1="false";
                laundry1="false";
                ebill1="false";
                cooler1="false";
                ro1="false";
                water_heater1="false";
                sweeper1="false";
                bed1="false";
                matress1="false";
                kitchen1="false";


                for (i=0;i<7;i++)
                {
                    for (String s2:chips1)
                    {
                        if (s2.equals("Ac"))
                        {
                           ac1="true";
                        }
                        if (s2.equals("Sweeping Facility"))
                        {
                           sweeper1="true";
                        }
                        if (s2.equals("RO Water"))
                        {
                           ro1="true";
                        }
                        if (s2.equals("Laundry Facility"))
                        {
                           laundry1="true";
                        }
                        if (s2.equals("Electricity Bill Included"))
                        {
                           ebill1="true";
                        }
                        if (s2.equals("Water Heater"))
                        {
                           water_heater1="true";
                        }
                        if (s2.equals("Cooler"))
                        {
                           cooler1="true";
                        }

                    }
                }

                String  gender1=  radioButton.getText().toString();
                    final String hname1=editText.getText().toString();
                    String oname1=editText2.getText().toString();
                    String email1=editText3.getText().toString();
                    final String no11=editText5.getText().toString();
                    final String no21=editText6.getText().toString();
                    String srent1=editText7.getText().toString();
                    String drent1=editText12.getText().toString();
                    String trent1=editText14.getText().toString();
                    String hno1=editText8.getText().toString();
                    String coname1=editText9.getText().toString();
                    String landmark1=editText10.getText().toString();
                    String detail1="";
                    String city1=editText11.getText().toString();
                    String fulladd1=hno1+", "+coname1+landmark1+", "+city1;

                    UserHostel userHostel=new UserHostel(colonyname,uid,path,type,gender1,hname1,oname1,email1,no11,no21,srent1,drent1,trent1,detail1,fulladd1,savail1,davail1,tavail1,ac1,laundry1,ebill1,cooler1,ro1,water_heater1,sweeper1,bed1,matress1,kitchen1);
                    reference.child("Colonies").child(colonyname).child(uid).setValue(userHostel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                String msg = hname1+"  "+no11+"  "+no21;
                                String number1 = "6265752172";
                                String number2 = "9893510414";
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage(number1,null,msg,null,null);
                                smsManager.sendTextMessage(number2,null,msg,null,null);
                                Intent i=new Intent(adddetail.this,Profile.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });






            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText20.getText().toString().isEmpty())
                {
                    editText20.setError("required");
                    editText20.requestFocus();
                    return;
                }
                if (editText21.getText().toString().isEmpty())
                {
                    editText21.setError("required");
                    editText21.requestFocus();
                    return;
                }
                if (editText4.getText().toString().isEmpty())
                {
                    editText4.setError("required");
                    editText4.requestFocus();
                    return;
                }
                if (editText25.getText().toString().isEmpty())
                {
                    editText25.setError("required");
                    editText25.requestFocus();
                    return;
                }
                if (editText26.getText().toString().isEmpty())
                {
                    editText26.setError("required");
                    editText26.requestFocus();
                    return;
                }
                if (editText28.getText().toString().isEmpty())
                {
                    editText28.setError("required");
                    editText28.requestFocus();
                    return;
                }

                Chip[] chips={chip12,chip13,chip14,chip15,chip16,chip17,chip18,chip19,chip20,chip21};
                ac1="false";
                laundry1="false";
                ebill1="false";
                cooler1="false";
                ro1="false";
                water_heater1="false";
                sweeper1="false";
                bed1="false";
                matress1="false";
                kitchen1="false";


                for (i=0;i<10;i++)
                {
                    for (String s2:chips2)
                    {

                        if (s2.equals("Ac"))
                        {
                            ac1="true";
                        }
                        if (s2.equals("Sweeping Facility"))
                        {
                            sweeper1="true";
                        }
                        if (s2.equals("RO Water"))
                        {
                            ro1="true";
                        }
                        if (s2.equals("Laundry Facility"))
                        {
                            laundry1="true";
                        }
                        if (s2.equals("Electricity Bill Included"))
                        {
                            ebill1="true";
                        }
                        if (s2.equals("Water Heater"))
                        {
                            water_heater1="true";
                        }
                        if (s2.equals("Cooler"))
                        {
                            cooler1="true";
                        }
                        if (s2.equals("Bed"))
                        {
                            bed1="true";
                        }
                        if (s2.equals("Sleeping Matress"))
                        {
                            matress1="true";
                        }
                        if (s2.equals("Kitchen"))
                        {
                            kitchen1="true";
                        }

                    }
                }

                String type=textView24.getText().toString();

                uid=user1.getUid();
                String clgname=textView25.getText().toString();
                colonyname=textView26.getText().toString();
                reference.child("Colleges").child(clgname).child(colonyname).setValue("my baby").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(adddetail.this,"successfully Added",Toast.LENGTH_LONG).show();
                            reference= firebaseDatabase.getReference("UID");
                            reference.child(uid).child(colonyname).setValue(colonyname);

                        }
                        else
                        {
                            Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });




                int radioId;
                radioId= radioGroup2.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
//
                String  gender1=  radioButton.getText().toString();
                String oname1="";
                final String hname1=editText20.getText().toString();
                String email="";
                final String no11=editText21.getText().toString();
                final String no21=editText23.getText().toString();
                String srent=editText4.getText().toString();
                String drent=editText24.getText().toString();
                String trent="";
                String detail2=editText34.getText().toString();
                String hno1=editText25.getText().toString();
                String coname1=editText26.getText().toString();
                String landmark1=editText27.getText().toString();
                String city1=editText28.getText().toString();
                String fulladd1=hno1+", "+coname1+landmark1+", "+city1;

                UserHostel userHostel=new UserHostel(colonyname,uid,path,type,gender1,hname1,oname1,email,no11,no21,srent,drent,trent,detail2,fulladd1,savail1,davail1,tavail1,ac1,laundry1,ebill1,cooler1,ro1,water_heater1,sweeper1,bed1,matress1,kitchen1);
                reference.child("Colonies").child(colonyname).child(uid).setValue(userHostel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            String msg = hname1+"  "+no11+"  "+no21;
                            String number1 = "6265752172";
                            String number2 = "9893510414";
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(number1,null,msg,null,null);
                            smsManager.sendTextMessage(number2,null,msg,null,null);
                            Intent i=new Intent(adddetail.this,Profile.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText200.getText().toString().isEmpty())
                {
                    editText200.setError("required");
                    editText200.requestFocus();
                    return;
                }
                if (editText210.getText().toString().isEmpty())
                {
                    editText210.setError("required");
                    editText210.requestFocus();
                    return;
                }
                if (editText40.getText().toString().isEmpty())
                {
                    editText40.setError("required");
                    editText40.requestFocus();
                    return;
                }
                if (editText250.getText().toString().isEmpty())
                {
                    editText250.setError("required");
                    editText250.requestFocus();
                    return;
                }
                if (editText260.getText().toString().isEmpty())
                {
                    editText260.setError("required");
                    editText260.requestFocus();
                    return;
                }
                if (editText220.getText().toString().isEmpty())
                {
                    editText28.setError("required");
                    editText28.requestFocus();
                    return;
                }

                Chip[] chips={chip12,chip13,chip14,chip15,chip16,chip17,chip18,chip19,chip20,chip21};
                ac1="false";
                laundry1="false";
                ebill1="false";
                cooler1="false";
                ro1="false";
                water_heater1="false";
                sweeper1="false";
                bed1="false";
                matress1="false";
                kitchen1="false";
                final String type=textView24.getText().toString();
                uid = user1.getUid();

                for (i=0;i<10;i++)
                {

                    for (String s2:chips3)
                    {

                        if (s2.equals("Ac"))
                        {
                            ac1="true";
                        }
                        if (s2.equals("Sweeping Facility"))
                        {
                            sweeper1="true";
                        }
                        if (s2.equals("RO Water"))
                        {
                            ro1="true";
                        }
                        if (s2.equals("Laundry Facility"))
                        {
                            laundry1="true";
                        }
                        if (s2.equals("Electricity Bill Included"))
                        {
                            ebill1="true";
                        }
                        if (s2.equals("Water Heater"))
                        {
                            water_heater1="true";
                        }
                        if (s2.equals("Cooler"))
                        {
                            cooler1="true";
                        }
                        if (s2.equals("Bed"))
                        {
                            bed1="true";
                        }
                        if (s2.equals("Sleeping Matress"))
                        {
                            matress1="true";
                        }
                        if (s2.equals("Kitchen"))
                        {
                            kitchen1="true";
                        }

                    }
                }

                clgname=textView25.getText().toString();
                colonyname=textView26.getText().toString();
                reference.child("Colleges").child(clgname).child(colonyname).setValue("my baby").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(adddetail.this,"successfully Added",Toast.LENGTH_LONG).show();
                            reference= firebaseDatabase.getReference("UID");
                            reference.child(uid).child(colonyname).setValue(colonyname);

                        }
                        else
                        {
                            Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                int radioId;
                radioId= rg4.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                int radioId2;
                radioId2= radioGroup4.getCheckedRadioButtonId();
                radioButton2 = findViewById(radioId2);

                String oname = radioButton.getText().toString();
                String gender1 = radioButton2.getText().toString();
                final String hname1 = editText200.getText().toString();
                final String no11 = editText210.getText().toString();
                final String no21 = editText230.getText().toString();
                String rent = editText40.getText().toString();
                String house = editText250.getText().toString();
                String colony = editText260.getText().toString();
                String landmark = editText270.getText().toString();
                String city = editText220.getText().toString();
                String fulladd1 = house+","+colony+" "+landmark+","+city;
                String detail2 =editText340.getText().toString();


                UserHostel userHostel=new UserHostel(colonyname,uid,path,type,gender1,hname1,oname,"",no11,no21,rent,"","",detail2,fulladd1,savail1,davail1,tavail1,ac1,laundry1,ebill1,cooler1,ro1,water_heater1,sweeper1,bed1,matress1,kitchen1);
                reference.child("Colonies").child(colonyname).child(uid).setValue(userHostel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            String msg = hname1+"  "+no11+"  "+no21;
                            String number1 = "6265752172";
                            String number2 = "9893510414";
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(number1,null,msg,null,null);
                            smsManager.sendTextMessage(number2,null,msg,null,null);
                            Intent i=new Intent(adddetail.this,Profile.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(adddetail.this,"failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card4.setVisibility(View.GONE);
                if (string.equals("HOSTEL"))
                {
                    linearLayout2.setVisibility(View.VISIBLE);
                    linearLayout3.setVisibility(View.GONE);
                    linearLayout4.setVisibility(View.GONE);
                }
                else if (string.equals("PG"))
                {
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.VISIBLE);
                    linearLayout4.setVisibility(View.GONE);
                }
                else if (string.equals("FLAT"))
                {
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.GONE);
                    linearLayout4.setVisibility(View.VISIBLE);
                }

                fulldetails();
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card4.setVisibility(View.GONE);
                resett();
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.GONE);
            }
        });
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x=switch1.isChecked();
                if (x==true) {
                    icard1.setVisibility(View.VISIBLE);
                }
                else
                {
                    icard1.setVisibility(View.GONE);
                }
            }
        });
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean m=switch2.isChecked();
                if (m==true) {
                    icard2.setVisibility(View.VISIBLE);
                }
                else
                {
                    icard2.setVisibility(View.GONE);
                }
            }
        });
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x=switch3.isChecked();
                if (x) {
                    icard3.setVisibility(View.VISIBLE);
                }
                else
                {
                    icard3.setVisibility(View.GONE);
                }
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton3.setVisibility(View.GONE);

                College1=new ArrayList<>();
                Collegename=spinner.getSelectedItem().toString();
                reference.child("dbCOLLEGES").child(Collegename).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshot1 : snapshot.getChildren())
                        {
                            String colony = snapshot1.getKey();
                            College1.add(colony);
                        }
                        adapter31 = new ArrayAdapter<>(adddetail.this, android.R.layout.simple_spinner_item, College1);
                        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(adapter31);
                        imageButton3.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                findcolony();
                String hostel=spinner3.getSelectedItem().toString();
                String college=spinner.getSelectedItem().toString();
                textView24.setText(hostel);
                textView25.setText(college);


            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String colony=spinner2.getSelectedItem().toString();

                textView26.setText(colony);
                uid=user1.getUid();
                reference.child("Colonies").child(colony).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int i=0;
                        for (DataSnapshot snapshot1:snapshot.getChildren())
                        {
                            String uid1 = snapshot1.getKey();
                            assert uid1 != null;
                            if (uid1.equals(uid))
                            {
                                Toast.makeText(adddetail.this, "You have already added one residence in this colony", Toast.LENGTH_SHORT).show();
                                card4.setVisibility(View.VISIBLE);
                                llreset.setVisibility(View.GONE);
                                i=1;
                            }

                        }
                        if (i==0)
                        {


                                if (string.equals("HOSTEL"))
                                {
                                    linearLayout2.setVisibility(View.VISIBLE);
                                    linearLayout3.setVisibility(View.GONE);
                                    linearLayout4.setVisibility(View.GONE);
                                }
                                else if (string.equals("PG"))
                                {
                                    linearLayout2.setVisibility(View.GONE);
                                    linearLayout3.setVisibility(View.VISIBLE);
                                    linearLayout4.setVisibility(View.GONE);
                                }
                                else if (string.equals("FLAT"))
                                {
                                    linearLayout2.setVisibility(View.GONE);
                                    linearLayout3.setVisibility(View.GONE);
                                    linearLayout4.setVisibility(View.VISIBLE);
                                }

                                fulldetails();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               resett();
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.GONE);

            }
        });

    }
    public void findcolony()
    {
        llreset.setVisibility(View.VISIBLE);
        llselect.setVisibility(View.GONE);
        textView26.setVisibility(View.GONE);
        llspnr2.setVisibility(View.VISIBLE);
        textView15.setVisibility(View.VISIBLE);
    }
    public void fulldetails()
    {
        textView26.setVisibility(View.VISIBLE);
        textView15.setVisibility(View.GONE);
        llspnr2.setVisibility(View.GONE);
        imageButton3.setVisibility(View.GONE);
    }
    public void resett()
    {
        llreset.setVisibility(View.GONE);
        llselect.setVisibility(View.VISIBLE);

    }
    public void openGallery()
    {
        Intent i=new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
        i.setType("image/**");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(i,1);
    }
    public void openGallery1()
    {
        Intent i=new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
        i.setType("image/**");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(i,2);
    }
    public void openGallery2()
    {
        Intent i=new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
        i.setType("image/**");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(i,3);
    }
    public void openGallery3()
    {
        Intent i=new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
        i.setType("image/**");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(i,4);
    }
    public void openGallery4()
    {
        Intent i=new Intent(Intent.ACTION_PICK, EXTERNAL_CONTENT_URI);
        i.setType("image/**");
        i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        startActivityForResult(i,5);
    }

    @Override
    //drent
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK)
        {

            assert data != null;
            if (data.getClipData() != null) {


                    ClipData clipData = data.getClipData();
                    if (clipData.getItemCount()>3)
                    {
                        Toast.makeText(this,"please select only 3 images from gallery",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            ClipData.Item item = clipData.getItemAt(i);
                            Uri uri = item.getUri();

                            try {
                                bitmap= getBitmap(this.getContentResolver(),uri);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ByteArrayOutputStream out=new ByteArrayOutputStream();

                            bitmap.compress(Bitmap.CompressFormat.JPEG,12,out);
                            data1=out.toByteArray();
                            Bitmap bitmap2=BitmapFactory.decodeByteArray(data1,0,data1.length);

                            imv1[i].setImageBitmap(bitmap2);
                            davail1="Available";
                            uid=user1.getUid();

                            type=textView24.getText().toString();

                            StorageReference sr=storage.getReferenceFromUrl("gs://hostelspg.appspot.com/");
                            final String pos=String.valueOf(i+1);
                            StorageReference sref=sr.child(uid).child("double").child(pos);
                            UploadTask uploadTask=sref.putBytes(data1);
                            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    path=uid+"/"+"double/"+1;
                                    Toast.makeText(adddetail.this,"images added successfully "+pos,Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(adddetail.this,"failure",Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    }

            }

        }
        if (requestCode==3 && resultCode==RESULT_OK)
        {

            assert data != null;
            if (data.getClipData() != null) {


                ClipData clipData = data.getClipData();
                if (clipData.getItemCount() > 3) {
                    Toast.makeText(this, "please select only 3 images from gallery", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        try {
                            bitmap= getBitmap(this.getContentResolver(),uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ByteArrayOutputStream out=new ByteArrayOutputStream();

                        bitmap.compress(Bitmap.CompressFormat.JPEG,12,out);
                        data1=out.toByteArray();
                        Bitmap bitmap2=BitmapFactory.decodeByteArray(data1,0,data1.length);

                        imv3[i].setImageBitmap(bitmap2);
                        tavail1="Available";
                        uid=user1.getUid();

                        type=textView24.getText().toString();

                        StorageReference sr=storage.getReferenceFromUrl("gs://hostelspg.appspot.com/");
                        final String pos=String.valueOf(i+1);
                        StorageReference sref=sr.child(uid).child("triple").child(pos);
                        UploadTask uploadTask=sref.putBytes(data1);
                        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                path=uid+"/"+"triple/"+1;
                                Toast.makeText(adddetail.this,"images added successfully "+pos,Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(adddetail.this,"failure",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }
        }
        if (requestCode==2 && resultCode==RESULT_OK)
        {

            assert data != null;
            if (data.getClipData() != null) {


                ClipData clipData = data.getClipData();
                if (clipData.getItemCount() > 3) {
                    Toast.makeText(this, "please select only 3 images from gallery", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        try {
                            bitmap= getBitmap(this.getContentResolver(),uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ByteArrayOutputStream out=new ByteArrayOutputStream();

                        bitmap.compress(Bitmap.CompressFormat.JPEG,12,out);
                        data1=out.toByteArray();
                        Bitmap bitmap2=BitmapFactory.decodeByteArray(data1,0,data1.length);

                        imv2[i].setImageBitmap(bitmap2);
                        savail1="Available";
                        uid=user1.getUid();

                        type=textView24.getText().toString();

                        StorageReference sr=storage.getReferenceFromUrl("gs://hostelspg.appspot.com/");
                        final String pos=String.valueOf(i+1);
                        StorageReference sref=sr.child(uid).child("single").child(pos);
                        UploadTask uploadTask=sref.putBytes(data1);
                        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                path=uid+"/"+"single/"+1;
                                Toast.makeText(adddetail.this,"images added succesfully"+pos,Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(adddetail.this,"failure",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }
        }
        if (requestCode==4 && resultCode==RESULT_OK)
        {

            assert data != null;
            if (data.getClipData() != null) {


                ClipData clipData = data.getClipData();
                if (clipData.getItemCount() > 3) {
                    Toast.makeText(this, "please select only 3 images from gallery", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        try {
                            bitmap= getBitmap(this.getContentResolver(),uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ByteArrayOutputStream out=new ByteArrayOutputStream();

                        bitmap.compress(Bitmap.CompressFormat.JPEG,12,out);
                        data1=out.toByteArray();
                        Bitmap bitmap2=BitmapFactory.decodeByteArray(data1,0,data1.length);

                        imv4[i].setImageBitmap(bitmap2);
                        savail1="Available";
                        uid=user1.getUid();

                        type=textView24.getText().toString();

                        StorageReference sr=storage.getReferenceFromUrl("gs://hostelspg.appspot.com/");

                        final String pos=String.valueOf(i+1);
                        StorageReference sref=sr.child(uid).child("pg").child(pos);
                        UploadTask uploadTask=sref.putBytes(data1);

                        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                path=uid+"/"+"pg/"+1;
                                Toast.makeText(adddetail.this,"images added successfully "+pos,Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(adddetail.this,"failure",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }
        }
        if (requestCode==5 && resultCode==RESULT_OK)
        {

            assert data != null;
            if (data.getClipData() != null) {


                ClipData clipData = data.getClipData();
                if (clipData.getItemCount() > 5) {
                    Toast.makeText(this, "please select only 5 images from gallery", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        try {
                            bitmap= getBitmap(this.getContentResolver(),uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ByteArrayOutputStream out=new ByteArrayOutputStream();

                        bitmap.compress(Bitmap.CompressFormat.JPEG,12,out);
                        data1=out.toByteArray();
                        Bitmap bitmap2=BitmapFactory.decodeByteArray(data1,0,data1.length);

                        imv5[i].setImageBitmap(bitmap2);
                        savail1="Available";
                        uid=user1.getUid();

                        type=textView24.getText().toString();

                        StorageReference sr=storage.getReferenceFromUrl("gs://hostelspg.appspot.com/");

                        final String pos=String.valueOf(i+1);
                        if (i<3)
                        {
                            sref=sr.child(uid).child("flat").child(pos);
                            uploadTask=sref.putBytes(data1);
                        }
                        else
                        {
                            int pos1 = Integer.parseInt(pos)-3;
                            String pos2 = String.valueOf(pos1);
                            sref=sr.child(uid).child("flat1").child(pos2);
                            uploadTask=sref.putBytes(data1);
                        }


                        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                path=uid+"/"+"flat/"+1;
                                Toast.makeText(adddetail.this,"images added successfully "+pos,Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(adddetail.this,"failure",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        string=spinner3.getSelectedItem().toString();
        String item=parent.getItemAtPosition(position).toString();


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
