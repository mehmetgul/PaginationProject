$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PaginationTesting.feature");
formatter.feature({
  "name": "Verify the Pagination Helper Implementation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify the pagination function with expected results",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Use the \"\u003cList of Content\u003e\" pagination and \"\u003cNumber of Item each page\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Get the Item Count and compare with expected \"\u003cItem Count\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Get the Page Count and compare with expected \"\u003cPage Count\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Get the Page Item Count and compare with Expected Result",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Page Item Count",
        "Expected Result"
      ]
    },
    {
      "cells": [
        "0",
        "4"
      ]
    },
    {
      "cells": [
        "1",
        "2"
      ]
    },
    {
      "cells": [
        "2",
        "-1"
      ]
    }
  ]
});
formatter.step({
  "name": "Get the Page Index\u003e and compare the Expected Page Index",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Page Index",
        "Expected Page Index"
      ]
    },
    {
      "cells": [
        "5",
        "1"
      ]
    },
    {
      "cells": [
        "2",
        "0"
      ]
    },
    {
      "cells": [
        "20",
        "-1"
      ]
    },
    {
      "cells": [
        "-10",
        "-1"
      ]
    }
  ]
});
formatter.examples({
  "name": "initial data",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "List of Content",
        "Number of Item each page",
        "Item Count",
        "Page Count"
      ]
    },
    {
      "cells": [
        "abcdef",
        "4",
        "6",
        "2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify the pagination function with expected results",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Use the \"abcdef\" pagination and \"4\"",
  "keyword": "Given "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.useThePaginationAnd(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Item Count and compare with expected \"6\"",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheItemCountAndCompareWithExpected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Count and compare with expected \"2\"",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getThePageCountAndCompareWithExpected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Item Count and compare with Expected Result",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheAndCompareWith(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Index\u003e and compare the Expected Page Index",
  "rows": [
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheAndCompareThe(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify the pagination function as expected (alternate scenario)",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Use the \"\u003cList of Content\u003e\" pagination and \"\u003cNumber of Item each page\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Get the Item Count and compare with expected \"\u003cItem Count\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Get the Page Count and compare with expected \"\u003cPage Count\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "Get the Page Item Count and compare with Expected Result",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Page Item Count",
        "Expected Result"
      ]
    },
    {
      "cells": [
        "0",
        "3"
      ]
    },
    {
      "cells": [
        "1",
        "3"
      ]
    },
    {
      "cells": [
        "2",
        "3"
      ]
    },
    {
      "cells": [
        "3",
        "3"
      ]
    },
    {
      "cells": [
        "4",
        "2"
      ]
    },
    {
      "cells": [
        "5",
        "-1"
      ]
    },
    {
      "cells": [
        "-1",
        "-1"
      ]
    }
  ]
});
formatter.step({
  "name": "Get the Page Index\u003e and compare the Expected Page Index",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Page Index",
        "Expected Page Index"
      ]
    },
    {
      "cells": [
        "5",
        "1"
      ]
    },
    {
      "cells": [
        "2",
        "0"
      ]
    },
    {
      "cells": [
        "20",
        "-1"
      ]
    },
    {
      "cells": [
        "-10",
        "-1"
      ]
    },
    {
      "cells": [
        "10",
        "3"
      ]
    },
    {
      "cells": [
        "13",
        "4"
      ]
    },
    {
      "cells": [
        "100",
        "-1"
      ]
    }
  ]
});
formatter.examples({
  "name": "initial data for second sample",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "List of Content",
        "Number of Item each page",
        "Item Count",
        "Page Count"
      ]
    },
    {
      "cells": [
        "abcdefghiklmnd",
        "3",
        "14",
        "5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify the pagination function as expected (alternate scenario)",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Use the \"abcdefghiklmnd\" pagination and \"3\"",
  "keyword": "Given "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.useThePaginationAnd(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Item Count and compare with expected \"14\"",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheItemCountAndCompareWithExpected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Count and compare with expected \"5\"",
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getThePageCountAndCompareWithExpected(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Item Count and compare with Expected Result",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheAndCompareWith(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the Page Index\u003e and compare the Expected Page Index",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "assessment.stepDef.PaginationSteps.getTheAndCompareThe(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
});