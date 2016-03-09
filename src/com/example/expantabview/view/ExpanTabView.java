package com.example.expantabview.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.example.expantabview.R;

public class ExpanTabView extends LinearLayout
{
    
    private Context mContext;
    
    private ArrayList<String> mTextArray;
    
    private ArrayList<View> mViewArray;
    
    private ToggleButton selectionButton;
    
    public ExpanTabView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        this.mContext = context;
        //设置水平布局
        setOrientation(LinearLayout.HORIZONTAL);
    }
    
    public void setTabTextView(ArrayList<String> textArray, ArrayList<View> viewArray)
    {
        mTextArray = textArray;
        mViewArray = viewArray;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        for(int i = 0; i < textArray.size(); i++)
        {
            ToggleButton tabButton = (ToggleButton)inflater.inflate(R.layout.tab_button, this, false);
            tabButton.setText(textArray.get(i));
            addView(tabButton);
            tabButton.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    ToggleButton tButton = (ToggleButton)view;
                    if(selectionButton != null && selectionButton != tButton)
                    {
                        selectionButton.setChecked(false);
                    }
                    selectionButton = tButton;
                }
            });
        }
    }
}
