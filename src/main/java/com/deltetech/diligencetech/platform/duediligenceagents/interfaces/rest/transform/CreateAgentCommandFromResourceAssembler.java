package com.deltetech.diligencetech.platform.duediligenceagents.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.interfaces.rest.resources.CreateAgentResource;

public class CreateAgentCommandFromResourceAssembler {
    public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource) {
        return new CreateAgentCommand(resource.id(), resource.email(), resource.username(), resource.password(), resource.image());
    }
}