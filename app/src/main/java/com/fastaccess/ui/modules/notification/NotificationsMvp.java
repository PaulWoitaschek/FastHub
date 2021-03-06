package com.fastaccess.ui.modules.notification;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.fastaccess.data.dao.GroupedNotificationModel;
import com.fastaccess.data.dao.model.Notification;
import com.fastaccess.ui.base.mvp.BaseMvp;
import com.fastaccess.ui.widgets.recyclerview.BaseViewHolder;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosh on 19 Feb 2017, 7:53 PM
 */

public interface NotificationsMvp {

    interface View extends BaseMvp.FAView, SwipeRefreshLayout.OnRefreshListener {

        @CallOnMainThread void onNotifyAdapter(@Nullable List<GroupedNotificationModel> items);

        void onUpdateReadState(GroupedNotificationModel item, int position);

        void onClick(@NonNull String url);

        void onReadNotification(@NonNull Notification notification);
    }

    interface Presenter extends BaseViewHolder.OnItemClickListener<GroupedNotificationModel> {

        void onWorkOffline();

        @NonNull ArrayList<GroupedNotificationModel> getNotifications();

        void onCallApi();

        void onMarkAllAsRead(@NonNull List<GroupedNotificationModel> data);
    }
}
