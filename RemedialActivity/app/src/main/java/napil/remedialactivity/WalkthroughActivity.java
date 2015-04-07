package napil.remedialactivity;

/**
 * Created by Napil on 4/7/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class WalkthroughActivity extends Activity {

    private static final int MAX_VIEWS = 4;

    ViewPager mViewPager;
    private Button button;
    private Button button2;
    private ImageView image;
    private ImageView image2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough_activity);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new WalkthroughPagerAdapter());
        mViewPager.setOnPageChangeListener(new WalkthroughPageChangeListener());


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast x= Toast.makeText(getApplicationContext(),
                        "Sign Up Now.", Toast.LENGTH_LONG);
                x.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                x.show();

            }
        });

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast x= Toast.makeText(getApplicationContext(),
                        "Log In Now.", Toast.LENGTH_LONG);

                x.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                x.show();

            }
        });

        image = (ImageView) findViewById(R.id.imageView);

        image.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast x= Toast.makeText(getApplicationContext(),
                        "You have clicked the BACK button.", Toast.LENGTH_LONG);
                x.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                x.show();

            }
        });

        image2 = (ImageView) findViewById(R.id.imageView1);

        image2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast x= Toast.makeText(getApplicationContext(),
                        "Ypu have clicked the SKIP button.", Toast.LENGTH_LONG);

                x.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                x.show();

            }
        });

    }


    class WalkthroughPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return MAX_VIEWS;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (View) object;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            Log.e("walkthrough", "instantiateItem(" + position + ");");
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View imageViewContainer = inflater.inflate(R.layout.walkthrough_single_view, null);
            ImageView imageView = (ImageView) imageViewContainer.findViewById(R.id.image_view);


            switch(position) {
                case 0:
                    imageView.setImageResource(R.drawable.image1);
                    break;

                case 1:
                    imageView.setImageResource(R.drawable.image2);
                    break;

                case 2:
                    imageView.setImageResource(R.drawable.image3);
                    break;

                case 3:
                    imageView.setImageResource(R.drawable.image4);

                    break;


            }

            ((ViewPager) container).addView(imageViewContainer, 0);
            return imageViewContainer;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }
    }


    class WalkthroughPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            Button bt1,bt2,bt3,bt4;
            bt1 = (Button) findViewById(R.id.btn1);
            bt2 = (Button) findViewById(R.id.btn2);
            bt3 = (Button) findViewById(R.id.btn3);
            bt4 = (Button) findViewById(R.id.btn4);
            // Here is where you should show change the view of page indicator
            switch(position) {

                case 0:

                    setButton(bt1,4,15,R.drawable.circle2);
                    setButton(bt2,4,15,R.drawable.circle);
                    setButton(bt3,4,15,R.drawable.circle);
                    setButton(bt4,4,15,R.drawable.circle);
                    break;

                case 1:

                    setButton(bt1,4,15,R.drawable.circle);
                    setButton(bt2,4,15,R.drawable.circle2);
                    setButton(bt3,4,15,R.drawable.circle);
                    setButton(bt4,4,15,R.drawable.circle);
                    break;

                case 2:

                    setButton(bt1,4,15,R.drawable.circle);
                    setButton(bt2,4,15,R.drawable.circle);
                    setButton(bt3,4,15,R.drawable.circle2);
                    setButton(bt4,4,15,R.drawable.circle);
                    break;

                case 3:

                    setButton(bt1,4,15,R.drawable.circle);
                    setButton(bt2,4,15,R.drawable.circle);
                    setButton(bt3,4,15,R.drawable.circle);
                    setButton(bt4,4,15,R.drawable.circle2);
                    break;

                default:

            }

        }

    }

    private void setButton(Button btn,int w,int h,int c)
    {
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setBackgroundResource(c);
    }
}