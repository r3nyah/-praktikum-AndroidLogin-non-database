package www.smktelkommlg.logintest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoveActivityThird extends AppCompatActivity {
    public static String EXTRA_PERSON="extra_person";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_third);

        if(getIntent() != null){
            TextView tvObject = findViewById(R.id.tv_object);
            person Manusia = getIntent().getParcelableExtra(EXTRA_PERSON);
            String text = "Name\t= "+Manusia.getName()+"\nEmail\t  = "+Manusia.getEmail()+"\nAge\t    = "+Manusia.getAge()+"\nCity\t    = "+Manusia.getCity();
            //String text = "Name="+"\nEmail="+"\nAge="+"\nCity=";
            //"Name = :"+Manusia.getName()+
            tvObject.setText(text);
        }
    }
}
