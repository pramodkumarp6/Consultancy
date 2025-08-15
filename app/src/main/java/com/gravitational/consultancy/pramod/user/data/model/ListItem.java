package com.gravitational.consultancy.pramod.user.data.model;

public class ListItem {


    private String company;
    private String jobTitle;
    private  String address;
    private String postDate;
    private  String experience;
    private  String comment;
    private  String contract_name;
    private  String salary;
    private  String post;



    private  String contract_mobile;




    public ListItem(String company, String jobTitle, String address, String postDate,String experience,String post,String salary,String contract_name,String contract_mobile,String comment ) {
        this.contract_mobile = contract_mobile;
        this.address = address;
        this.company = company;
        this.jobTitle = jobTitle;
        this.postDate = postDate;
        this.experience = experience;
        this.post = post;
        this.salary = salary;
        this.contract_name = contract_name;
        this.comment = comment;
    }




    public  String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }


    public String getAddress() {
        return address;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getExperience() {
        return experience;
    }

    public String getSalary() {
        return salary;
    }

    public String getContract_name() {
        return contract_name;
    }

    public String getComment() {
        return comment;
    }

    public String getPost() {
        return post;
    }
    public String getContract_mobile() {
        return contract_mobile;
    }
}