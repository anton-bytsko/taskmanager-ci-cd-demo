@echo off
setlocal

echo Checking Gradle installation...

if exist "%JAVA_HOME%" (
    echo Java found at %JAVA_HOME%
) else (
    echo Java not found in JAVA_HOME
    echo Checking PATH...
    where java >nul 2>nul
    if errorlevel 1 (
        echo ERROR: Java not found!
        echo Please install Java 11 or higher
        pause
        exit /b 1
    )
)

echo Building project...
gradle build %*

if errorlevel 1 (
    echo Build failed!
    pause
    exit /b 1
) else (
    echo Build successful!
)