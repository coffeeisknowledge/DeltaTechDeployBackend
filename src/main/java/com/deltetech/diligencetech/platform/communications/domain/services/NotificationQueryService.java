package com.deltetech.diligencetech.platform.communications.domain.services;

import com.deltetech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import com.deltetech.diligencetech.platform.communications.domain.model.queries.GetAllNotificationsQuery;
import com.deltetech.diligencetech.platform.communications.domain.model.queries.GetNotificationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService{
    List<Notification> handle(GetAllNotificationsQuery query);
    Optional<Notification> handle(GetNotificationByIdQuery query);

}