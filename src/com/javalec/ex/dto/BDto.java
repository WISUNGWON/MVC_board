package com.javalec.ex.dto;

import java.sql.Timestamp;

public class BDto {
    
    // DB의 column명과 같은 변수를 선언해줌
    int bld;
    String bName;
    String bTitle;
    String bContent;
    Timestamp bDate;
    int bHit;
    int bGroup;
    int bStep;
    int bIndent;
    
    // 디폴트 생성자.
    public BDto() {
        
    }
    
    // 생성시에 인자값을 받고 값을 초기화하는 생성자.
    public BDto (int bld, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup, int bStep, int bIndent) {
        this.bld = bld;
        this.bName = bName;
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bDate = bDate;
        this.bHit = bHit;
        this.bGroup = bGroup;
        this.bStep = bStep;
        this.bIndent = bIndent;
        
    }

    public int getBld() {
        return bld;
    }

    public void setBld(int bld) {
        this.bld = bld;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public Timestamp getbDate() {
        return bDate;
    }

    public void setbDate(Timestamp bDate) {
        this.bDate = bDate;
    }

    public int getbHit() {
        return bHit;
    }

    public void setbHit(int bHit) {
        this.bHit = bHit;
    }

    public int getbGroup() {
        return bGroup;
    }

    public void setbGroup(int bGroup) {
        this.bGroup = bGroup;
    }

    public int getbStep() {
        return bStep;
    }

    public void setbStep(int bStep) {
        this.bStep = bStep;
    }

    public int getBIndent() {
        return bIndent;
    }

    public void setBIndent(int bIndent) {
        this.bIndent = bIndent;
    }

}
