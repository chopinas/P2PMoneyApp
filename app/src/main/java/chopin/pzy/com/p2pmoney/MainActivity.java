package chopin.pzy.com.p2pmoney;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chopin.pzy.com.p2pmoney.fragment.HomeFragment;
import chopin.pzy.com.p2pmoney.fragment.MeFragment;
import chopin.pzy.com.p2pmoney.fragment.MoreFragment;
import chopin.pzy.com.p2pmoney.fragment.TouziFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();

    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.iv_touzi)
    ImageView ivTouzi;
    @BindView(R.id.tv_touzi)
    TextView tvTouzi;
    @BindView(R.id.ll_touzi)
    LinearLayout llTouzi;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_me)
    LinearLayout llMe;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.ll_more)
    LinearLayout llMore;

    private Fragment homeFragment,meFragment,moreFragment,touziFragment;
    private  FragmentTransaction ft;

    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ft=getFragmentManager().beginTransaction();
        resetFragment();

    }

    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.ll_home,R.id.ll_touzi,R.id.ll_more,R.id.ll_me})
    public void  changeTab(View view){
        ft=getFragmentManager().beginTransaction();
        hideOtherFragment();
        switch (view.getId()){
            case R.id.ll_home:
                if(homeFragment==null){
                    homeFragment=new HomeFragment();
                    ft.add(R.id.main_content,homeFragment);
                }
                ft.show(homeFragment);
                ivHome.setImageResource(R.drawable.bid01);
                tvHome.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;
            case R.id.ll_touzi:
                Log.i(TAG,"22222");
                if(touziFragment==null){
                    touziFragment=new TouziFragment();
                    ft.add(R.id.main_content,touziFragment);
                }
                ft.show(touziFragment);
                ivTouzi.setImageResource(R.drawable.bid03);
                tvTouzi.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;
            case R.id.ll_me:
                Log.i(TAG,"44444");
                if(meFragment==null){
                    meFragment=new MeFragment();
                    ft.add(R.id.main_content,meFragment);
                }
                ivMe.setImageResource(R.drawable.bid05);
                tvMe.setTextColor(getResources().getColor(R.color.home_back_selected));
                ft.show(meFragment);
                break;
            case R.id.ll_more:
                Log.i(TAG,"33333");
                if(moreFragment==null){
                    moreFragment=new MoreFragment();
                    ft.add(R.id.main_content,moreFragment);
                }
                ivMore.setImageResource(R.drawable.bid07);
                tvMore.setTextColor(getResources().getColor(R.color.home_back_selected));
                ft.show(moreFragment);
                break;
        }
        ft.commit();
    }

    private void resetFragment() {
        if(homeFragment==null){
            homeFragment=new HomeFragment();
            ft.add(R.id.main_content,homeFragment);
        }else {
            ft.show(homeFragment);
        }
        ivHome.setImageResource(R.drawable.bid01);
        tvHome.setTextColor(getResources().getColor(R.color.home_back_selected));
        ft.commit();
    }

    private void hideOtherFragment() {
        if(homeFragment!=null){
            ft.hide(homeFragment);
            ivHome.setImageResource(R.drawable.bid02);
            tvHome.setTextColor(getResources().getColor(R.color.home_back_unselected));
        }
        if(touziFragment!=null){
            ivTouzi.setImageResource(R.drawable.bid04);
            tvTouzi.setTextColor(getResources().getColor(R.color.home_back_unselected));
            ft.hide(touziFragment);
        }
        if(meFragment!=null){
            ivMe.setImageResource(R.drawable.bid06);
            tvMe.setTextColor(getResources().getColor(R.color.home_back_unselected));
            ft.hide(meFragment);
        }
        if(moreFragment!=null){
            ivMore.setImageResource(R.drawable.bid08);
            tvMore.setTextColor(getResources().getColor(R.color.home_back_unselected));
            ft.hide(moreFragment);
        }
    }

}
