package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAll();

    @Insert("insert into issues (id, summary, description) values(#{id},#{summary},#{description})")
    void insert(String id,String summary,String description);

    @Delete("delete from issues where id = #{id};")
    void delete(String id);

    @Select("select * from issues where id = #{issueId}")
    IssueEntity findById(String issueId);
}
