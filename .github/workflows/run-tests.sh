#!/bin/bash

echo "========================================"
echo "     TASK MANAGER - TEST RUNNER"
echo "========================================"

# Создаем директории
mkdir -p build/classes build/test-classes lib

echo "📥 Downloading dependencies..."
if [ ! -f "lib/junit.jar" ]; then
    wget -q -O lib/junit.jar https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
    wget -q -O lib/hamcrest.jar https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
fi

echo "🔧 Compiling source code..."
javac -d build/classes \
      -sourcepath src/main/java \
      src/main/java/com/taskmanager/*.java

if [ $? -ne 0 ]; then
    echo "❌ Compilation failed!"
    exit 1
fi

echo "🔧 Compiling tests..."
javac -d build/test-classes \
      -cp "build/classes:lib/junit.jar:lib/hamcrest.jar" \
      -sourcepath src/test/java \
      src/test/java/com/taskmanager/*.java

if [ $? -ne 0 ]; then
    echo "❌ Test compilation failed!"
    exit 1
fi

echo "🧪 Running tests..."
echo "----------------------------------------"

# Запускаем тесты по отдельности для лучшей читаемости
echo "📋 Running TaskTest (3 tests)..."
java -cp "build/classes:build/test-classes:lib/junit.jar:lib/hamcrest.jar" \
     org.junit.runner.JUnitCore \
     com.taskmanager.TaskTest

echo "----------------------------------------"

echo "📋 Running TaskManagerTest (7 tests)..."
java -cp "build/classes:build/test-classes:lib/junit.jar:lib/hamcrest.jar" \
     org.junit.runner.JUnitCore \
     com.taskmanager.TaskManagerTest

echo "========================================"
echo "✅ TESTS COMPLETED"
echo "========================================"