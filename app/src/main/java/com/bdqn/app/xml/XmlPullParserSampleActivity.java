package com.bdqn.app.xml;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bdqn.app.R;
import com.bdqn.app.utils.LogUtils;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlPullParserSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_pull_parser_sample);

        RelativeLayout rootView = (RelativeLayout) findViewById(R.id.rootView);


        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.item_1,rootView,true);

        AssetManager manager = getAssets();
        try {
            InputStream in = manager.open("xmls/a.xml");
            int len = 0;
            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }

//            LogUtils.e(builder.toString());

            pullParseXml(builder.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }


    class Button {
        String width;
        String height;
        String onClick;
        String text;

        @Override
        public String toString() {
            return "Button{" +
                    "width='" + width + '\'' +
                    ", height='" + height + '\'' +
                    ", onClick='" + onClick + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }


    private void pullParseXml(String content) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput(new StringReader(content));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                System.out.println("Start document");
            } else if (eventType == XmlPullParser.START_TAG) {
                if(xpp.getName().equals("LinearLayout")){
                    LogUtils.e(xpp.getNamespace("android"));
                }


                System.out.println("Start tag " + xpp.getName());
                if(xpp.getName().equals("Button")){
                    LogUtils.e(xpp.getAttributeValue(null,"text"));
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                System.out.println("End tag " + xpp.getName());
            } else if (eventType == XmlPullParser.TEXT) {
                System.out.println("Text " + xpp.getAttributeValue("","android:text"));
            }
            eventType = xpp.next();
        }
        System.out.println("End document");
    }


}
