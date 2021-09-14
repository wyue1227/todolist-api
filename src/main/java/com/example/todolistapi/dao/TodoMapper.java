package com.example.todolistapi.dao;

import java.util.List;

import com.example.todolistapi.entity.TodoEntity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TodoMapper {

    @Insert("insert into todolist(create_time, update_time, plan_time, finish_time, content, remark, status, section_id) values(now(), now(), #{planTime}, #{finishTime}, #{content}, #{remark}, #{status}, #{sectionID})")
    int insertTodo(TodoEntity entity);

    @Update("<script> update todolist" + "<set>" + "<if test = 'content != null'> `content` = #{content}, </if>"
            + "<if test = 'remark != null'> remark = #{remark}, </if>"
            + "<if test = 'sectionID != null'> section_id = #{sectionID}, </if>"
            + "<if test = 'planTime != null'> plan_time = #{planTime}, </if>" + "update_time = now() " + "</set>"
            + "where todo_id = #{todoID} </script>")
    int updateTodoInfo(TodoEntity entity);

    @Update("update todolist set finish_time = now(), `status` = 1, update_time = now() where todo_id = #{todoID}")
    int todoEnd(int todoID);

    @Update("update todolist set finish_time = NULL, `status` = 0, update_time = now() where todo_id = #{todoID}")
    int todoNotEnd(int todoID);

    @Delete("delete from todolist where todo_id = #{todoID}")
    int deleteTodo(int todoID);

    @Select("select * from todolist where todo_id = #{todoID}")
    // @ResultType(TodoEntity.class)
    TodoEntity getTodoDetail(int todoID);

    @Select("select * from todolist where section_id = #{sectionID}")
    List<TodoEntity> getTodoList(int sectionID);
}