package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye_message", "Looking forward to hearing from you soon");
        context.setVariable("admin_name", adminConfig.getAdminName());

        context.setVariable("company_name", companyConfig.getCompanyName());
        context.setVariable("company_mail", companyConfig.getCompanyEmail());
        context.setVariable("company_phonenumber", companyConfig.getCompanyTelephone());
        context.setVariable("company_address", companyConfig.getCompanyAddress());

        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTasksAvailableUpdateMail(String message) {

        List<Task> taskList = taskRepository.findAll();

        Context context = new Context();
        context.setVariable("is_friend", true);
        context.setVariable("show_button", false);
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://rafalzywica.github.io/");
        context.setVariable("task_list", taskList);
        context.setVariable("task_list_size", taskList.size());
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye_message", "Looking forward to hearing from you soon");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("admin_config", adminConfig);

        context.setVariable("company_name", companyConfig.getCompanyName());
        context.setVariable("company_mail", companyConfig.getCompanyEmail());
        context.setVariable("company_phonenumber", companyConfig.getCompanyTelephone());
        context.setVariable("company_address", companyConfig.getCompanyAddress());

        return templateEngine.process("mail/tasks-available-update-mail", context);
    }
}