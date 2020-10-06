package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Activitymodel> activitylist;
    Activitymodel activitymodel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        recyclerView = findViewById(R.id.recyleview);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setSelectedItemId(R.id.home);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext()
                                , search.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.record:
                        startActivity(new Intent(getApplicationContext()
                                , record.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.user:
                        startActivity(new Intent(getApplicationContext()
                                , user.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });



    GridLayoutManager gridLayoutManager = new GridLayoutManager(homepage.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
    activitylist = new ArrayList<>();

        activitymodel = new Activitymodel("不要常餵內臟類","不少飼主喜歡給狗狗餵內臟類的肉食，覺得能讓狗狗長白長胖。牠們確實會變的白胖，但那只不過是外強中乾。內臟類不管人類或是狗狗都是不能多吃的。像是雞肝等內臟中含有豐富的磷，但含鈣量卻很低。磷對鈣的吸收會有抑製作用，長期以內臟為主食便會因為缺鈣導致體內維生素A積累過多而中毒。",R.drawable.feed4);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("2020台中寵物用品暨服務展","匯集各大寵物品牌聯手展出，飼料、保健用品、玩具、清潔、文創、美容等一應俱全！現場超殺折扣、銅板商品、百元商品、買一送一、優惠好康、買越多送越多，還有好玩有趣的毛孩運動會、家族動員令等活動等你來！",R.drawable.act1);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("如何選擇合適寵物碗架","為了能讓寵物有完美的進食姿勢，在選擇品牌與樣式的同時，也別忽略了寵物的身高並依照合適的尺寸再進行購買。寵物肩膀以下約10公分是寵物比較容易進食的高度。",R.drawable.go2);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("如何預防寵物口腔疾病？","請幫牠們每天定期使用專用的漱口水以及牙膏，預防口腔細菌滋生。並建議不要餵人類的食物或是減少含有糖份的零食和餅乾。最重要的是要定期進行檢查與洗牙才能及早預防口腔疾病。",R.drawable.hea04);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("請不要給狗狗吃主人的食物","在不少鄉下地區，寵物跟主人吃的食物是一樣的。但主人的食物裡面會有過多的油鹽，對牠們的身體不好，吃久了容易掉毛以及得到胰腺炎。辛辣的食物更是大忌，要是吃到了就會導致腸胃的不適而腹瀉或嘔吐。",R.drawable.feed3);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("如何挑選梳齒","挑選梳齒時以梳齒上有圓珠包覆的為佳，較不易刮傷皮膚，常幫毛小孩梳毛不但能促進血液循環活化，也能讓毛髮更蓬鬆亮麗。",R.drawable.go3);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("寵物吹風機挑選五核心","1.輕鬆控制恆溫"+ "\n"+"2.溫度均衡"+"\n"+"3.超大風量"+"\n"+"4.沒有巨響噪音、手持隔熱設計"+"\n"+"5.安全品質認證",R.drawable.go1);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("不要只餵牠們一種食物","在多年前對寵物的呵護還沒有今天如此精心的時候，飼主都是依居住當地什麼東西最多就餵寵物什麼。例如在北極，狗狗們就以魚為主食；在美國南部就變成了玉米麵包；在歐洲則是馬鈴薯……單一的食物來源，使得牠們非常容易因為營養不均衡而生病。",R.drawable.feed2);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("毛孩便祕如何應對？","通常會造成便秘的原因是因為:"+"\n"+"1.纖維攝取不足或者吃進很難消化的食物 " + "\n"+ "2.缺乏運動、過度理毛（貓）"+"\n" + "3.壓力、飲水量不足等。當牠們出現便秘的情況時，不妨試著調整毛孩的飲食結構，並確保牠們都有喝足夠的水。",R.drawable.hea01);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("毛孩到底需不需要穿衣服？","需要視狗狗體質而定。如果不是皮膚容易敏感，或是毛髮過柔、過長、容易結毛球的毛孩，冷天氣要外出時，可適度給予一些衣物，以降低忽然的溫差對身體免疫系統調節不良，而引起感冒、感染的可能。",R.drawable.hea02);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("狗狗多久需要洗一次澡？","狗狗皮膚構造有2~5層，且皮膚本身雖然沒有汗腺，但卻會分泌保護皮毛的分泌物，過度清洗的話容易破壞這部分的組織。而狗狗多久需要洗一次澡，其實並沒有硬性規定，需要依品種、膚質及生活狀況不同來判斷洗澡的頻率（多為一週一次至一個月一次）",R.drawable.hea03);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("防疫期間帶著毛小孩散心去～" + "\n"+"全台友善毛小孩的戶外景點推薦","在疫情還未全面獲得解決的時期裡，對於很多家裡有毛小孩的人來說，若想出門走走，可以讓毛小孩自由自在的奔跑玩耍的地點絕對是最棒的選擇了！"+"\n" +"台南市政府為此推出了「毛小孩遊台南友善地圖」，地圖內羅列了不少友善寵物景點。可以直接到臺南市政府觀光旅遊局的網站下載喔！",R.drawable.act5);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("不能只用肉餵狗","狗狗是雜食動物，和人類一樣都需要均衡飲食。有的主人覺得只給狗狗吃肉牠就能長得更強壯，但是這樣餵狗不僅花更多錢，而且蛋白質過高狗狗消化不了會導致牠們拉肚子。儘管肉類富含營養，但光吃肉絕對是不夠的。",R.drawable.feed1);
        activitylist.add(activitymodel);







    ActivityDataAdapter actrecyleViewAdapter = new ActivityDataAdapter(homepage.this,activitylist);
        recyclerView.setAdapter(actrecyleViewAdapter);

    }

}

