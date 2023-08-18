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

public class WordAdapter2 extends ArrayAdapter<Word2> {
    private static final String LOG_TAG = WordAdapter2.class.getSimpleName();


    WordAdapter2(Activity context, ArrayList<Word2> words3) {
        super(context, 0, words3);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null)
        {
            v= LayoutInflater.from(getContext()).inflate(R.layout.list3,parent,false);
        }
        final Word2 words3 = getItem(position);

        final TextView textView74,textView78,textView79,textView80,textView81,textView82, textView83;
        ImageButton imageButton8;
        imageButton8=v.findViewById(R.id.imageButton8);
        textView83=v.findViewById(R.id.textView83);
        assert words3 != null;
        textView83.setText(words3.getType());
        textView78=v.findViewById(R.id.textView78);
        textView78.setText(words3.getName());
        textView81=v.findViewById(R.id.textView81);
        textView81.setText(words3.getProfession());
        textView79=v.findViewById(R.id.textView79);
        textView79.setText(words3.getAge());
        textView82=v.findViewById(R.id.textView82);
        textView82.setText(words3.getAddress());
        textView74=v.findViewById(R.id.textView74);
        textView74.setText(words3.getDate());
        textView80=v.findViewById(R.id.textView80);
        textView80.setText(words3.getPhone());
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=textView80.getText().toString();
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t));
                getContext().startActivity(i);
            }
        });
        return v;
    }
}
