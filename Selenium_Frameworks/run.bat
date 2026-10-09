@echo off
echo ========================================================
echo  Executing Salesforce Login Automation Test Suite
echo ========================================================
call "%~dp0mvnw.cmd" clean test
pause
