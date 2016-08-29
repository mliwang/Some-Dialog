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
    //��ͨ�Ի���
    public void click1(View v){
    	//�˴�ֻ����this,this�̳���context
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("����Ԥ��");
    	builder.setMessage("׼�����أ�");
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "�������ء���������", 1).show();
				// TODO Auto-generated method stub
				
			}
		});
    	builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "ȡ�����ء���������", 1).show();
				
			}
		});
    	builder.show();
    	
    	
    	
    	
    }
    //��ѡ�Ի���
    public void click2(View v){
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("��ѡ��γ�");
    	final String items[]={"jAVA","C++","C#","basic","IOS","HIS"};
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "��ǰ��ѡ�γ���"+items[which], 1).show();
				dialog.dismiss();
				
			}
		});
    	builder.show();
    }
    //��ѡ�Ի���
    public void click3(View v){
    	AlertDialog.Builder builder =new Builder(this);
    	builder.setTitle("��ѡ������ϲ���Ե�ˮ��");
    	final String items[]={"�㽶","����","ƻ��","���ܹ�","����","����"};
    	final boolean checkedItems[]={false,false,false,false,false,false};
    	builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				//����Щ�Ǳ�ѡ�е�
				
				
				
				
				
			}
		});
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//����Щ�Ǳ�ѡ�е�
				String cache="";
				for (int i = 0; i < checkedItems.length; i++) {
					if(checkedItems[i]){
						String fruit =items[i];
						cache=cache+"��"+fruit;
						
					}
					
				}
				Toast.makeText(getApplicationContext(), cache, 1).show();
				dialog.dismiss();
			}
		});
    	builder.show();
    	
    }
    //progress�Ի���
    public void click4(View v){
    	final ProgressDialog dialog=new ProgressDialog(this);
    	dialog.setTitle("��������������");
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
