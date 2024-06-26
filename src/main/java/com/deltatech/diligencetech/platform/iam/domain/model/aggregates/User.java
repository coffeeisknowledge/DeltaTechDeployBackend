package com.deltatech.diligencetech.platform.iam.domain.model.aggregates;

import com.deltatech.diligencetech.platform.iam.domain.model.entities.Role;
import com.deltatech.diligencetech.platform.iam.domain.model.valueobjects.AgentId;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    @NotBlank
    @Getter
    @Size(max = 50)
    @Column(unique = true)
    private String email;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;

    @Embedded
    private AgentId agentId;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() { this.roles = new HashSet<>(); }

    public User(String email, String password, Long agentId) {
        this();
        this.email = email;
        this.password = password;
        this.agentId = new AgentId(agentId);
    }

    public User(String email, String password,Long agentId, List<Role> roles) {
        this(email, password, agentId);
        //this.roles = new HashSet<>(Role.validateRoleSet(roles));
    }

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles) {
        var validatedRoleSet = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoleSet);
        return this;
    }

   // new
    public String getUserEmail() {
        return this.email;
    }
    public Long getAgentId() {
        return this.agentId.agentId();
    }

}
