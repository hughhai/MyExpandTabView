package com.example.expantabview.view;

import android.content.Context;
import android.widget.RelativeLayout;

public class BaseTabView extends RelativeLayout
{
    protected OnSelectListener mOnSelectListener;
    
    public BaseTabView(Context context)
    {
        super(context);
    }
    
    public void setOnSelectListener(OnSelectListener onSelectListener)
    {
        mOnSelectListener = onSelectListener;
    }
    
}
