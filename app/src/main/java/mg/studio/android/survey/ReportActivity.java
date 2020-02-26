package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {
    TextView tv_1;
    TextView tv_2;
    TextView tv_3;
    TextView tv_4;
    TextView tv_5;
    TextView tv_6;
    TextView tv_7;
    TextView tv_8;
    TextView tv_9;
    TextView tv_10;
    TextView tv_11;
    TextView tv_12;

    public  void myFindviewbyid(){
        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_3=findViewById(R.id.tv_3);
        tv_4=findViewById(R.id.tv_4);
        tv_5=findViewById(R.id.tv_5);
        tv_6=findViewById(R.id.tv_6);
        tv_7=findViewById(R.id.tv_7);
        tv_8=findViewById(R.id.tv_8);
        tv_9=findViewById(R.id.tv_9);
        tv_10=findViewById(R.id.tv_10);
        tv_11=findViewById(R.id.tv_11);
        tv_12=findViewById(R.id.tv_12);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent=getIntent();
        Bundle data=intent.getBundleExtra("bundle");
        String msg[]=data.getStringArray("report");

        myFindviewbyid();

        tv_1.setText("1.You are going to buy a new "+msg[0]+" phone.");
        tv_2.setText("2.Your phone cost "+msg[1]+".");
        tv_3.setText("3.You are using the "+msg[2]+" phone.");
        tv_4.setText("4.You phone have these functions:"+msg[3]);
        tv_5.setText("5.You used these functions most often:"+msg[4]);
        tv_6.setText("6.You expect your phone have "+msg[5]+" functions in the future.");
        tv_7.setText("7.You will buy a new phone in such a condition:"+msg[6]);
        tv_8.setText("8.You will choose "+msg[7]+" if you are going to buy a new one.");
        tv_9.setText("9.You think "+msg[8]+" is the most important characteristic to evaluate a new phone.");
        tv_10.setText("10.You are "+msg[9]+" years old.");
        tv_11.setText("11.You are "+msg[10]+".");
        tv_12.setText("12.You earn "+msg[11]+" per month.");
    }
}
