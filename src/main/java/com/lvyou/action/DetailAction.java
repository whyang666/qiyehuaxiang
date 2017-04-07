package com.lvyou.action;

import com.lvyou.entity.CompanyInfo;
import com.lvyou.entity.SearchInfo;
import com.lvyou.service.InformationService;
import com.lvyou.service.SearchService;
import com.lvyou.service.SearchServiceImp;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

/**
 * Created by win7 on 2017/3/15.
 */
public class DetailAction {
    private String companyname;
    private List<SearchInfo> result;
    private CompanyInfo companyInfo;
    private float total;
//    private List<Float> second;
//    private List<Float> third;

//    public List<Float> getSecond() {
//        return second;
//    }
//
//    public void setSecond(List<Float> second) {
//        this.second = second;
//    }
//
//    public List<Float> getThird() {
//        return third;
//    }
//
//    public void setThird(List<Float> third) {
//        this.third = third;
//    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public List<SearchInfo> getResult() {
        return result;
    }

    public void setResult(List<SearchInfo> result) {
        this.result = result;
    }

    public String detail(){
        SearchService s = new SearchServiceImp();
        result = s.searchHead(companyname);
        companyInfo=new InformationService().findDetail(companyname);
        total=Float.parseFloat(companyInfo.getTotal());

        //这里的返回值没有用？？？？？
        //companyInfo.getSecondScore().getFSituation();
        ActionContext.getContext().put("total",total);
        ActionContext.getContext().put("companyInfo",companyInfo);
//        companyInfo.getState()
        ActionContext.getContext().put("third",companyInfo.getThirdScore());
        ActionContext.getContext().put("companyname",companyname);
        return "success";
    }
}
