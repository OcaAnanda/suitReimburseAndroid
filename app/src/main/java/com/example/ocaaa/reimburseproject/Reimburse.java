package com.example.ocaaa.reimburseproject;

/**
 * Created by Asus on 6/18/2017.
 */

public class Reimburse {
    private String id;
    private String date;
    private String project;
    private String type;
    private int total;
    private String foto;
    private String details;
    private int status;
    private String reason;
    private User u;

    public Reimburse() {
    }

    public Reimburse(String id, String date, String project, String type, int total, String foto, String details, int status, String reason, User u) {
        this.id = id;
        this.date = date;
        this.project = project;
        this.type = type;
        this.total = total;
        this.foto = foto;
        this.details = details;
        this.status = status;
        this.reason = reason;
        this.u = u;
    }

    public Reimburse(String id, String date, String project, String type, int total, int status) {
        this.id = id;
        this.date = date;
        this.project = project;
        this.type = type;
        this.total = total;
        this.status = status;
    }

    public Reimburse(String id, String date, String project, String type, int total, int status, User u) {
        this.id = id;
        this.date = date;

        this.project = project;
        this.type = type;
        this.total = total;
        this.status = status;
        this.u = u;
    }

    public String getStatusText(){
        switch(status){
            case 0:
                return "PENDING";
            case 1:
                return "ACCEPTED";
            case 2:
                return "REJECTED";
        }
        return "";
    }

    public int getColor(){
        switch(status){
            case 0:
                return R.color.statusPending;
            case 1:
                return R.color.statusAccepted;
            case 2:
                return R.color.statusRejected;
        }
        return 0;
    }

    public int getIcon(){
        switch(type){
            case "Akomodasi":
                return R.drawable.ic_hotel;
            case "Konsumsi":
                return R.drawable.ic_free_breakfast;
            case "Transportasi":
                return R.drawable.ic_directions_car;
        }
        return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
