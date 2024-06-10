package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryService {
    Optional<Project> handle(GetProjectByIdQuery query);
    List<Project> handle(GetAllProjectsQuery query);
    Optional<ProjectMemberItem> handle(GetProjectMemberItemByProjectIdAndAgentId query);
    List<ProjectMemberItem> handle(GetAllProjectMemberItemByProjectId query);
}
