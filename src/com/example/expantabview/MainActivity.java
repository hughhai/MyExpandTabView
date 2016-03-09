package com.example.expantabview;

import java.util.ArrayList;

import com.example.expantabview.view.ExpanTabView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity
{

    private ExpanTabView expandtabview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandtabview = (ExpanTabView)findViewById(R.id.expandtabview);
        ArrayList<String> textArray = new ArrayList<String>();
        textArray.add("��Ŀ����");
        textArray.add("��Ŀ����");
        textArray.add("רҵ���");
        expandtabview.setTabTextView(textArray, null);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
