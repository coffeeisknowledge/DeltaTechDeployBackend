package com.deltetech.diligencetech.platform.communications.domain.model.aggregates;

import com.deltetech.diligencetech.platform.communications.domain.model.commands.CreateNotificationCommand;
import com.deltetech.diligencetech.platform.communications.domain.model.valueobjects.NotificationData;
import com.deltetech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.deltetech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

  @Embedded
  @Getter
  private NotificationData notificationData;

  public Notification() { }

  public Notification(CreateNotificationCommand command) {
    this.notificationData = new NotificationData(command.type(),command.content());
  }

}