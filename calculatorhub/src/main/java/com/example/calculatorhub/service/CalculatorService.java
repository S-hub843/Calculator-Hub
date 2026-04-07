package com.example.calculatorhub.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
public class CalculatorService {

    // ================= FINANCE =================

    public double gst(double amount, double rate) {
        return amount + (amount * rate / 100);
    }

    public double roi(double gain, double investment) {
        return ((gain / investment) * 100)-100;
    }

    public double interest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public double breakEven(double fixedCost, double price, double variableCost) {
        return fixedCost / (price - variableCost);
    }

    // ================= PERSONAL =================

    public long dateDiff(String start, String end) {
        LocalDate d1 = LocalDate.parse(start);
        LocalDate d2 = LocalDate.parse(end);
        return ChronoUnit.DAYS.between(d1, d2);
    }

    public long timeDuration(String start, String end) {
        LocalTime t1 = LocalTime.parse(start);
        LocalTime t2 = LocalTime.parse(end);
        return ChronoUnit.MINUTES.between(t1, t2);
    }

    // ================= HEALTH =================

    public double bmi(double weight, double height) {
        return weight / (height * height);
    }

    public double calories(double weight) {
        return weight * 30; // simple formula
    }

    public double water(double weight) {
        return weight * 0.033; // liters
    }

    // ================= BUSINESS =================

    public double profit(double revenue, double cost) {
        return ((revenue - cost) / revenue) * 100;
    }

    public double startup(double revenue, double multiplier) {
        return revenue * multiplier;
    }

    public double cost(double fixedCost, double variableCost, double units) {
        return fixedCost + (variableCost * units);
    }
}