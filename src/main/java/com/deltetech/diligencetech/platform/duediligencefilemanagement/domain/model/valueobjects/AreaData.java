package com.deltetech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

public record AreaData(String name, Boolean obligatory) {
    public AreaData() {
        this("", false);
    }
}