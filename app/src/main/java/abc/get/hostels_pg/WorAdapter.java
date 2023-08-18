package abc.get.hostels_pg;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WorAdapter extends ArrayAdapter<UserHostel>{
    private String y="a";
    private int i=1;
    private DatabaseReference reference;
    private FirebaseDatabase fd = FirebaseDatabase.getInstance();
    FirebaseUser user1=FirebaseAuth.getInstance().getCurrentUser();


    private  static final String LOG_TAG=WorAdapter.class.getSimpleName();


    public WorAdapter(Activity context, ArrayList<UserHostel> words) {
        super(context,0,words);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        if (v==null)
        {
            v=LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        final UserHostel user =getItem(position);
        TextView textView22,textView23,textView27,textView21,textView39,textView126,textView128,textView130,textView132,
                    textView134,textView136,textView138;
        CardView cardView;

        reference = fd.getReference("Saved");

        final  ImageView imageView7,imageView20;
         ImageView imageView9,imageView14,imageView19,imageView18,imageView15,imageView16,imageView17,imageView8,imageView10;
         LinearLayout lh,lp,lf,lhs,lhd,lht,lp1,lp2,lf1,lf2,lf3;
        cardView=v.findViewById(R.id.card);

        textView22=v.findViewById(R.id.textView22);

        lh = v.findViewById(R.id.lh);
        lp = v.findViewById(R.id.lp);
        lf = v.findViewById(R.id.lf);
        lhs = v.findViewById(R.id.lhs);
        lhd = v.findViewById(R.id.lhd);
        lht = v.findViewById(R.id.lht);
        lp1 = v.findViewById(R.id.lp1);
        lp2 = v.findViewById(R.id.lp2);
        lf1 = v.findViewById(R.id.lf1);
        lf2 = v.findViewById(R.id.lf2);
        lf3 = v.findViewById(R.id.lf3);

        textView39 = v.findViewById(R.id.textView39);
        textView126 = v.findViewById(R.id.textView126);
        textView128 = v.findViewById(R.id.textView128);
        textView130 = v.findViewById(R.id.textView130);
        textView132 = v.findViewById(R.id.textView132);
        textView134 = v.findViewById(R.id.textView134);
        textView136 = v.findViewById(R.id.textView136);
        textView138 = v.findViewById(R.id.textView138);

        imageView9=v.findViewById(R.id.imageView9);
        imageView14=v.findViewById(R.id.imageView14);
        imageView20=v.findViewById(R.id.imageView20);
        imageView20.setTag("save");
        imageView19=v.findViewById(R.id.imageView19);
        imageView18=v.findViewById(R.id.imageView18);
        imageView15=v.findViewById(R.id.imageView15);
        imageView16=v.findViewById(R.id.imageView16);
        imageView7=v.findViewById(R.id.imageView7);
        imageView17=v.findViewById(R.id.imageView17);
        imageView8=v.findViewById(R.id.imageView8);
        imageView10=v.findViewById(R.id.imageView10);
        assert user != null;
        String ac = user.getAc();
        String laundry = user.getLaundry();
        String ebill = user.getEbill();
        String cooler =user.getCooler();
        String ro = user.getRo();
        String water_heater = user.getWater_heater();
        String sweeper = user.getSweeper();
        String bed = user.getBed();
        String matress = user.getMatress();
        String kitchen = user.getKitchen();

        textView22.setText(user.getHname());
        textView21=v.findViewById(R.id.textView21);
        if (user.getType().equals("PG"))
        {
            textView21.setTextColor(Color.parseColor("#061FFD"));
        }
        if (user.getType().equals("FLAT"))
        {
            textView21.setTextColor(Color.parseColor("#00aa00"));
        }
        if (user.getType().equals("HOSTEL"))
        {
            textView21.setTextColor(Color.parseColor("#FD2B06"));
            imageView16.setVisibility(View.GONE);
            imageView7.setVisibility(View.GONE);
            imageView18.setVisibility(View.GONE);
        }
        if (ac.equals("false"))
        {
            imageView9.setImageAlpha(50);
        }
        if (sweeper.equals("false"))
        {
            imageView17.setImageAlpha(50);
        }
        if (ro.equals("false"))
        {
            imageView15.setImageAlpha(50);
        }
        if (water_heater.equals("false"))
        {
            imageView10.setImageAlpha(50);
        }
        if (laundry.equals("false"))
        {
            imageView14.setImageAlpha(50);
        }
        if (ebill.equals("false"))
        {
            imageView19.setImageAlpha(50);
        }
        if (cooler.equals("false"))
        {
            imageView8.setImageAlpha(50);
        }
        if (bed.equals("false"))
        {
            imageView16.setImageAlpha(50);
        }
        if (matress.equals("false"))
        {
            imageView7.setImageAlpha(50);
        }
        if (kitchen.equals("false"))
        {
            imageView18.setImageAlpha(50);
        }

        imageView20.setOnClickListener(new View.OnClickListener() {
            String firebaseUser = user1.getUid();
            @Override
            public void onClick(View v) {
                String tag=String.valueOf(imageView20.getTag());
                if (tag.equals("save")) {
                    imageView20.setImageResource(R.drawable.save);
                    imageView20.setTag("saved");

                    String colony = user.getColony();
                    String uid = user.getUid();
                    String h=user.getHname();
                    Toast.makeText(imageView7.getContext(), ""+h+" is added to saved", Toast.LENGTH_SHORT).show();
                    reference.child(String.valueOf(firebaseUser)).child(String.valueOf(i)).child("colony").setValue(colony);
                    reference.child(String.valueOf(firebaseUser)).child(String.valueOf(i)).child("uid").setValue(uid);
                    i++;
                }

                if (tag.equals("saved"))
                {
                    imageView20.setImageResource(R.drawable.saved);
                    imageView20.setTag("save");

                    reference.child(firebaseUser).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String colony = user.getColony();
                            String uid = user.getUid();
                            String h=user.getHname();
                            Toast.makeText(imageView7.getContext(), ""+h+" is removed from saved", Toast.LENGTH_SHORT).show();
                            for (DataSnapshot snapshot1:snapshot.getChildren())
                            {
                                String colony1 = (String) snapshot1.child("colony").getValue();
                                String uid1 = (String) snapshot1.child("uid").getValue();
                                if (colony.equals(colony1) && uid.equals(uid1))
                                {
                                    String a = snapshot1.getKey();
                                    reference.child(firebaseUser).child(a).removeValue();
                                    System.out.println(snapshot1);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });
        textView21.setText(user.getType());
        textView23=v.findViewById(R.id.textView23);
        String type = user.getType();
        if (type.equals("HOSTEL"))
        {
            lhs.setVisibility(View.GONE);
            lhd.setVisibility(View.GONE);
            lht.setVisibility(View.GONE);
            lp.setVisibility(View.GONE);
            lf.setVisibility(View.GONE);
            if (user.savail.equals("Available"))
            {
                lhs.setVisibility(View.VISIBLE);
                textView39.setText(user.srent);
            }
            if (user.davail.equals("Available"))
            {
                lhd.setVisibility(View.VISIBLE);
                textView126.setText(user.drent);
            }
            if (user.tavail.equals("Available"))
            {
                lht.setVisibility(View.VISIBLE);
                textView128.setText(user.trent);
            }

        }
        if (type.equals("PG"))
        {
            lh.setVisibility(View.GONE);
            lp.setVisibility(View.VISIBLE);
            lf.setVisibility(View.GONE);
            textView130.setText(user.srent);
            textView132.setText(user.drent);
        }
        if (type.equals("FLAT"))
        {
            lh.setVisibility(View.GONE);
            lp.setVisibility(View.GONE);
            lf.setVisibility(View.VISIBLE);
            if (user.oname.equals("1 BHK"))
            {
                lf1.setVisibility(View.VISIBLE);
                lf2.setVisibility(View.GONE);
                lf3.setVisibility(View.GONE);
                textView134.setText(user.srent);
            }
            if (user.oname.equals("2 BHK"))
            {
                lf1.setVisibility(View.GONE);
                lf2.setVisibility(View.VISIBLE);
                lf3.setVisibility(View.GONE);
                textView136.setText(user.srent);
            }
            if (user.oname.equals("3 BHK"))
            {
                lf1.setVisibility(View.GONE);
                lf2.setVisibility(View.GONE);
                lf3.setVisibility(View.VISIBLE);
                textView138.setText(user.srent);
            }
        }
        textView27=v.findViewById(R.id.textView27);
        textView27.setText(user.getFulladd());

        return v;
    }
}

