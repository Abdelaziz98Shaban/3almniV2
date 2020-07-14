package com.example.android.miwok;

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

public class WordAdapter extends ArrayAdapter<Word> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        //     // resource refer to an xml file id  is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0. because i'll fill it manually in getView method

        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        // convertView refers to the recyclerView that needs to be populated
        View listItemView = convertView;
        if (listItemView == null) {
            // null here means that is no view that we can reuse and this happens only when you open the activity for the first time then after filing it it won't be null again
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            // false here means we don't wanna attach list_item view to the parent  list view
        }
        // Get the {@link word} object located at this position in the list
        // getItem is a public method from ArrayAdapter
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version name from the current word object and
        // set this text on the name TextView
        englishTextView.setText(currentWord.getmDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView arabicTextView = (TextView) listItemView.findViewById(R.id.arabic_text_view);
        // Get the version number from the current word object and
        // set this text on the number TextView
        arabicTextView.setText(currentWord.getmArabicTranslation());



        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
          ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            iconView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to by contextCompat which Returns a color associated with a particular resource ID
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}