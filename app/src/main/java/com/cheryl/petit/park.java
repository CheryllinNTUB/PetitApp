package com.cheryl.petit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class park extends AppCompatActivity {
    private ImageButton back;
    private Spinner city,reigon;
    private RecyclerView recyclerview;
    List<ParkData> ParkList;
    ParkData parklist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        back = findViewById(R.id.back);
        city = findViewById(R.id.city);
        reigon = findViewById(R.id.region);
        recyclerview = findViewById(R.id.recyleview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(park.this,1);
        recyclerview.setLayoutManager(gridLayoutManager);

        ParkList = new ArrayList<>();

        parklist = new ParkData("至善公園狗狗活動區","台北市士林區111台灣台北市士林區福林路至善路一段");
        ParkList.add(parklist);
        parklist = new ParkData("萬興狗活動區(道南左岸河濱公園)","台北市文山區新光路二段30號 ");
        ParkList.add(parklist);
        parklist = new ParkData("北勢湖公園狗活動區","台北市內湖區西康里堤頂大道2段");
        ParkList.add(parklist);
        parklist = new ParkData("迎風狗運動公園","台北市松山區莊敬里迎風河濱公園金泰段");
        ParkList.add(parklist);
        parklist = new ParkData("潭美毛寶貝快樂公園","台北市內湖區蘆洲里潭美街852號");
        ParkList.add(parklist);
        parklist = new ParkData("華山公園狗活動區","台北市中正區市民大道2段與林森北路交叉口");
        ParkList.add(parklist);
        parklist = new ParkData("玉成公園狗活動區","台北市南港區中坡南路55號");
        ParkList.add(parklist);
        parklist = new ParkData("板橋寵物運動公園","新北市板橋區板城路28-1號");
        ParkList.add(parklist);
        parklist = new ParkData("蘆洲蘆堤寵物公園","新北市蘆洲區環堤大道與永樂街交岔口");
        ParkList.add(parklist);
        parklist = new ParkData("永和綠寶石寵物公園","新北市永和區環河西路一段8號");
        ParkList.add(parklist);
        parklist = new ParkData("板橋華江寵物公園","新北市板橋區華江橋下");
        ParkList.add(parklist);
        parklist = new ParkData("中和四號寵物公園","新北市中和區中安街6號");
        ParkList.add(parklist);
        parklist = new ParkData("新店陽光公園","新北市新店區安業路47巷");
        ParkList.add(parklist);
        parklist = new ParkData("林口力行寵物公園","新北市林口區文化北路段526巷");
        ParkList.add(parklist);
        parklist = new ParkData("新店寵物親情公園","新北市新店區環河路112-1號");
        ParkList.add(parklist);
        parklist = new ParkData("林口松柏滯洪池公園","新北市林口區松柏路18號");
        ParkList.add(parklist);
        parklist = new ParkData("浮洲橋寵物公園","新北市板橋區機車專用道23號");
        ParkList.add(parklist);
        parklist = new ParkData("三重寵物公園","新北市三重區環河北路一段龍門陸橋路口");
        ParkList.add(parklist);
        parklist = new ParkData("中成寵物公園","桃園市桃園區國際路二段475巷");
        ParkList.add(parklist);
        parklist = new ParkData("寵物示範公園","桃園市桃園區民光東路旁");
        ParkList.add(parklist);
        parklist = new ParkData("平鎮雙連公園","桃園市平鎮區路光路14巷96弄10-38號");
        ParkList.add(parklist);
        parklist = new ParkData("龜山大湖公園","桃園市龜山區忠義路二段638巷");
        ParkList.add(parklist);
        parklist = new ParkData("福林公園","桃園市桃園區介壽路與介新街交叉口");
        ParkList.add(parklist);
        parklist = new ParkData("頭前溪寵物公園","新竹市東區中華路一段1巷");
        ParkList.add(parklist);
        parklist = new ParkData("竹東寵物公園","新竹縣竹東鎮沿河街上");
        ParkList.add(parklist);
        parklist = new ParkData("東興河濱公園","苗栗縣頭份市中港溪東興大橋下");
        ParkList.add(parklist);
        parklist = new ParkData("泉源寵物公園","台中市東區樂業一路79號");
        ParkList.add(parklist);
        parklist = new ParkData("安平寵物公園","台南市安平區州平二街底");
        ParkList.add(parklist);
        parklist = new ParkData("高雄狗狗運動公園","高雄市苓雅區中正一路中正公園西側");
        ParkList.add(parklist);
        parklist = new ParkData("高屏溪河濱寵物運動公園","屏東縣屏東市前進里高屏橋下");
        ParkList.add(parklist);
        parklist = new ParkData("觀音亭寵物公園","澎湖縣馬公市介壽路7號");
        ParkList.add(parklist);

        RecyleViewAdapter_park recyleViewAdapter_park = new RecyleViewAdapter_park(park.this,ParkList);
        recyclerview.setAdapter(recyleViewAdapter_park);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.list)
        );


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(park.this,search.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
