package com.example.expantabview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.expantabview.view.ExpandTabView;
import com.example.expantabview.view.OnSelectListener;
import com.example.expantabview.view.ViewLeft;
import com.example.expantabview.view.ViewMid;
import com.example.expantabview.view.ViewRight;

public class MainActivity extends Activity
{
    
    private ExpandTabView expandtabview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandtabview = (ExpandTabView)findViewById(R.id.expandtabview);
        ArrayList<String> textArray = new ArrayList<String>();
        textArray.add("项目进程");
        textArray.add("项目资料");
        textArray.add("专业类别");
        ArrayList<View> viewArray = new ArrayList<View>();
        ViewLeft viewLeft = new ViewLeft(this);
        ViewMid viewMid = new ViewMid(this);
        ViewRight viewRight = new ViewRight(this);
        viewArray.add(viewLeft);
        viewArray.add(viewMid);
        viewArray.add(viewRight);
        viewLeft.setOnSelectListener(new OnSelectListener()
        {
            @Override
            public void selValue(String showText)
            {
                expandtabview.setSelValue(0, showText);
            }
        });
        viewMid.setOnSelectListener(new OnSelectListener()
        {
            @Override
            public void selValue(String showText)
            {
                expandtabview.setSelValue(1, showText);
            }
        });
        viewRight.setOnSelectListener(new OnSelectListener()
        {
            @Override
            public void selValue(String showText)
            {
                expandtabview.setSelValue(2, showText);
            }
        });
        expandtabview.setTabTextView(textArray, viewArray);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
