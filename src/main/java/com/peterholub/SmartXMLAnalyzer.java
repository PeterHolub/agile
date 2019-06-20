package com.peterholub;

import com.peterholub.fileloader.FileLoader;
import com.peterholub.fileloader.impl.FileLoaderImpl;
import com.peterholub.matcher.Matcher;
import com.peterholub.matcher.impl.MatcherImpl;
import com.peterholub.xpatchbuilder.XPatchBuilder;
import com.peterholub.xpatchbuilder.impl.XPatchBuilderImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SmartXMLAnalyzer {
    private final static String CHARSET = "UTF-8";
    private final static int AMOUNT_OF_MATCHED_ATTRIBUTES = 3;
    private final static String SYSTEM_MESSAGE = "This element was chosen by matched attributes:";

    public static void main(String[] args) throws IOException {

        XPatchBuilder xPatchBuilder = new XPatchBuilderImpl();

        FileLoader fileLoader = new FileLoaderImpl();

        Matcher matcher = new MatcherImpl();

        //Get First HTML
        File input = fileLoader.getFileFromResources(args[0]);

        //Get Second HTML
        File input2 = fileLoader.getFileFromResources(args[1]);

        //Parse First HTML
        Document doc = Jsoup.parse(input, CHARSET);

        //Parse Second HTML
        Document doc2 = Jsoup.parse(input2, CHARSET);

        //Getting okButton element
        Element okButton = doc.getElementById(args[2]);

        //Getting all elements from second HTML
        Elements elements = doc2.getAllElements();

        List<String> keyAndValuesForAttributesMatched = new ArrayList<>();

        //Going through all elements in HTML to find attribute
        for (Element element : elements) {

            //If element founded, print all information
            if (matcher.compareElement(okButton, element, keyAndValuesForAttributesMatched) >= AMOUNT_OF_MATCHED_ATTRIBUTES) {

                System.out.println(SYSTEM_MESSAGE);
                //Print matched attributes
                keyAndValuesForAttributesMatched.forEach(System.out::println);
                //Print Xpath
                System.out.println(xPatchBuilder.getXPatch(element));
                //Finish program
                System.exit(1);
            } else {
                keyAndValuesForAttributesMatched.clear();
            }
        }
    }
}
