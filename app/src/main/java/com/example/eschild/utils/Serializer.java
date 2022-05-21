package com.example.eschild.utils;//package com.example.eschild.utils;
//
//import android.content.Context;
//
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//
//
//public abstract class Serializer {
//    public static void serialize(String file, Object object, Context context){
//        try{
//            FileOutputStream f = context.openFileOutput(file, Context.MODE_PRIVATE);
//            ObjectOutputStream oos;
//            try{
//                oos = new ObjectOutputStream(f);
//                oos.write(object);
//                oos.flush();
//                oos.close();
//            }
//            catch (Exception e){
//                throw e;
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
