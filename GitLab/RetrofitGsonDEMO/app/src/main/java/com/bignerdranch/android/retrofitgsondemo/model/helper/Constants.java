package com.bignerdranch.android.retrofitgsondemo.model.helper;

/**
 * Created by 1 on 23.06.2016.
 */
public class Constants {

    public static class HTTP{

        public static final String BASE_URL="http://services.hanselandpetal.com";
    }

    public static final class DATABASE{

        //DB
        public static final String DB_NAME="myDataBase";
        public static final int DB_VERSION=1;

        //TABLE
        public static final String TABLE_NAME="flowers";

        //COLUMS
        public static final String PRODUCT_ID="productId";
        public static final String CATEGORY="category";
        public static final String PRICE="price";
        public static final String INSTRUCTIONS="instructions";
        public static final String NAME="name";
        public static final String PHOTO="photo";
        public static final String PHOTO_URL="photo_url";

        public static final String DROP_QUERY="DROP TABLE IF EXIST " + TABLE_NAME;

        public static final String GET_FLOWERS_QUERY="SELECT * FROM  " + TABLE_NAME;



        public static final String CREATE_TABLE_QUERY="CREATE TABLE " + TABLE_NAME +
                "("+
                PRODUCT_ID + " PRIMARY KEY , "+
                CATEGORY + " TEXT not null, " +
                PRICE + " VARCHAR(50) not null, " +
                INSTRUCTIONS + " TEXT not null, " +
                NAME + " TEXT not null, " +
                PHOTO_URL + " TEXT not null, " +
                PHOTO+ " blob not null)";




    }
    public static final class REFERENCE{
        public static final String FLOWER="flower";

    }
}
