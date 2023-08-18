package abc.get.hostels_pg;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class AboutUs extends AppCompatActivity {
 Spinner spinner6,spinner7;
 EditText editText13;
 TextView textView143;

 Button button18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        button18=findViewById(R.id.button18);
        spinner6=findViewById(R.id.spinner6);
        spinner7=findViewById(R.id.spinner7);
        editText13=findViewById(R.id.editText13);
        textView143=findViewById(R.id.textView143);
        textView143.setVisibility(View.GONE);
        ArrayList<String> num=new ArrayList<>();
        num.add("I am a User");
        num.add("I am a house/hostel owner");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,num);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter);

        ArrayList<String> num2=new ArrayList<>();
        num2.add("Adding Your Place related");
        num2.add("Booking Related");
        num2.add("Payment Related");
        num2.add("Others");
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,num2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter2);
        String q3=editText13.getText().toString();
        String q1=spinner6.getSelectedItem().toString();
        String q2=spinner7.getSelectedItem().toString();
        final String q4=q1+"   "+q2+"  "+ "  "+q3;
        final String no1="6265752172";
        final String no2="9893510414";
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(AboutUs.this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
                SmsManager smsManager = SmsManager.getDefault();
                String q3=editText13.getText().toString();
                String q1=spinner6.getSelectedItem().toString();
                String q2=spinner7.getSelectedItem().toString();
                final String q4=q1+"   "+q2+"  "+ "  "+q3;
                smsManager.sendTextMessage(no1,null,q4,null,null);
                smsManager.sendTextMessage(no2,null,q4,null,null);
                Toast.makeText(AboutUs.this, "Request Has Been Sent Successfully", Toast.LENGTH_SHORT).show();
                textView143.setVisibility(View.VISIBLE);
            }
        });
    }
}
