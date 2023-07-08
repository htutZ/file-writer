package com.htut.filewriter;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.util.Base64;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.content.ContentResolver;

import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@CapacitorPlugin(name = "FileWriter")
public class FileWriterPlugin extends Plugin {

    
    private static final int CREATE_REQUEST_CODE = 41;

    private PluginCall savedCall;

    @PluginMethod()
    public void createDocument(PluginCall call) {
        this.savedCall = call;

        String fileName = call.getString("fileName");

        Activity activity = getActivity();
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);

        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/vnd.openxmlformats-officedocument.presentationml.presentation");
        intent.putExtra(Intent.EXTRA_TITLE, fileName);

        startActivityForResult(call, intent, CREATE_REQUEST_CODE);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        System.out.println("handleOnActivityResult executed");
        if (requestCode == CREATE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null && data.getData() != null) {
                Uri uri = data.getData();
                
                String fileContent = savedCall.getString("fileContent");
                if (fileContent != null) {
                    writeToFile(uri, fileContent);
                } else {
                    savedCall.error("File content is missing.");
                }
            } else {
                savedCall.error("File URI is missing.");
            }
        }
    }

    private void writeToFile(Uri uri, String base64FileContent) {
        System.out.println("Base64 data length: " + base64FileContent.length());
        try {
            ContentResolver resolver = getContext().getContentResolver();
            OutputStream outputStream = resolver.openOutputStream(uri);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            // Convert the base64 string to byte array
            byte[] data = Base64.decode(base64FileContent, Base64.DEFAULT);

            // Write the bytes to the file
            bufferedOutputStream.write(data);

            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            JSObject ret = new JSObject();
            ret.put("uri", uri.toString());
            savedCall.resolve(ret);
        } catch (IOException e) {
            savedCall.error("Failed to write to file.", e);
        }
    }

}

