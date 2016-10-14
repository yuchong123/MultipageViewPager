package org.yuc.multipageviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private ImagePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);


        List<Integer> ids=new ArrayList<Integer>();
        ids.add(R.mipmap.p1);
        ids.add(R.mipmap.p2);
        ids.add(R.mipmap.p3);
        ids.add(R.mipmap.p4);
        ids.add(R.mipmap.p5);
        ids.add(R.mipmap.p6);
        ids.add(R.mipmap.p7);
        ids.add(R.mipmap.p8);
        ids.add(R.mipmap.p9);
        ids.add(R.mipmap.p10);

        adapter = new ImagePagerAdapter(this, ids);
        vp.setAdapter(adapter);

        // 缓存的页面数
        vp.setOffscreenPageLimit(3);
        //间距
        vp.setPageMargin(8);

        vp.post(new Runnable() {
            @Override
            public void run() {
                int paddingLeft = vp.getPaddingLeft();
                int imgWidth = vp.getWidth() - paddingLeft*2;
                float excursion = -(float)paddingLeft/(float)imgWidth;
                vp.setPageTransformer(true, new ThreeDPageTransformer(excursion));
                adapter.notifyDataSetChanged();
            }
        });

    }
}
