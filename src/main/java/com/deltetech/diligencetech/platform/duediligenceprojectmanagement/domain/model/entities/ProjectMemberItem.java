package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltetech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class ProjectMemberItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;

    @Getter
    @Embedded
    @NotNull
    private AgentRecordId agentRecordId;

    public ProjectMemberItem(Project project, AgentRecordId agentRecordId) {
        this.project = project;
        this.agentRecordId = agentRecordId;
    }

    public ProjectMemberItem() {
    }
}
