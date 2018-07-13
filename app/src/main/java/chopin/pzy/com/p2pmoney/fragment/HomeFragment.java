package chopin.pzy.com.p2pmoney.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import chopin.pzy.com.p2pmoney.R;

public class HomeFragment extends Fragment {
    @BindView(R.id.title_left)
    ImageView titleLeft;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.titlt_right)
    ImageView titltRight;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initTitle();
        return view;
    }

    private void initTitle() {
        titleLeft.setVisibility(View.INVISIBLE);
        titltRight.setVisibility(View.INVISIBLE);
        tvContent.setText("首页");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
