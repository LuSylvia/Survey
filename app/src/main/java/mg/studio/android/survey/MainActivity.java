package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int count = 0;
    static String msg[] = new String[12];


    //定义控件
    //welcome
    CheckBox cb_01_accept;
    //ques1
    RadioButton rb_01_Iphone;
    RadioButton rb_01_Nokia;
    RadioButton rb_01_Samsung;
    RadioButton rb_01_Lenovo;
    RadioButton rb_01_MI;
    RadioButton rb_01_Sony;
    RadioButton rb_01_others;
    //ques2
    RadioButton rb_02_under1000;
    RadioButton rb_02_1000To1999;
    RadioButton rb_02_2000To2999;
    RadioButton rb_02_3000To3999;
    RadioButton rb_02_above4000;
    //ques3
    RadioButton rb_03_2g;
    RadioButton rb_03_3g;
    RadioButton rb_03_4g;
    RadioButton rb_03_others;
    //ques4
    CheckBox cb_04_music;
    CheckBox cb_04_photo;
    CheckBox cb_04_game;
    CheckBox cb_04_bussiness;
    CheckBox cb_04_gps;
    CheckBox cb_04_data;
    CheckBox cb_04_others;
    //ques5
    CheckBox cb_05_music;
    CheckBox cb_05_photo;
    CheckBox cb_05_game;
    CheckBox cb_05_bussiness;
    CheckBox cb_05_gps;
    CheckBox cb_05_data;
    CheckBox cb_05_others;
    //ques6
    EditText ed_06;
    //ques7
    RadioButton rb_07_1year;
    RadioButton rb_07_3year;
    RadioButton rb_07_break;
    RadioButton rb_07_new;
    RadioButton rb_07_others;
    //ques8
    RadioButton rb_08_Iphone;
    RadioButton rb_08_Nokia;
    RadioButton rb_08_Samsung;
    RadioButton rb_08_Lenovo;
    RadioButton rb_08_MI;
    RadioButton rb_08_Sony;
    RadioButton rb_08_others;
    //ques9
    RadioButton rb_09_appearance;
    RadioButton rb_09_price;
    RadioButton rb_09_performance;
    RadioButton rb_09_others;
    //ques10
    RadioButton rb_10_under18;
    RadioButton rb_10_19To25;
    RadioButton rb_10_25To35;
    RadioButton rb_10_beyond35;
    //ques11
    RadioButton rb_11_male;
    RadioButton rb_11_female;
    //ques12
    RadioButton rb_12_nojob;
    RadioButton rb_12_under3k;
    RadioButton rb_12_3kTO5k;
    RadioButton rb_12_5kTo10k;
    RadioButton rb_12_above10k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

    }



    public void myFindViewbyid() {
        //welcome
        cb_01_accept = findViewById(R.id.checkbox_welcome);
        //ques1
        rb_01_Iphone = findViewById(R.id.rb_01_iphone);
        rb_01_Nokia = findViewById(R.id.rb_01_Nokia);
        rb_01_Samsung = findViewById(R.id.rb_01_Samsung);
        rb_01_MI = findViewById(R.id.rb_01_MI);
        rb_01_Lenovo = findViewById(R.id.rb_01_Lenovo);
        rb_01_Sony = findViewById(R.id.rb_01_Sony);
        rb_01_others = findViewById(R.id.rb_01_Others);
        //ques2
        rb_02_under1000 = findViewById(R.id.rb_02_under1000);
        rb_02_1000To1999 = findViewById(R.id.rb_02_1000To1999);
        rb_02_2000To2999 = findViewById(R.id.rb_02_2000To2999);
        rb_02_3000To3999 = findViewById(R.id.rb_02_3000To3999);
        rb_02_above4000 = findViewById(R.id.rb_02_above4000);
        //ques3
        rb_03_2g = findViewById(R.id.rb_03_2G);
        rb_03_3g = findViewById(R.id.rb_03_3G);
        rb_03_4g = findViewById(R.id.rb_03_4G);
        rb_03_others = findViewById(R.id.rb_03_Others);
        //ques4
        cb_04_music = findViewById(R.id.cb_04_music);
        cb_04_photo = findViewById(R.id.cb_04_photo);
        cb_04_game = findViewById(R.id.cb_04_game);
        cb_04_bussiness = findViewById(R.id.cb_04_bussiness);
        cb_04_gps = findViewById(R.id.cb_04_gps);
        cb_04_data = findViewById(R.id.cb_04_data);
        cb_04_others = findViewById(R.id.cb_04_others);
        //ques5
        cb_05_music = findViewById(R.id.cb_05_music);
        cb_05_photo = findViewById(R.id.cb_05_photo);
        cb_05_game = findViewById(R.id.cb_05_game);
        cb_05_bussiness = findViewById(R.id.cb_05_bussiness);
        cb_05_gps = findViewById(R.id.cb_05_gps);
        cb_05_data = findViewById(R.id.cb_05_data);
        cb_05_others = findViewById(R.id.cb_05_others);
        //ques6
        ed_06 = findViewById(R.id.ed_06);
        //ques7
        rb_07_1year = findViewById(R.id.rb_07_1year);
        rb_07_3year = findViewById(R.id.rb_07_3year);
        rb_07_break = findViewById(R.id.rb_07_break);
        rb_07_new = findViewById(R.id.rb_07_new);
        rb_07_others = findViewById(R.id.rb_07_others);
        //ques8
        rb_08_Iphone = findViewById(R.id.rb_08_Iphone);
        rb_08_Nokia = findViewById(R.id.rb_08_Nokia);
        rb_08_Samsung = findViewById(R.id.rb_08_Samsung);
        rb_08_MI = findViewById(R.id.rb_08_MI);
        rb_08_Lenovo = findViewById(R.id.rb_08_Lenovo);
        rb_08_Sony = findViewById(R.id.rb_08_Sony);
        rb_08_others = findViewById(R.id.rb_08_Others);
        //ques9
        rb_09_appearance = findViewById(R.id.rb_09_appearance);
        rb_09_price = findViewById(R.id.rb_09_price);
        rb_09_performance = findViewById(R.id.rb_09_performance);
        rb_09_others = findViewById(R.id.rb_09_others);
        //ques10
        rb_10_under18 = findViewById(R.id.rb_10_under18);
        rb_10_19To25 = findViewById(R.id.rb_10_19To25);
        rb_10_25To35 = findViewById(R.id.rb_10_25To35);
        rb_10_beyond35 = findViewById(R.id.rb_10_beyond35);
        //ques11
        rb_11_male = findViewById(R.id.rb_11_male);
        rb_11_female = findViewById(R.id.rb_11_female);
        //ques12
        rb_12_nojob = findViewById(R.id.rb_12_nojob);
        rb_12_under3k = findViewById(R.id.rb_12_under3k);
        rb_12_3kTO5k = findViewById(R.id.rb_12_3Kto5K);
        rb_12_5kTo10k = findViewById(R.id.rb_12_5kto10K);
        rb_12_above10k = findViewById(R.id.rb_12_above10K);

    }

    public void onBtnClick(View view) {
        //绑定控件
        myFindViewbyid();
        switch (view.getId()) {
            case R.id.btn_welcome_next:
                if (!cb_01_accept.isChecked()) {
                    Toast.makeText(MainActivity.this, "You should accept these quests first!", Toast.LENGTH_LONG).show();
                    break;
                }
                setContentView(R.layout.question_one);
                break;
            case R.id.btn_ques1_next:
                if (rb_01_Iphone.isChecked()) {
                    //temp = rb_01_Iphone.getText().toString();
                    msg[count]= rb_01_Iphone.getText().toString();
                } else if (rb_01_Nokia.isChecked()) {
                    msg[count] = rb_01_Nokia.getText().toString();
                } else if (rb_01_Samsung.isChecked()) {
                    msg[count] = rb_01_Samsung.getText().toString();
                } else if (rb_01_Lenovo.isChecked()) {
                    msg[count] = rb_01_Lenovo.getText().toString();
                } else if (rb_01_MI.isChecked()) {
                    msg[count] = rb_01_MI.getText().toString();
                } else if (rb_01_Sony.isChecked()) {
                    msg[count] = rb_01_Sony.getText().toString();
                } else if (rb_01_others.isChecked()) {
                    msg[count] = rb_01_others.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "You must select a choice first!", Toast.LENGTH_LONG).show();
                    break;
                }

                Log.e("msg01", msg[count] + ",count=" + count);
                count++;
                setContentView(R.layout.question_two);
                break;
            case R.id.btn_ques2_next:
                if(rb_02_under1000.isChecked()){
                    msg[count]=rb_02_under1000.getText().toString();
                }else if(rb_02_1000To1999.isChecked()){
                    msg[count]=rb_02_1000To1999.getText().toString();
                }else if(rb_02_2000To2999.isChecked()){
                    msg[count]=rb_02_2000To2999.getText().toString();
                }else if(rb_02_3000To3999.isChecked()){
                    msg[count]=rb_02_3000To3999.getText().toString();
                }else if(rb_02_above4000.isChecked()){
                    msg[count]=rb_02_above4000.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg02",msg[count]+",count="+count);

                count++;
                setContentView(R.layout.question_three);
                break;
            case R.id.btn_ques3_next:
                if(rb_03_2g.isChecked()){
                    msg[count]=rb_03_2g.getText().toString();
                }else if(rb_03_3g.isChecked()){
                    msg[count]=rb_03_3g.getText().toString();
                }else if(rb_03_4g.isChecked()){
                    msg[count]=rb_03_4g.getText().toString();
                }else if(rb_03_others.isChecked()){
                    msg[count]=rb_03_others.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg03",msg[count]);
                count++;
                setContentView(R.layout.question_four);
                break;
            case R.id.btn_ques4_next:
                if(!cb_04_music.isChecked()&&!cb_04_photo.isChecked()&&!cb_04_game.isChecked()&&!cb_04_bussiness.isChecked()
                        &&!cb_04_gps.isChecked()&&!cb_04_data.isChecked()&&!cb_04_others.isChecked()){
                    Toast.makeText(MainActivity.this,"You must select at least 1 choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                //初始化
                msg[count]="";
                if(cb_04_music.isChecked()){
                    msg[count]+=cb_04_music.getText().toString()+" ";
                }
                if(cb_04_photo.isChecked()){
                    msg[count]+=cb_04_photo.getText().toString()+" ";
                }
                if(cb_04_game.isChecked()){
                    msg[count]+=cb_04_game.getText().toString()+" ";
                }
                if(cb_04_bussiness.isChecked()){
                    msg[count]+=cb_04_bussiness.getText().toString()+" ";
                }
                if(cb_04_gps.isChecked()){
                    msg[count]+=cb_04_gps.getText().toString()+" ";
                }
                if(cb_04_data.isChecked()){
                    msg[count]+=cb_04_data.getText().toString()+" ";
                }
                if(cb_04_others.isChecked()){
                    msg[count]+=cb_04_others.getText().toString()+" ";
                }
                Log.e("msg04",msg[count]);

                count++;
                setContentView(R.layout.question_five);
                break;
            case R.id.btn_ques5_next:
                if(!cb_05_music.isChecked()&&!cb_05_photo.isChecked()&&!cb_05_game.isChecked()&&!cb_05_bussiness.isChecked()
                        &&!cb_05_gps.isChecked()&&!cb_05_data.isChecked()&&!cb_05_others.isChecked()){
                    Toast.makeText(MainActivity.this,"You must select at least 1 choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                //初始化
                msg[count]="";
                if(cb_05_music.isChecked()){
                    msg[count]+=cb_05_music.getText().toString()+" ";
                }
                if(cb_05_photo.isChecked()){
                    msg[count]+=cb_05_photo.getText().toString()+" ";
                }
                if(cb_05_game.isChecked()){
                    msg[count]+=cb_05_game.getText().toString()+" ";
                }
                if(cb_05_bussiness.isChecked()){
                    msg[count]+=cb_05_bussiness.getText().toString()+" ";
                }
                if(cb_05_gps.isChecked()){
                    msg[count]+=cb_05_gps.getText().toString()+" ";
                }
                if(cb_05_data.isChecked()){
                    msg[count]+=cb_05_data.getText().toString()+" ";
                }
                if(cb_05_others.isChecked()){
                    msg[count]+=cb_05_others.getText().toString()+" ";
                }

                count++;
                setContentView(R.layout.question_six);
                break;
            case R.id.btn_ques6_next:

                msg[count]="";
                msg[count]=ed_06.getText().toString();
                if(msg[count].equals("")){
                    Toast.makeText(MainActivity.this,"you must input something!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg06",msg[count]);
                count++;
                setContentView(R.layout.question_seven);
                break;
            case R.id.btn_ques7_next:

                if(rb_07_1year.isChecked()){
                    msg[count]="When the old phone has been used for a year or two.(but it still works)";
                }else if(rb_07_3year.isChecked()){
                    msg[count]="When the old phone has been used for more than three years.(but it still works)";
                }else if(rb_07_break.isChecked()){
                    msg[count]="When the old phone breaks down.";
                }else if(rb_07_new.isChecked()){
                    msg[count]="When a new phone is released.";
                }else if(rb_07_others.isChecked()){
                    msg[count]=rb_07_others.getText().toString();
                } else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg07",msg[count]);
//
                count++;
                setContentView(R.layout.question_eight);
                break;
            case R.id.btn_ques8_next:

                if(rb_08_Iphone.isChecked()){
                    msg[count]= rb_08_Iphone.getText().toString();
                }else if(rb_08_Nokia.isChecked()){
                    msg[count]= rb_08_Nokia.getText().toString();
                }else if(rb_08_Samsung.isChecked()){
                    msg[count]= rb_08_Samsung.getText().toString();
                }else if(rb_08_Lenovo.isChecked()){
                    msg[count]= rb_08_Lenovo.getText().toString();
                }else if(rb_08_MI.isChecked()){
                    msg[count]= rb_08_MI.getText().toString();
                }else if(rb_08_Sony.isChecked()){
                    msg[count]= rb_08_Sony.getText().toString();
                }else if(rb_08_others.isChecked()){
                    msg[count]= rb_08_others.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg08",msg[count]);


                count++;
                setContentView(R.layout.question_nine);
                break;
            case R.id.btn_ques9_next:

                if(rb_09_appearance.isChecked()){
                    msg[count]= rb_09_appearance.getText().toString();
                }else if(rb_09_price.isChecked()){
                    msg[count]= rb_09_price.getText().toString();
                }else if(rb_09_performance.isChecked()){
                    msg[count]= rb_09_performance.getText().toString();
                }else if(rb_09_others.isChecked()){
                    msg[count]= rb_09_others.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg09",msg[count]);
                count++;
                setContentView(R.layout.question_ten);
                break;
            case R.id.btn_ques10_next:

                if(rb_10_under18.isChecked()){
                    msg[count]= rb_10_under18.getText().toString();
                }else if(rb_10_19To25.isChecked()){
                    msg[count]= rb_10_19To25.getText().toString();
                }else if(rb_10_25To35.isChecked()){
                    msg[count]= rb_10_25To35.getText().toString();
                }else if(rb_10_beyond35.isChecked()){
                    msg[count]= rb_10_beyond35.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg10",msg[count]);
                count++;
                setContentView(R.layout.question_eleven);
                break;
            case R.id.btn_ques11_next:
                if(rb_11_male.isChecked()){
                    msg[count]=rb_11_male.getText().toString();
                }else if(rb_11_female.isChecked()){
                    msg[count]=rb_11_female.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg11",msg[count]);
                count++;
                setContentView(R.layout.question_twelve);
                break;
            case R.id.btn_ques12_next:

                if(rb_12_nojob.isChecked()){
                    msg[count]= rb_12_nojob.getText().toString();
                }else if(rb_12_under3k.isChecked()){
                    msg[count]= rb_12_under3k.getText().toString();
                }else if(rb_12_3kTO5k.isChecked()){
                    msg[count]= rb_12_3kTO5k.getText().toString();
                }else if(rb_12_5kTo10k.isChecked()){
                    msg[count]= rb_12_5kTo10k.getText().toString();
                }else if(rb_12_above10k.isChecked()){
                    msg[count]= rb_12_above10k.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this,"You must select a choice first!",Toast.LENGTH_LONG).show();
                    break;
                }
                Log.e("msg12",msg[count]);
                setContentView(R.layout.finish_survey);
                break;

            case R.id.btn_finish:

                for(int i=0;i<msg.length;i++){
                    Log.e("msg"+i,msg[i]+",ok?\n");

                }

                Intent intent=new Intent(MainActivity.this,ReportActivity.class);
                Bundle bundle=new Bundle();
                bundle.putStringArray("report",msg);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
                //finish();


                break;

            default:
                break;


        }


    }



}
