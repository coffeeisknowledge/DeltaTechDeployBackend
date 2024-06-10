package com.deltetech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltetech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.*;
import com.deltetech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Folder extends AuditableAbstractAggregateRoot<Folder> {
    // particular attributes
    @Getter
    @Embedded
    private FolderData folderData;

    @Embedded
    private FilesList innerFiles;

    @Column
    @Getter
    private FolderPriority priority;

    @Column
    @Getter
    private FolderStatus buyStatus;

    @Column
    @Getter
    private FolderStatus sellStatus;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area parent;
}
