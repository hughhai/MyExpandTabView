package com.example.expantabview.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.example.expantabview.R;

public class ExpandTabView extends LinearLayout
{
    
    private Context mContext;
    
    private ArrayList<String> mTextArray;
    
    private ArrayList<View> mViewArray = new ArrayList<View>();
    
    private ArrayList<ToggleButton> mToggleButton = new ArrayList<ToggleButton>();
    
    private ToggleButton selectedButton;
    
    private int selectedPosition;
    
    private PopupWindow popuWindow;
    
    public ExpandTabView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }
    
    private void init(Context context)
    {
        this.mContext = context;
        // 设置水平布局
        setOrientation(LinearLayout.HORIZONTAL);
    }
    
    public void setTabTextView(ArrayList<String> textArray, ArrayList<View> viewArray)
    {
        mTextArray = textArray;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        for (int i = 0; i < textArray.size(); i++)
        {
            // Tab Button布局
            ToggleButton tabButton = (ToggleButton)inflater.inflate(R.layout.tab_button, this, false);
            tabButton.setText(textArray.get(i));
            addView(tabButton);
            tabButton.setTag(i);
            tabButton.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    ToggleButton tButton = (ToggleButton)view;
                    if (selectedButton != null && selectedButton != tButton)
                    {
                        selectedButton.setChecked(false);
                    }
                    selectedButton = tButton;
                    selectedPosition = (Integer)view.getTag();
                    startAnimation();
                }
            });
            mToggleButton.add(tabButton);
            
            // popuwindow中的view布局
            RelativeLayout rlLayout = new RelativeLayout(mContext);
            RelativeLayout.LayoutParams rlLayoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlLayout.addView(viewArray.get(i), rlLayoutParams);
            rlLayout.setBackgroundResource(R.drawable.popuwindow_bg);
            rlLayout.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View arg0)
                {
                    if (popuWindow != null && popuWindow.isShowing())
                    {
                        popuWindow.dismiss();
                        selectedButton.setChecked(false);
                    }
                }
            });
            mViewArray.add(rlLayout);
            
        }
    }
    
    private void startAnimation()
    {
        if (popuWindow == null)
        {
            popuWindow = new PopupWindow(mViewArray.get(selectedPosition), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        
        if (selectedButton.isChecked())
        {
            if (popuWindow.isShowing())
            {
                popuWindow.dismiss();
                popuWindow.setContentView(mViewArray.get(selectedPosition));
                popuWindow.showAsDropDown(this, 0, 0);
            }
            else
            {
                popuWindow.setContentView(mViewArray.get(selectedPosition));
                popuWindow.showAsDropDown(this, 0, 0);
            }
        }
        else
        {
            if (popuWindow.isShowing())
            {
                popuWindow.dismiss();
            }
        }
    }
    
    public void setSelValue(int tabPos, String text)
    {
        mToggleButton.get(tabPos).setText(text);
        if (popuWindow.isShowing())
        {
            popuWindow.dismiss();
        }
        selectedButton.setChecked(false);
    }
}
