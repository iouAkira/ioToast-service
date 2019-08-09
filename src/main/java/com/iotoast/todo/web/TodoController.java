package com.iotoast.todo.web;

import com.iotoast.todo.pojo.IoTodo;
import com.iotoast.todo.service.TodoService;
import com.iotoast.utils.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.iotoast.utils.JSONResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    Resource resource;
    @Autowired
    TodoService todoService;

    /**
     * 获取所有TodoList
     **/
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public JSONResult getAllTodo() {
        List<IoTodo> todos = new ArrayList<IoTodo>();
//        for (int i = 0; i < 6; i++) {
//            IoTodo todo = new IoTodo();
//            todo.setId(UUID.randomUUID().toString());
//            todo.setGroupId(UUID.randomUUID().toString());
//            todo.setTagId(UUID.randomUUID().toString());
//            todo.setTitle("这是一条待办事项" + i);
//            todo.setContent("这是一条待办事项说明" + i);
//            todo.setCreator("Akira" + i);
//            todo.setCreateTime(new Date());
//            todos.add(todo);
//        }
        todos = todoService.findAllTodo();
        return JSONResult.ok(todos);
    }

    @RequestMapping(value = "/resource")
    public JSONResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }

    /**
     * 增加一条Todo
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONResult addTodo(@RequestBody IoTodo todo) {
        todoService.insertTodo(todo);
        return JSONResult.ok();
    }

    /**
     * 删除一条Todo
     **/
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public JSONResult delTodo() {
        return JSONResult.ok();
    }

    /**
     * 更新一条Todo
     **/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JSONResult updateTodo() {
        return JSONResult.ok();
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public JSONResult findOne(@RequestParam String id) {
        IoTodo todo = todoService.findTodoById(id);
        return JSONResult.ok(todo);
    }
}
