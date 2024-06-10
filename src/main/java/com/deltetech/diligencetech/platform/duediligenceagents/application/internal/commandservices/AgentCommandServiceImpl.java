package com.deltetech.diligencetech.platform.duediligenceagents.application.internal.commandservices;

import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.DeleteAgentCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.commands.UpdateAgentUsernameCommand;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.services.AgentCommandService;
import com.deltetech.diligencetech.platform.duediligenceagents.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentCommandServiceImpl implements AgentCommandService {

  private final AgentRepository agentRepository;

  public AgentCommandServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }

  @Override
  public Long handle(CreateAgentCommand command) {
    if (agentRepository.existsByCode(command.code())){
      throw new IllegalArgumentException("Agent with same code already exists");
    }
    var agent = new Agent(command);
    try {
      agentRepository.save(agent);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving agent: " + e.getMessage());
    }
    return agent.getId();
  }

  @Override
  public Optional<Agent> handle(UpdateAgentUsernameCommand command) {
    var result = agentRepository.findById(command.id());
    if (result.isEmpty()) throw new IllegalArgumentException("Agent does not exist");
    var agentToUpdate = result.get();
    try {
      var updatedAgent = agentRepository.save(agentToUpdate.updateUsername(command.username()));
      return Optional.of(updatedAgent);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while updating agent: " + e.getMessage());
    }
  }

  @Override
  public void handle(DeleteAgentCommand command) {
    if (!agentRepository.existsById(command.id())) {
      throw new IllegalArgumentException("Agent does not exist");
    }
    try {
      agentRepository.deleteById(command.id());
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while deleting agent: " + e.getMessage());
    }

  }}
