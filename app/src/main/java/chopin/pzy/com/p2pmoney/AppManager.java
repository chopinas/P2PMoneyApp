package chopin.pzy.com.p2pmoney;

import android.app.Activity;

import java.util.Stack;

public class AppManager {

    private Stack<Activity> activityStack=new Stack();

    private AppManager appManager=null;

    private AppManager(){
    }

    public AppManager getInstance() {
        if(appManager==null){
            appManager=new AppManager();
        }
        return appManager;
    }

    public void addActivity(Activity activity){
        activityStack.add(activity);
    }
    
    public void removeActivity(Activity activity){
        for (int i = activityStack.size(); i>=0 ; i--) {
            if(activityStack.get(i).getClass().equals(activity.getClass())){
                activity.finish();
                activityStack.remove(activity);
                break;
            }
        }
    }

    public void removeCurrentActivity(){
        Activity currentActivity=activityStack.lastElement();
        currentActivity.finish();
        activityStack.remove(currentActivity);
    }

    public void removeAll(){
        for (int i = activityStack.size(); i>=0 ; i--) {
            activityStack.get(i).finish();
            activityStack.remove(activityStack.get(i));
        }
    }

    public int getSize(){
        return activityStack.size();
    }
}
