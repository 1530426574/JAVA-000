package src.louis.homework;


import java.io.*;
import java.net.Socket;
import java.nio.CharBuffer;

import okhttp3.*;

class OKHttpClient {
    public static void main(String[] args) throws IOException {
        OKHttpClient okHttpClient = new OkHttpClient();

        Request build = new Request.Builder()
                .get()
                .url("http://localhost:8801")
                .addHeader("Connection", "close")
                .build();

        Response response = okHttpClient.newCall(build).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        Reader reader = response.body().charStream();
        CharBuffer buf = CharBuffer.allocate(10);
        reader.read(buf);

        buf.flip();
        char[] dst = new char[buf.limit()];
        buf.get(dst, 0 , buf.limit());
        System.out.println(dst);

    }
}