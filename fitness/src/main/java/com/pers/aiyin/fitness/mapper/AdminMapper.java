package com.pers.aiyin.fitness.mapper;

import com.pers.aiyin.fitness.entity.Admin;

public interface AdminMapper {
    Admin login(Admin admin);
    Admin getByName(String name);
}

