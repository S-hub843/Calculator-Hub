package com.example.calculatorhub.controller;

import com.example.calculatorhub.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/calculators")
@CrossOrigin
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    // HOME
    @GetMapping("/")
    public String home() {
        return "Calculator Hub Backend Running";
    }

    // ================= FINANCE =================
    @GetMapping("/emi")
    public Map<String, Double> emi(@RequestParam double principal,
                                   @RequestParam double rate,
                                   @RequestParam double time) {

        double monthlyRate = rate / 12 / 100;
        double months = time * 12;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);

        Map<String, Double> res = new HashMap<>();
        res.put("emi", emi);

        return res;
    }
    @GetMapping("/gst")
    public Map<String, Double> gst(@RequestParam double amount, @RequestParam double rate) {
        Map<String, Double> res = new HashMap<>();
        res.put("gst", service.gst(amount, rate));
        return res;
    }

    @GetMapping("/roi")
    public Map<String, Double> roi(@RequestParam double gain, @RequestParam double investment) {
        Map<String, Double> res = new HashMap<>();
        res.put("roi", service.roi(gain, investment));
        return res;
    }

    @GetMapping("/interest")
    public Map<String, Double> interest(@RequestParam double p,
                                        @RequestParam double r,
                                        @RequestParam double t) {

        Map<String, Double> res = new HashMap<>();
        res.put("interest", service.interest(p, r, t));
        return res;
    }

    @GetMapping("/break-even")
    public Map<String, Double> breakEven(@RequestParam double fixedCost,
                                         @RequestParam double price,
                                         @RequestParam double variableCost) {

        Map<String, Double> res = new HashMap<>();
        res.put("breakEven", service.breakEven(fixedCost, price, variableCost));
        return res;
    }

    // ================= PERSONAL =================

    @GetMapping("/date-diff")
    public Map<String, Long> dateDiff(@RequestParam String start,
                                      @RequestParam String end) {

        Map<String, Long> res = new HashMap<>();
        res.put("days", service.dateDiff(start, end));
        return res;
    }

    @GetMapping("/time-duration")
    public Map<String, Long> timeDuration(@RequestParam String start,
                                          @RequestParam String end) {

        Map<String, Long> res = new HashMap<>();
        res.put("minutes", service.timeDuration(start, end));
        return res;
    }

    // ================= HEALTH =================

    @GetMapping("/bmi")
    public Map<String, Double> bmi(@RequestParam double weight,
                                   @RequestParam double height) {

        Map<String, Double> res = new HashMap<>();
        res.put("bmi", service.bmi(weight, height));
        return res;
    }

    @GetMapping("/calories")
    public Map<String, Double> calories(@RequestParam double weight) {

        Map<String, Double> res = new HashMap<>();
        res.put("calories", service.calories(weight));
        return res;
    }

    @GetMapping("/water")
    public Map<String, Double> water(@RequestParam double weight) {

        Map<String, Double> res = new HashMap<>();
        res.put("water", service.water(weight));
        return res;
    }
    @GetMapping("/pregnancy")
    public Map<String, String> pregnancy(@RequestParam String lastPeriod) {

        LocalDate date = LocalDate.parse(lastPeriod);
        LocalDate dueDate = date.plusDays(280);

        Map<String, String> res = new HashMap<>();
        res.put("dueDate", dueDate.toString());

        return res;
    }
    // ================= BUSINESS =================

    @GetMapping("/profit")
    public Map<String, Double> profit(@RequestParam double revenue,
                                      @RequestParam double cost) {

        Map<String, Double> res = new HashMap<>();
        res.put("profitMargin", service.profit(revenue, cost));
        return res;
    }

    @GetMapping("/startup")
    public Map<String, Double> startup(@RequestParam double revenue,
                                       @RequestParam double multiplier) {

        Map<String, Double> res = new HashMap<>();
        res.put("valuation", service.startup(revenue, multiplier));
        return res;
    }

    @GetMapping("/cost")
    public Map<String, Double> cost(@RequestParam double fixedCost,
                                    @RequestParam double variableCost,
                                    @RequestParam double units) {

        Map<String, Double> res = new HashMap<>();
        res.put("totalCost", service.cost(fixedCost, variableCost, units));
        return res;
    }

    // ================= DASHBOARD =================

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Dashboard not available (DB removed)");
        return data;
    }
}