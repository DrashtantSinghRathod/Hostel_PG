package abc.get.hostels_pg;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class book extends AppCompatActivity implements PaymentResultListener {

    EditText editText2,editText3,editText,editText17,editText18,editText16,editText15;
    TextView textView63,textView54,textView48,textView77;
    RadioGroup rg;
    RadioButton radioButton1,radioButton2,radioButton3;
    private DatabaseReference reference,reference2;
    private FirebaseDatabase fd = FirebaseDatabase.getInstance();
    FirebaseUser user1= FirebaseAuth.getInstance().getCurrentUser();
    Button button;
    String TAG = "Payment Error";
    String firebaseUser;
    String type,hname,date,srent,drent,trent,fulladd,type1,name,age,phone,proff,address,ouid,no1,no2,rent,savail,davail,tavail;
    int i=1;
    AdView mAdView;
    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Checkout.preload(getApplicationContext());
        Intent i=getIntent();
        type=i.getStringExtra("type");
        hname=i.getStringExtra("hname");
        srent=i.getStringExtra("srent");
        no1=i.getStringExtra("no1");
        no2=i.getStringExtra("no2");
        drent=i.getStringExtra("drent");
        trent=i.getStringExtra("trent");
        fulladd=i.getStringExtra("fulladd");
        ouid=i.getStringExtra("ouid");
        savail = i.getStringExtra("savail");
        davail = i.getStringExtra("davail");
        tavail = i.getStringExtra("tavail");

        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        textView63=findViewById(R.id.textView63);
        textView54=findViewById(R.id.textView54);
        textView48=findViewById(R.id.textView48);
        textView77=findViewById(R.id.textView77);
        editText=findViewById(R.id.editText);
        editText17=findViewById(R.id.editText17);
        editText18=findViewById(R.id.editText18);
        editText16=findViewById(R.id.editText16);
        editText15=findViewById(R.id.editText15);

        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton1.setVisibility(View.GONE);
        radioButton2.setVisibility(View.GONE);
        radioButton3.setVisibility(View.GONE);
        rg=findViewById(R.id.rg);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        textView48.setText(type);
        textView54.setText(hname);
        button=findViewById(R.id.button);
        firebaseUser = user1.getUid();

        notificationHelper = new NotificationHelper(this);

        ActivityCompat.requestPermissions(book.this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        String year1 = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        String month1 = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
        final String date1 = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
        date = date1+"/"+month1+"/"+year1;
        Toast.makeText(this, date1, Toast.LENGTH_LONG).show();
        textView63.setText(date);

        if (savail.equals("Available"))
        {
            radioButton1.setVisibility(View.VISIBLE);
            textView77.setText(srent);
        }
        if (davail.equals("Available"))
        {
            radioButton2.setVisibility(View.VISIBLE);
            textView77.setText(drent);
        }
        if (tavail.equals("Available"))
        {
            radioButton3.setVisibility(View.VISIBLE);
            textView77.setText(trent);
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId==R.id.radioButton1){
                    textView77.setText(srent);
                    type1="Single Room";
                }
                if (checkedId==R.id.radioButton2){
                    textView77.setText(drent);
                    type1="Double Room";
                }
                if (checkedId==R.id.radioButton3){
                    textView77.setText(trent);
                    type1="Triple Room";
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rent=textView77.getText().toString();
                if (editText.getText().toString().isEmpty())
                {
                    editText.setError("required");
                    editText.requestFocus();
                    return;
                }
                if (editText15.getText().toString().isEmpty())
                {
                    editText15.setError("required");
                    editText15.requestFocus();
                    return;
                }
                if (editText16.getText().toString().isEmpty())
                {
                    editText16.setError("required");
                    editText16.requestFocus();
                    return;
                }
                if (editText17.getText().toString().isEmpty())
                {
                    editText17.setError("required");
                    editText17.requestFocus();
                    return;
                }
                if (editText18.getText().toString().isEmpty())
                {
                    editText18.setError("required");
                    editText18.requestFocus();
                    return;
                }
                else {
                    startPayment();
                }
            }
        });
    }

    public void startPayment() {
        Checkout checkout = new Checkout();
//        checkout.setKeyID("<rzp_test_Y5agwWWVeWsLb8>");
        /**
         * Instantiate Checkout
         */

        /**
         * Set your logo here
         */
//        checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Get Hostelry");
            options.put("description", "123456");
            //options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            options.put("prefill.email", "aryanguptar741@gmail.com");
            options.put("prefill.contact", "6265752172");
            checkout.open(activity, options);
        } catch (Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successfull", Toast.LENGTH_SHORT).show();
        reference=fd.getReference("Users");
        reference.child(firebaseUser).child("bookdetails").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                i= (int) snapshot.getChildrenCount();
                Toast.makeText(book.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
                i=i+1;
                Word1 word1 = new Word1(date,hname,type1,no1,rent,fulladd);
                reference.child(firebaseUser).child("bookdetails").child(String.valueOf(i)).setValue(word1);

                name=editText.getText().toString();
                age=editText17.getText().toString();
                phone=editText18.getText().toString();
                proff=editText16.getText().toString();
                address=editText15.getText().toString();
                Word2 word2 = new Word2(name,type1,address,proff,age,phone,date);
                reference2=fd.getReference("Owner");
                reference2.child(ouid).child(String.valueOf(i)).setValue(word2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        name=editText.getText().toString();
        phone=editText18.getText().toString();
        String msg = hname+"  "+no1+"     "+name+"  "+phone;
        Intent i = new Intent(this,MyBookings.class);
        startActivity(i);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(no1,null,"you have got new bookings",null,null);

        String number1 = "6265752172";
        String number2 = "9893510414";
        smsManager.sendTextMessage(number1,null,msg,null,null);
        smsManager.sendTextMessage(number2,null,msg,null,null);

        sendOnChannel1("Booking Successful","Click view booking details");

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void sendOnChannel1(String title, String message)
    {
        NotificationCompat.Builder nb = notificationHelper.getChannel1Notification(title,message);
        notificationHelper.getManager().notify(1,nb.build());
    }
}
