package com.kylexu.springbootmapper.mapper;

import com.kylexu.springbootmapper.model.TUser;
import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    TUser selectByPrimaryKey(Integer id);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser record);
}