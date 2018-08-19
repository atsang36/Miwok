package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AndyTsang on 2018-06-24.
 */

public class WordAdapter extends ArrayAdapter {
    private int background_color;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        background_color = colorId;

    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word word = (Word) getItem(position);

        // Find the TextView in the list_item.xml layout with the default translation
        TextView defaultTransTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        defaultTransTextView.setText(word.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTransTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        miwokTransTextView.setText(word.getMiwokTranslation());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_view);
        //Check if image is present in Word instance
        if (word.hasImage()) {
            // Get the image resource ID from the current Word object and
            // set the image to iconView
            //make sure view is visible
            iconView.setImageResource(word.getmImageResourceId());
            iconView.setVisibility(View.VISIBLE);
            //otherwise make view invisible
        }else{
            iconView.setVisibility(View.GONE);
        }


        //Set the theme colour for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the colour that colorId maps to
        int color = ContextCompat.getColor(getContext(),background_color);
        //change the color of the background
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
//    }
}
