package www.smktelkommlg.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button btnExit;
    private int REQUEST_CODE = 100;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnExit = (Button) findViewById(R.id.btnExit);
        Button btnMove = findViewById(R.id.btn_move_activity);
        Button btnBiodata = findViewById(R.id.btn_move_activity_second);
        Button btnMoveData = findViewById(R.id.btn_move_activity_third);
        Button btnShare = findViewById(R.id.btnShare);
        Button btnDial = findViewById(R.id.btnDial);
        Button btnMessage = findViewById(R.id.btnMessage);
        //Button btnMoveForResult = findViewById(R.id.btn_move_activity_fourth);
        Button btnMoveForResult = findViewById(R.id.btn_move_activity_fourth);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, MoveActivity.class));
            }
        });
        btnBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, MoveActivitySecond.class));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Perintah Intent Implicit untuk share ke sosmed
                Intent intent = new Intent(Intent.ACTION_SEND);

                // Membawa data / pesan yang ingin dishare
                intent.putExtra(intent.EXTRA_TEXT, "Test share to media social xD");
                intent.setType("text/plain");

                // Menjalankan perintah Intent Implicit
                startActivity(Intent.createChooser(intent, "Share to :"));
            }
        });
        btnMoveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person Manusia = new person("Arian", "arian@gmail.com", "Malang", 17);
                //Manusia.setEmail("Arian@gmail.com");
                //Manusia.setName("Arian");
                //Manusia.setCity("Malang");
                //Manusia.setAge(17);
                //startActivity(new Intent(Welcome.this, MoveActivityThird.class));
                Intent intent_object = new Intent(Welcome.this, MoveActivityThird.class);
                intent_object.putExtra(MoveActivityThird.EXTRA_PERSON, Manusia);
                startActivity(intent_object);

            }
        });
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+911";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, MessageOne.class));
            }
        });

        btnMoveForResult.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent moveForResultIntent = new Intent(Welcome.this,MoveActivityFourth.class);
                startActivityForResult(moveForResultIntent,REQUEST_CODE);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==MoveActivityFourth.RESULT_CODE){
                int selectValue = data.getIntExtra(MoveActivityFourth.EXTRA_SELECTED_VALUE,0);
                tvResult.setText("Hasil = "+selectValue);
            }
        }
    }


    @Override
    public void onClick(View view) {

    }
}
