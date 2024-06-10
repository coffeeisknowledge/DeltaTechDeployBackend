package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectCommand;

import java.util.Optional;

public interface ProjectCommandService {
    Long handle(CreateProjectCommand command);
    Optional<Project> handle(UpdateProjectCommand command);
    void handle(DeleteProjectCommand command);
    void handle(AddMemberToProjectMemberCommand command);
}
