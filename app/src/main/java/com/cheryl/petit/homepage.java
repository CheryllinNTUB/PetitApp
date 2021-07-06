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
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private static final String TAG = "FirestoreSearchActivity";
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

        activitymodel = new Activitymodel("狗狗選擇食物時…","狗狗吃東西時很少經過咀嚼而是用吞的。因此狗狗不是通過細嚼慢咽來品嘗食物的味道，而主要是靠嗅覺和味覺的雙重作用，它的味覺主要靠嗅覺來決定。狗狗很少因味覺而引起食慾或者產生拒食現象。因此，我們在給狗準備食物時，要特別注意對食物氣味的調理。\n狗狗在逐漸邁入中高齡後健康指數與體力會逐漸下降，平日的飲食攝取不均很容易造成免疫系統問題與慢性疾病的產生。如果再加上口腔狀況不佳，更容易導致食慾不佳而影響吸收。在食物的選擇上面，可以增加食物種類的多樣性，並將食物切碎（磨碎）為較小的好咀嚼的方式，以增加食物營養的吸收。除了特別注意六大營養均衡攝取外，可以特別補充中高齡犬普遍容易缺乏的鋅、鈣、維生素D、維生素E等營養素，或者選擇直接補充營養補給品也是一種方便的選擇。",R.drawable.go2);
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

        activitymodel = new Activitymodel("寵物鮮食食譜-親子雜菜丼(狗用)","準備食材：紅蘿蔔、南瓜、花椰菜、雞里肌肉、雞蛋、白米。\n" +
                "\n" +
                "步驟1：將食材都切碎，蔬菜建議用刨絲方式不只快又方便。\n" +
                "\n" +
                "步驟2：將白米洗淨後加入切碎食材攪拌。\n" +
                "\n" +
                "步驟3：加入雞蛋和水攪拌，至於水量要加多少可自己衡量，最多不要超過2倍。\n" +
                "\n" +
                "步驟4：在電鍋中倒進1杯水後，即可將食材放入蒸煮。\n" +
                "\n" +
                "確實做完以上步驟即完成，放涼後即可給毛孩食用嘍！",R.drawable.eat);
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

        activitymodel = new Activitymodel("貓嘗不了甜頭?","味覺有五味，酸甜苦辣鹹。各位有沒有研究過貓咪的味覺呢？ \n" +
                "貓的味覺器官位於舌根部的味蕾和軟齶。牠們不光能感知酸、苦、辣、鹹味，還能品嚐出水的味道，這一點是其他動物所不及的。但唯獨甜味牠們卻沒辦法立刻嘗出味道來。\n" +
                "大多數哺乳動物的舌頭都有味覺感受器:細胞表面的一種蛋白質，當有食物進入口中的時候會刺激細胞的內部運作而發送一個信號給大腦。味覺的感受器通常由兩個不同的基因——Taslr2和Taslr3產生的兩對蛋白質組成。\n" +
                "曾經有研究人員從包括一隻虎和一隻印度豹在內的6隻貓科動物身上提取了唾液和血液樣本，結果發現它們全都有一種帶有缺陷的基因，而其它哺乳動物正是用這種基因生成舌頭上的“甜味受體”。“甜味受體”由兩種分別稱為“T1R2”和“T1R3”的蛋白質形成，而貓科動物由於基因缺陷而不會形成這兩種重要蛋白質中的其中一種:T1R2。\n" +
                "目前為止，貓科動物是哺乳動物中唯一缺少甜味基因的，甚至食肉動物中貓近親的鬣狗和貓鼬都有這個基因。同時喵星人也許還缺少其他享受或消化醣類的組件，比如肝臟中的葡糖激酶(一種關鍵酶，控制著碳水化合物代謝，也防止葡萄糖過剩)。除此之外，大多主流寵物食品製造商在其產品中使用玉米或其他穀類。這也許就是越來越多貓咪得糖尿病的原因。\n",R.drawable.feed5);
        activitylist.add(activitymodel);

        activitymodel = new Activitymodel("寵物鮮食食譜-南瓜鯛魚起司燒（貓用）","準備食材：南瓜、花椰菜、低鹽起司、去刺魚塊。\n" +
                "\n" +
                "步驟1：將蔬菜切碎後放進碗中。\n" +
                "\n" +
                "步驟2：將去刺魚塊切塊後一起放入碗中。\n" +
                "\n" +
                "步驟3：加入水和灑上低鹽起司。\n" +
                "\n" +
                "步驟4：同樣在電鍋中倒進1杯水後，就可將食材放入蒸煮。\n" +
                "\n" +
                "小祕訣：記得要把魚塊攪碎，這樣毛孩才好進食喔",R.drawable.eat);
        activitylist.add(activitymodel);






        ActivityDataAdapter actrecyleViewAdapter = new ActivityDataAdapter(homepage.this,activitylist);
        recyclerView.setAdapter(actrecyleViewAdapter);

    }

}