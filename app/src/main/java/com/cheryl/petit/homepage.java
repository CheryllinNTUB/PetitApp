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

        activitymodel = new Activitymodel("為什麼貓掌一定要疊在最上面?","這是為了保護重要的打獵工具\n打獵是貓最重要的事之一，而爪子則是主要工具及武器。因此貓會特別保護爪子，不輕易讓他人觸碰。\n 此外，貓是短跑健將，常突然奔跑或跳躍。若貓掌被壓迫，就會影響彈跳空間，所以貓掌上方的空間必須空著\n 貓掌的反射性探知，除了鬍鬚與氣味以外，貓掌也是貓貓感知環境的重要工具，所以當觸碰到異物的時候，貓會反射性地用肉掌去探知對方",R.drawable.feed4);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("毛孩進食時…","均衡的攝取食物營養是減低毛孩消化功能負擔的重要環節，而餵養方式則取決於飼主的判斷與經驗。一般來說，人吃的飯菜中先不說含油含鹽量是否對毛孩不好，單說食物的攝取營養均衡就不全面！\n由於生理構造不同，狗狗對於大部分蔬果所含的營養和維生素雖然可以吸收，但是卻無法代謝!! 若是長期食用蔬果，會造成囤積維生素過多而引發維生素中毒。因此為了狗狗的健康，飼主應該採用科學的餵養方式。\n" +
                "Petit正是為了科學餵養方式而開發了飲食卡路里控制與記錄的功能，希望使用者在看完這篇文章後，能夠因為我們的努力而讓餵養寵物變得更加輕鬆喔~\n",R.drawable.go2);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("貓咪打獵前會扭屁屁?","家裡的貓咪在準備活動筋骨時總是會先扭一扭屁股，你知道這是為什麼嗎?\n" +
                "首先，貓咪會藉由會邊搖屁股邊計算獵物的動向、距離及路線，提高抓到獵物的機會。再來會扭動身體來測試爪子與地面接觸的強度，幫助他們能夠安全起跳。最後將力量向大腿內部集中，晃動臀部可儲存力量，達到更好的跳躍效果\n" +
                "而貓咪的屁股有個特別的穴道—「百會穴」，定期幫牠按摩、拍打穴道的話能夠促進貓咪身體健康並放鬆情緒。百會穴一共有2個，另一個位在兩隻耳朵的正中間。\n" +
                "貓咪在幼貓時期時，母貓會幫忙舔拭小貓的屁股來幫助排便。因此成年後的貓被撫摸、拍打屁股時，會將拍屁股理解為是表達親密、視對方為家人的方式喔\n",R.drawable.go3);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("寵物嘔吐了?","當毛孩開始不明原因嘔吐時，可依據以下情形來判斷造成原因並且做進一步的處理:\n" +
                "暫時性的嘔吐:\n 腸胃不適、吃太多、暈車、吃下了草、過敏症\n" +
                "持續性的嘔吐:\n 若是在嘔吐後有食慾，原因可能是胃腸不適或是胃中有異物。沒有食慾的話則有可能是傳染性疾病、重度胃腸不適、子宮蓄膿症、胃腸套疊、腸閉塞、金屬或藥物中毒、肝炎、腎炎、胰臟炎等...\n" +
                "但是不論是因為何種原因造成的嘔吐，建議還是第一時間帶寵物去醫院做詳細的檢查喔\n",R.drawable.hea01);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("狗狗的皮膚保養","狗狗皮膚構造有2~5層且本身沒有汗腺，但會分泌保護皮毛的分泌物，若是過度清洗的話，會破壞了皮膚組織。\n" +
                "而狗狗多久需要洗一次澡，其實並沒有硬性規定。狗狗依品種、膚質及生活狀況不同，每隻狗狗需要洗澡的頻率可能差距很大。\n（大多為一週一次至一個月一次）\n" +
                "此外，固定帶狗狗去美容院也是很重要的一件事情。雖然有些飼主會嫌麻煩，但梳理狗狗的毛髮還是對狗狗的皮膚有一定程度的影響！因為美容除了美觀外，留下的皮毛是要讓狗狗自身調節對大自然氣候變化的能力，炎熱時皮毛可以抵抗惡毒的紫外線，酷寒時可以激增毛量的生長。\n" +
                "至於到底要不要給狗狗穿衣服呢?這就需要視狗狗體質而定了\n" +
                "如果不是皮膚容易敏感，或是毛髮過柔、過長、容易結毛球的狗狗，冷天氣要外出時，可適度給予一些衣物，以降低忽然的溫差對身體免疫系統調節不良，而引起感冒、感染的可能。\n",R.drawable.hea03);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("肉球的五個秘密","大家都很愛捏貓咪的肉球，但是你知道肉球的小祕密嗎?這邊來跟大家分享五個與肉球有關的冷知識:\n" +
                "1.貓掌會流汗，貓咪全身上下只有肉球有汗腺，是主要的散熱媒介。所以當天氣熱時，讓貓貓活動在冰涼的瓷磚地板比剃毛更有效降溫。有的貓貓緊張或興奮時，肉球也會泛紅出汗，這時記得安撫一下\n" +
                "\t2.貓掌可以消音，貓咪是潛伏型的狩獵者，貓指甲不但可以收合、貓掌表面還覆蓋厚厚的脂肪，就像一塊止滑的軟墊。讓貓咪無論是攀爬、行走或者跑跳，都能無聲無息\n" +
                "\t3.貓掌跟鼻子同顏色，貓掌、貓鼻與貓耳都是「沒有毛的皮膚」，而皮膚的色素成分影響貓毛花色，所以這些部位的顏色都會與毛髮有點關係。所以通常：白貓有粉肉球、黑貓有黑肉球、花貓有花肉球、乳牛毛就是乳牛肉球\n" +
                "\t4.前腳掌有五個肉球，多數人以為一個貓掌只有四個肉球，但其實貓前肢內側也有ㄧ顆不落地的肉球，稱為「手根球」。有人說它的功用是攀爬止滑用、也有人說它是退化的大姆指，但其實兩種說法都可以，因為可愛就好啦！\n" +
                "\t5.貓掌像隻泰迪熊，隨著肉球顏色不同，每一隻肉球泰迪熊的模樣也不同，也是獨一無二的\n",R.drawable.feed1);
        activitylist.add(activitymodel);






    ActivityDataAdapter actrecyleViewAdapter = new ActivityDataAdapter(homepage.this,activitylist);
        recyclerView.setAdapter(actrecyleViewAdapter);

    }

}

