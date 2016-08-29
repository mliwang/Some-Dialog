package cn.itcast.dialog;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      
    }
    //普通对话框
    public void click1(View v){
    	//此处只能填this,this继承了context
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("高能预警");
    	builder.setMessage("准备下载？");
    	builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "正在下载。。。。。", 1).show();
				// TODO Auto-generated method stub
				
			}
		});
    	builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "取消下载。。。。。", 1).show();
				
			}
		});
    	builder.show();
    	
    	
    	
    	
    }
    //单选对话框
    public void click2(View v){
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("请选择课程");
    	final String items[]={"jAVA","C++","C#","basic","IOS","HIS"};
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "当前所选课程是"+items[which], 1).show();
				dialog.dismiss();
				
			}
		});
    	builder.show();
    }
    //多选对话框
    public void click3(View v){
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("请选择你最喜欢吃的水果");
    	final String items[]={"香蕉","西瓜","苹果","哈密瓜","葡萄","柿子"};
    	final boolean checkedItems[]={false,false,false,false,false,false};
    	builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				//查哪些是被选中的
				
				
				
				
				
			}
		});
    	builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//查哪些是被选中的
				String cache="";
				for (int i = 0; i < checkedItems.length; i++) {
					if(checkedItems[i]){
						String fruit =items[i];
						cache=cache+"、"+fruit;
						
					}
					
				}
				Toast.makeText(getApplicationContext(), cache, 1).show();
				dialog.dismiss();
			}
		});
    	builder.show();
    	
    }
    //progress对话框
    public void click4(View v){
    	final ProgressDialog dialog=new ProgressDialog(this);
    	dialog.setTitle("正在玩命加载中");
    	dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    	dialog.setMax(100);
    	for (int i = 0; i < 100; i++) {
			
		}
    	dialog.show();
    	new Thread(){public void run() {
    		dialog.setMax(100);
        	for (int i = 0; i < 100; i++) {
        		
        		dialog.setProgress(i);
        		SystemClock.sleep(50);
    			
    		}
        	dialog.dismiss();
    	};}.start();
    	
    }

}
