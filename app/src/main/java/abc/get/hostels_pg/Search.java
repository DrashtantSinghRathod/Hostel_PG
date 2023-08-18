package abc.get.hostels_pg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ChipGroup cg1, cg2;
    Chip chip1, chip2, chip3, chip4,chip22,chip23;


    AdView mAdView;
    Spinner spinner5;
    Button button,button5;
    LinearLayout ll;
    ProgressBar progressBar3,progressBar4;
    String[] colonyarr;
    String[] uidarr;

    DatabaseReference reference,reference2,reference3;
    ArrayList<UserHostel> words = new ArrayList<>();
    ArrayList<String> college = new ArrayList<>();
    ArrayList<String> colony = new ArrayList<>();
    ArrayList<String> selected=new ArrayList<>();
    ArrayList<String> selected3=new ArrayList<>();
    ArrayList<String> selected4=new ArrayList<>();
    ArrayList<DataSnapshot> snapshots = new ArrayList<>();

    ArrayList<String> selected2=new ArrayList<>();
    ListView list1;
    String type,c,f,a,b;
    WorAdapter adapter1;

    UserHostel userHostel;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cg1 = findViewById(R.id.cg1);
        cg2 = findViewById(R.id.cg2);
        chip1 = findViewById(R.id.chip1);
        chip2 = findViewById(R.id.chip2);
        chip3 = findViewById(R.id.chip3);
        chip4 = findViewById(R.id.chip4);
        chip22=findViewById(R.id.chip22);
        chip23=findViewById(R.id.chip23);

        selected3.add("HOSTEL");
        selected3.add("PG");
        selected3.add("FLAT");
        selected4.add("Boys");
        selected4.add("Girls");
        selected4.add("For Family");

        spinner5 = findViewById(R.id.spinner5);

        progressBar3=findViewById(R.id.progressBar3);
        progressBar4=findViewById(R.id.progressBar4);
        progressBar4.setVisibility(View.GONE);

        button=findViewById(R.id.button);
        button5 = findViewById(R.id.button5);
        button5.setVisibility(View.GONE);
        button.setVisibility(View.GONE);

        ll = findViewById(R.id.ll);
        ll.setVisibility(View.GONE);
        list1=findViewById(R.id.list1);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        CompoundButton.OnCheckedChangeListener checkedChangeListener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    selected.add(buttonView.getText().toString());
                }
                else
                {
                    selected.remove(buttonView.getText().toString());
                }
            }
        };
        chip1.setOnCheckedChangeListener(checkedChangeListener);
        chip2.setOnCheckedChangeListener(checkedChangeListener);
        chip22.setOnCheckedChangeListener(checkedChangeListener);
        CompoundButton.OnCheckedChangeListener checkedChangeListener2=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    selected2.add(buttonView.getText().toString());
                }
                else
                {
                    selected2.remove(buttonView.getText().toString());
                }
            }
        };
        chip3.setOnCheckedChangeListener(checkedChangeListener2);
        chip4.setOnCheckedChangeListener(checkedChangeListener2);
        chip23.setOnCheckedChangeListener(checkedChangeListener2);

        list1.setOnItemClickListener(this);

        reference = fd.getReference("Colleges");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    String college_name = snapshot1.getKey();
                    college.add(college_name);
                }
                ArrayAdapter <String> adapter = new ArrayAdapter<>(Search.this,android.R.layout.simple_spinner_item,college);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner5.setAdapter(adapter);
                ll.setVisibility(View.VISIBLE);
                progressBar3.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ll.setVisibility(View.GONE);
                  progressBar4.setVisibility(View.VISIBLE);
                  button5.setVisibility(View.VISIBLE);
                  String selected_college = (String) spinner5.getSelectedItem();
                  reference = fd.getReference("Colleges");
                  reference.child(selected_college).addValueEventListener(new ValueEventListener() {
                      @Override
                      public void onDataChange(@NonNull DataSnapshot snapshot) {
                          for (DataSnapshot snapshot1:snapshot.getChildren())
                          {
                              final String colony_name = snapshot1.getKey();
//                              colony.add(colony_name);

                              reference2 = fd.getReference("Colonies");

                              assert colony_name != null;
                              reference2.child(colony_name).addValueEventListener(new ValueEventListener() {
                                  @Override
                                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                                      for (DataSnapshot snapshot1:snapshot.getChildren()) {
                                          String uid = snapshot1.getKey();
//
                                          assert uid != null;
                                          reference2.child(colony_name).child(uid).addValueEventListener(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                  UserHostel w;
                                                  w = snapshot.getValue(UserHostel.class);
                                                  assert w != null;
                                                  String savail = w.savail;
                                                  String davail = w.davail;
                                                  String tavail = w.tavail;
                                                  String type = w.type;

                                                  if (selected.isEmpty() && selected2.isEmpty()) {
                                                      words.add(w);
                                                      if (type.equals("PG")||type.equals("FLAT"))
                                                      {
                                                          if (savail.equals("Not Added")||savail.equals("NotAvailable"))
                                                          {
                                                              words.remove(w);
                                                          }
                                                      }
                                                  }
                                                  if (selected.isEmpty())
                                                  {
                                                      for (String a : selected3) {
                                                          if (a.equals(w.getType())) {
                                                              Toast.makeText(Search.this, w.getType(), Toast.LENGTH_SHORT).show();
                                                              for (String b : selected2) {
                                                                  if (b.equals(w.getGender())) {
                                                                      words.add(w);
                                                                      if (type.equals("PG")||type.equals("FLAT"))
                                                                      {
                                                                          if (savail.equals("Not Added")||savail.equals("NotAvailable"))
                                                                          {
                                                                              words.remove(w);
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                          }
                                                      }
                                                  }
                                                  if (selected2.isEmpty())
                                                  {
                                                      for (String a : selected) {
                                                          if (a.equals(w.getType())) {
                                                              Toast.makeText(Search.this, w.getType(), Toast.LENGTH_SHORT).show();
                                                              for (String b : selected4) {
                                                                  if (b.equals(w.getGender())) {
                                                                      words.add(w);
                                                                      if (type.equals("PG")||type.equals("FLAT"))
                                                                      {
                                                                          if (savail.equals("Not Added")||savail.equals("NotAvailable"))
                                                                          {
                                                                              words.remove(w);
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                          }
                                                      }
                                                  }
                                                      else {
                                                      for (String a : selected) {
                                                          if (a.equals(w.getType())) {
                                                              Toast.makeText(Search.this, w.getType(), Toast.LENGTH_SHORT).show();
                                                              for (String b : selected2) {
                                                                  if (b.equals(w.getGender())) {
                                                                      words.add(w);
                                                                      if (type.equals("PG")||type.equals("FLAT"))
                                                                      {
                                                                          if (savail.equals("Not Added")||savail.equals("NotAvailable"))
                                                                          {
                                                                              words.remove(w);
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                          }
                                                      }
                                                  }
                                                  progressBar4.setVisibility(View.GONE);
                                                  adapter1 = new WorAdapter(Search.this, words);
                                                  list1.setAdapter(adapter1);

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
                      }
                      @Override
                      public void onCancelled(@NonNull DatabaseError error) {

                      }
                  });
//                  for (String cn:colony)
//                  {
//                      for (String uid:selected3)
//                      {
//                          DataSnapshot snapshot = reference2.child(cn).child(uid)
//                      }
//                  }
                  list1.setVisibility(View.VISIBLE);


              }
          });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setVisibility(View.VISIBLE);
                words.clear();
                button5.setVisibility(View.GONE);
                colony.clear();
                Toast.makeText(Search.this,selected.toString()+selected2.toString(),Toast.LENGTH_LONG).show();

            }
        });
    }



    private void layoutAnimation(ListView listView)
    {
        Context context=listView.getContext();
        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(context,R.anim.anim);
        listView.setLayoutAnimation(layoutAnimationController);
        listView.getAdapter().notify();
        listView.scheduleLayoutAnimation();


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        userHostel = words.get(position);
        type = userHostel.getType();
        String uid=userHostel.getUid();
        String colony=userHostel.getColony();
        //Toast.makeText(this,type,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Search.this,showdetail.class);
        intent.putExtra("type",type);
        intent.putExtra("colony",colony);
        intent.putExtra("uid",uid);
        startActivity(intent);
    }
    }

