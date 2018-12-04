package com.deloitte.todoApplication.todolistapplication.todoitem;

import javax.persistence.*;

@Entity
public class todoitem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description ")
    private String desc;

    @Column(name = "userName")
    private String toDoListUser;


    public String getToDoListUser() {
        return toDoListUser;
    }

    public void setToDoListUser(String toDoListUser) {
        this.toDoListUser = toDoListUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public todoitem(String desc, int Id) {
        super();
        this.desc = desc;
        this.id = Id;
    }

    public void setDesc(String desc) {

        this.desc = desc;

    }

    public todoitem() {

    }





}
