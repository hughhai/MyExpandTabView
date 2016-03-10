package com.example.expantabview.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.expantabview.R;

public class ViewLeft extends BaseTabView
{
    
    private Context mContext;
    
    private ListView listView;
    
    private ListAdapter adapter;
    
    private List<Map<String, String>> data;
    
    public ViewLeft(Context context)
    {
        super(context);
        init(context);
    }
    
    private void init(Context context)
    {
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.view_left_layout, this, true);
        listView = (ListView)findViewById(R.id.leftListview);
        data = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 3; i++)
        {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "left " + i);
            data.add(map);
        }
        adapter = new SimpleAdapter(context, data, android.R.layout.simple_list_item_1, new String[] {"name"}, new int[] {android.R.id.text1});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                if (mOnSelectListener != null)
                {
                    Map<String, String> map = data.get(arg2);
                    mOnSelectListener.selValue(map.get("name"));
                }
            }
        });
    }
}
