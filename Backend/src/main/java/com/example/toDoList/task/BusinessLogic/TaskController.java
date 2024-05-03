package com.example.toDoList.task.BusinessLogic;

import com.example.toDoList.Fasada.Fasada;
import com.example.toDoList.payload.response.TaskResponse;
import com.example.toDoList.task.BusinessLogic.command.GetTasksCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/task")
@RestController
public class TaskController {
    private final Fasada fasada;

    public TaskController(Fasada fasada) {
        this.fasada = fasada;
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity getAllTaskForUser(HttpServletRequest request){
        Long userId = (Long) request.getAttribute("id");
        List<TaskResponse> tasks = fasada.handle(GetTasksCommand.from(userId));
        if(tasks != null){
            return ResponseEntity.ok(tasks);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}