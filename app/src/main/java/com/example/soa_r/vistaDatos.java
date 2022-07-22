package com.example.soa_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.os.Bundle;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class vistaDatos extends AppCompatActivity {



    List<CarouselItem> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_datos);

        ImageCarousel carousel = findViewById(R.id.carousel);
        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));

        carousel.addData(list);


    }
}