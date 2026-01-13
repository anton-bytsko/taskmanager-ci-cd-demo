#!/bin/bash

# Проверяем, установлен ли gradle
if ! command -v gradle &> /dev/null; then
    echo "Gradle не установлен. Используем встроенный wrapper..."
    if [ ! -f "gradlew" ]; then
        echo "Создаем gradle wrapper..."
        ./gradle/wrapper/gradlew "$@"
    else
        echo "Gradle wrapper уже существует"
    fi
else
    gradle "$@"
fi