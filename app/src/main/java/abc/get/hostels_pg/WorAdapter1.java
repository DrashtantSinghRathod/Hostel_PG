package abc.get.hostels_pg;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class WorAdapter1 extends ArrayAdapter<Word1> {
    private  static final String LOG_TAG=WorAdapter1.class.getSimpleName();


    WorAdapter1(Activity context, ArrayList<Word1> words2) {
        super(context,0,words2);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null)
        {
            v= LayoutInflater.from(getContext()).inflate(R.layout.list2,parent,false);
        }
        final Word1 words2 = getItem(position);

        final TextView textView66,textView67,textView70,textView71,textView73,textView146;
        ImageButton imageButton18;
        textView146=v.findViewById(R.id.textView146);
        textView146.setText(words2.getNo1());
        imageButton18=v.findViewById(R.id.imageButton18);
        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView146.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                getContext().startActivity(i);
            }
        });
        textView67=v.findViewById(R.id.textView67);
        assert words2 != null;
        textView67.setText(words2.getType());
        textView66=v.findViewById(R.id.textView66);
        textView66.setText(words2.getHname());
        textView70=v.findViewById(R.id.textView70);
        textView70.setText(words2.getRent());
        textView71=v.findViewById(R.id.textView71);
        textView71.setText(words2.getDate());
        textView73=v.findViewById(R.id.textView73);
        textView73.setText(words2.getAddress());
        return v;
    }
}
