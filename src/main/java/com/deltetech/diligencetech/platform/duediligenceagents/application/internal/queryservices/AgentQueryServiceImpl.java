package com.deltetech.diligencetech.platform.duediligenceagents.application.internal.queryservices;

import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByCodeQuery;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByIdQuery;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAllAgentsQuery;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.services.AgentQueryService;
import com.deltetech.diligencetech.platform.duediligenceagents.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentQueryServiceImpl implements AgentQueryService{

  private final AgentRepository agentRepository;


  public AgentQueryServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }


  @Override
  public Optional<Agent> handle(GetAgentByIdQuery query) {
    return agentRepository.findById(query.id());
  }

  @Override
  public Optional<Agent> handle(GetAgentByCodeQuery query) {
    return agentRepository.findByCode(query.code());
  }

  @Override
  public List<Agent> handle(GetAllAgentsQuery query) {
    return agentRepository.findAll();
  }


}
