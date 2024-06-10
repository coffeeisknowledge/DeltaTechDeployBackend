package com.deltetech.diligencetech.platform.duediligenceagents.domain.exceptions;

public class AgentNotFoundException extends RuntimeException{
    public AgentNotFoundException(Long aLong) {
        super("Agent with id " + aLong + " not found");
    }
}
