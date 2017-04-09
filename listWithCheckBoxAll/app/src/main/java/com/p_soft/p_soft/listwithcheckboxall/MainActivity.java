package com.p_soft.p_soft.listwithcheckboxall;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {







    Button btnfindall;
    ArrayList<String> listarray = new ArrayList<String>();





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listarray.add("A");
        listarray.add("B");
        listarray.add("C");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listarray);
        getListView().setAdapter(adapter);

        /** Defining checkbox click event listener **/
        final OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chk = (CheckBox) v;
                int itemCount = getListView().getCount();
                for(int i=0 ; i < itemCount ; i++){

                    getListView().setItemChecked(i, chk.isChecked());

                }
            }
        };


        /////////////////////////////////////////////////////

        final OnClickListener clickListener1 = new OnClickListener() {
            @Override
            public void onClick(View v) {

                int itemCount = getListView().getCount();

                for(int i=0 ; i < itemCount ; i++){


                }
            }
        };

        //////////////////////////////////////////////////////

        /** Defining click event listener for the listitem checkbox */
        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                CheckBox chk = (CheckBox) findViewById(R.id.chkAll);
                int checkedItemCount = getCheckedItemCount();

                if(getListView().getCount()==checkedItemCount)
                    chk.setChecked(true);
                else
                    chk.setChecked(false);
            }
        };

        /** Getting reference to checkbox available in the main.xml layout */
        final CheckBox chkAll =  ( CheckBox ) findViewById(R.id.chkAll);

        /** Setting a click listener for the checkbox **/
        chkAll.setOnClickListener(clickListener);

        /** Setting a click listener for the listitem checkbox **/
        getListView().setOnItemClickListener(itemClickListener);


    ////////////////////////



    }


    private int getCheckedItemCount(){
        int cnt = 0;
        SparseBooleanArray positions = getListView().getCheckedItemPositions();
        int itemCount = getListView().getCount();

        for(int i=0;i<itemCount;i++){
            if(positions.get(i))
                cnt++;
        }

        return cnt;
    }
}