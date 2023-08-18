package abc.get.hostels_pg;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

    private NotificationManager manager;
    public static final String channel1ID="channel1ID";
    public static final String channel1Name="Channel 1";
    public NotificationHelper(Context base) {
        super(base);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            createChannels();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels()
    {
            NotificationChannel channel1 =new NotificationChannel(channel1ID,channel1Name, NotificationManager.IMPORTANCE_HIGH);
            channel1.enableLights(true);
            channel1.enableVibration(true);
            channel1.setLightColor(R.color.colorPrimary);
            channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            getManager().createNotificationChannel(channel1);
    }
    public NotificationManager getManager()
    {
        if (manager==null)
        {
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }
    public NotificationCompat.Builder getChannel1Notification(String title, String message)
    {
        Intent i = new Intent(this,MyBookings.class);
        PendingIntent pi = PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(getApplicationContext(),channel1ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.mylogo)
                .setAutoCancel(true)
                .setContentIntent(pi);
    }
}
