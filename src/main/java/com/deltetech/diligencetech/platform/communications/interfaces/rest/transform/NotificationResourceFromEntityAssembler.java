package com.deltetech.diligencetech.platform.communications.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import com.deltetech.diligencetech.platform.communications.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity) {
        return new NotificationResource(entity.getId(), entity.getNotificationData().type(), entity.getNotificationData().content());
    }
}
