pipeline {
  agent any
  stages {
    stage('Clean & Compile') {
      steps {
        echo 'Cleaning and compiling'
        sh './gradlew clean classes'
      }
    }

    stage('Tests') {
      steps {
        echo 'Running unit tests'
        sh './gradlew check'
      }
    }

  }

  post {
    always {
      junit 'build/reports/**/*.xml'
    }
  }
}
