package com.iotoast.todo.mapper;

import com.iotoast.todo.pojo.IoTodo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoDao {
    /**
     * 通过ID查询todo信息
     * @return todo信息
     */
    @Select("SELECT * FROM io_todo WHERE id = #{id}")
    IoTodo findTodoById(@Param("id") String id);

    /**
     * 查询所有的todo
     * @return 返回所有todo
     */
    @Select("SELECT * FROM io_todo ")
    List<IoTodo> findAllTodo();


    /**
     * 新增一条todo
     */
    @Insert("INSERT INTO io_todo(id,tag_id,group_id,start_time,end_time,done_time,remind_time,title,content,status,is_loop,priority,creator,create_time,update_time) " +
                    "VALUES(#{id},#{tagId},#{groupId},#{startTime},#{endTime},#{doneTime},#{remindTime},#{title},#{content},#{status},#{isLoop},#{priority},#{creator},#{createTime},#{updateTime})")
    void insertTodo(IoTodo todo);

    /**
     * 更新一条todo
     */
    @Update("UPDATE  user SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
    void updateUser();

    /**
     * 根据ID删除一条todo
     * @param id
     */
    @Delete("DELETE FROM todo WHERE id = #{id}")
    void deleteTodo(@Param("id") int id);
}
