package com.example.mappelito.laboration2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.mappelito.laboration2.adapter.ExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private EditText editTextView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<Integer, List<String>> listDataChild;

    boolean isPart = true;
    boolean isComplete = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();


        editTextView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String query = s.toString();
                /*Toast.makeText(getApplicationContext(),
                        query,
                        Toast.LENGTH_SHORT).show();*/
                List<String> grp;
                int childIndex = -1;
                int groupIndex = -1;
                int hashKey;
                String title = "";
                String listItem = "";
                String completeWord = "";
                String completeWordLowercase = "";
                String queryLowercase = "";

                if (!query.isEmpty()) {
                    outerloop:
                    {
                        for (HashMap.Entry<Integer, List<String>> entry : listDataChild.entrySet()) {
                            grp = entry.getValue();
                            hashKey = entry.getKey();
                            groupIndex = hashKey;
                            title = listDataGroup.get(groupIndex);

                            for (int i = 0; i < grp.size(); i++) {

                                listItem = grp.get(i);

                                completeWord = "/" + title + "/" + listItem;
                                completeWordLowercase = completeWord.toLowerCase();
                                queryLowercase = query.toLowerCase();

                                if (completeWordLowercase.equals(queryLowercase)) {
                                    isComplete = true;
                                    isPart = false;
                                    childIndex = i;
                                    break outerloop;

                                } else if (completeWordLowercase.startsWith(queryLowercase)) {
                                    isComplete = false;
                                    isPart = true;
                                    childIndex = i;
                                    break outerloop;
                                } else {
                                    isPart = false;
                                    isComplete = false;
                                    childIndex = -1;
                                    expandableListView.setItemChecked(-1, true);
                                }
                            }
                        }
                    }


                    if (isComplete) {
                        expandableListView.expandGroup(groupIndex, true);
                        int index = expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupIndex, childIndex));
                        expandableListView.setItemChecked(index, true);
                        editTextView.setBackgroundColor(Color.TRANSPARENT);
                    } else if (isPart) {
                        editTextView.setBackgroundColor(Color.TRANSPARENT);
                    } else {
                        editTextView.setBackgroundColor(Color.RED);
                    }

                } else {
                    editTextView.setBackgroundColor(Color.TRANSPARENT);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }


    /**
     * method to initialize the views
     */

    private void initViews() {

        expandableListView = findViewById(R.id.expandableListView);
        editTextView = findViewById(R.id.editText);
    }

    /**
     * method to initialize the listeners
     */
    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                editTextView.setText("/"+ listDataGroup.get(groupPosition)
                        + "/"
                        + listDataChild.get(groupPosition).get(
                        childPosition));

                int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
                parent.setItemChecked(index, true);

                return true;
            }
        });

        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*(editTextView.setText("/" +
                        listDataGroup.get(groupPosition));
            */}
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //editTextView.setText(getString(R.string.search_init));
                expandableListView.setItemChecked(-1, true);
            }
        });

    }
    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {


        // Adding group data
        listDataGroup.add(getString(R.string.text_gtx1000));
        listDataGroup.add(getString(R.string.text_gtx900));
        listDataGroup.add(getString(R.string.text_gtx700));

        // array of strings
        String[] array;

        // list of gtx1000
        List<String> gtx1000List = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_gtx1000);
        for (String item : array) {
            gtx1000List.add(item);
        }

        // list of gtx900
        List<String> gtx900List = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_gtx900);
        for (String item : array) {
            gtx900List.add(item);
        }

        // list of gtx700
        List<String> gtx700List = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_gtx700);
        for (String item : array) {
            gtx700List.add(item);
        }

        // Adding child data
        listDataChild.put(0, gtx1000List);
        listDataChild.put(1, gtx900List);
        listDataChild.put(2, gtx700List);

        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }
}

