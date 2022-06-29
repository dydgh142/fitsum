package org.tensorflow.lite.examples.posenet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.miguelrochefort.fitnesscamera.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
/*
public class SliderAdapter extends SliderViewAdapter<SliderViewAdapter.ViewHolder> {

    int[] images;

    public  SliderAdapter(int[] images){

        this.images=images;
    }

    //여기서부터 지우고 다시 해보기.

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.imageView.setImageResource(images[position]);

    }

    @Override
    public  int getCount(){
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{

        ImageView imageView;

        public  Holder(View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.image_view);


        }

    }
}*/
