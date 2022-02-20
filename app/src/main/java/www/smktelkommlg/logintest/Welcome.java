package www.smktelkommlg.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnExit = (Button) findViewById(R.id.btnExit);
        Button btnMove = findViewById(R.id.btn_move_activity);
        Button btnBiodata = findViewById(R.id.btn_move_activity_second);
        Button btnShare = findViewById(R.id.btnShare);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
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
    }
}