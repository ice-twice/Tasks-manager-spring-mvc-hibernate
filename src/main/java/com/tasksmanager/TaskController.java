package com.tasksmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private TaskService taskService = new TaskService(new TaskDaoImpl());

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @PostMapping(value = "/")
    public String addBook(@ModelAttribute Task task) {
        taskService.addNewTask(task);
        return "redirect:/";
    }
}