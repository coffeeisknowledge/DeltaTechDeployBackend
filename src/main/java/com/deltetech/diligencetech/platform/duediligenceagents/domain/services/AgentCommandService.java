package com.deltetech.diligencetech.platform.duediligenceagents.domain.services;

import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.DeleteAgentCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.UpdateAgentUsernameCommand;

import java.util.Optional;

public interface AgentCommandService {
    Long handle(CreateAgentCommand command);
    void handle(DeleteAgentCommand command);
    Optional<Agent> handle(UpdateAgentUsernameCommand command);


}
