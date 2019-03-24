package com.ag.api.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todoItem")
//@EntityListeners(AuditingEntityListener.class)
public class ToDoItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    public ToDoItem()
    {}

    public ToDoItem(String text)
    {
        this.text = text;
        this.completed = false;
        this.createdAt = new Date();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
}
