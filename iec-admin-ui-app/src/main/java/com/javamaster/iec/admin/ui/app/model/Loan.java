/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.iec.admin.ui.app.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author poornae
 */
public class Loan {

    private int loanID;
    private Float loan_amount;
    private String loan_term;
    private Float installment_amount;
    private int remaining_installment;
    private Float late_payment;
    private Date loan_start_date;
    private Date loan_end_date;
    private String loan_status;
    private Timestamp updated_at;
    private int updated_by;
    private int customer_id; //foreign key
    private List<Transaction> transactions;

    public Loan(int loanID, Float loan_amount, String loan_term, Float installment_amount, int remaining_installment, Float late_payment, Date loan_start_date, Date loan_end_date, String loan_status, Timestamp updated_at, int updated_by, int customer_id, List<Transaction> transactions) {
        this.loanID = loanID;
        this.loan_amount = loan_amount;
        this.loan_term = loan_term;
        this.installment_amount = installment_amount;
        this.remaining_installment = remaining_installment;
        this.late_payment = late_payment;
        this.loan_start_date = loan_start_date;
        this.loan_end_date = loan_end_date;
        this.loan_status = loan_status;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.transactions = transactions;
    }

    public Loan(Float loan_amount, String loan_term, Float installment_amount, int remaining_installment, Float late_payment, Date loan_start_date, Date loan_end_date, String loan_status, Timestamp updated_at, int updated_by, int customer_id, List<Transaction> transactions) {
        this.loan_amount = loan_amount;
        this.loan_term = loan_term;
        this.installment_amount = installment_amount;
        this.remaining_installment = remaining_installment;
        this.late_payment = late_payment;
        this.loan_start_date = loan_start_date;
        this.loan_end_date = loan_end_date;
        this.loan_status = loan_status;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
        this.customer_id = customer_id;
        this.transactions = transactions;
    }

    public int getLoanID() {
        return loanID;
    }

    public Float getLoan_amount() {
        return loan_amount;
    }

    public String getLoan_term() {
        return loan_term;
    }

    public Float getInstallment_amount() {
        return installment_amount;
    }

    public int getRemaining_installment() {
        return remaining_installment;
    }

    public Float getLate_payment() {
        return late_payment;
    }

    public Date getLoan_start_date() {
        return loan_start_date;
    }

    public Date getLoan_end_date() {
        return loan_end_date;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public void setLoan_amount(Float loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setLoan_term(String loan_term) {
        this.loan_term = loan_term;
    }

    public void setInstallment_amount(Float installment_amount) {
        this.installment_amount = installment_amount;
    }

    public void setRemaining_installment(int remaining_installment) {
        this.remaining_installment = remaining_installment;
    }

    public void setLate_payment(Float late_payment) {
        this.late_payment = late_payment;
    }

    public void setLoan_start_date(Date loan_start_date) {
        this.loan_start_date = loan_start_date;
    }

    public void setLoan_end_date(Date loan_end_date) {
        this.loan_end_date = loan_end_date;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
