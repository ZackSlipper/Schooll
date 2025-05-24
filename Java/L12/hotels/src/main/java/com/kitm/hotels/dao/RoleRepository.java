package com.kitm.hotels.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kitm.hotels.entity.Role;
import com.kitm.hotels.enums.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(Roles name);
}