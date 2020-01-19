package com.grandstream.test;



import com.sun.org.apache.xml.internal.serializer.OutputPropertyUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XmlTest {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException, UnsupportedEncodingException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();



        Element phonebook = document.createElement("phonebook");
        phonebook.setAttribute("type", "mycreate");
        Element contact = document.createElement("contact");
        contact.setTextContent("sunxiang");

        phonebook.appendChild(contact);

        document.appendChild(phonebook);
        document.setXmlStandalone(true);

        FileOutputStream out = null;
        Writer writer=null;
        out = new FileOutputStream(new File("/home/Sun/workspace/my_workspace_java/Data Structure and Algorithms/Test/src/com/grandstream/test/phonebook-utf-my.xml" ));

//            String head="<?xml version=\"1.0\" encoding=\""+mCharset+"\"?>\n";
        writer = new BufferedWriter(new OutputStreamWriter(out));
//            writer.write(head);// add by wtxu,fix bug 141964,SHIFT-JIS/UTF-32 head 显示的是utf-8

        StreamResult xmlResult = new StreamResult(writer);
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        tf.setOutputProperty(OutputKeys.VERSION, "1.0");
        tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
        tf.transform(new DOMSource(document), xmlResult);


    }
}
