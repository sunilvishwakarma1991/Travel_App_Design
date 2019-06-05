package gt.com.travel_app_design.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import gt.com.travel_app_design.R;
import gt.com.travel_app_design.adapter.ViewPagerAdapter;


public class MainActivity extends Activity {

  ViewPager viewPager;
  Context activity = MainActivity.this;
  LinearLayout sliderDotspanel;
  private int dotscount;
  private ImageView[] dots;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager = (ViewPager) findViewById(R.id.viewPager);

    sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

    viewPager.setAdapter(viewPagerAdapter);

    dotscount = viewPagerAdapter.getCount();
    dots = new ImageView[dotscount];

    for(int i = 0; i < dotscount; i++){

      dots[i] = new ImageView(this);
      dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

      LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

      params.setMargins(8, 0, 8, 0);

      sliderDotspanel.addView(dots[i], params);

    }

    dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {

        for(int i = 0; i< dotscount; i++){
          dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
        }

        dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });



  }

}
