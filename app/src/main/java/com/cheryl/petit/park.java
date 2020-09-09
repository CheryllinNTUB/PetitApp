package com.cheryl.petit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.firestore.SnapshotParser;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.util.ArrayList;


public class park extends AppCompatActivity {
    private ImageButton back;
    private FirebaseFirestore firebaseFirestore;
    FirestorePagingAdapter firestoreRecyclerAdapter;
    RecyclerView recyclerView;
    private Spinner city,reigon;
    ArrayList<String> cityList;
    ArrayAdapter<String>cityAdapter;

    ArrayList<String> choosetext, array01,array02,array03,array04,array05, array06,array07,array08,
            array09,array10,array11,array12,array13,array14,array15,array16,array17,array18,
            array19,array20,array21,array22;
    ArrayAdapter<String>reigonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.parklist);
        city = findViewById(R.id.city);
        reigon = findViewById(R.id.region);
        firebaseFirestore = FirebaseFirestore.getInstance();
        Query query = firebaseFirestore.collection("Park");

        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(3)
                .build();

        FirestorePagingOptions<Parkmodel> opinions = new FirestorePagingOptions
                .Builder<Parkmodel>()
                .setLifecycleOwner(this)
                .setQuery(query, config, new SnapshotParser<Parkmodel>() {
                    @NonNull
                    @Override
                    public Parkmodel parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Parkmodel parkData = snapshot.toObject(Parkmodel.class);
                        String itemId = snapshot.getId();
                        parkData.setItem_id(itemId);
                        return parkData;
                    }
                })
                .build();

            firestoreRecyclerAdapter = new FirestorePagingAdapter<Parkmodel, ParkViewHolder>(opinions) {
            @NonNull
            @Override
            public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row_park, parent, false);
                return new ParkViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ParkViewHolder holder, int position, @NonNull Parkmodel model) {

                holder.name.setText(model.getParkname());
                holder.address.setText(model.getParkAddress());
            }

            @Override
            protected void onLoadingStateChanged(@NonNull LoadingState state){
                super.onLoadingStateChanged(state);

                switch (state){

                    case LOADING_INITIAL:
                        Log.d("PAGING_LOG","loading data");
                        break;
                    case LOADING_MORE:
                        Log.d("PAGING_LOG","loading next page");
                        break;
                    case FINISHED:
                        Log.d("PAGING_LOG","all data loaded");
                        break;
                    case ERROR:
                        Log.d("PAGING_LOG","loading error");
                        break;
                    case LOADED:
                        Log.d("PAGING_LOG","total items loaded");
                        break;

                }
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(firestoreRecyclerAdapter);


        cityList = new ArrayList<>();
        cityList .add("請選擇縣市");
        cityList .add("台北市");//01
        cityList .add("新北市");//02
        cityList .add("基隆市");//03
        cityList .add("桃園市");//04
        cityList .add("新竹市");//05
        cityList .add("新竹縣");//06
        cityList .add("苗栗縣");//07
        cityList .add("台中市");//08
        cityList .add("彰化縣");//09
        cityList .add("雲林縣");//10
        cityList .add("南投縣");//11
        cityList .add("嘉義縣");//12
        cityList .add("嘉義市");//13
        cityList .add("台南市");//14
        cityList .add("高雄市");//15
        cityList .add("屏東縣");//16
        cityList .add("台東縣");//17
        cityList .add("花蓮縣");//18
        cityList .add("宜蘭縣");//19
        cityList .add("澎湖縣");//20
        cityList .add("金門縣");//21
        cityList .add("連江縣");//22

        cityAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,cityList);

        city.setAdapter(cityAdapter);

        choosetext = new ArrayList<>();
        choosetext.add("請選擇區域");

        array01 = new ArrayList<>();
        array01.add("中正區");
        array01.add("大同區");
        array01.add("中山區");
        array01.add("松山區");
        array01.add("大安區");
        array01.add("萬華區");
        array01.add("信義區");
        array01.add("士林區");
        array01.add("北投區");
        array01.add("內湖區");
        array01.add("南港區");
        array01.add("文山區");

        array02 = new ArrayList<>();
        array02.add("板橋區");
        array02.add("新莊區");
        array02.add("中和區");
        array02.add("永和區");
        array02.add("土城區");
        array02.add("樹林區");
        array02.add("三峽區");
        array02.add("鶯歌區");
        array02.add("三重區");
        array02.add("蘆洲區");
        array02.add("五股區");
        array02.add("泰山區");
        array02.add("林口區");
        array02.add("八里區");
        array02.add("淡水區");
        array02.add("三芝區");
        array02.add("石門區");
        array02.add("金山區");
        array02.add("萬里區");
        array02.add("汐止區");
        array02.add("瑞芳區");
        array02.add("貢寮區");
        array02.add("平溪區");
        array02.add("雙溪區");
        array02.add("新店區");
        array02.add("深坑區");
        array02.add("石碇區");
        array02.add("坪林區");
        array02.add("烏來區");

        array03 = new ArrayList<>();
        array03.add("仁愛區");
        array03.add("中正區");
        array03.add("信義區");
        array03.add("中山區");
        array03.add("安樂區");
        array03.add("暖暖區");
        array03.add("七堵區");

        array04 = new ArrayList<>();
        array04.add("桃園區");
        array04.add("中壢區");
        array04.add("平鎮區");
        array04.add("八德區");
        array04.add("楊梅區");
        array04.add("蘆竹區");
        array04.add("大溪區");
        array04.add("龍潭區");
        array04.add("龜山區");
        array04.add("大園區");
        array04.add("觀音區");
        array04.add("新屋區");
        array04.add("復興區");

        array05 = new ArrayList<>();
        array05.add("東區");
        array05.add("北區");
        array05.add("香山區");

        array06 = new ArrayList<>();
        array06.add("竹北市");
        array06.add("竹東鎮");
        array06.add("新埔鎮");
        array06.add("關西鎮");
        array06.add("湖口鄉");
        array06.add("新豐鄉");
        array06.add("峨眉鄉");
        array06.add("寶山鄉");
        array06.add("北埔鄉");
        array06.add("芎林鄉");
        array06.add("橫山鄉");
        array06.add("尖石鄉");
        array06.add("五峰鄉");

        array07 = new ArrayList<>();
        array07.add("苗栗市");
        array07.add("頭份市");
        array07.add("竹南鎮");
        array07.add("後龍鎮");
        array07.add("通霄鎮");
        array07.add("苑裡鎮");
        array07.add("卓蘭鎮");
        array07.add("造橋鄉");
        array07.add("西湖鄉");
        array07.add("頭屋鄉");
        array07.add("公館鄉");
        array07.add("銅鑼鄉");
        array07.add("三義鄉");
        array07.add("大湖鄉");
        array07.add("獅潭鄉");
        array07.add("三灣鄉");
        array07.add("南庄鄉");
        array07.add("泰安鄉");

        array08 = new ArrayList<>();
        array08.add("中區");
        array08.add("東區");
        array08.add("南區");
        array08.add("北區");
        array08.add("西區");
        array08.add("北屯區");
        array08.add("西屯區");
        array08.add("南屯區");
        array08.add("太平區");
        array08.add("大里區");
        array08.add("霧峰區");
        array08.add("烏日區");
        array08.add("豐原區");
        array08.add("后里區");
        array08.add("石岡區");
        array08.add("東勢區");
        array08.add("新社區");
        array08.add("潭子區");
        array08.add("大雅區");
        array08.add("神岡區");
        array08.add("大肚區");
        array08.add("沙鹿區");
        array08.add("龍井區");
        array08.add("梧棲區");
        array08.add("清水區");
        array08.add("大甲區");
        array08.add("外埔區");
        array08.add("大安區");
        array08.add("和平區");

        array09 = new ArrayList<>();
        array09.add("彰化市");
        array09.add("員林市");
        array09.add("和美鎮");
        array09.add("鹿港鎮");
        array09.add("溪湖鎮");
        array09.add("二林鎮");
        array09.add("田中鎮");
        array09.add("北斗鎮");
        array09.add("花壇鄉");
        array09.add("芬園鄉");
        array09.add("大村鄉");
        array09.add("永靖鄉");
        array09.add("伸港鄉");
        array09.add("線西鄉");
        array09.add("福興鄉");
        array09.add("秀水鄉");
        array09.add("埔心鄉");
        array09.add("埔鹽鄉");
        array09.add("大城鄉");
        array09.add("芳苑鄉");
        array09.add("竹塘鄉");
        array09.add("社頭鄉");
        array09.add("二水鄉");
        array09.add("田尾鄉");
        array09.add("埤頭鄉");
        array09.add("溪州鄉");

        array10 = new ArrayList<>();
        array10.add("斗六市");
        array10.add("斗南鎮");
        array10.add("虎尾鎮");
        array10.add("西螺鎮");
        array10.add("土庫鎮");
        array10.add("北港鎮");
        array10.add("林內鄉");
        array10.add("古坑鄉");
        array10.add("大埤鄉");
        array10.add("莿桐鄉");
        array10.add("褒忠鄉");
        array10.add("二崙鄉");
        array10.add("崙背鄉");
        array10.add("麥寮鄉");
        array10.add("臺西鄉");
        array10.add("東勢鄉");
        array10.add("元長鄉");
        array10.add("四湖鄉");
        array10.add("口湖鄉");
        array10.add("水林鄉");

        array11 = new ArrayList<>();
        array11.add("南投市");
        array11.add("埔里鎮");
        array11.add("草屯鎮");
        array11.add("竹山鎮");
        array11.add("集集鎮");
        array11.add("名間鄉");
        array11.add("鹿谷鄉");
        array11.add("中寮鄉");
        array11.add("魚池鄉");
        array11.add("國姓鄉");
        array11.add("水里鄉");
        array11.add("信義鄉");
        array11.add("仁愛鄉");

        array12 = new ArrayList<>();
        array12.add("太保市");
        array12.add("朴子市");
        array12.add("布袋鎮");
        array12.add("大林鎮");
        array12.add("民雄鄉");
        array12.add("溪口鄉");
        array12.add("新港鄉");
        array12.add("六腳鄉");
        array12.add("東石鄉");
        array12.add("義竹鄉");
        array12.add("鹿草鄉");
        array12.add("水上鄉");
        array12.add("中埔鄉");
        array12.add("竹崎鄉");
        array12.add("梅山鄉");
        array12.add("番路鄉");
        array12.add("大埔鄉");
        array12.add("阿里山鄉");

        array13 = new ArrayList<>();
        array13.add("東區");
        array13.add("西區");

        array14 = new ArrayList<>();
        array14.add("中西區");
        array14.add("東區");
        array14.add("南區");
        array14.add("北區");
        array14.add("安平區");
        array14.add("安南區");
        array14.add("永康區");
        array14.add("歸仁區");
        array14.add("新化區");
        array14.add("左鎮區");
        array14.add("玉井區");
        array14.add("楠西區");
        array14.add("南化區");
        array14.add("仁德區");
        array14.add("關廟區");
        array14.add("龍崎區");
        array14.add("官田區");
        array14.add("麻豆區");
        array14.add("佳里區");
        array14.add("西港區");
        array14.add("七股區");
        array14.add("將軍區");
        array14.add("學甲區");
        array14.add("北門區");
        array14.add("新營區");
        array14.add("後壁區");
        array14.add("白河區");
        array14.add("東山區");
        array14.add("六甲區");
        array14.add("下營區");
        array14.add("柳營區");
        array14.add("鹽水區");
        array14.add("善化區");
        array14.add("大內區");
        array14.add("山上區");
        array14.add("新市區");
        array14.add("安定區");

        array15 = new ArrayList<>();
        array15.add("楠梓區");
        array15.add("左營區");
        array15.add("鼓山區");
        array15.add("三民區");
        array15.add("鹽埕區");
        array15.add("前金區");
        array15.add("新興區");
        array15.add("苓雅區");
        array15.add("前鎮區");
        array15.add("旗津區");
        array15.add("小港區");
        array15.add("鳳山區");
        array15.add("大寮區");
        array15.add("鳥松區");
        array15.add("林園區");
        array15.add("仁武區");
        array15.add("大樹區");
        array15.add("大社區");
        array15.add("岡山區");
        array15.add("路竹區");
        array15.add("橋頭區");
        array15.add("梓官區");
        array15.add("彌陀區");
        array15.add("永安區");
        array15.add("燕巢區");
        array15.add("田寮區");
        array15.add("阿蓮區");
        array15.add("茄萣區");
        array15.add("湖內區");
        array15.add("旗山區");
        array15.add("美濃區");
        array15.add("內門區");
        array15.add("杉林區");
        array15.add("甲仙區");
        array15.add("六龜區");
        array15.add("茂林區");
        array15.add("桃源區");
        array15.add("那瑪夏區");

        array16 = new ArrayList<>();
        array16.add("屏東市");
        array16.add("潮州鎮");
        array16.add("東港鎮");
        array16.add("恆春鎮");
        array16.add("萬丹鄉");
        array16.add("長治鄉");
        array16.add("麟洛鄉");
        array16.add("九如鄉");
        array16.add("里港鄉");
        array16.add("鹽埔鄉");
        array16.add("高樹鄉");
        array16.add("萬巒鄉");
        array16.add("內埔鄉");
        array16.add("竹田鄉");
        array16.add("新埤鄉");
        array16.add("枋寮鄉");
        array16.add("新園鄉");
        array16.add("崁頂鄉");
        array16.add("林邊鄉");
        array16.add("南州鄉");
        array16.add("佳冬鄉");
        array16.add("琉球鄉");
        array16.add("車城鄉");
        array16.add("滿州鄉");
        array16.add("枋山鄉");
        array16.add("霧臺鄉");
        array16.add("瑪家鄉");
        array16.add("泰武鄉");
        array16.add("來義鄉");
        array16.add("春日鄉");
        array16.add("獅子鄉");
        array16.add("牡丹鄉");
        array16.add("三地門鄉");

        array17 = new ArrayList<>();
        array17.add("台東市");
        array17.add("成功鎮");
        array17.add("關山鎮");
        array17.add("長濱鄉");
        array17.add("池上鄉");
        array17.add("東河鄉");
        array17.add("鹿野鄉");
        array17.add("卑南鄉");
        array17.add("大武鄉");
        array17.add("綠島鄉");
        array17.add("太麻里鄉");
        array17.add("海瑞鄉");
        array17.add("延平鄉");
        array17.add("金峰鄉");
        array17.add("達仁鄉");
        array17.add("蘭嶼鄉");

        array18 = new ArrayList<>();
        array18.add("花蓮市");
        array18.add("鳳林鎮");
        array18.add("玉里鎮");
        array18.add("新城鄉");
        array18.add("吉安鄉");
        array18.add("壽豐鄉");
        array18.add("光復鄉");
        array18.add("豐濱鄉");
        array18.add("瑞穗鄉");
        array18.add("富里鄉");
        array18.add("秀林鄉");
        array18.add("萬榮鄉");
        array18.add("卓溪鄉");

        array19 = new ArrayList<>();
        array19.add("宜蘭市");
        array19.add("頭城鎮");
        array19.add("羅東鎮");
        array19.add("蘇澳鎮");
        array19.add("礁溪鄉");
        array19.add("壯圍鄉");
        array19.add("員山鄉");
        array19.add("冬山鄉");
        array19.add("五結鄉");
        array19.add("三星鄉");
        array19.add("大同鄉");
        array19.add("南澳鄉");

        array20 = new ArrayList<>();
        array20.add("馬公市");
        array20.add("湖西鄉");
        array20.add("白沙鄉");
        array20.add("西嶼鄉");
        array20.add("望安鄉");
        array20.add("七美鄉");


        array21 = new ArrayList<>();
        array21.add("金城鎮");
        array21.add("金湖鎮");
        array21.add("金沙鎮");
        array21.add("金寧鄉");
        array21.add("烈嶼鄉");
        array21.add("烏坵鄉");

        array22 = new ArrayList<>();
        array22.add("南竿鄉");
        array22.add("北竿鄉");
        array22.add("莒光鄉");
        array22.add("東引鄉");

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, choosetext);
                }

                if (i == 1) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array01);
                }

                if (i == 2) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array02);
                }

                if (i == 3) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array03);
                }

                if (i == 4) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array04);
                }

                if (i == 5) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array05);
                }

                if (i == 6) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array06);
                }

                if (i == 7) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array07);
                }

                if (i == 8) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array08);
                }

                if (i == 9) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array09);
                }

                if (i == 10) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array10);
                }

                if (i == 11) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array11);
                }

                if (i == 12) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array12);
                }

                if (i == 13) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array13);
                }

                if (i == 14) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array14);
                }

                if (i == 15) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array15);
                }

                if (i == 16) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array16);
                }

                if (i == 17) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array17);
                }

                if (i == 18) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array18);
                }


                if (i == 19) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array19);
                }


                if (i == 20) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array20);
                }


                if (i == 21) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array21);
                }

                if (i == 22) {
                    reigonAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, array22);
                }

                reigon.setAdapter(reigonAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(park.this, search.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private class ParkViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView address;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.parkname);
            address = itemView.findViewById(R.id.parkaddress);
        }
    }
}