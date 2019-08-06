package com.iotoast.todo.service;

import com.iotoast.todo.mapper.TodoDao;
import com.iotoast.todo.pojo.IoTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements TodoDao {
    @Autowired
    TodoDao todoDao;

    @Override
    public IoTodo findTodoById(String id) {
        return null;
    }

    public List<IoTodo> findAllTodo() {
        return todoDao.findAllTodo();
    }

    @Override
    public void insertTodo() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteTodo(int id) {

    }
}
