package com.assem.notificationexample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    // Part 8
    // creating groups to group notificationChannels (channel 1 - 2 will be at group 1)
    public static final String GROUP_1 = "group1";
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    // Part 8
    // creating groups to group notificationChannels (channel 1 - 2 will be at group 1)
    public static final String GROUP_2 = "group2";
    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannelGroup group1 = new NotificationChannelGroup(GROUP_1, "group 1");
            NotificationChannelGroup group2 = new NotificationChannelGroup(GROUP_2, "group 2");

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            channel1.setGroup(GROUP_1);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");
            channel2.setGroup(GROUP_1);

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Channel 3",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel3.setDescription("This is Channel 3");
            channel3.setGroup(GROUP_2);

            NotificationChannel channel4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "Channel 4",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel4.setDescription("This is Channel 4");
            channel4.setGroup(GROUP_2);

            NotificationChannel channel5 = new NotificationChannel(
                    CHANNEL_5_ID,
                    "Channel 5",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel5.setDescription("This is Channel 5");
            channel5.setGroup(GROUP_2);

            NotificationManager manager = getSystemService(NotificationManager.class);
            // Part 8
            // creating groups to group notificationChannels (channel 1 - 2 will be at group 1)
            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            // creating groups to group notificationChannels (channel 3 - 4 - 5 will be at group 2)
            manager.createNotificationChannelGroup(group2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);
        }
    }
}
