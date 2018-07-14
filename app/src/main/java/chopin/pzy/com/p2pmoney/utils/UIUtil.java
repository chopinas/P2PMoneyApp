package chopin.pzy.com.p2pmoney.utils;


import chopin.pzy.com.p2pmoney.common.MyApplication;

public class UIUtil {

    public static int getColor(int colorId) {
       return MyApplication.mContext.getResources().getColor(colorId);
    }

    public static String[] getStringArr(int arrId) {
        return MyApplication.mContext.getResources().getStringArray(arrId);
    }

    /**
     * 1dp---1px;
     * 1dp---0.75px;
     * 1dp---0.5px;
     * ....
     *
     * @param dp
     * @return
     */
    public static int dp2px(int dp) {
        float density =MyApplication.mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    public static int px2dp(int px) {
        float density =MyApplication.mContext.getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }

}
