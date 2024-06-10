package com.deltetech.diligencetech.platform.communications.application.internal.queryservices;

import com.deltetech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import com.deltetech.diligencetech.platform.communications.domain.model.queries.GetAllNotificationsQuery;
import com.deltetech.diligencetech.platform.communications.domain.model.queries.GetNotificationByIdQuery;
import com.deltetech.diligencetech.platform.communications.domain.services.NotificationQueryService;
import com.deltetech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {

    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsQuery query) {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.notificationId());
    }
}
