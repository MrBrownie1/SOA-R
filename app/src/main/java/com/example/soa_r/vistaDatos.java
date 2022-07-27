package com.example.soa_r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class vistaDatos extends AppCompatActivity {



    List<CarouselItem> list = new ArrayList<>();

    private Button _btn_link;
    String _url = "https://therapeutic-frequent-collision.glitch.me";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_datos);

        ImageCarousel carousel = findViewById(R.id.carousel);
        list.add(new CarouselItem("https://www.ilovepozarica.com/wp-content/uploads/2019/04/624216-N.jpg"));
        list.add(new CarouselItem("https://www.lavoz.com.ar/resizer/RtMILJPilyuk8lsrLhQ4Np9q9z0=/1023x682/smart/cloudfront-us-east-1.images.arcpublishing.com/grupoclarin/YYKCB22QNBAKLB6Q5WJXDQA62M.jpg"));
        list.add(new CarouselItem("https://www.municipiosoledad.gob.mx/sites/default/files/styles/estilo_imagen_1296x624/public/noticias/2019-11/PARTICIPACION%20CIUDADAN%20A%20%20%281%29.jpeg?itok=4NVM820B"));
        list.add(new CarouselItem("https://s3.amazonaws.com/mundo-bucket-s3/wp-content/uploads/2020/11/20224234/IMG_1605920786614.jpg"));
        list.add(new CarouselItem("https://s3.amazonaws.com/mundo-bucket-s3/wp-content/uploads/2019/10/24080013/36-544284bazar_ropa.jpg"));

        carousel.addData(list);


        _btn_link = findViewById(R.id.boton_link);

        _btn_link.setOnClickListener(view -> {
            Uri _link = Uri.parse(_url);
            Intent i = new Intent(Intent.ACTION_VIEW,_link);
            startActivity(i);
            Log.d("click", "ok");
        });


    }
}