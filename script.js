const BASE_URL = "http://localhost:8080";

/* Tabs */
function showSection(id, el) {
  document.querySelectorAll(".section").forEach(s => s.classList.remove("active"));
  document.getElementById(id).classList.add("active");

  document.querySelectorAll(".tab").forEach(t => t.classList.remove("active"));
  el.classList.add("active");
}

/* Tool navigation */
function openTool(id) {
  document.querySelector(".container").style.display = "none";
  document.getElementById("toolView").style.display = "block";

  document.querySelectorAll(".tool-content").forEach(t => t.classList.remove("active"));
  document.getElementById(id).classList.add("active");
}

function goBack() {
  document.querySelector(".container").style.display = "block";
  document.getElementById("toolView").style.display = "none";
}

/* API calls */
async function fetchData(url, id, label) {
  try {
    const res = await fetch(url);
    const data = await res.json();
    document.getElementById(id).innerText = `${label}: ${Object.values(data)[0]}`;
  } catch {
    document.getElementById(id).innerText = "Error";
  }
}

/* Existing */
function getBMI() {
  fetchData(`${BASE_URL}/api/calculators/bmi?weight=${bmiWeight.value}&height=${bmiHeight.value}`, "bmiResult", "BMI");
}

function getPercentage() {
  fetchData(`${BASE_URL}/api/calculators/percentage?obtained=${obtained.value}&total=${total.value}`, "percentageResult", "Percentage");
}

function getAge() {
  fetchData(`${BASE_URL}/api/calculators/age?birthYear=${birthYear.value}`, "ageResult", "Age");
}

function getEMI() {
  fetchData(`${BASE_URL}/api/calculators/emi?principal=${principal.value}&rate=${rate.value}&time=${time.value}`, "emiResult", "EMI");
}

/* New (confirm backend endpoints) */
function getGST() {
  fetchData(`${BASE_URL}/api/calculators/gst?amount=${gstAmount.value}&rate=${gstRate.value}`, "gstResult", "GST");
}

function getROI() {
  fetchData(`${BASE_URL}/api/calculators/roi?investment=${roiInvestment.value}&returns=${roiReturns.value}`, "roiResult", "ROI");
}

function getInterest() {
  fetchData(`${BASE_URL}/api/calculators/interest?principal=${intPrincipal.value}&rate=${intRate.value}&time=${intTime.value}`, "interestResult", "Interest");
}

function getBreakeven() {
  fetchData(`${BASE_URL}/api/calculators/breakeven?fixedCost=${fixedCost.value}&price=${pricePerUnit.value}&variable=${variableCost.value}`, "breakevenResult", "Break-even");
}

function getTimeDuration() {
  fetchData(`${BASE_URL}/api/calculators/time?start=${startTime.value}&end=${endTime.value}`, "timeResult", "Duration");
}

function getDateDiff() {
  fetchData(`${BASE_URL}/api/calculators/date?start=${startDate.value}&end=${endDate.value}`, "dateResult", "Days");
}
function filterTools() {
  const query = document.getElementById("searchInput").value.toLowerCase();

  const sections = document.querySelectorAll(".section");

  sections.forEach(section => {
    let hasMatch = false;

    const tools = section.querySelectorAll(".tool");

    tools.forEach(tool => {
      // ONLY get heading text (h4)
      const title = tool.querySelector("h4").innerText.toLowerCase();

      if (title.includes(query)) {
        tool.style.display = "block";
        hasMatch = true;
      } else {
        tool.style.display = "none";
      }
    });

    // show/hide entire section
    section.style.display = hasMatch ? "block" : "none";
  });
}
// Calories
function getCalories() {
  fetchData(
    `${BASE_URL}/api/calculators/calories?age=${ageCal.value}&weight=${weightCal.value}&height=${heightCal.value}&gender=${genderCal.value}`,
    "calorieResult",
    "Calories"
  );
}

// Water Intake
function getWater() {
  fetchData(
    `${BASE_URL}/api/calculators/water?weight=${weightWater.value}`,
    "waterResult",
    "Water Intake"
  );
}

// Pregnancy
function getPregnancy() {
  fetchData(
    `${BASE_URL}/api/calculators/pregnancy?lastPeriod=${lastPeriod.value}`,
    "pregnancyResult",
    "Due Date"
  );
}
// Startup Valuation
function getValuation() {
  fetchData(
    `${BASE_URL}/api/calculators/valuation?revenue=${revenueVal.value}&growth=${growthVal.value}`,
    "valuationResult",
    "Valuation"
  );
}

// Profit Margin
function getProfit() {
  fetchData(
    `${BASE_URL}/api/calculators/profit?cost=${costProfit.value}&revenue=${revenueProfit.value}`,
    "profitResult",
    "Profit Margin"
  );
}

// Cost Estimator
function getCost() {
  fetchData(
    `${BASE_URL}/api/calculators/cost?fixed=${fixedCostEst.value}&variable=${variableCostEst.value}`,
    "costResult",
    "Total Cost"
  );
}