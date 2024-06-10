package com.deltetech.diligencetech.platform.duediligenceagents.domain.services;

import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByCodeQuery;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByIdQuery;
import com.deltetech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAllAgentsQuery;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AgentQueryService {
  Optional<Agent> handle(GetAgentByIdQuery query);
  Optional<Agent> handle(GetAgentByCodeQuery query);
  List<Agent> handle (GetAllAgentsQuery query);

}

