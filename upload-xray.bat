@echo off
SETLOCAL

:: -----------------------------
:: CONFIGURAÇÕES
:: -----------------------------
set XRAY_CLIENT_ID=3498CDAD513D4066A79FA78B1AE1E4BC
set XRAY_CLIENT_SECRET=4c4c9299f639f0cea48e65237332f7aa87467a0fe51a71cebf8b101e1d86299e
set REPORT_JSON=target\cucumber-reports\cucumber.json

:: -----------------------------
:: 1. RODAR OS TESTES COM MAVEN
:: -----------------------------
echo Rodando testes com Maven...
mvn test

:: -----------------------------
:: 2. GERAR BEARER TOKEN XRAY
:: -----------------------------
echo Gerando Bearer Token Xray...
for /f "delims=" %%a in ('curl -s -H "Content-Type: application/json" -X POST --data "{\"client_id\":\"%XRAY_CLIENT_ID%\",\"client_secret\":\"%XRAY_CLIENT_SECRET%\"}" https://xray.cloud.getxray.app/api/v2/authenticate') do set BEARER_TOKEN=%%a

echo Token gerado: %BEARER_TOKEN%

:: -----------------------------
:: 3. UPLOAD DO JSON PARA XRAY
:: -----------------------------
echo Fazendo upload do relatório para o Xray Cloud...
curl -s -H "Content-Type: application/json" -H "Authorization: Bearer %BEARER_TOKEN%" -X POST --data @%REPORT_JSON% https://xray.cloud.getxray.app/api/v2/import/execution/cucumber

ENDLOCAL
pause
