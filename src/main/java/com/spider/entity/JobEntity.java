package com.spider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="t_lagou")
@Entity
public class JobEntity {
    @Id
    @Column(columnDefinition = "bigint")
    private Long lgId;
    private String lgCompany;
    private String lgPosition;
    private String lgSalaryBegin;
    private String lgSalaryEnd;
    private String lgHref;
    private Date lgCreateTime;
    private Date lgUpdateTime;

    public Long getLgId() {
        return lgId;
    }

    public void setLgId(Long lgId) {
        this.lgId = lgId;
    }

    public String getLgCompany() {
        return lgCompany;
    }

    public void setLgCompany(String lgCompany) {
        this.lgCompany = lgCompany;
    }

    public String getLgPosition() {
        return lgPosition;
    }

    public void setLgPosition(String lgPosition) {
        this.lgPosition = lgPosition;
    }

    public String getLgSalaryBegin() {
        return lgSalaryBegin;
    }

    public void setLgSalaryBegin(String lgSalaryBegin) {
        this.lgSalaryBegin = lgSalaryBegin;
    }

    public String getLgSalaryEnd() {
        return lgSalaryEnd;
    }

    public void setLgSalaryEnd(String lgSalaryEnd) {
        this.lgSalaryEnd = lgSalaryEnd;
    }

    public String getLgHref() {
        return lgHref;
    }

    public void setLgHref(String lgHref) {
        this.lgHref = lgHref;
    }

    public Date getLgCreateTime() {
        return lgCreateTime;
    }

    public void setLgCreateTime(Date lgCreateTime) {
        this.lgCreateTime = lgCreateTime;
    }

    public Date getLgUpdateTime() {
        return lgUpdateTime;
    }

    public void setLgUpdateTime(Date lgUpdateTime) {
        this.lgUpdateTime = lgUpdateTime;
    }
}
