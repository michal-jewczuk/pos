pipeline {
  agent any
  stages {
    stage('Clean and Compile') {
      steps {
        echo 'Cleaning and compiling'
        sh './gradlew clean classes'
      }
    }

    stage('Tests') {
      steps {
        echo 'Running unit tests'
        sh './gradlew test'
      }
    }

  }
}
