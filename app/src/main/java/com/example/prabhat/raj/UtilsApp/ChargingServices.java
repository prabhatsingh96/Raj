package com.example.prabhat.raj.UtilsApp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AlertDialogLayout;
import android.widget.Toast;

import com.example.prabhat.raj.AppActivity.AsynTaskActivity;
import com.example.prabhat.raj.AppActivity.MainActivity;
import com.example.prabhat.raj.R;

public class ChargingServices extends Service {
    private  TextToSpeech textToSpeech;
    public ChargingServices() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean status  = intent.getBooleanExtra("STATUS",false);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        if(status){
            builder.setMessage("Phone is Pluggin");
            speech("Phone is Pluggin");
           simpleNotification("Your Phone is charging now");
            simpleNotificationwithActivity("Your Phone is charging now");
            simpleNotificationGoActivityBackHome("Your Phone is charging now");
            simpleNotificationWithAction("Your Phone is charging now");
            //make phone call
            openFbFromNotification();
        }
        else {
            builder.setMessage("Phone is Pluggin");
            speech("Phone is UnPlugged");
            simpleNotification("Your Phone is Unplugged");
            simpleNotificationwithActivity("Your Phone is unplugged");
            simpleNotificationGoActivityBackHome("Your Phone is unplugged");
            simpleNotificationWithAction("Your Phone is unplugged");
            // make phone call
            openFbFromNotification();
        }



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public  void speech(final String  msg){

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public  void onInit(int i) {
              textToSpeech.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }


    public void simpleNotification(String msg){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Charging...");
        builder.setContentText(msg);
        builder.setSmallIcon(android.support.v4.R.drawable.notification_bg);
        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(12,n);
    }



    public void simpleNotificationwithActivity(String msg){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Charging...");
        builder.setContentText(msg);
        builder.setSmallIcon(android.support.v4.R.drawable.notification_template_icon_low_bg);

        Intent resultIntent = new Intent(this, AsynTaskActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,22,
                resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(22,n);
    }


    public void simpleNotificationGoActivityBackHome(String msg){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setContentTitle("Charging...");
        builder.setContentText(msg);
        builder.setSound(notificationUri);
        builder.setSmallIcon(android.support.v4.R.drawable.notification_template_icon_low_bg);


        Intent resultIntent = new Intent(this, AsynTaskActivity.class);
        android.app.TaskStackBuilder tsb = android.app.TaskStackBuilder.create(this);
        tsb.addParentStack(AsynTaskActivity.class);
        tsb.addNextIntent(resultIntent);
        PendingIntent pendingIntent = tsb.getPendingIntent(25,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(25,n);

    }


    public void simpleNotificationWithAction(String msg){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
      //  Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setContentTitle("Charging...");
        builder.setContentText(msg);
       //builder.setSound(notificationUri);
        builder.setSmallIcon(android.support.v4.R.drawable.notification_template_icon_low_bg);


      //  Intent resultIntent = new Intent(this, AsynTaskActivity.class);
        String uri = "facebook://facebook.com/inbox";
        Intent resultIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

        android.app.TaskStackBuilder tsb = android.app.TaskStackBuilder.create(this);
        tsb.addParentStack(MainActivity.class);
        tsb.addNextIntent(resultIntent);
        PendingIntent pendingIntent = tsb.getPendingIntent(28,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.addAction(android.support.v4.R.drawable.notification_template_icon_low_bg,"facebook",pendingIntent);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(28,n);



    }




    public void openFbFromNotification(){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.gallary_icon)
                        .setContentTitle("Welcome FaceBook")
                        .setContentText("FaceBook LogIn");

       /* Intent myIntent = new Intent(Intent.ACTION_CALL);
        myIntent.setData(Uri.parse("694154257"));
*/
       //Intent myIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:694154257"));
        String uri = "facebook://facebook.com/inbox";
        String uri1 = "https://faq.whatsapp.com";
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
       //startActivity(intent);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        myIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent).addAction(R.drawable.gallary_icon, "Make phone call", resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(19, mBuilder.build());




    }



   /*
   cancel notification

   public static void cancelNotification(Context ctx, int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancel(notifyId);
    }*/


    }
