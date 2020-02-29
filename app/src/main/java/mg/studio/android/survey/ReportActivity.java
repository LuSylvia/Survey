package mg.studio.android.survey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;

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
    Button btn_saveResult;

    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;



    public  void myFindViewById(){
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
        btn_saveResult=findViewById(R.id.btn_saveResult);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent=getIntent();
        final Bundle data=intent.getBundleExtra("bundle");
        final String msg[]=data.getStringArray("report");

        myFindViewById();

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


        //动态申请权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }


        btn_saveResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //存储到SD卡
                save2SD(msg);

                //存储到JSON文件
                save2JSON(msg);


                Toast.makeText(ReportActivity.this,"Save successed!",Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }





    //保存到SD卡
    private  void save2SD(String msg[]){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File sdFile= Environment.getExternalStorageDirectory();
            File saveData=new File(sdFile,"saveData1.txt");

            try {
                FileOutputStream fout=new FileOutputStream(saveData);
                fout.write(        ("Survey Report"+"\r\n").getBytes()   );
                for(int i=0;i<msg.length;i++){
                    fout.write(    ("Answer"+(i+1)+":"+msg[i]+"\r\n").getBytes()    );

                }
                fout.flush();
                fout.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(ReportActivity.this,"NO SD CARD!",Toast.LENGTH_SHORT).show();
        }

    }

    //保存到JSON文件
    private void save2JSON(String msg[]){
        JSONObject json=new JSONObject();
        try {
            for(int i=0;i<msg.length;i++){
                json.put("Answer"+(i+1),msg[i]);
            }
            //将json字符串写入到json文件中
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdFile= Environment.getExternalStorageDirectory();
                File saveData=new File(sdFile,"saveData2.json");

               FileOutputStream fout=new FileOutputStream(saveData);
               fout.write(json.toString().getBytes());
               fout.flush();
               fout.close();


            }else{
                Toast.makeText(ReportActivity.this,"NO SD CARD!",Toast.LENGTH_SHORT).show();
            }
            System.out.println(json.toString());



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
