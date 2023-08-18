package abc.get.hostels_pg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class showdetail extends AppCompatActivity {
LinearLayout linearLayout4,linearLayout5,linearLayout6,llhs,llhd,llht,llhpg,llhflat;
TextView textView1,textView2,textView3,textView4,textView5,textView9,textView12,textView19,textView14,textView17,
        textView22,textView24,textView25,textView26,textView27,textView28,textView29,
        textView32,textView35,textView37,textView38,
        textView260,textView270,textView280,textView290,
        textView320,textView350,textView370,textView380,textView105,textView109,textView110;
ImageView imageView11,imageView12,imageView13,imageView21,imageView22,imageView23,
          imageView31,imageView32,imageView33,imageView41,imageView42,imageView43,
        imageView410,imageView420,imageView430,imageView431,imageView432;
ImageView imageView27,imageView28,imageView29,imageView30,imageView35,imageView36,imageView37,imageView38,imageView39,
            imageView50,imageView51,imageView52,imageView53,imageView54,imageView55,imageView56,imageView57,imageView58,imageView59,
        imageView500,imageView510,imageView520,imageView530,imageView540,imageView550,imageView560,imageView570,imageView580,imageView590;
DatabaseReference reference;
ImageButton imageButton9,imageButton10,imageButton12,imageButton13,imageButton14,imageButton15,imageButton16,imageButton17;
String ac,sweeper,ro,water_heater,laundry,ebill,cooler,bed,matress,kitchen,wifi,gym;

int i;
ImageView[] iv1;

ImageView[] iv2;
ImageView[] iv3;
ImageView[] iv4;
ImageView[] iv5;
String uid,colony,srent,drent,trent,fulladd,savail,no1,no2,davail,tavail;
AdView mAdView;


LinearLayout hsv1,hsv2,hsv3;
Button button10,button3,button11;
ProgressBar progressBar6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);

        linearLayout5=findViewById(R.id.linearLayout5);
        linearLayout4=findViewById(R.id.linearLayout4);
        linearLayout6=findViewById(R.id.linearLayout6);
        llhs=findViewById(R.id.llhs);
        llhd=findViewById(R.id.llhd);
        llht=findViewById(R.id.llht);
        llhpg=findViewById(R.id.llpg);
        llhflat=findViewById(R.id.llflat);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView9 = findViewById(R.id.textView9);
        textView14 = findViewById(R.id.textView14);
        textView19 = findViewById(R.id.textView19);
        textView12 = findViewById(R.id.textView12);
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
        textView105 = findViewById(R.id.textView105);
        textView109 = findViewById(R.id.textView109);
        textView110 = findViewById(R.id.textView110);
        textView260 = findViewById(R.id.textView260);
        textView270 = findViewById(R.id.textView270);
        textView280 = findViewById(R.id.textView280);
        textView290 = findViewById(R.id.textView290);
        textView320 = findViewById(R.id.textView320);
        textView350 = findViewById(R.id.textView350);
        textView370 = findViewById(R.id.textView370);
        textView380 = findViewById(R.id.textView380);

        imageButton9=findViewById(R.id.imageButton9);
        imageButton10=findViewById(R.id.imageButton10);
        imageButton12=findViewById(R.id.imageButton12);
        imageButton13=findViewById(R.id.imageButton13);
        imageButton14=findViewById(R.id.imageButton14);
        imageButton15=findViewById(R.id.imageButton15);
        imageButton16=findViewById(R.id.imageButton16);
        imageButton17=findViewById(R.id.imageButton17);

        progressBar6=findViewById(R.id.progressBar6);

        button10=findViewById(R.id.button10);
        button3=findViewById(R.id.button3);
        button11=findViewById(R.id.button11);

        hsv1=findViewById(R.id.hsv1);
        hsv2=findViewById(R.id.hsv2);
        hsv3=findViewById(R.id.hsv3);

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

        imageView27 = findViewById(R.id.imageView27);
        imageView28 = findViewById(R.id.imageView28);
        imageView29 = findViewById(R.id.imageView29);
        imageView30 = findViewById(R.id.imageView30);
        imageView35 = findViewById(R.id.imageView35);
        imageView36 = findViewById(R.id.imageView36);
        imageView37 = findViewById(R.id.imageView37);
        imageView38 = findViewById(R.id.imageView38);
        imageView39 = findViewById(R.id.imageView39);
        imageView410 = findViewById(R.id.imageView410);
        imageView420 = findViewById(R.id.imageView420);
        imageView430 = findViewById(R.id.imageView430);
        imageView431 = findViewById(R.id.imageView431);
        imageView432 = findViewById(R.id.imageView432);


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
        iv5[3]=imageView431;
        iv5[4]=imageView432;

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent intent =getIntent();
        String type = intent.getStringExtra("type");
        uid = intent.getStringExtra("uid");
        colony=getIntent().getExtras().getString("colony");
        Toast.makeText(this,"welcome to"+type,Toast.LENGTH_LONG).show();
        reference = FirebaseDatabase.getInstance().getReference("Colonies");
        reference.child(colony).child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHostel userHostel = snapshot.getValue(UserHostel.class);
                textView1.setText(userHostel.gender+" Hostel");
                textView2.setText(userHostel.hname);
                textView3.setText(userHostel.oname);
                textView4.setText(userHostel.no1);
                textView5.setText(userHostel.no2);
                textView9.setText(userHostel.savail);

                savail = userHostel.savail;
                davail = userHostel.davail;
                tavail = userHostel.tavail;

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

                    hsv1.setVisibility(View.GONE);

                }
                textView14.setText(userHostel.davail);
                String sa2=userHostel.davail;
                if (sa2.equals("Available"))
                {
                    textView14.setTextColor(Color.parseColor("#00ff00"));
                }
                if (sa2.equals("Not Added"))
                {

                    hsv2.setVisibility(View.GONE);

                }
                if (sa2.equals("Not Available"))
                {
                    textView14.setTextColor(Color.parseColor("#ff0000"));

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

                    hsv3.setVisibility(View.GONE);
                }
                setHostel();
                setPG();
                setFlat();

                no1=userHostel.no1;
                no2=userHostel.no2;
                srent = userHostel.srent;
                drent = userHostel.drent;
                trent = userHostel.trent;
                fulladd = userHostel.fulladd;
                textView12.setText(userHostel.srent);
                textView17.setText(userHostel.drent);
                textView22.setText(userHostel.trent);
                textView25.setText(userHostel.fulladd);

                textView26.setText(userHostel.gender+" PG");
                textView27.setText(userHostel.hname);
                textView28.setText(userHostel.no1);
                textView29.setText(userHostel.no2);
                textView32.setText(userHostel.srent);
                textView35.setText(userHostel.drent);
                textView109.setText(userHostel.detail);
                textView38.setText(userHostel.fulladd);
                progressBar6.setVisibility(View.GONE);

                textView260.setText(userHostel.gender+" Flat");
                textView105.setText(userHostel.getOname());
                textView270.setText(userHostel.hname);
                textView280.setText(userHostel.no1);
                textView290.setText(userHostel.no2);
                textView320.setText(userHostel.srent);
                textView110.setText(userHostel.detail);
                textView380.setText(userHostel.fulladd);

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
                                    llhs.setVisibility(View.GONE);

                                }
                                if (t.equals("double/"))
                                {
                                    iv2[0].setImageBitmap(bitmap);
                                    llhd.setVisibility(View.GONE);

                                }
                                if (t.equals("triple/"))
                                {
                                    iv3[0].setImageBitmap(bitmap);
                                    llht.setVisibility(View.GONE);

                                }
                                if (t.equals("pg/"))
                                {
                                    iv4[0].setImageBitmap(bitmap);
                                    llhpg.setVisibility(View.GONE);
                                }
                                if (t.equals("flat/"))
                                {
                                    iv5[0].setImageBitmap(bitmap);
                                    llhflat.setVisibility(View.GONE);
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
                            iv1[1].setImageBitmap(bitmap);
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
                            iv1[2].setImageBitmap(bitmap);
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
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView25.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+t));
                startActivity(i);


            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView38.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+t));
                startActivity(i);


            }
        });
        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView290.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });
        imageButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView280.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });
        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView29.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });
        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView28.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });
        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView5.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });
        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView4.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                startActivity(i);
            }
        });

        if (type.equals("HOSTEL"))
        {
            linearLayout5.setVisibility(View.GONE);
            linearLayout4.setVisibility(View.VISIBLE);
            linearLayout6.setVisibility(View.GONE);
//            setHostel();

        }
        if (type.equals("PG"))
        {
            linearLayout5.setVisibility(View.VISIBLE);
            linearLayout4.setVisibility(View.GONE);
            linearLayout6.setVisibility(View.GONE);
            //setPG();
        }
        if (type.equals("FLAT"))
        {
            linearLayout5.setVisibility(View.GONE);
            linearLayout4.setVisibility(View.GONE);
            linearLayout6.setVisibility(View.VISIBLE);
            //setFlat();
        }
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showdetail.this, book.class);
                String type=textView1.getText().toString();
                String hname=textView2.getText().toString();
                i.putExtra("type",type);
                i.putExtra("hname",hname);
                i.putExtra("srent",srent);
                i.putExtra("drent",drent);
                i.putExtra("trent",trent);
                i.putExtra("fulladd",fulladd);
                i.putExtra("ouid",uid);
                i.putExtra("no1",no1);
                i.putExtra("no2",no2);
                i.putExtra("savail",savail);
                i.putExtra("davail",davail);
                i.putExtra("tavail",tavail);
                startActivity(i);
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showdetail.this, book.class);
                String type=textView26.getText().toString();
                String hname=textView27.getText().toString();
                i.putExtra("type",type);
                i.putExtra("hname",hname);
                i.putExtra("srent",srent);
                i.putExtra("drent",drent);
                i.putExtra("no1",no1);
                i.putExtra("no2",no2);
                i.putExtra("trent",trent);
                i.putExtra("fulladd",fulladd);
                i.putExtra("ouid",uid);
                i.putExtra("savail",savail);
                i.putExtra("davail",davail);
                i.putExtra("tavail",tavail);
                startActivity(i);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(showdetail.this, book.class);
                String type1=textView260.getText().toString();
                String type2 = textView105.getText().toString();
                String type  = type1+" ("+type2+")";
                String hname=textView270.getText().toString();
                i.putExtra("type",type);
                i.putExtra("hname",hname);
                i.putExtra("no1",no1);
                i.putExtra("no2",no2);
                i.putExtra("srent",srent);
                i.putExtra("drent",drent);
                i.putExtra("trent",trent);
                i.putExtra("fulladd",fulladd);
                i.putExtra("ouid",uid);
                i.putExtra("savail",savail);
                i.putExtra("davail",davail);
                i.putExtra("tavail",tavail);
                startActivity(i);
            }
        });

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
        if (ac.equals("false")){
            imageView500.setImageAlpha(60);
        }
        if (sweeper.equals("false")){
            imageView510.setImageAlpha(60);
        }
        if (ro.equals("false")){
            imageView520.setImageAlpha(60);
        }
        if (laundry.equals("false")){
            imageView530.setImageAlpha(60);
        }
        if (ebill.equals("false")){
            imageView540.setImageAlpha(60);
        }
        if (water_heater.equals("false")){
            imageView550.setImageAlpha(60);
        }
        if (cooler.equals("false")){
            imageView560.setImageAlpha(60);
        }
        if (bed.equals("false")){
            imageView570.setImageAlpha(60);
        }
        if (matress.equals("false")){
            imageView580.setImageAlpha(60);
        }
        if (kitchen.equals("false")){
            imageView590.setImageAlpha(60);
        }
    }

}
