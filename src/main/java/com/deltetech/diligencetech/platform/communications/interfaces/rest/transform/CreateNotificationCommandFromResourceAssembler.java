package com.deltetech.diligencetech.platform.communications.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.communications.domain.model.commands.CreateNotificationCommand;
import com.deltetech.diligencetech.platform.communications.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
        return new CreateNotificationCommand(resource.type(), resource.content());
    }
}