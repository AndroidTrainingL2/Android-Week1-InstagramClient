package legochen.yahoo.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import legochen.yahoo.com.myapplication.InstagrmPhoto;

/**
 * Created by legochen on 7/30/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagrmPhoto> {
    // What data do we need from the activity
    // Context, Data Sosurce
    public InstagramPhotosAdapter(Context context, List<InstagrmPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    // What our item looks like
    // Use the template to display each photo


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        InstagrmPhoto photo = getItem(position);
        // Check if we are using a recycled view, if not we need to inflate
        if (convertView == null) {
            // create a new view from template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // Lookup the views for populating the data (image, caption)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        // Insert the model data into each of the view items
        tvCaption.setText(photo.caption);
        // clear out the imageview
        ivPhoto.setImageResource(0);
        // Insert the image using picasso (send out async)
        Picasso.with(getContext()).load(photo.imageURL).into(ivPhoto);
        // Return the created item as a view
        return convertView;
    }
}
