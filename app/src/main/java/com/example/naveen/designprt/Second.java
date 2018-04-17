package com.example.naveen.designprt;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.naveen.designprt.business.Adapter1;
import com.example.naveen.designprt.business.Adapter2;

import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {
    RecyclerView recyclerView1, recyclerView2,recyclerView3;
    private Adapter1 adapter1;
    private Adapter2 adapter2;

    List<String> imageList = new ArrayList<>();
    LinearLayout lnrSearch;
    // ScrollViewListener scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView3=(RecyclerView)findViewById(R.id.recyclerView3);

        lnrSearch = (LinearLayout) findViewById(R.id.lnrSearch);
        ///   scrollView=(ScrollViewListener) findViewById(R.id.scrollView);

        initialize();
    }

    void initialize() {
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        setAdapter1();
        setAdapter2();
        setAdapter3();
        //scrollView.setOnScrollChangedListener(mOnScrollChangedListener);
    }

    void setAdapter1() {
        adapter1 = new Adapter1(this, imageList());
        recyclerView1.setAdapter(adapter1);
    }

    void setAdapter2() {
        adapter2 = new Adapter2(this, imageList());
        recyclerView2.setAdapter(adapter2);
    }

    void setAdapter3() {
        adapter1 = new Adapter1(this, imageList());
        recyclerView3.setAdapter(adapter1);
    }

    private List<String> imageList() {
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");
        imageList.add("http://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x_e2s/sample_images/img/index/ff_x_e2s_001.JPG");

        return imageList;
    }

//    private ScrollViewListener.OnScrollChangedListener mOnScrollChangedListener = new ScrollViewListener.OnScrollChangedListener() {
//        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
//
//            System.out.println("Scrolled: " + t);
//
//            //Parallax Effect on scroll
//            if (t > 0) {
//                final float newY = (t / 4.0f) * -1.0f;
//                lnrSearch.setY(newY);
//            } else {
//                lnrSearch.setY(0.0f);
//            }
//        }
//    };
}
