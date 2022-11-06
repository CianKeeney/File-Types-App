package com.example.filetypes;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FileFromXML {

    private Context context;

    public File[] getPeople() {
        return file;
    }

    private File[] file;

    public FileFromXML(Context context){
        this.context = context;

        // make the input stream
        InputStream stream = context.getResources().openRawResource(R.raw.file);
        DocumentBuilder docBuilder = null;
        Document xmlDoc = null;

        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = docBuilder.parse(stream);
        }catch(Exception e){

        }

        // slice xmlDoc
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList descriptionList = xmlDoc.getElementsByTagName("description");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList urlList = xmlDoc.getElementsByTagName("url");

        file = new File[nameList.getLength()];

        // populate people
        for(int i=0;i< file.length;i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String description = descriptionList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            file[i] = new File(name, description, image, url);
        }

    }

    public int getLength(){return file.length;}
    public File getPerson(int i){return file[i];}
    public String [] getNames(){
        String names [] = new String[file.length];
        for(int i=0;i<getLength();i++){
            names[i] = getPerson(i).getName();
        }
        return names;
    }
}
