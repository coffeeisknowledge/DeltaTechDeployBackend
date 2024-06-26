package com.deltatech.diligencetech.platform.iam.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.iam.domain.model.commands.SignUpCommand;
import com.deltatech.diligencetech.platform.iam.domain.model.entities.Role;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;
import java.util.List;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand fromResource(SignUpResource resource) {
        List<Role> roles = new ArrayList<>();
        if (resource.roles() != null) {
            for (String name : resource.roles()) {
                System.out.println("Attempting to convert role name: " + name);
                try {
                    Role role = Role.toRoleFromName(name);
                    roles.add(role);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error converting role name: " + name + " - " + e.getMessage());
                    // Handle the exception as needed (e.g., skip the invalid role, throw a custom exception, etc.)
                }
            }
        }
        System.out.print("Roles: ");
        roles.forEach(role -> System.out.print(role.getName().name() + " "));
        System.out.println(); // New line after listing roles
        //var roles = resource.roles() != null
        //        ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList()
        //        : new ArrayList<Role>();
        //System.out.print("Roles:");
        //System.out.println(roles.getFirst().getName().name());
        return new SignUpCommand(resource.username(), resource.email(), resource.password(), resource.firstname(), resource.lastname(), roles);
    }
}
