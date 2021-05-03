package com.jazzteam.borisov.controller.person;

import com.jazzteam.borisov.models.person.Teacher;
import com.jazzteam.borisov.service.personservice.ServiceTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private ServiceTeacher serviceTeacher;

    public ServiceTeacher getServiceTeacher() {
        return serviceTeacher;
    }

    @Autowired
    public void setServiceTeacher(ServiceTeacher serviceTeacher) {
        this.serviceTeacher = serviceTeacher;
    }

    @GetMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Teacher get(@PathVariable("id") int id) {
        return serviceTeacher.find(id);
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void save(@RequestBody Teacher teacher) {
        serviceTeacher.save(teacher);
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void update(@RequestBody Teacher teacher) {
        serviceTeacher.update(teacher);
    }

    @DeleteMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void delete(@PathVariable("id") int id) {
        serviceTeacher.delete(id);
    }

    @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Teacher> getAll() {
        return serviceTeacher.findAll();
    }
}
