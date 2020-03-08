package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    //
    TextView tv_single;
    TextView tv_multiselect;
    TextView tv_edit;

    Button btn_single_next;
    Button btn_multiselect_next;
    Button btn_edit_next;
    Button btn_loadjson;
    Button btn_defaultquestion;

    EditText ed_edit;
    RadioGroup rg_single;
    RadioGroup rg_multiselect;
    ArrayList<CheckBox> checkBoxes=new ArrayList<>();



    int numTotal=0;//用于记录问题总数
    int currQues=0;//用于记录当前是第几个问题

    private ArrayList<String> optionsList=new ArrayList<>();//存储动态生成问卷中单个问题的所有选项
    private String selectOption;
    ArrayList<String> answers=new ArrayList<>();//存储动态生成问卷中用户选择的答案
    String type;//类型
    String question;//题目


    //String json="{\"survey\":{\"id\":\"12344134\",\"len\":\"2\",\"questions\":[{\"type\":\"single\",\"question\":\"How well do the professors teach at this university?\",\"options\":[{\"1\":\"Extremely well\"},{\"2\":\"Very well\"}]},{\"type\":\"single\",\"question\":\"How effective is the teaching outside yur major at the univesrity?\",\"options\":[{\"1\":\"Extremetly effective\"},{\"2\":\"Very effective\"},{\"3\":\"Somewhat effective\"},{\"4\":\"Not so effective\"},{\"5\":\"Not at all effective\"}]}]}}";
    String json="";
    JSONObject jsonObject3 =null;
    JSONArray jsonQuestions=null;
    JSONObject jsonQuestion=null;
    JSONArray jsonOptions=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_loadjson=findViewById(R.id.btn_loadjson);
        btn_defaultquestion=findViewById(R.id.btn_defaultQuestion);

        //得到本地json文本内容
        String fileName = "demo.json";
        json = getJson(this, fileName);

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


    private void myFindViewByID_single(){
        tv_single=findViewById(R.id.tv_single);
        btn_single_next=findViewById(R.id.btn_single_next);
        rg_single=findViewById(R.id.rg_single);
    }

    private void myFindViewByID_multiselect(){
        tv_multiselect=findViewById(R.id.tv_multiselect);
        btn_multiselect_next=findViewById(R.id.btn_multiselect_next);
        rg_multiselect=findViewById(R.id.rg_multiselect);
    }

    private void myFindViewByID_edit(){
        tv_edit=findViewById(R.id.tv_edit);
        ed_edit=findViewById(R.id.ed_edit);
        btn_edit_next=findViewById(R.id.btn_edit_next);

    }

    //读取json对象中的数据，并将其一一填充
    private void loadJsonData()throws JSONException {
        //获取问题对象，包括类型，题目，选项
        jsonQuestion= jsonQuestions.getJSONObject(currQues);
        //获取问题的类型
        type= jsonQuestion.optString("type");
        System.out.println("type:"+type);
        //获取问题的题目
        question= jsonQuestion.optString("question");
        System.out.println("question:"+question);
    }

    //从assets路径读取sample.json到字符串json中
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //默认问卷的点击事件
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

    //动态生成问卷的点击事件
    public void myClick(View view) {
        switch (view.getId()){
            //选用已经写好的问卷
            case R.id.btn_defaultQuestion:
                setContentView(R.layout.welcome);
                break;

            //读取assets文件下的sample.json文件
            case R.id.btn_loadjson:
                try {
                    //用survey构造jsonObject3
                    jsonObject3 = new JSONObject(String.valueOf(new JSONObject(json).getJSONObject("survey")));
                    assert jsonObject3 != null;
                    //获取问题数量，确定要构造的页面总数
                    numTotal = this.jsonObject3.optInt("len");
                    System.out.println("length=" + numTotal);
                    //获取所有问题对象
                    jsonQuestions = this.jsonObject3.optJSONArray("questions");
                    //获取currQues处的问题
                    loadJsonData();

                    if (type.equals("single")) {
                        showSingleQuestion();
                    } else if (type.equals("multiselect")) {
                        showMultiselectQuestion();
                    } else if (type.equals("edit")) {
                        showEditQuestion();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

                //单选
            case R.id.btn_single_next:
                //获取用户勾选选项
                int id = rg_single.getCheckedRadioButtonId();
                if (id == -1) {
                    Toast.makeText(MainActivity.this, "You must select 1 choice first!", Toast.LENGTH_SHORT).show();
                    break;
                }
                //若存在被勾选的选项，则记录该选项的文字信息
                RadioButton radioButton = findViewById(id);
                answers.add("question"+(currQues + 1) + ":" + radioButton.getText().toString());

                currQues++;

                if (currQues == numTotal) {
                    //已经是最后一个问题了，该跳转到finish界面
                    jumpFinish();
//                    Toast.makeText(this, "Last question!", Toast.LENGTH_SHORT).show();
//                    for(int i=0;i<answers.size();i++){
//                        //Log.e("Survey2",answers.get(i)+"\n");
//                        System.out.println(answers.get(i));
//                    }
                    break;
                } else {
                    //否则，跳转到下一个问题
                    try {
                        loadJsonData();
                        if (type.equals("single")) {
                            showSingleQuestion();
                        } else if (type.equals("multiselect")) {
                            showMultiselectQuestion();
                        } else if (type.equals("edit")) {
                            showEditQuestion();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("survey2", " 单选跳转出错!");
                    }

                }

                break;

            //多选
            case R.id.btn_multiselect_next:
                //获取用户勾选选项
                StringBuffer sb = new StringBuffer();
                for (CheckBox checkbox : checkBoxes) {
                    if (checkbox.isChecked()) {
                        sb.append(checkbox.getText().toString() + "--");
                    }
                }
                if (sb != null && "".equals(sb.toString())) {
                    Toast.makeText(getApplicationContext(), "You should at least select 1 choice!", Toast.LENGTH_LONG).show();
                    break;
                } else {
                    //Toast.makeText(getApplicationContext(), "你选择的是:" + sb.toString(), Toast.LENGTH_LONG).show();
                    answers.add(   ("question"+(currQues + 1) + ":"+ sb.toString() ) );

                }

                currQues++;
                if (currQues == numTotal) {
                    //已经是最后一个问题了，该跳转到finish界面

                    Toast.makeText(this, "Last question!", Toast.LENGTH_SHORT).show();
                    jumpFinish();
                    break;
                } else {
                    //否则，跳转到下一个问题
                    try {
                        loadJsonData();
                        if (type.equals("single")) {
                            showSingleQuestion();
                        } else if (type.equals("multiselect")) {
                            showMultiselectQuestion();
                        } else if (type.equals("edit")) {
                            showEditQuestion();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("survey2", " 多选跳转出错!");
                    }

                }

                break;
            case R.id.btn_edit_next:
                String answer = ed_edit.getText().toString();
                if (answer != null && !answer.equals("")) {
                    answers.add("question"+(currQues + 1) + ":" + answer);

                    currQues++;

                    if (currQues == numTotal) {
                        //已经是最后一个问题了，该跳转到finish界面
                        Toast.makeText(this, "Last question!", Toast.LENGTH_SHORT).show();
                        jumpFinish();
                        break;
                    } else {
                        //否则，跳转到下一个问题
                        try {
                            loadJsonData();
                            if (type.equals("single")) {
                                showSingleQuestion();
                            } else if (type.equals("multiselect")) {
                                showMultiselectQuestion();
                            } else if (type.equals("edit")) {
                                showEditQuestion();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("survey2", " 编辑跳转出错!");
                        }

                    }

                }else{
                    Toast.makeText(this, "You should write somethins first!", Toast.LENGTH_SHORT).show();
                    break;
                }


                break;

            default:
                break;
        }


    }


    //显示单选页面
    private  void showSingleQuestion()throws JSONException {
        setContentView(R.layout.question_single);
        myFindViewByID_single();
        //获取所有选项
        jsonOptions=new JSONArray(String.valueOf(jsonQuestion.get("options")));
        //填充问题
        tv_single.setText((currQues+1)+"."+question);
        //移除原有的选项
        rg_single.removeAllViews();
        optionsList.clear();
        //获取每个选项的内容，存放进选项列表里

        for(int i=0;i<jsonOptions.length();i++){
            optionsList.add(jsonOptions.getString(i));
            //System.out.println("options:"+optionsList.get(i));
        }


        for(int i=0;i<optionsList.size();i++){
            RadioButton rb=new RadioButton(this);
            rg_single.addView(rb);
            rb.setTextSize(18);
            rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            rb.setPadding(50,10,50,10);
            rb.setText(optionsList.get(i));
        }
    }

    //显示多选页面
    private void showMultiselectQuestion()throws JSONException{
        setContentView(R.layout.question_multiselect);
        myFindViewByID_multiselect();
        //移除原有选项
        rg_multiselect.removeAllViewsInLayout();
        optionsList.clear();

        jsonOptions=new JSONArray(String.valueOf(jsonQuestion.get("options")));

        //填充问题
        tv_multiselect.setText((currQues+1)+"."+question);
        //获取每个选项的内容，存放进选项列表里
        for(int i=0;i<jsonOptions.length();i++){
            optionsList.add(jsonOptions.getString(i));
            System.out.println("options:"+optionsList.get(i));
        }
        //移除checkboxes原有的checkbox
        checkBoxes.clear();
        //填充选项
        for(int i=0;i<optionsList.size();i++){
            CheckBox cb=new CheckBox(this);
            rg_multiselect.addView(cb);
            cb.setText(optionsList.get(i));
            checkBoxes.add(cb);
        }

    }

    //显示编辑页面
    private  void showEditQuestion(){
        setContentView(R.layout.question_edit);
        myFindViewByID_edit();
        ed_edit.setText(null);
        //填充问题
        tv_edit.setText((currQues+1)+"."+question);


    }


    public void jumpFinish(){
        Intent intent=new Intent(MainActivity.this,Report2Activity.class);
        intent.putExtra("result2",answers);
        startActivity(intent);
        finish();
    }


}
