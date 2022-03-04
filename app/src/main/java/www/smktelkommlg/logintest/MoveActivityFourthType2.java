package www.smktelkommlg.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoveActivityFourthType2 extends AppCompatActivity implements View.OnClickListener{
    private int REQUEST_CODE = 100;
    private TextView tvResult;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnMoveForResult = findViewById(R.id.btn_move_activity_fourth);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnMoveForResult.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent moveForResultIntent = new Intent(MoveActivityFourthType2.this, MoveActivityFourth.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
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
