package com.example.intentdemo;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentActivity extends Activity {

    public static final String MY_ACTION = "com.example.MY_ACTION";

    Button showContact,
            editContact,
            showDialPad,
            callPerson,
            webBrowser,
            geoLocation;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        // ¸ø°´Å¥Ìí¼Ó°ó¶¨µÄÊÂ¼þ
        Button myButton = (Button) findViewById(R.id.myButton);
        showContact=(Button) findViewById(R.id.view_contact);
        editContact=(Button) findViewById(R.id.edit_contact);
        showDialPad=(Button) findViewById(R.id.show_dial_pad);
        callPerson=(Button) findViewById(R.id.calling);
        webBrowser=(Button) findViewById(R.id.web_browser);
        geoLocation=(Button) findViewById(R.id.geo_location);

        myButton.setOnClickListener(new OnClick());

        showContact.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //ÏÔÊ¾_idÎª1µÄÁªÏµÈËÐÅÏ¢
                //String data = "content://contacts/people/1";
                //Uri uri = Uri.parse(data);
                //ACTION_VIEWÏÔÊ¾Êý¾Ý¸øÓÃ»§
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivity(intent);


            }
        });

        editContact.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //±à¼­_idÎª1µÄÁªÏµÈËÐÅÏ¢
                String data = "content://contacts/people/1";
                Uri uri = Uri.parse(data);
                //ACTION_EDITÏÔÊ¾¿É±à¼­Êý¾Ý
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_EDIT);
                intent.setData(uri);
                startActivity(intent);

            }
        });

        showDialPad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //ÏÔÊ¾²¦´òµç»°µÄ½çÃæ
                String data = "tel:13811111111";
                Uri uri = Uri.parse(data);
                //ACTION_DIALÏÔÊ¾²¦´òµç»°µÄÃæ°å
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);


            }
        });

        callPerson.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Ö±½Ó²¦´òµç»°
                String data = "tel:13811111111";
                Uri uri = Uri.parse(data);
                //ACTION_CALLÖ±½Ó´òµç»°
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);

            }
        });

        webBrowser.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //·ÃÎÊä¯ÀÀÆ÷
                String data = "http://www.baidu.com";
                Uri uri = Uri.parse(data);
                //ACTION_VIEWÏÔÊ¾Êý¾Ý¸øÓÃ»§
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);

            }
        });

        geoLocation.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //·ÃÎÊµØÍ¼
                String data = "geo://39.92,116.46";
                Uri uri = Uri.parse(data);
                //ACTION_VIEWÏÔÊ¾Êý¾Ý¸øÓÃ»§
                Intent intent=new Intent();
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(requestCode);
        System.out.println(resultCode);
    }

    public class OnClick implements OnClickListener {

        @Override
        public void onClick(View v) {
            // Éú³ÉÒ»¸öIntent¶ÔÏó
            Intent intent = new Intent();
            intent.setAction(MY_ACTION);
            intent.putExtra("testIntent", "testExtra");
            // Ö±½ÓÆô¶¯Ò»¸öActivity
            // startActivity(intent);
            // Æô¶¯Ò»¸öÓÐ·µ»ØÖµµÄActivity
            startActivityForResult(intent, 2);
//			Intent intent =new Intent();
//			intent.setClass(IntentActivity.this, SecondActivity.class);
//			startActivity(intent);
        }
    }


}
