@echo off
curl -H "Content-Type: application/json" ^
     -X POST ^
     -u admin:123 ^
     --data @target/cucumber-reports/cucumber.json ^
     http://localhost:8080/rest/raven/1.0/import/execution/cucumber
pause