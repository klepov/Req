package com.example.dima.req;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import lzma.sdk.lzma.Decoder;
import lzma.streams.LzmaInputStream;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AssetManager am = this.getAssets();
        InputStream fileDescriptor = null;
//
//        try {
//            fileDescriptor = am.openFd("app_34.json.gz");
//            FileInputStream stream = fileDescriptor.createInputStream();
//            ZipInputStream zis = new ZipInputStream(stream);
//            ZipEntry entry;
//
//            while ((entry = zis.getNextEntry()) != null)
//            {
//                System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
//                // consume all the data from this entry
//                while (zis.available() > 0)
//                    zis.read();
//                // I could close the entry, but getNextEntry does it automatically
//                // zis.closeEntry()
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            InputStream open = getResources().getAssets().open("app_34.json.lzma");
//            ZipEntry sd = zipFile.getEntry();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

        try {
//            URL url = getClass().getResource("/assets/app_34.json.zip");
//            File f = new File("file:/data/app/com.example.dima.req-2/base.apk!/assets/app_34.json.zip");
            fileDescriptor = am.open("app_34.json.zip");
            ZipInputStream zipInputStream = new ZipInputStream(fileDescriptor);
            zipInputStream.getNextEntry();

            Scanner sc = new Scanner(zipInputStream);
            while (sc.hasNextLine()) {
                System.out.println(sc.next());
            }
//            unzip(f,null);

//            readCompressedStringFromFile(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File file = new File(am.getLocales()+"app_34.json.lzma");

    }

    private File createFileFromInputStream(InputStream inputStream) {

        try{
            File f = new File("app_34.json");
            OutputStream outputStream = new FileOutputStream(f);
            byte buffer[] = new byte[1024];
            int length = 0;

            while((length=inputStream.read(buffer)) > 0) {
                outputStream.write(buffer,0,length);
            }

            outputStream.close();
            inputStream.close();

            return f;
        }catch (IOException e) {
            //Logging exception
        }

        return null;
    }

//
//    public static LzmaInputStream readLzmaStream(final InputStream receiver, final OutputStream output) throws IOException {
//        final LzmaInputStream input = new LzmaInputStream(receiver, new Decoder());
//        StreamCopy.copy(input, output);
//        return input;
//    }

    public static void readCompressedStringFromFile(final  FileInputStream fileInput) throws IOException {
//        Observable.just(fileInput)
//                .subscribeOn(Schedulers.io())
//                .doOnNext(new Action1<FileInputStream>() {
//                    @Override
//                    public void call(FileInputStream fileInputStream) {
//                        try {
//                            final BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
//                            final ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
//                            final BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(byteArrayOutputStream);
//
//                            final LzmaInputStream lzmaStream = readLzmaStream(bufferedInputStream, bufferedOutputStream);
//
//                            bufferedOutputStream.flush();
//                            final String str = byteArrayOutputStream.toString("UTF-8");
//
//                            lzmaStream.close();
//                            fileInputStream.close();
//                            bufferedInputStream.close();
//                            byteArrayOutputStream.close();
//                            bufferedOutputStream.close();
////                            return str;
//
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                })
//                .map(new Func1<FileInputStream, String>() {
//                    @Override
//                    public String call(FileInputStream fileInputStream) {
//                        return "s";
//                    }
//                })
////                .map(new Func1<FileInputStream, String>() {
////                    @Override
////                    public String call(FileInputStream fileInputStream) {
////                        try {
////                            final BufferedInputStream bufferedInputStream= new BufferedInputStream(fileInputStream);
////                            final ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
////                            final BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(byteArrayOutputStream);
////
////                            final LzmaInputStream lzmaStream = readLzmaStream(bufferedInputStream, bufferedOutputStream);
////
////                            bufferedOutputStream.flush();
////                            final String str = byteArrayOutputStream.toString("UTF-8");
////
////                            lzmaStream.close();
////                            fileInputStream.close();
////                            bufferedInputStream.close();
////                            byteArrayOutputStream.close();
////                            bufferedOutputStream.close();
////                            return str;
////
////                        } catch (UnsupportedEncodingException e) {
////                            e.printStackTrace();
////                        } catch (IOException e) {
////                            e.printStackTrace();
////                        }
////                        return "";
////                    }})
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d("sd",s);
//                    }
//                });
    }

    public void unzip(File _zipFile, String _targetLocation) {

        //create target location folder if not exist

        try {
            FileInputStream fin = new FileInputStream(_zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream(_targetLocation + ze.getName());
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }

                zin.closeEntry();
                fout.close();

            }
            zin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
