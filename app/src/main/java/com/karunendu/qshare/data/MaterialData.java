package com.karunendu.qshare.data;

import java.io.Serializable;

/**
 * Created by SpecPC on 1/29/2017.
 */

public class MaterialData implements Serializable
{
    private String id,fid,title,subject,file,text,sem,course,datetime,facName,facEmail,facPhone;
    boolean isopen;

    public boolean isopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getFacEmail() {
        return facEmail;
    }

    public void setFacEmail(String facEmail) {
        this.facEmail = facEmail;
    }

    public String getFacPhone() {
        return facPhone;
    }

    public void setFacPhone(String facPhone) {
        this.facPhone = facPhone;
    }


}
