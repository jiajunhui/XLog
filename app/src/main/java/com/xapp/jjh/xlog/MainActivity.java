package com.xapp.jjh.xlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xapp.jjh.logtools.tools.XLog;
import com.xapp.jjh.xlog.bean.Product;
import com.xapp.jjh.xlog.bean.ProductImage;
import com.xapp.jjh.xlog.utils.GsonTools;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductImage> images = new ArrayList<>();
        ProductImage productImage;
        for(int i=0;i<10;i++){
            productImage = new ProductImage();
            productImage.setId(10000 + i);
            productImage.setWidth(500*i);
            productImage.setHeight(800*i);
            productImage.setImageUrl("http://img.ikan.cn/sdvnxdnv" + i);
            images.add(productImage);
        }

        Product product = new Product();
        product.setId(100001111);
        product.setpName("Animal");
        product.setPrice(5486.00);
        product.setImages(images);

        String json = GsonTools.createGsonString(product);
        XLog.json(json);
        XLog.fileLog(json);
        XLog.fileLog("TEST_CUS_FILE_NAME" + System.currentTimeMillis(),json);
        try{
            int i = 9/0;
        }catch (Exception e){
            XLog.fileLogException(e);
            XLog.fileLogException("EXCEPTION_TEST",e);
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        XLog.d("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        XLog.d("onResume");
        XLog.printMethodCallStatck();
    }

    @Override
    protected void onPause() {
        super.onPause();
        XLog.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        XLog.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d("onDestroy");
    }
}
