package com.deltetech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltetech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.*;
import com.deltetech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Area extends AuditableAbstractAggregateRoot<Area> {
    // particular attributes
    @Getter
    @Embedded
    private AreaData areaData;

    @Embedded
    private FoldersList folders;
}
