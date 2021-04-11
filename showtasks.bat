call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openchrome
echo.
echo Cannot open chrome

:openchrome
start "C:\Program Files (x86)\Google\Chrome\Application\Chrome.exe" http://localhost:8080/crud/v1/task/getTasks