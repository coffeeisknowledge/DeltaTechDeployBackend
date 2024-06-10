package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectResource;

public class ProjectResourceFromEntityAssembler {
    public static ProjectResource toResourceFromEntity(Project entity) {
        return new ProjectResource(entity.getId(), entity.getName().projectFullName(), entity.getManagerName().getProjectManagerFullName(), entity.getStatus().getProjectStatusName());
    }
}