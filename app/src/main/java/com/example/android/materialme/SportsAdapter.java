/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialme;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/***
 * The adapter class for the RecyclerView, contains the sports data.
 */
class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param sportsData ArrayList containing the sports data.
     * @param context Context of the application.
     */
    SportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sport currentSport = mSportsData.get(position);

        // Set background for the title TextView based on sport title
        int backgroundResource = getBackgroundResource(currentSport.getTitle());
        holder.mTitleText.setBackgroundResource(backgroundResource);

        holder.bindTo(currentSport);
    }


    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
        }

        void bindTo(Sport currentSport){
            // Populate the textviews with data.
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

        }
    }

    private int getBackgroundResource(String title) {
        // You can implement your logic to determine the background image based on the title
        // For demonstration purposes, let's assume some basic logic here
        if (title.equalsIgnoreCase("Baseball")) {
            return R.drawable.img_basketball; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Basketball")) {
            return R.drawable.img_baseball; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Bowling")) {
            return R.drawable.img_bowling; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Cycling")) {
            return R.drawable.img_cycling; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Soccer")) {
            return R.drawable.img_soccer; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Swimming")) {
            return R.drawable.img_swimming; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Tennis")) {
            return R.drawable.img_tennis; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("TableTennis")) {
            return R.drawable.img_baseball; // Replace with your actual image file
        } else if (title.equalsIgnoreCase("Running")) {
            return R.drawable.img_running;
        } else if (title.equalsIgnoreCase("Golf")) {
            return R.drawable.img_golf;
        } else if (title.equalsIgnoreCase("Badminton")) {
            return R.drawable.img_badminton; // Replace with your actual image file
        } else {
            // Default background image if no match is found
            return R.drawable.img_basketball; // Replace with your actual default image file
        }
    }

    public void deleteItem(int position) {
        mSportsData.remove(position);
        notifyItemRemoved(position);
    }


    public void onItemMove(int fromPosition, int toPosition) {
        // Cambia la posición de los elementos en la lista
        Collections.swap(mSportsData, fromPosition, toPosition);
        // Notifica al adaptador que los elementos han cambiado de posición
        notifyItemMoved(fromPosition, toPosition);
    }


}
