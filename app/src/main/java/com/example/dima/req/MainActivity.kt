package com.example.dima.req

import android.app.Activity
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dima.req.extensions.registerDeserializer
import com.example.dima.req.model.Organizations
import com.example.dima.req.model.ParseOrganization

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

import java.net.URISyntaxException
import java.net.URL
import java.util.Scanner
import java.util.zip.GZIPInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

import lzma.sdk.lzma.Decoder
import lzma.streams.LzmaInputStream
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.functions.Action1
import rx.functions.Func1
import rx.schedulers.Schedulers
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val am = this.assets
        var fileDescriptor: InputStream? = null

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
            var gson = GsonBuilder()
                    .registerDeserializer(Organizations.deserializer())
                    .registerDeserializer(ParseOrganization.deserializer()).create()
            fileDescriptor = am.open("5.json")
//            fileDescriptor = am.open("app_34.json.zip")
            val zipInputStream = ZipInputStream(fileDescriptor)
            zipInputStream.nextEntry

            val s = Scanner(fileDescriptor).useDelimiter("\\A")
            val result = if (s.hasNext()) s.next() else ""
            val js = getString(R.string.json)
//            var reader = JsonReader(InputStreamReader(fileDescriptor,"UTF-8"));
//            reader.beginArray()
            var  reader = JsonReader(StringReader(js));

            val orgType= object : TypeToken<Organizations>() {}.type
            gson.fromJson<Organizations>(reader,orgType)

//            val reader = JsonReader(InputStreamReader(zipInputStream))
//            val sc = Scanner(zipInputStream)
//            reader.beginArray()
//            val orgType= object : TypeToken<ParseOrganization>() {}.type
//            while (reader.hasNext()){
//               val org = gson.fromJson<ParseOrganization>(reader,orgType)
//                Log.d("ParseOrganization",org.source_name)
//            }
//            reader.close()

//            while (sc.hasNextLine()) {
//                                System.out.println(sc.next());
//            }
            //            unzip(f,null);

            //            readCompressedStringFromFile(stream);
        } catch (e: IOException) {
            e.printStackTrace()
        }

        //        File file = new File(am.getLocales()+"app_34.json.lzma");

    }

//    private fun createFileFromInputStream(inputStream: InputStream): File? {
//
//        try {
//            val f = File("app_34.json")
//            val outputStream = FileOutputStream(f)
//            val buffer = ByteArray(1024)
//            var length = 0
//
//            while ((length = inputStream.read(buffer)) > 0) {
//                outputStream.write(buffer, 0, length)
//            }
//
//            outputStream.close()
//            inputStream.close()
//
//            return f
//        } catch (e: IOException) {
//            //Logging exception
//        }
//
//        return null
//    }
//
//    fun unzip(_zipFile: File, _targetLocation: String) {
//
//        //create target location folder if not exist
//
//        try {
//            val fin = FileInputStream(_zipFile)
//            val zin = ZipInputStream(fin)
//            var ze: ZipEntry? = null
//            while ((ze = zin.nextEntry) != null) {
//                val fout = FileOutputStream(_targetLocation + ze!!.name)
//                var c = zin.read()
//                while (c != -1) {
//                    fout.write(c)
//                    c = zin.read()
//                }
//
//                zin.closeEntry()
//                fout.close()
//
//            }
//            zin.close()
//        } catch (e: Exception) {
//            println(e)
//        }
//
//    }

    companion object {

        //
        //    public static LzmaInputStream readLzmaStream(final InputStream receiver, final OutputStream output) throws IOException {
        //        final LzmaInputStream input = new LzmaInputStream(receiver, new Decoder());
        //        StreamCopy.copy(input, output);
        //        return input;
        //    }

        @Throws(IOException::class)
        fun readCompressedStringFromFile(fileInput: FileInputStream) {
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
    }

}
