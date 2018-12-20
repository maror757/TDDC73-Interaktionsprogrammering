package com.example.laboration3;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class InteractiveSearcher extends LinearLayout {

    private EditText editText;
    private Context context;
    private String history = ""; // Keeping the latest written/clicked string. Used for closing the popup window.
    private String urlBase = "https://andla.pythonanywhere.com/getnames";
    private ArrayList<String> searchResults;
    private URL url; // The URL for each search
    private int MAX_N;
    private Integer ID; // Stores the ID of every search. Every search has an unique ID.
    private TextView textView;
    private ListPopupWindow listpopupWindow; // The popup window used in this module.
    private PopupAdapter popupAdapter;


    public InteractiveSearcher(Context context, int max_N, TextView tv) {
        super(context);
        this.context = context;
        editText = new EditText(context);
        editText.setSingleLine(true);
        editText.setHint("Search name...");
        MAX_N = max_N;
        ID = 0;
        textView = tv;

        setListeners();

        LayoutParams editTextParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
        this.addView(editText, editTextParams);



        listpopupWindow = new ListPopupWindow(context);
            listpopupWindow.setAnchorView(editText);

        // TODO: Dynamisk Width & Height
            listpopupWindow.setWidth(500);
            listpopupWindow.setHeight(300);
            listpopupWindow.setModal(false);

        // On click listener for items in popup
            listpopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                history = searchResults.get(position);
                editText.setText(searchResults.get(position));
                //listpopupWindow.dismiss();
            }
        });
    }

    // Create listeners for the interactive searcher
    private void setListeners()
    {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            // The only listener needed. Checks after we changed the text.
            @Override
            public void afterTextChanged(Editable arg0) {

                // Dont do any unnecessary searches. Check if the query is the same as the history.
                if(!(history.toLowerCase()).equals(arg0.toString().toLowerCase()))
                {
                    // Search with the given query and add +1 to the ID.
                    // Each search will have a unique ID.
                    String searchName = "/" + ID + "/" + arg0.toString();
                    fetchDataFromServer(searchName);
                    ID++;
                    history = arg0.toString();
                    textView.setText(searchName);
                }
            }
        });
    }

    private void printResults()
    {
        for(String s : searchResults)
        {
            System.out.print(s + "/");
        }
        System.out.println("");
    }

    // Fetches data from the server (web-page)
    private void fetchDataFromServer(String query)  {

        // Create the url
        String searchedItemURL = urlBase + query;

        // Do the thread thing...
        new RetrieveSearchResult().execute(searchedItemURL);
        //new RetrieveSearchResult();
    }

    // Private class for the search function on an other thread
    private class RetrieveSearchResult extends AsyncTask<String, Void, ArrayList<String>> {

        // Private variables
        private Exception exception;

        // Do in Background
        @Override
        protected ArrayList<String> doInBackground(String... url_string) {
            String webpageOutput;
            ArrayList<String> tempList = new ArrayList<>();

            try{
                url = new URL(url_string[0]);
            }
            catch (MalformedURLException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

            HttpURLConnection urlConnection = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                webpageOutput = readStream(in);
            } catch (IOException e) {
                webpageOutput = "Failure!";
                e.printStackTrace();
            } finally{
                urlConnection.disconnect();
            }

            tempList = string2arrayList(webpageOutput);

            return tempList;

        }


        // After execute
        @Override
        protected void onPostExecute(ArrayList<String> nameList) {
            searchResults = nameList;

            // Check if there is any names in the list
            if(searchResults.isEmpty()) // Close popup if no names
            {
                listpopupWindow.dismiss();
            }
            else // Push the names to the popup
            {
                // Trace the result
                printResults();

                // Prepare the adapter
                popupAdapter = new PopupAdapter(context, searchResults);
                listpopupWindow.setAdapter(popupAdapter);

                // Show the popup window when typing text
                listpopupWindow.show();
            }
        }

        // Extract words from the web-page stream and put them in a list
        private ArrayList<String> string2arrayList(String webpageOutput)
        {
            String word = "";
            ArrayList<String> tempList = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder(webpageOutput);
            int count = 0;

            for (int i = 0; i < stringBuilder.length(); i++)
            {
                Character charAt = stringBuilder.charAt(i);
                if(Character.isAlphabetic(charAt) || Character.isDigit(charAt))
                {
                    word = word + charAt;
                }
                else
                {
                    if(word.isEmpty() == false)
                    {
                        // Since we know that the names start after "id", "<int>", "result".
                        // We only extract the names -> (count > 2)
                        if(count > 2)
                            tempList.add(word);

                        count++;
                    }
                    word = "";
                }
                if(count > (MAX_N + 2) && (MAX_N != -1))
                    break;
            }

            return tempList;
        }

        // Read the stream (web-page) and return as string
        private String readStream(InputStream is) throws IOException {
            StringBuilder sb = new StringBuilder();
            BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
            for (String line = r.readLine(); line != null; line =r.readLine()){
                sb.append(line);
            }
            is.close();
            return sb.toString();
        }
    }
}
