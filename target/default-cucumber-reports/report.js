$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PaginationTesting.feature");
formatter.feature({
  "name": "Verify the pagination",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the pagination function as expected",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Use the List of Content pagination and Number of Item each page",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.useTheListOfContentPaginationAndNumberOfItemEachPage(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Item Count",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheItemCount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Count",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getThePageCount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Item Count",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getPageTheItemCount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Index",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getThePageIndex()"
});
formatter.result({
  "status": "passed"
});
});